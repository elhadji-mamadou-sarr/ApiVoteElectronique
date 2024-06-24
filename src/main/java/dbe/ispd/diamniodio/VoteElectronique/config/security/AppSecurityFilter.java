package dbe.ispd.diamniodio.VoteElectronique.config.security;

import dbe.ispd.diamniodio.VoteElectronique.models.Autorisation;
import dbe.ispd.diamniodio.VoteElectronique.models.Role;
import dbe.ispd.diamniodio.VoteElectronique.repositories.AutorisationRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AppSecurityFilter implements Filter {
    @Autowired
    AutorisationRepository autorisationRepository;
    private Map<String, List<String>> urlsFilter;

    public AppSecurityFilter(){
        urlsFilter = new HashMap<>();
        urlsFilter.put("/api/apprenants",List.of("admin","apprenant"));
        urlsFilter.put("/api/apprenants",List.of("admin"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("--------------Debut filter App security----------------");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String uri = httpServletRequest.getRequestURI();
        boolean authRequired=false;
        Set<String> urls = urlsFilter.keySet();
        List<String> requiredRoles = new ArrayList<>();
        for (String url: urls) {
            if (url.startsWith(url)) {
                authRequired=true;
                requiredRoles=urlsFilter.get(url);
                break;
            }
        }

        if (!"/api/login".equals(uri)) {
            //demande authentification
            String autHeader = httpServletRequest.getHeader("Authorization");
            if (autHeader == null || autHeader.isEmpty()) {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().print("{\"error\": \" devez vous identifier avant d'acceder a cette page\"}");
                httpServletResponse.setContentType("application/json");
                System.out.println("Fin App security :" +uri+" Non authoriser");
                return;
            }

            System.out.println("Fin du filter App Securite");
            Pattern pattern = Pattern.compile("Bearer (\\w+)", Pattern.CASE_INSENSITIVE);
            Matcher m = pattern.matcher(autHeader);
            if (m.matches()) {
                String token = m.group(1);
                Autorisation autorisation = autorisationRepository.findById(token).orElse(null);
                System.out.println("Votre token est : "+token);
                if (autorisation == null) {
                    httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                    httpServletResponse.getWriter().print("{\"error\": \"Votre token est invalide\"}");
                    return;
                }else {
                    //l'utilisateur  existe,verifie lerole
                    System.out.println("Utilisateur ==> "+autorisation);
                    for (Role r: autorisation.getElecteur().getRoles()) {
                        if (requiredRoles.contains(r.getCode())) {
                            filterChain.doFilter(servletRequest, servletResponse);
                            return;
                        }
                    }
                    //
                    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    httpServletResponse.getWriter().print("{\"error\": \" devez vous identifier avant d'acceder a cette page\"}");
                    httpServletResponse.setContentType("application/json");
                    System.out.println("Fin App security :" +uri+" Non authoriser");
                    return;
                }
               // System.out.println("token "+token);
            }else{
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.getWriter().print("{\"error\": \"format authorisation incorrect\"}");
                System.out.println("format authorisation incorrect");
                return;

            }

        }else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

    }


}

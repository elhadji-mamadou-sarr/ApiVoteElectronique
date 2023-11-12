package dbe.ispd.diamniodio.VoteElectronique.models;

public class UserLoginForm {

    private String voterId;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getVoterId() {
        return voterId;
    }

    public UserLoginForm(String voterId, String password) {
        this.voterId = voterId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginForm{" +
                "voterId='" + voterId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

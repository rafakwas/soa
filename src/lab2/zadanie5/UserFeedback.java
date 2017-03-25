package lab2.zadanie5;

public class UserFeedback {
    private String login;
    private String email;
    private String comment;

    public UserFeedback(String login, String email, String comment) {
        this.login = login;
        this.email = email;
        this.comment = comment;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

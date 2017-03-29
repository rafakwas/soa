package lab3.zadanie3;

public class UserFeedback {
    private String login;
    private String email;
    private String comment;
    private long id;

    public UserFeedback() {
    }

    public UserFeedback(String login, String email, String comment, long id) {
        this.login = login;
        this.email = email;
        this.comment = comment;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserFeedback{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFeedback that = (UserFeedback) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

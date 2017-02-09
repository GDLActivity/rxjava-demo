package gdlactivity.service;

/**
 * Github Profile.
 */
public class Profile {

    private int id;
    private String login;
    private String url;

    @Override
    public String toString() {
        return String.format("%s [%s]", login, url);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

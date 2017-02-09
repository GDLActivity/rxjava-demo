package gdlactivity.service;

import com.google.gson.annotations.SerializedName;

/**
 * Github Profile.
 */
public class Profile {

    private int id;
    private String login;
    private String url;
    @SerializedName("followers_url")
    private String followersUrl;

    public String getFollowers() {
        return followersUrl;
    }

    public void setFollowers(String followersUrl) {
        this.followersUrl = followersUrl;
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

    @Override
    public String toString() {
        return String.format("%s [%s], followers: %s", login, url, followersUrl);
    }
}

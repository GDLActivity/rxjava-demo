package gdlactivity.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import java.util.List;

/**
 * Created by nacho on 08/02/17.
 */
public interface GithubService {

    public static final String BASE_URL = "https://api.github.com/";

    @GET("users")
    Observable<List<Profile>> getUsers(@Query("since") int since);

    @GET("users/{user}/followers")
    Observable<List<Profile>> getFollowers(@Path("user") String user);
}

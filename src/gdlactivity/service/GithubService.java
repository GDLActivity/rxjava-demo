package gdlactivity.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by nacho on 08/02/17.
 */
public interface GithubService {

    @GET("https://api.github.com/users?since={since}")
    Call<List<Profile>> getUsers(@Path("since") int since);
}

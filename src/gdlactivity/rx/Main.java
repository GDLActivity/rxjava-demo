package gdlactivity.rx;

import gdlactivity.service.GithubService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Main class to show the Reactive extension for Java.
 */
public class Main {

    public static void main(String...args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);

        System.out.println(service.getUsers(new Random().nextInt()).execute().body());
    }
}

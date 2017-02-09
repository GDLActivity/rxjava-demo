package gdlactivity.rx;

import gdlactivity.service.GithubService;
import gdlactivity.service.Profile;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Main class to show the Reactive extension for Java.
 */
public class Main {

    public static void main(String...args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        int random = new Random().nextInt();
        GithubService service = retrofit.create(GithubService.class);
        Observable<List<Profile>> observable = service.getUsers(random);

        observable
                .flatMap(new Func1<List<Profile>, Observable<Profile>>() {
                    @Override
                    public Observable<Profile> call(List<Profile> profiles) {
                        return Observable.from(profiles);
                    }
                }).flatMap(new Func1<Profile, Observable<List<Profile>>>() {
                    @Override
                    public Observable<List<Profile>> call(Profile profile) {
                        return service.getFollowers(profile.getLogin());
                    }
                })
                .filter(l -> l.size() > 1)
                .subscribe(new Observer<List<Profile>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println(t.getMessage());
                    }

                    @Override
                    public void onNext(List<Profile> profiles) {
                        profiles.stream().forEach(System.out::println);
                    }
                })
        ;
    }
}

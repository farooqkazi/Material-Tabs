package samples.exoguru.materialtabs.Services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kazi on 15/Apr/17.
 */

public class Interactor_Service {

    public static MUSIC_API getConnection() {

        Retrofit retrofit = null;
        OkHttpClient okHttpClient = null;

        /**Used to print the log statements of the parsed json data in the logcat**/
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY

                );

        /**add HttpLoggingInterceptor to okhttp**/

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        if(retrofit == null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)

                    /** Used to parse json to Pojo */

                    .addConverterFactory(GsonConverterFactory.create())

                    /** Display data received to recycler view */

                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                    /** Add okhttp as a friend */

                    .client(okHttpClient)
                    .build();

        }

        return retrofit.create(MUSIC_API.class);
    }

}

package samples.exoguru.materialtabs.Services;

import retrofit2.http.GET;
import rx.Observable;
import samples.exoguru.materialtabs.Model.TrackModel;

/**
 * Created by Kazi on 14/Apr/17.
 */

/** Define the form of request: Get, Post, Query*/

public interface MUSIC_API {

    @GET(Constants.CLASSIC_API)
    Observable<TrackModel> getMusic();

    @GET(Constants.ROCK_API)
    Observable<TrackModel> getRock();

    @GET(Constants.POP_API)
    Observable<TrackModel> getPop();




    /*Call<TrackModel> listTracks(@Query("term") String q, @Query("limit") int limit);*/

    /*@GET(Constants.CLASSIC_API)
    Observable <TrackModel> getTracks(@Query("term") String genre,
                                            @Query("media") String media,
                                            @Query("entity") String type,
                                            @Query("limit") int limit,
                                            @Query("country") String country

    );*/


}

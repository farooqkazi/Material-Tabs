package samples.exoguru.materialtabs.Tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import samples.exoguru.materialtabs.Adapter.MusicAdapter;
import samples.exoguru.materialtabs.Model.TrackModel;
import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.Services.Interactor_Service;
import samples.exoguru.materialtabs.Services.MUSIC_API;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab2 extends Fragment {

    RecyclerView recyclerView_Music;
    MUSIC_API MUSICAPI;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = view.getContext();

        establishConnection();
        initialiseRecyclerView(view);
        callService();
    }
    public void establishConnection() {

        MUSICAPI = Interactor_Service.getConnection();
    }

    public void initialiseRecyclerView(View view) {
        this.recyclerView_Music = (RecyclerView) view.findViewById(R.id.recyclerView_Tab2);
        recyclerView_Music.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }

    public void callService() {

        MUSICAPI.getRock()
                .subscribeOn(Schedulers.newThread()) // Always better to have a new thread as Android runs on One thread
                .observeOn(AndroidSchedulers.mainThread()) //Schedules a new thread on which a operation can be performed
                .subscribe(new Observer<TrackModel>() {

                    //Final Call after completing and processing all data
                    @Override
                    public void onCompleted() {

                        //mSwipeRefreshLayout.setRefreshing(false);
                    }

                    //404, Network Errors
                    @Override
                    public void onError(Throwable e) {
                        Log.i("Error", e.getMessage());
                    }

                    @Override
                    public void onNext(TrackModel trackModels) {

                        //Log.i("HELLO", String.valueOf(trackModels));

                        //Adapter
                        recyclerView_Music.setAdapter(new MusicAdapter(trackModels.getResults(), R.layout.row_layout, context));


                    }
                });
    }
}
package samples.exoguru.materialtabs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import samples.exoguru.materialtabs.Model.Result;
import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.Model.TrackModel;

/**
 * Created by Kazi on 16/Apr/17.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MaterialsTabViewHolder> {

    List<Result> trackModels;
    int row_layout;
    Context applicationContext;

    /**Intializing the Constructor*/

    public MusicAdapter(List<Result> trackModels, int row_layout, Context applicationContext) {

        this.trackModels = trackModels;
        this.row_layout = row_layout;
        this.applicationContext = applicationContext;
    }

    /** Override should always be last*/
    @Override
    public MaterialsTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row_layout, parent, false);
        return new MaterialsTabViewHolder(view);

    }


    @Override
    public void onBindViewHolder(MaterialsTabViewHolder holder, final int position) {

        holder.tvClassicArtistName.setText(trackModels.get(position).getArtistName());
        holder.tvClassicCollectionName.setText(trackModels.get(position).getCollectionName());
        holder.tvClassicPrice.setText("$"+ trackModels.get(position).getTrackPrice());

        String url = trackModels.get(position).getArtworkUrl60();
        Picasso.with(applicationContext).load(url).into(holder.ivImage);

        holder.cvPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url_preview = trackModels.get(position).getPreviewUrl();
                intent.setDataAndType(Uri.parse(url_preview), "audio/*");
                applicationContext.startActivity(intent);
            }
        });

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */


    @Override
    public int getItemCount() {

        return trackModels.size();
    }

    /**
     * Caches the view references (caches row elements): ViewHolder pattern
     */
    public static class MaterialsTabViewHolder extends RecyclerView.ViewHolder {
        //Constructor
        //Initialize the row Elements


        TextView tvClassicArtistName;
        TextView tvClassicCollectionName;
        TextView tvClassicPrice;
        ImageView ivImage;
        CardView cvPreview;


        public MaterialsTabViewHolder(View itemView) {
            super(itemView);

            tvClassicArtistName = (TextView) itemView.findViewById(R.id.tvClassicArtistName);
            tvClassicCollectionName = (TextView) itemView.findViewById(R.id.tvClassicCollectionName);
            tvClassicPrice = (TextView) itemView.findViewById(R.id.tvClassicPrice);
            itemView.setTag(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
            cvPreview=(CardView) itemView.findViewById(R.id.cardView);

            itemView.setTag(itemView);
        }

    }
}


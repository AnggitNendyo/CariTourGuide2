package d3ti.uns.anggit.caritourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import d3ti.uns.anggit.caritourguide.view.activity.DaftarTourguide;
import d3ti.uns.anggit.caritourguide.R;

public class SearchTourguideAdapter extends RecyclerView.Adapter<SearchTourguideAdapter.MyViewHolder> {
    private Context mContext;
    private List<DaftarTourguide> mData;

    public SearchTourguideAdapter(Context mContext, List<DaftarTourguide> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_search_tourguide,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nama_tourguide.setText(mData.get(position).getNama_tourguide());
        holder.status_tourguide.setText(mData.get(position).getStatus_tourguide());
        holder.foto_tourguide.setImageResource(mData.get(position).getFoto_tourguide());

        //set klick listener

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama_tourguide;
        TextView status_tourguide;
        ImageView foto_tourguide;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);


            nama_tourguide = (TextView) itemView.findViewById(R.id.nama_tourguide);
            status_tourguide = (TextView) itemView.findViewById(R.id.status_tourguide);
            foto_tourguide = (ImageView) itemView.findViewById(R.id.foto_tourguide);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
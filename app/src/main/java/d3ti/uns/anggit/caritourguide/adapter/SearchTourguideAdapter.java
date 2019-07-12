package d3ti.uns.anggit.caritourguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideItems;
import d3ti.uns.anggit.caritourguide.view.activity.DetailTourguideActivity;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class SearchTourguideAdapter extends RecyclerView.Adapter<SearchTourguideAdapter.MyViewHolder> {
    private Context mContext;
    private List<SearchTourguideItems> mData;
    private RequestManager requestManager;

    public SearchTourguideAdapter(Context mContext, List<SearchTourguideItems> mData, RequestManager requestManager) {
        this.mContext = mContext;
        this.mData = mData;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_search_tourguide, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailTourguideActivity.class);
                i.putExtra("id_tourguide", mData.get(myViewHolder.getAdapterPosition()).getIdTourguide());
                i.putExtra("nama_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNamaTourguide());
                i.putExtra("foto_tourguide", mData.get(myViewHolder.getAdapterPosition()).getFotoTourguide());
                i.putExtra("status_tourguide", mData.get(myViewHolder.getAdapterPosition()).getStatusTourguide());
                i.putExtra("kota_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNama());
                i.putExtra("alamat_tourguide", mData.get(myViewHolder.getAdapterPosition()).getAlamatTourguide());
                i.putExtra("jenis_kelamin", mData.get(myViewHolder.getAdapterPosition()).getJenisKelamin());
                i.putExtra("umur_tourguide", mData.get(myViewHolder.getAdapterPosition()).getUmurTourguide());
                i.putExtra("harga_tourguide", mData.get(myViewHolder.getAdapterPosition()).getHargaTourguide());
                i.putExtra("hari_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNamaHari());
                i.putExtra("topik_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNamaTopik());
                i.putExtra("fasilitas_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNamaServis());
                i.putExtra("bahasa_tourguide", mData.get(myViewHolder.getAdapterPosition()).getNamaBahasa());
                i.putExtra("deskripsi_tourguide", mData.get(myViewHolder.getAdapterPosition()).getDeskripsiTourguide());
                mContext.startActivity(i);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nama_tourguide.setText(mData.get(position).getNamaTourguide());
        holder.status_tourguide.setText(mData.get(position).getStatusTourguide());
        requestManager.load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + mData.get(position).getFotoTourguide()).into(holder.foto_tourguide);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama_tourguide;
        TextView status_tourguide;
        ImageView foto_tourguide;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nama_tourguide = (TextView) itemView.findViewById(R.id.nama_tourguide);
            status_tourguide = (TextView) itemView.findViewById(R.id.status_tourguide);
            foto_tourguide = (ImageView) itemView.findViewById(R.id.foto_tourguide);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
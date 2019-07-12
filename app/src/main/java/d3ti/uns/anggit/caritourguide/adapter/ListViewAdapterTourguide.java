package d3ti.uns.anggit.caritourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.model.PemesananItemT;
import d3ti.uns.anggit.caritourguide.model.PemesananItemW;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class ListViewAdapterTourguide extends RecyclerView.Adapter<ListViewAdapterTourguide.ViewHolderPemesananTourguide> {
    private Context mContext;
    private List<PemesananItemT> mData;
    private RequestManager requestManager;

    public ListViewAdapterTourguide(Context mContext, List<PemesananItemT>mData, RequestManager requestManager){
        this.mContext = mContext;
        this.mData = mData;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public ViewHolderPemesananTourguide onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.lv_pemesanan_tourguide, viewGroup, false);

        final ViewHolderPemesananTourguide viewHolderPemesananTourguide = new ViewHolderPemesananTourguide(view);
        return viewHolderPemesananTourguide;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPemesananTourguide viewHolderPemesananTourguide, int i) {
        try {
            viewHolderPemesananTourguide.nama_wisatawan.setText(mData.get(i).getNamaWisatawan());
            viewHolderPemesananTourguide.status_pemesanan.setText(mData.get(i).getStatusPemesanan());
            viewHolderPemesananTourguide.tanggal_tour.setText(mData.get(i).getTanggalPemesanan());
            requestManager.load(BASE_URL + "caritourguide/assets/img/foto_wisatawan/" + mData.get(i).getFotoWisatawan()).into(viewHolderPemesananTourguide.foto_wisatawan);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if(mData.isEmpty()){
            return 0;
        }
        return mData.size();
    }

    public static class ViewHolderPemesananTourguide extends RecyclerView.ViewHolder {
        TextView nama_wisatawan;
        TextView status_pemesanan;
        TextView tanggal_tour;
        ImageView foto_wisatawan;
        CardView cardView;

        public ViewHolderPemesananTourguide(View itemView) {
            super(itemView);
            nama_wisatawan = (TextView) itemView.findViewById(R.id.tv_nama_wisatawan);
            status_pemesanan = (TextView) itemView.findViewById(R.id.tv_status_pemesanan_tourguide);
            tanggal_tour = (TextView)itemView.findViewById(R.id.tv_tanggal_tour);
            foto_wisatawan = (ImageView) itemView.findViewById(R.id.foto_wisatawan);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
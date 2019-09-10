package d3ti.uns.anggit.caritourguide.adapter;

import android.content.Context;
import android.content.Intent;
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
import d3ti.uns.anggit.caritourguide.view.activity.DetailPemesananTourguideActivity;

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
        viewHolderPemesananTourguide.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailPemesananTourguideActivity.class);
                i.putExtra("id_pemesanan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getIdPemesanan());
                i.putExtra("id_wisatawan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getIdWisatawan());
                i.putExtra("nama_wisatawan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getNamaWisatawan());
                i.putExtra("kota_tourguide", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getNama());
                i.putExtra("harga_tourguide", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getHargaTourguide());
                i.putExtra("lokasi_temu", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getLokasiTemu());
                i.putExtra("status_pemesanan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getStatusPemesanan());
                i.putExtra("foto_wisatawan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getFotoWisatawan());
                i.putExtra("waktu_tour", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getJamPemesanan());
                i.putExtra("tanggal_tour",mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getTanggalPemesanan());
                i.putExtra("notelp_wisatawan", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getNotelpWisatawan());
                i.putExtra("review_tour", mData.get(viewHolderPemesananTourguide.getAdapterPosition()).getReviewTourT());
                mContext.startActivity(i);
            }
        });
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
            cardView = (CardView) itemView.findViewById(R.id.card_view_pemesanan_tourguide);
        }
    }
}
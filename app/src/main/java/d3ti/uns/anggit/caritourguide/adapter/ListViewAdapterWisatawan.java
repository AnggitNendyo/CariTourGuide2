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
import d3ti.uns.anggit.caritourguide.model.PemesananItemW;
import d3ti.uns.anggit.caritourguide.view.activity.DetailPemesananWisatawanActivity;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class ListViewAdapterWisatawan extends RecyclerView.Adapter<ListViewAdapterWisatawan.ViewHolderPemesananWisatawan> {
    private Context mContext;
    private List<PemesananItemW> mData;
    private RequestManager requestManager;

    public ListViewAdapterWisatawan(Context mContext, List<PemesananItemW>mData, RequestManager requestManager){
        this.mContext = mContext;
        this.mData = mData;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public ViewHolderPemesananWisatawan onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.lv_pemesanan_wisatawan, viewGroup, false);

        final ViewHolderPemesananWisatawan viewHolderPemesananWisatawan = new ViewHolderPemesananWisatawan(view);
        viewHolderPemesananWisatawan.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailPemesananWisatawanActivity.class);
                i.putExtra("id_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getIdTourguide());
                i.putExtra("status_pemesanan", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getStatusPemesanan());
                i.putExtra("nama_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getNamaTourguide());
                i.putExtra("foto_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getFotoTourguide());
                i.putExtra("kota_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getIdKab());
                i.putExtra("harga_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getHargaTourguide());
                i.putExtra("lokasi_temu", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getLokasiTemu());
                i.putExtra("status_tourguide", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getStatusTourguide());
                i.putExtra("tanggal_tour", mData.get(viewHolderPemesananWisatawan.getAdapterPosition()).getTanggalPemesanan());
                mContext.startActivity(i);
            }
        });
    return viewHolderPemesananWisatawan;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPemesananWisatawan viewHolderPemesananWisatawan, int i) {
        try {
            viewHolderPemesananWisatawan.nama_tourguide.setText(mData.get(i).getNamaTourguide());
            viewHolderPemesananWisatawan.status_pemesanan.setText(mData.get(i).getStatusPemesanan());
            viewHolderPemesananWisatawan.harga_tourguide.setText(mData.get(i).getHargaTourguide());
            requestManager.load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + mData.get(i).getFotoTourguide()).into(viewHolderPemesananWisatawan.foto_tourguide);
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

    public static class ViewHolderPemesananWisatawan extends RecyclerView.ViewHolder {
        TextView nama_tourguide;
        TextView status_pemesanan;
        TextView harga_tourguide;
        ImageView foto_tourguide;
        CardView cardView;

        public ViewHolderPemesananWisatawan(View itemView) {
            super(itemView);
            nama_tourguide = (TextView) itemView.findViewById(R.id.tv_nama_tourguide);
            status_pemesanan = (TextView) itemView.findViewById(R.id.tv_status_pemesanan_wisatawan);
            harga_tourguide = (TextView)itemView.findViewById(R.id.tv_harga_tourguide);
            foto_tourguide = (ImageView) itemView.findViewById(R.id.foto_tourguide);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
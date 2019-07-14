package d3ti.uns.anggit.caritourguide.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import d3ti.uns.anggit.caritourguide.R;

public class DetailPemesananTourguideActivity extends AppCompatActivity {
    TextView tv_nama_wisatawan, tv_kota_tour, tv_harga_tourguide, tv_lokasi_temu,
    tv_tanggal_tour, tv_waktu_tour, tv_status_tour;

    ImageView iv_foto_wisatawan;

    String id_wisatawan, nama_wisatawan, lokasi_temu, status_pemesanan,
            tanggal_tour, foto_wisatawan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_tourguide);
    }
}

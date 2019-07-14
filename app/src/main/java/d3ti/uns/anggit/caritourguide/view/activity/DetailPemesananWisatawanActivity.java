package d3ti.uns.anggit.caritourguide.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import d3ti.uns.anggit.caritourguide.R;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class DetailPemesananWisatawanActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nama_tourguide, tv_status_tourguide, tv_kota_tourguide, tv_harga_tourguide, tv_lokasi_temu,
            tv_tanggal_tour, tv_status_pemesanan, tv_waktu_tour;
    ImageView iv_foto_tourguide;
    String id_tourguide, nama_tourguide, foto_tourguide, status_tourguide,
    tanggal_tour, status_pemesanan, kota_tourguide, lokasi_temu, harga_tourguide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_wisatawan);
        id_tourguide = getIntent().getExtras().getString("id_tourguide");
        nama_tourguide = getIntent().getExtras().getString("nama_tourguide");
        foto_tourguide = getIntent().getExtras().getString("foto_tourguide");
        status_tourguide = getIntent().getExtras().getString("status_tourguide");
        kota_tourguide = getIntent().getExtras().getString("kota_tourguide");
        harga_tourguide = getIntent().getExtras().getString("harga_tourguide");
        status_pemesanan = getIntent().getExtras().getString("status_pemesanan");
        tanggal_tour = getIntent().getExtras().getString("tanggal_tour");
        lokasi_temu = getIntent().getExtras().getString("lokasi_temu");

        iv_foto_tourguide = findViewById(R.id.iv_foto_tourguide);
        tv_nama_tourguide = findViewById(R.id.tv_nama_tourguide);
        tv_kota_tourguide = findViewById(R.id.tv_kota_tourguide);
        tv_status_tourguide = findViewById(R.id.tv_status_tourguide);
        tv_harga_tourguide = findViewById(R.id.tv_harga_tourguide);
        tv_tanggal_tour = findViewById(R.id.tv_tanggal_tour);
        tv_status_pemesanan = findViewById(R.id.tv_status_pemesanan);
        tv_lokasi_temu = findViewById(R.id.tv_lokasi_temu);

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + foto_tourguide).into(iv_foto_tourguide);
        tv_nama_tourguide.setText(nama_tourguide);
        tv_kota_tourguide.setText(kota_tourguide);
        tv_status_tourguide.setText(status_tourguide);
        tv_harga_tourguide.setText(harga_tourguide);
        tv_status_pemesanan.setText(status_pemesanan);
        tv_lokasi_temu.setText(lokasi_temu);
        tv_tanggal_tour.setText(tanggal_tour);

    }

    @Override
    public void onClick(View v) {

    }
}

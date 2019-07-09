package d3ti.uns.anggit.caritourguide.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import d3ti.uns.anggit.caritourguide.R;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class DetailTourguideActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nama_tourguide, tv_status_tourguide, tv_kota_tourguide, tv_alamat_tourguide,
            tv_jenis_kelamin, tv_umur_tourguide, tv_harga_tourguide, tv_hari_tourguide, tv_topik_tourguide, tv_fasilitas_tourguide,
            tv_bahasa_tourguide, tv_deskripsi_tourguide;
    ImageView iv_foto_tourguide;
    String id_tourguide, nama_tourguide, foto_tourguide, status_tourguide, alamat_tourguide, kota_tourguide, jenis_kelamin,
            umur_tourguide, harga_tourguide, hari_tourguide, topik_tourguide, fasilitas_tourguide, bahasa_tourguide, deskripsi_tourguide;
    Button btn_pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tourguide);
        id_tourguide = getIntent().getExtras().getString("id_tourguide");
        nama_tourguide = getIntent().getExtras().getString("nama_tourguide");
        foto_tourguide = getIntent().getExtras().getString("foto_tourguide");
        status_tourguide = getIntent().getExtras().getString("status_tourguide");
        alamat_tourguide = getIntent().getExtras().getString("alamat_tourguide");
        kota_tourguide = getIntent().getExtras().getString("kota_tourguide");
        jenis_kelamin = getIntent().getExtras().getString("jenis_kelamin");
        umur_tourguide = getIntent().getExtras().getString("umur_tourguide");
        harga_tourguide = getIntent().getExtras().getString("harga_tourguide");
        hari_tourguide = getIntent().getExtras().getString("hari_tourguide");
        topik_tourguide = getIntent().getExtras().getString("topik_tourguide");
        fasilitas_tourguide = getIntent().getExtras().getString("fasilitas_tourguide");
        bahasa_tourguide = getIntent().getExtras().getString("bahasa_tourguide");
        deskripsi_tourguide = getIntent().getExtras().getString("deskripsi_tourguide");

        tv_nama_tourguide = findViewById(R.id.tv_nama_tourguide);
        tv_kota_tourguide = findViewById(R.id.tv_kota_tourguide);
        tv_status_tourguide = findViewById(R.id.tv_status_tourguide);
        tv_alamat_tourguide = findViewById(R.id.tv_alamat_tourguide);
        tv_jenis_kelamin = findViewById(R.id.tv_jenis_kelamin);
        tv_umur_tourguide = findViewById(R.id.tv_umur_tourguide);
        tv_harga_tourguide = findViewById(R.id.tv_harga_tourguide);
        tv_hari_tourguide = findViewById(R.id.tv_hari_tourguide);
        tv_fasilitas_tourguide = findViewById(R.id.tv_fasilitas_tourguide);
        tv_topik_tourguide = findViewById(R.id.tv_topik_tourguide);
        tv_bahasa_tourguide = findViewById(R.id.tv_bahasa_tourguide);
        tv_deskripsi_tourguide = findViewById(R.id.tv_deskripsi_tourguide);
        iv_foto_tourguide = findViewById(R.id.iv_foto_tourguide);
        btn_pesan = findViewById(R.id.btn_pesan);
        btn_pesan.setOnClickListener(this);

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + foto_tourguide).into(iv_foto_tourguide);
        tv_nama_tourguide.setText(nama_tourguide);
        tv_kota_tourguide.setText(kota_tourguide);
        tv_status_tourguide.setText(status_tourguide);
        tv_alamat_tourguide.setText(alamat_tourguide);
        tv_jenis_kelamin.setText(jenis_kelamin);
        tv_umur_tourguide.setText(umur_tourguide);
        tv_harga_tourguide.setText(harga_tourguide);
        tv_hari_tourguide.setText(hari_tourguide);
        tv_fasilitas_tourguide.setText(fasilitas_tourguide);
        tv_topik_tourguide.setText(topik_tourguide);
        tv_bahasa_tourguide.setText(bahasa_tourguide);
        tv_deskripsi_tourguide.setText(deskripsi_tourguide);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_pesan :
                Intent intentWithData = new Intent(this, BookingTourguideActivity.class);
                intentWithData.putExtra(BookingTourguideActivity.ID_TOURGUIDE,id_tourguide );
                startActivity(intentWithData);
                break;
        }
    }
}

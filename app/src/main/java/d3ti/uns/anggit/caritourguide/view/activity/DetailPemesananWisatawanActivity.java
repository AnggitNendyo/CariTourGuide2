package d3ti.uns.anggit.caritourguide.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.EditStatusPemesananResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class DetailPemesananWisatawanActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nama_tourguide, tv_status_tourguide, tv_kota_tourguide, tv_harga_tourguide, tv_lokasi_temu,
            tv_tanggal_tour, tv_status_pemesanan, tv_waktu_tour;
    ImageView iv_foto_tourguide;
    String id_tourguide, nama_tourguide, foto_tourguide, status_tourguide,id_pemesanan,
            tanggal_tour, status_pemesanan, kota_tourguide, lokasi_temu, harga_tourguide, waktu_tour;
    private Button btnCancel;
    private Button btnChat;
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_wisatawan);
        initView();
        id_pemesanan = getIntent().getExtras().getString("id_pemesanan");
        id_tourguide = getIntent().getExtras().getString("id_tourguide");
        nama_tourguide = getIntent().getExtras().getString("nama_tourguide");
        foto_tourguide = getIntent().getExtras().getString("foto_tourguide");
        status_tourguide = getIntent().getExtras().getString("status_tourguide");
        kota_tourguide = getIntent().getExtras().getString("kota_tourguide");
        harga_tourguide = getIntent().getExtras().getString("harga_tourguide");
        status_pemesanan = getIntent().getExtras().getString("status_pemesanan");
        tanggal_tour = getIntent().getExtras().getString("tanggal_tour");
        lokasi_temu = getIntent().getExtras().getString("lokasi_temu");
        waktu_tour = getIntent().getExtras().getString("waktu_tour");

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + foto_tourguide).into(iv_foto_tourguide);
        tv_nama_tourguide.setText(nama_tourguide);
        tv_kota_tourguide.setText(kota_tourguide);
        tv_status_tourguide.setText(status_tourguide);
        tv_harga_tourguide.setText(harga_tourguide);
        tv_status_pemesanan.setText(status_pemesanan);
        tv_lokasi_temu.setText(lokasi_temu);
        tv_tanggal_tour.setText(tanggal_tour);
        tv_waktu_tour.setText(waktu_tour);

        if(!TextUtils.equals(tv_status_pemesanan.getText().toString(), "menunggu")){
            btnCancel.setVisibility(View.GONE);
        }
        if(!TextUtils.equals(tv_status_pemesanan.getText().toString(),"disetujui")){
            btnChat.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                apiInterface.putStatusPemesnan(id_pemesanan, "dicancel").enqueue(new Callback<EditStatusPemesananResponse>() {
                    @Override
                    public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                        try{
                            if (response.isSuccessful())
                            {
                                Toast.makeText(DetailPemesananWisatawanActivity.this, "Pemesanan di Cancel", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<EditStatusPemesananResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
                break;

            case R.id.btn_chat:
                break;
        }
    }

    private void initView() {
        iv_foto_tourguide = findViewById(R.id.iv_foto_tourguide);
        tv_nama_tourguide = findViewById(R.id.tv_nama_tourguide);
        tv_kota_tourguide = findViewById(R.id.tv_kota_tourguide);
        tv_status_tourguide = findViewById(R.id.tv_status_tourguide);
        tv_harga_tourguide = findViewById(R.id.tv_harga_tourguide);
        tv_tanggal_tour = findViewById(R.id.tv_tanggal_tour);
        tv_status_pemesanan = findViewById(R.id.tv_status_pemesanan);
        tv_lokasi_temu = findViewById(R.id.tv_lokasi_temu);
        tv_waktu_tour = findViewById(R.id.tv_waktu_tour);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnChat = (Button) findViewById(R.id.btn_chat);
        btnCancel.setOnClickListener(this);
        btnChat.setOnClickListener(this);
    }
}

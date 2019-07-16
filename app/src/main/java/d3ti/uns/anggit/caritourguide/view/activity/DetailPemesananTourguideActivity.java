package d3ti.uns.anggit.caritourguide.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class DetailPemesananTourguideActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivFotoWisatawan;
    private TextView tvNamaWisatawan;
    private TextView tvWisatawan;
    private TextView tvKotaTour;
    private TextView tvHargaTourguide;
    private TextView tvLokasiTemu;
    private TextView tvTanggalTour;
    private TextView tvWaktuTour;
    private TextView tvStatusPemesanan;
    private Button btnCancel;
    private Button btnSetuju;
    private Button btnSelesai;
    private Button btnChat;

    String id_wisatawan, nama_wisatawan, lokasi_temu, status_pemesanan, harga_tourguide,
            tanggal_tour, waktu_tour, foto_wisatawan, id_pemesanan, kota_tourguide;

    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_tourguide);
        initView();
        id_pemesanan = getIntent().getExtras().getString("id_pemesanan");
        id_wisatawan = getIntent().getExtras().getString("id_wisatawan");
        foto_wisatawan = getIntent().getExtras().getString("foto_wisatawan");
        nama_wisatawan = getIntent().getExtras().getString("nama_wisatawan");
        kota_tourguide = getIntent().getExtras().getString("kota_tourguide");
        status_pemesanan = getIntent().getExtras().getString("status_pemesanan");
        tanggal_tour = getIntent().getExtras().getString("tanggal_tour");
        lokasi_temu = getIntent().getExtras().getString("lokasi_temu");
        waktu_tour = getIntent().getExtras().getString("waktu_tour");
        harga_tourguide = getIntent().getExtras().getString("harga_tourguide");

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_wisatawan/" + foto_wisatawan).into(ivFotoWisatawan);
        tvNamaWisatawan.setText(nama_wisatawan);
        tvKotaTour.setText(kota_tourguide);
        tvStatusPemesanan.setText(status_pemesanan);
        tvHargaTourguide.setText(harga_tourguide);
        tvLokasiTemu.setText(lokasi_temu);
        tvTanggalTour.setText(tanggal_tour);
        tvWaktuTour.setText(waktu_tour);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel_t:
                apiInterface.putStatusPemesnan(id_pemesanan, "dicancel").enqueue(new Callback<EditStatusPemesananResponse>() {
                    @Override
                    public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                        try{
                            if (response.isSuccessful())
                            {
                                Toast.makeText(DetailPemesananTourguideActivity.this, "Pemesanan di Cancel", Toast.LENGTH_SHORT).show();
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

            case R.id.btn_setuju_t:
                apiInterface.putStatusPemesnan(id_pemesanan, "disetujui").enqueue(new Callback<EditStatusPemesananResponse>() {
                    @Override
                    public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                        try{
                            if (response.isSuccessful())
                            {
                                Toast.makeText(DetailPemesananTourguideActivity.this, "Pemesanan di Setujui", Toast.LENGTH_SHORT).show();
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

            case R.id.btn_selesai_t:
                apiInterface.putStatusPemesnan(id_pemesanan, "selesai").enqueue(new Callback<EditStatusPemesananResponse>() {
                    @Override
                    public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                        try{
                            if (response.isSuccessful())
                            {
                                Toast.makeText(DetailPemesananTourguideActivity.this, "Tour Telah Selesai", Toast.LENGTH_SHORT).show();
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

            case R.id.btn_chat_t:

                break;
        }
    }
    private void initView() {
        ivFotoWisatawan = (CircleImageView) findViewById(R.id.iv_foto_wisatawan);
        tvNamaWisatawan = (TextView) findViewById(R.id.tv_nama_wisatawan);
        tvWisatawan = (TextView) findViewById(R.id.tv_wisatawan);
        tvKotaTour = (TextView) findViewById(R.id.tv_kota_tour);
        tvHargaTourguide = (TextView) findViewById(R.id.tv_harga_tourguide);
        tvLokasiTemu = (TextView) findViewById(R.id.tv_lokasi_temu);
        tvTanggalTour = (TextView) findViewById(R.id.tv_tanggal_tour);
        tvWaktuTour = (TextView) findViewById(R.id.tv_waktu_tour);
        tvStatusPemesanan = (TextView) findViewById(R.id.tv_status_pemesanan);
        btnCancel = (Button) findViewById(R.id.btn_cancel_t);
        btnSetuju = (Button) findViewById(R.id.btn_setuju_t);
        btnSelesai = (Button) findViewById(R.id.btn_selesai_t);
        btnChat = (Button) findViewById(R.id.btn_chat_t);
        btnSetuju.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnChat.setOnClickListener(this);
        btnSelesai.setOnClickListener(this);
    }
}

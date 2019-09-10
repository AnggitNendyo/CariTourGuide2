package d3ti.uns.anggit.caritourguide.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
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
    private TextView tv_review_tour_t;
    private Button btnTolak;
    private Button btnSetuju;
    private Button btnSelesai;
    private Button btnChat;
    AlertDialog.Builder builder;

    String id_wisatawan, nama_wisatawan, lokasi_temu, status_pemesanan, harga_tourguide,
            tanggal_tour, waktu_tour, foto_wisatawan, id_pemesanan, kota_tourguide, notelp_wisatawan, apiwa, review_tour_t;

    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_tourguide);
        initView();
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

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
        notelp_wisatawan = getIntent().getExtras().getString("notelp_wisatawan");
        review_tour_t = getIntent().getExtras().getString("review_tour");
        Log.d("review tour guide", review_tour_t);
        apiwa = "https://api.whatsapp.com/send?phone=";

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_wisatawan/" + foto_wisatawan).into(ivFotoWisatawan);
        tvNamaWisatawan.setText(nama_wisatawan);
        tvKotaTour.setText(kota_tourguide);
        tvStatusPemesanan.setText(status_pemesanan);
        tvHargaTourguide.setText(harga_tourguide);
        tvLokasiTemu.setText(lokasi_temu);
        tvTanggalTour.setText(tanggal_tour);
        tvWaktuTour.setText(waktu_tour);
        tv_review_tour_t.setText(review_tour_t);

        if (TextUtils.equals(tvStatusPemesanan.getText().toString(), "menunggu")) {
            btnSelesai.setVisibility(View.GONE);
            btnChat.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tvStatusPemesanan.getText().toString(), "disetujui")) {
            btnTolak.setVisibility(View.GONE);
            btnSetuju.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tvStatusPemesanan.getText().toString(), "selesai")) {
            btnChat.setVisibility(View.GONE);
            btnTolak.setVisibility(View.GONE);
            btnSetuju.setVisibility(View.GONE);
            btnSelesai.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tvStatusPemesanan.getText().toString(), "ditolak")) {
            btnChat.setVisibility(View.GONE);
            btnTolak.setVisibility(View.GONE);
            btnSetuju.setVisibility(View.GONE);
            btnSelesai.setVisibility(View.GONE);
        }

        if (TextUtils.equals(tvStatusPemesanan.getText().toString(), "dicancel")) {
            btnChat.setVisibility(View.GONE);
            btnTolak.setVisibility(View.GONE);
            btnSetuju.setVisibility(View.GONE);
            btnSelesai.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Button Tolak
            case R.id.btn_tolak_t:
                builder.setMessage("Apakah Anda Yakin akan menolak pesanan ini?");
                builder.setTitle("Perhatian !");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apiInterface.putStatusPemesnan(id_pemesanan, "ditolak").enqueue(new Callback<EditStatusPemesananResponse>() {
                            @Override
                            public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananTourguideActivity.this, "Pemesanan di Tolak", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onFailure(Call<EditStatusPemesananResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialogTolak = builder.create();
                alertDialogTolak.show();
                break;

            //Button Setuju
            case R.id.btn_setuju_t:
                builder.setMessage("Apakah anda yakin ingin menyetujui pesanan ini?");
                builder.setTitle("Perhatian !");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apiInterface.putStatusPemesnan(id_pemesanan, "disetujui").enqueue(new Callback<EditStatusPemesananResponse>() {
                            @Override
                            public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananTourguideActivity.this, "Pemesanan di Setujui", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<EditStatusPemesananResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialogSetuju = builder.create();
                alertDialogSetuju.show();
                break;

            //Button Selesai
            case R.id.btn_selesai_t:
                builder.setMessage("Apakah Anda Yakin ingin menyelesaikan pesanan ini?");
                builder.setTitle("Perhatian !");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apiInterface.putStatusPemesnan(id_pemesanan, "selesai").enqueue(new Callback<EditStatusPemesananResponse>() {
                            @Override
                            public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananTourguideActivity.this, "Tour Telah Selesai", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onFailure(Call<EditStatusPemesananResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialogSelesai = builder.create();
                alertDialogSelesai.show();
                break;

            //Button Chat
            case R.id.btn_chat_t:
                if (!TextUtils.isEmpty(notelp_wisatawan)) {
                    int panjang = notelp_wisatawan.length();
                    final String url = apiwa + "62" + notelp_wisatawan.substring(1, panjang);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Nomor WhatsApp Wisatawan Tidak Tersedia", Toast.LENGTH_SHORT).show();
                }

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
        tv_review_tour_t = findViewById(R.id.tv_review_tour_t);
        btnTolak = (Button) findViewById(R.id.btn_tolak_t);
        btnSetuju = (Button) findViewById(R.id.btn_setuju_t);
        btnSelesai = (Button) findViewById(R.id.btn_selesai_t);
        btnChat = (Button) findViewById(R.id.btn_chat_t);
        btnSetuju.setOnClickListener(this);
        btnTolak.setOnClickListener(this);
        btnChat.setOnClickListener(this);
        btnSelesai.setOnClickListener(this);
    }
}

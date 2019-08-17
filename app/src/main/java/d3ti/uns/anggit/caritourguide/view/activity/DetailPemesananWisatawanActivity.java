package d3ti.uns.anggit.caritourguide.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditStatusPemesananResponse;
import d3ti.uns.anggit.caritourguide.model.ReportResponse;
import d3ti.uns.anggit.caritourguide.model.ReviewTourItems;
import d3ti.uns.anggit.caritourguide.model.ReviewTourResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class DetailPemesananWisatawanActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nama_tourguide, tv_status_tourguide, tv_kota_tourguide, tv_harga_tourguide, tv_lokasi_temu,
            tv_tanggal_tour, tv_status_pemesanan, tv_waktu_tour, tv_review_tour;
    ImageView iv_foto_tourguide;
    String id_tourguide, nama_tourguide, foto_tourguide, status_tourguide, id_pemesanan,
            tanggal_tour, status_pemesanan, kota_tourguide, lokasi_temu, harga_tourguide, waktu_tour, notelp_tourguide, apiwa, review_tour, deskripsi_report;
    private Button btnCancel;
    private Button btnChat;
    private Button btnReview;
    private ImageButton btnReport;
    AlertDialog.Builder builder;
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan_wisatawan);
        initView();
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        sharedPrefManager = new SharedPrefManager(this);

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
        notelp_tourguide = getIntent().getExtras().getString("notelp_tourguide");
        review_tour = getIntent().getExtras().getString("review_tour");
        deskripsi_report = getIntent().getExtras().getString("deskripsi_report");


        apiwa = "https://api.whatsapp.com/send?phone=";

        Glide.with(this).load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + foto_tourguide).into(iv_foto_tourguide);
        tv_nama_tourguide.setText(nama_tourguide);
        tv_kota_tourguide.setText(kota_tourguide);
        tv_status_tourguide.setText(status_tourguide);
        tv_harga_tourguide.setText(harga_tourguide);
        tv_status_pemesanan.setText(status_pemesanan);
        tv_lokasi_temu.setText(lokasi_temu);
        tv_tanggal_tour.setText(tanggal_tour);
        tv_waktu_tour.setText(waktu_tour);
        tv_review_tour.setText(review_tour);

        if (TextUtils.equals(tv_status_pemesanan.getText().toString(), "menunggu")) {
            btnChat.setVisibility(View.GONE);
            btnReview.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tv_status_pemesanan.getText().toString(), "disetujui")) {
            btnCancel.setVisibility(View.GONE);
            btnReview.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tv_status_pemesanan.getText().toString(), "selesai")) {
            btnChat.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tv_status_pemesanan.getText().toString(), "ditolak")) {
            btnChat.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);
            btnReview.setVisibility(View.GONE);
        }
        if (TextUtils.equals(tv_status_pemesanan.getText().toString(), "dicancel")) {
            btnChat.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);
            btnReview.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                builder.setMessage("Apakah Anda Yakin akan membatalkan pesanan ini?");
                builder.setTitle("Perhatian !");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apiInterface.putStatusPemesnan(id_pemesanan, "dicancel").enqueue(new Callback<EditStatusPemesananResponse>() {
                            @Override
                            public void onResponse(Call<EditStatusPemesananResponse> call, Response<EditStatusPemesananResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananWisatawanActivity.this, "Pemesanan di Cancel", Toast.LENGTH_SHORT).show();
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
                builder.setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialogTolak = builder.create();
                alertDialogTolak.show();
                break;

            case R.id.btn_chat:
                int panjang = notelp_tourguide.length();
                final String url = apiwa + "62" + notelp_tourguide.substring(1, panjang);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                break;

            case R.id.btn_review:
                AlertDialog.Builder builderReview = new AlertDialog.Builder(this);
                builderReview.setMessage("Review Tour Anda");
                builderReview.setCancelable(false);

                final EditText etReviewText = new EditText(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                etReviewText.setLayoutParams(lp);
                builderReview.setView(etReviewText);

                builderReview.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        String review_tour = etReviewText.getText().toString();
                        apiInterface.postReviewTour(review_tour, id_pemesanan).enqueue(new Callback<ReviewTourResponse>() {
                            @Override
                            public void onResponse(Call<ReviewTourResponse> call, Response<ReviewTourResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananWisatawanActivity.this, "Review Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ReviewTourResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                builderReview.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertReview = builderReview.create();
                alertReview.show();
                break;

            case R.id.ib_report:
                AlertDialog.Builder builderReport = new AlertDialog.Builder(this);
                builderReport.setMessage("Laporkan Masalah Anda");
                builderReport.setCancelable(false);

                final EditText etReportText = new EditText(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                etReportText.setLayoutParams(layoutParams);
                builderReport.setView(etReportText);

                builderReport.setPositiveButton("Report", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogReport, int which) {
                        String deskripsi_report = etReportText.getText().toString();
                        apiInterface.postReport(sharedPrefManager.getSpEmailUser(), deskripsi_report, id_tourguide ).enqueue(new Callback<ReportResponse>() {
                            @Override
                            public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(DetailPemesananWisatawanActivity.this, "Report Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                        dialogReport.dismiss();
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ReportResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                builderReport.setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertReport = builderReport.create();
                alertReport.show();
                break;
        }
    }

    private void initView() {
        tv_review_tour = findViewById(R.id.tv_review_tour);
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
        btnReview = findViewById(R.id.btn_review);
        btnReport = findViewById(R.id.ib_report);

        btnCancel.setOnClickListener(this);
        btnChat.setOnClickListener(this);
        btnReview.setOnClickListener(this);
        btnReport.setOnClickListener(this);
    }
}
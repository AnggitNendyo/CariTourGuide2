package d3ti.uns.anggit.caritourguide.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.RegisterWisatawanResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterWisatawanActivity extends AppCompatActivity implements View.OnClickListener {
    View view;
    private TextView tvNamaWisatawan;
    private EditText etNamaWisatawan;
    private TextView tvEmailWisatawan;
    private EditText etEmailWisatawan;
    private TextView tvPasswordWisatawan;
    private EditText etPasswordWisatawan;
    private TextView tvUlangiPasswordWisatawan;
    private EditText etUlangiPasswordWisatawan;
    private Button btnRegisterWisatawan;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_wisatawan);
        initView();
    }

    private void initView() {
        tvNamaWisatawan = (TextView) findViewById(R.id.tv_nama_wisatawan);
        etNamaWisatawan = (EditText) findViewById(R.id.et_nama_wisatawan);
        tvEmailWisatawan = (TextView) findViewById(R.id.tv_email_wisatawan);
        etEmailWisatawan = (EditText) findViewById(R.id.et_email_wisatawan);
        tvPasswordWisatawan = (TextView) findViewById(R.id.tv_password_wisatawan);
        etPasswordWisatawan = (EditText) findViewById(R.id.et_password_wisatawan);
        tvUlangiPasswordWisatawan = (TextView) findViewById(R.id.tv_ulangi_password_wisatawan);
        etUlangiPasswordWisatawan = (EditText) findViewById(R.id.et_ulangi_password_wisatawan);
        btnRegisterWisatawan = (Button) findViewById(R.id.btn_register_wisatawan);

        btnRegisterWisatawan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_wisatawan:
                String nama = etNamaWisatawan.getText().toString();
                String email = etEmailWisatawan.getText().toString();
                String password = etPasswordWisatawan.getText().toString();
                String ulangi_password = etUlangiPasswordWisatawan.getText().toString();

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(ulangi_password)) {
                    Toast.makeText(this, "Isian Masih Kosong !", Toast.LENGTH_SHORT).show();
                } else {
                    apiInterface.registerWisatawan(email, password, nama).enqueue(new Callback<RegisterWisatawanResponse>() {
                        @Override
                        public void onResponse(Call<RegisterWisatawanResponse> call, Response<RegisterWisatawanResponse> response) {
                            try {
                                if (response.isSuccessful()) {
                                    String respon = response.body().getResult().getStatus();

                                    if (TextUtils.isEmpty(respon)) {
                                        Toast.makeText(getApplicationContext(), "Kesalahan Server !", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (TextUtils.equals(respon, "Register Berhasil")) {
                                            Toast.makeText(getApplicationContext(), "Register Berhasil !", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                            finish();
                                            getApplicationContext().startActivity(intent);
                                        } else if (TextUtils.equals(respon, "Email Telah Terdaftar !")) {
                                            Toast.makeText(getApplicationContext(), "Email Telah Terdaftar !", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Register Gagal !", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterWisatawanResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }


                break;
        }
    }
}

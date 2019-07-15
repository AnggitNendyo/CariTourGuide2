package d3ti.uns.anggit.caritourguide.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditProfilWisatawanItem;
import d3ti.uns.anggit.caritourguide.model.EditProfilWisatawanResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilWisatawanActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNamaWisatawan;
    private EditText etNotelpWisatawan;
    private EditText etAlamatWisatawan;
    private RadioGroup rgJeniskelaminWisatawan;
    private RadioButton rbLakilaki;
    private RadioButton rbPerempuan;
    private EditText etUmurWisatawan;
    private EditText etPasporWisatawan;
    private EditText etKtpWisatawan;
    private Button btnBatalProfilWisatawan;
    private Button btnSimpanProfilWisatawan;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_wisatawan);
        sharedPrefManager = new SharedPrefManager(this);
        initView();
    }

    private void putData() {
        String namaWisatawan = etNamaWisatawan.getText().toString();
        String noTelpWisatawan = etNotelpWisatawan.getText().toString();
        String alamatWisatawan = etAlamatWisatawan.getText().toString();
        String jenisKelamin = "";
        if (rbLakilaki.isChecked() == true) {
            jenisKelamin = "laki-laki";
        }
        if (rbPerempuan.isChecked() == true) {
            jenisKelamin = "perempuan";
        }
        String umurWisatawan = etUmurWisatawan.getText().toString();
        String pasporWisatawan = etPasporWisatawan.getText().toString();
        String ktpWisatawan = etKtpWisatawan.getText().toString();

        apiInterface.putProfilWisatawan(sharedPrefManager.getSpEmailUser(), namaWisatawan, noTelpWisatawan,
                alamatWisatawan, jenisKelamin, umurWisatawan, pasporWisatawan, ktpWisatawan)
                .enqueue(new Callback<EditProfilWisatawanResponse>() {
                    @Override
                    public void onResponse(Call<EditProfilWisatawanResponse> call, Response<EditProfilWisatawanResponse> response) {
                        try {
                            if (response.isSuccessful()) {
                                EditProfilWisatawanItem data = response.body().getResult();
                                if (!TextUtils.isEmpty(data.getNamaWisatawan())){
                                    Toast.makeText(EditProfilWisatawanActivity.this, "Berhasil Update Profil", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<EditProfilWisatawanResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_batal_profil_wisatawan:
                finish();
                break;

            case R.id.btn_simpan_profil_wisatawan:
                putData();
                break;
        }
    }

    private void initView() {
        etNamaWisatawan = (EditText) findViewById(R.id.et_nama_wisatawan);
        etNotelpWisatawan = (EditText) findViewById(R.id.et_notelp_wisatawan);
        etAlamatWisatawan = (EditText) findViewById(R.id.et_alamat_wisatawan);
        rgJeniskelaminWisatawan = (RadioGroup) findViewById(R.id.rg_jeniskelamin_wisatawan);
        rbLakilaki = (RadioButton) findViewById(R.id.rb_lakilaki);
        rbPerempuan = (RadioButton) findViewById(R.id.rb_perempuan);
        etUmurWisatawan = (EditText) findViewById(R.id.et_umur_wisatawan);
        etPasporWisatawan = (EditText) findViewById(R.id.et_paspor_wisatawan);
        etKtpWisatawan = (EditText) findViewById(R.id.et_ktp_wisatawan);
        btnBatalProfilWisatawan = (Button) findViewById(R.id.btn_batal_profil_wisatawan);
        btnSimpanProfilWisatawan = (Button) findViewById(R.id.btn_simpan_profil_wisatawan);
        btnBatalProfilWisatawan.setOnClickListener(this);
        btnSimpanProfilWisatawan.setOnClickListener(this);
    }
}

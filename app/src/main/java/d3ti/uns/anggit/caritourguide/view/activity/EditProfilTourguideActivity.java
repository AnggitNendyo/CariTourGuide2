package d3ti.uns.anggit.caritourguide.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditProfilTourguideItem;
import d3ti.uns.anggit.caritourguide.model.EditProfilTourguideResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditProfilTourguideActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNamaTourguide;
    private EditText etNotelpTourguide;
    private EditText etAlamatTourguide;
    private RadioButton rbLakilaki;
    private RadioButton rbPerempuan;
    private EditText etUmurTourguide;
    private EditText etKtpTourguide;
    private Button btnBatal;
    private Button btnSimpan;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_tourguide);
        sharedPrefManager = new SharedPrefManager(this);
        initView();

    }

    private void putData() {
        String namaTourguide = etNamaTourguide.getText().toString();
        String noTelpTourguide = etNotelpTourguide.getText().toString();
        String alamattTourguide = etAlamatTourguide.getText().toString();
        String jenisKelamin = "";
        if(rbLakilaki.isChecked() == true) {
            jenisKelamin = "laki-laki";
        }
        if(rbPerempuan.isChecked() == true) {
            jenisKelamin = "perempuan";
        }
        String umurTourguide = etUmurTourguide.getText().toString();
        String ktpTourguide = etKtpTourguide.getText().toString();

        apiInterface.putProfilTourguide(sharedPrefManager.getSpEmailUser(),namaTourguide,noTelpTourguide,alamattTourguide,jenisKelamin,ktpTourguide,umurTourguide)
                .enqueue(new Callback<EditProfilTourguideResponse>() {
                    @Override
                    public void onResponse(Call<EditProfilTourguideResponse> call, Response<EditProfilTourguideResponse> response) {
                        try {
                            if(response.isSuccessful()){
                                EditProfilTourguideItem data = response.body().getResult();
                                if(!TextUtils.isEmpty(data.getNamaTourguide())){
                                    Toast.makeText(EditProfilTourguideActivity.this, "Berhasil Update Data Tourguide !", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<EditProfilTourguideResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private void initView() {
        etNamaTourguide = (EditText) findViewById(R.id.et_nama_tourguide);
        etNotelpTourguide = (EditText) findViewById(R.id.et_notelp_tourguide);
        etAlamatTourguide = (EditText) findViewById(R.id.et_alamat_tourguide);
        rbLakilaki = (RadioButton) findViewById(R.id.rb_lakilaki);
        rbPerempuan = (RadioButton) findViewById(R.id.rb_perempuan);
        etUmurTourguide = (EditText) findViewById(R.id.et_umur_tourguide);
        etKtpTourguide = (EditText) findViewById(R.id.et_ktp_tourguide);
        btnBatal = (Button) findViewById(R.id.btn_batal);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);
        btnBatal.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_batal:
                finish();
                break;
            case R.id.btn_simpan:
                putData();
                break;
        }
    }
}

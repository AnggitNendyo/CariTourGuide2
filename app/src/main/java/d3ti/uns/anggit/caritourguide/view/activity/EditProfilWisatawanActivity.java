package d3ti.uns.anggit.caritourguide.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditProfilWisatawanItem;
import d3ti.uns.anggit.caritourguide.model.EditProfilWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanItems;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilWisatawanActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

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
    private TextView tvFotoWisatawan;
    private Button btnUploadFoto;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    SharedPrefManager sharedPrefManager;



    // DEKLARASI UPLOAD FOTO
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private static final String SERVER_PATH = "/assets/img/foto_wisatawan/";
    private Uri uri;
    private MultipartBody.Part fileToUpload;
    private RequestBody filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_wisatawan);
        sharedPrefManager = new SharedPrefManager(this);
        initView();
        loadData();
    }

    private void loadData() {
        apiInterface.getProfilWisatawan
                (sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ProfilWisatawanResponse>() {
            @Override
            public void onResponse(Call<ProfilWisatawanResponse> call, Response<ProfilWisatawanResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ProfilWisatawanItems> profilWisatawanItems = response.body().getResult();
                        etNamaWisatawan.setText(profilWisatawanItems.get(0).getNamaWisatawan());
                        etNotelpWisatawan.setText(profilWisatawanItems.get(0).getNotelpWisatawan());
                        etAlamatWisatawan.setText(profilWisatawanItems.get(0).getAlamatWisatawan());
                        etUmurWisatawan.setText(profilWisatawanItems.get(0).getUmurWisatawan());
                        etKtpWisatawan.setText(profilWisatawanItems.get(0).getKtpWisatawan());
                        etPasporWisatawan.setText(profilWisatawanItems.get(0).getPasporWisatawan());
                        tvFotoWisatawan.setText(profilWisatawanItems.get(0).getFotoWisatawan());

                        if (profilWisatawanItems.get(0).getJenisKelamin().equals("laki-laki")) {
                            rbLakilaki.setChecked(true);
                        } else {
                            rbPerempuan.setChecked(true);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ProfilWisatawanResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void putData() {
        String jk = "";
        if (rbLakilaki.isChecked() == true) {
            jk = "laki-laki";
        }
        if (rbPerempuan.isChecked() == true) {
            jk = "perempuan";
        }
        RequestBody umurWisatawan = RequestBody.create(MediaType.parse("text/plain"), etUmurWisatawan.getText().toString());
        RequestBody pasporWisatawan = RequestBody.create(MediaType.parse("text/plain"), etPasporWisatawan.getText().toString());
        RequestBody ktpWisatawan = RequestBody.create(MediaType.parse("text/plain"), etKtpWisatawan.getText().toString());
        RequestBody emailUser = RequestBody.create(MediaType.parse("text/plain"), sharedPrefManager.getSpEmailUser());
        RequestBody namaWisatawan = RequestBody.create(MediaType.parse("text/plain"), etNamaWisatawan.getText().toString());
        RequestBody noTelpWisatawan = RequestBody.create(MediaType.parse("text/plain"), etNotelpWisatawan.getText().toString());
        RequestBody alamatWisatawan = RequestBody.create(MediaType.parse("text/plain"), etAlamatWisatawan.getText().toString());
        RequestBody jenisKelamin = RequestBody.create(MediaType.parse("text/plain"), jk);

        apiInterface.putProfilWisatawan(emailUser, namaWisatawan, noTelpWisatawan,
                alamatWisatawan, jenisKelamin, umurWisatawan, pasporWisatawan, ktpWisatawan, fileToUpload, filename)
                .enqueue(new Callback<EditProfilWisatawanResponse>() {
                    @Override
                    public void onResponse(Call<EditProfilWisatawanResponse> call, Response<EditProfilWisatawanResponse> response) {
                        try {
                            if (response.isSuccessful()) {
                                EditProfilWisatawanItem data = response.body().getResult();
                                if (!TextUtils.isEmpty(data.getNamaWisatawan())) {
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
        switch (v.getId()) {
            case R.id.btn_batal_profil_wisatawan:
                finish();
                break;

            case R.id.btn_simpan_profil_wisatawan:
                putData();
                Toast.makeText(EditProfilWisatawanActivity.this, "Berhasil Update Profil", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.btn_upload_foto_wisatawan:
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
                openGalleryIntent.setType("image/*");
                startActivityForResult(openGalleryIntent, REQUEST_GALLERY_CODE);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK){
            uri = data.getData();
            if(EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                String filePath = getRealPathFromUriPath(uri, this);
                File file = new File(filePath);
                Log.d(EditProfilWisatawanActivity.class.getSimpleName(), "Filename "+ file.getName());
                RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
                fileToUpload = MultipartBody.Part.createFormData("file", file.getName(),mFile);
                filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
                tvFotoWisatawan.setText(file.getName());
            } else {
                EasyPermissions.requestPermissions(this, "This app needs access to your file storage so that it can read photos.",READ_REQUEST_CODE,Manifest.permission.READ_EXTERNAL_STORAGE);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getRealPathFromUriPath(Uri contentURI, Activity activity){
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null,null);
        if(cursor == null){
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
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
        tvFotoWisatawan = (TextView) findViewById(R.id.tv_foto_wisatawan);
        btnUploadFoto = (Button) findViewById(R.id.btn_upload_foto_wisatawan);
        btnUploadFoto.setOnClickListener(this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if(uri != null){
            String filePath = getRealPathFromUriPath(uri, this);
            File file = new File(filePath);
            RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
            fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), mFile);
            filename = RequestBody.create(MediaType.parse("text/plain"),file.getName());
            tvFotoWisatawan.setText(file.getName());
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(EditProfilWisatawanActivity.class.getSimpleName(), "Permission has been denied !");
    }
}

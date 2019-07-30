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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditProfilTourguideItem;
import d3ti.uns.anggit.caritourguide.model.EditProfilTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideItems;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditProfilTourguideActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

    private EditText etNamaTourguide;
    private EditText etNotelpTourguide;
    private EditText etAlamatTourguide;
    private RadioButton rbLakilaki;
    private RadioButton rbPerempuan;
    private EditText etUmurTourguide;
    private EditText etKtpTourguide;
    private Button btnBatal;
    private Button btnSimpan;
    private TextView tvFotoTourguide;
    private Button btnUploadFotoT;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    SharedPrefManager sharedPrefManager;

    // DEKLARASI UPLOAD FOTO
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private static final String SERVER_PATH = "/assets/img/foto_tourguide/";
    private Uri uri;
    private MultipartBody.Part fileToUpload;
    private RequestBody filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_tourguide);
        sharedPrefManager = new SharedPrefManager(this);
        initView();
        loadData();

    }

    private void loadData(){
        apiInterface.getProfilTourguide
            (sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ProfilTourguideResponse>() {
        @Override
        public void onResponse(Call<ProfilTourguideResponse> call, Response<ProfilTourguideResponse> response) {
            try{
                if(response.isSuccessful()){
                    List<ProfilTourguideItems>profilTourguideItems = response.body().getResult();
                    etNamaTourguide.setText(profilTourguideItems.get(0).getNamaTourguide());
                    etNotelpTourguide.setText(profilTourguideItems.get(0).getNotelpTourguide());
                    etAlamatTourguide.setText(profilTourguideItems.get(0).getAlamatTourguide());
                    etUmurTourguide.setText(profilTourguideItems.get(0).getUmurTourguide());
                    etKtpTourguide.setText(profilTourguideItems.get(0).getKtpTourguide());

                    if (profilTourguideItems.get(0).getJenisKelamin().equals("laki-laki")) {
                        rbLakilaki.setChecked(true);
                    } else {
                        rbPerempuan.setChecked(true);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<ProfilTourguideResponse> call, Throwable t) {
            t.printStackTrace();
        }
    });
    }

    private void putData() {
        String jk = "";
        if(rbLakilaki.isChecked() == true) {
            jk = "laki-laki";
        }
        if(rbPerempuan.isChecked() == true) {
            jk = "perempuan";
        }

        RequestBody namaTourguide = RequestBody.create(MediaType.parse("text/plain"), etNamaTourguide.getText().toString());
        RequestBody noTelpTourguide = RequestBody.create(MediaType.parse("text/plain"), etNotelpTourguide.getText().toString());
        RequestBody alamatTourguide = RequestBody.create(MediaType.parse("text/plain"), etAlamatTourguide.getText().toString());
        RequestBody umurTourguide = RequestBody.create(MediaType.parse("text/plain"), etUmurTourguide.getText().toString());
        RequestBody ktpTourguide = RequestBody.create(MediaType.parse("text/plain"), etKtpTourguide.getText().toString());
        RequestBody jenisKelamin = RequestBody.create(MediaType.parse("text/plain"), jk);
        RequestBody emailUser = RequestBody.create(MediaType.parse("text/plain"), sharedPrefManager.getSpEmailUser());


        apiInterface.putProfilTourguide(emailUser,namaTourguide,noTelpTourguide,alamatTourguide,jenisKelamin,ktpTourguide,umurTourguide, fileToUpload, filename)
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
        btnSimpan = (Button) findViewById(R.id.btn_simpan_profil_tourguide);
        btnBatal.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);
        tvFotoTourguide = (TextView) findViewById(R.id.tv_foto_tourguide);
        btnUploadFotoT = (Button) findViewById(R.id.btn_upload_foto_tourguide);
        btnUploadFotoT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_batal:
                finish();
                break;
            case R.id.btn_simpan_profil_tourguide:
                putData();
                Toast.makeText(EditProfilTourguideActivity.this, "Berhasil Update Profil", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.btn_upload_foto_tourguide:
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
                Log.d(EditProfilTourguideActivity.class.getSimpleName(), "Filename "+ file.getName());
                RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
                fileToUpload = MultipartBody.Part.createFormData("file", file.getName(),mFile);
                filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
                tvFotoTourguide.setText(file.getName());
            } else {
                EasyPermissions.requestPermissions(this, "This app needs access to your file storage so that it can read photos.",READ_REQUEST_CODE,Manifest.permission.READ_EXTERNAL_STORAGE);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getRealPathFromUriPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null,null);
        if(cursor == null){
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (uri != null){
            String filePath = getRealPathFromUriPath(uri, this);
            File file = new File(filePath);
            RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
            fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), mFile);
            filename = RequestBody.create(MediaType.parse("text/plain"),file.getName());
            tvFotoTourguide.setText(file.getName());
        }
    }



    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(EditProfilTourguideActivity.class.getSimpleName(), "Permission has been denied !");
    }
}

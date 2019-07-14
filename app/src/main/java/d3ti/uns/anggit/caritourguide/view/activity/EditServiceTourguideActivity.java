package d3ti.uns.anggit.caritourguide.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.EditServisResponse;
import d3ti.uns.anggit.caritourguide.model.KotaItem;
import d3ti.uns.anggit.caritourguide.model.KotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditServiceTourguideActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    // Deklarasi View
    SearchableSpinner spinnerKota;
    EditText edtHarga, edtDeskripsi;

    SharedPrefManager sharedPrefManager;

    CheckBox[] hariCheckbox;
    Integer[] hariCheckboxId = {R.id.cb_hari_senin, R.id.cb_hari_selasa, R.id.cb_hari_rabu, R.id.cb_hari_kamis, R.id.cb_hari_jumat, R.id.cb_hari_sabtu, R.id.cb_hari_minggu};

    CheckBox[] topikCheckbox;
    Integer[] topikCheckboxId = {R.id.cb_topik_wisata_alam, R.id.cb_topik_sejarah, R.id.cb_topik_seni, R.id.cb_topik_olahraga, R.id.cb_topik_wisata_kuliner, R.id.cb_topik_lainnya};

    CheckBox[] fasilitasCheckbox;
    Integer[] fasilitasCheckboxId = {R.id.cb_fasilitas_jalan, R.id.cb_fasilitas_sepeda, R.id.cb_fasilitas_sepeda_motor, R.id.cb_fasilitas_mobil, R.id.cb_fasilitas_kapal, R.id.cb_fasilitas_lainnya};

    CheckBox[] bahasaCheckbox;
    Integer[] bahasaCheckboxId = {R.id.cb_bahasa_indonesia, R.id.cb_bahasa_inggris, R.id.cb_bahasa_spanyol, R.id.cb_bahasa_prancis, R.id.cb_bahasa_korea, R.id.cb_bahasa_thailand, R.id.cb_bahasa_jepang, R.id.cb_bahasa_china, R.id.cb_bahasa_lainnya};

    Button btnSimpan, btnBatal;

    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    List<KotaItem> kotaItemList = new ArrayList<>();
    List<String> kotaId = new ArrayList<>();
    List<String> kotaNama = new ArrayList<>();
    ArrayAdapter<String> adapterSpinner;

    // Form Value
    String kota, harga, deskripsi;
    ArrayList<String> hari = new ArrayList<>();
    ArrayList<String> topik = new ArrayList<>();
    ArrayList<String> servis = new ArrayList<>();
    ArrayList<String> bahasa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_service_tourguide);

        sharedPrefManager = new SharedPrefManager(this);

        initView();

        loadKota();

        adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kotaNama);

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerKota.setAdapter(adapterSpinner);

        spinnerKota.setOnItemSelectedListener(this);
    }

    private void loadKota() {
        apiInterface.getKota().enqueue(new Callback<KotaResponse>() {
            @Override
            public void onResponse(Call<KotaResponse> call, Response<KotaResponse> response) {
                try {
                    if (response.isSuccessful()) {

                        kotaItemList.addAll(response.body().getResult());

                        for (int i = 0; i < kotaItemList.size(); i++) {
                            kotaNama.add(kotaItemList.get(i).getNama());
                            kotaId.add(kotaItemList.get(i).getIdKab());
                        }
                    } else {
                        Toast.makeText(EditServiceTourguideActivity.this, "Data Kota Tidak Dapat di Load !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<KotaResponse> call, Throwable t) {

            }
        });
    }

    private void initView() {
        spinnerKota = findViewById(R.id.spinner_kota_id);
        edtHarga = findViewById(R.id.et_harga_tourguide);
        edtDeskripsi = findViewById(R.id.et_deskripsi_tourguide);
        btnSimpan = findViewById(R.id.btn_simpan_edit_servis);
        btnBatal = findViewById(R.id.btn_batal_edit_servis);
        btnSimpan.setOnClickListener(this);
        btnBatal.setOnClickListener(this);

        hariCheckbox = new CheckBox[hariCheckboxId.length];
        for (int i = 0; i < hariCheckboxId.length; i++) {
            hariCheckbox[i] = findViewById(hariCheckboxId[i]);
            hariCheckbox[i].setOnCheckedChangeListener(this);
        }

        topikCheckbox = new CheckBox[topikCheckboxId.length];
        for (int i = 0; i < topikCheckboxId.length; i++) {
            topikCheckbox[i] = findViewById(topikCheckboxId[i]);
            topikCheckbox[i].setOnCheckedChangeListener(this);
        }

        fasilitasCheckbox = new CheckBox[fasilitasCheckboxId.length];
        for (int i = 0; i < fasilitasCheckboxId.length; i++) {
            fasilitasCheckbox[i] = findViewById(fasilitasCheckboxId[i]);
            fasilitasCheckbox[i].setOnCheckedChangeListener(this);
        }

        bahasaCheckbox = new CheckBox[bahasaCheckboxId.length];
        for (int i = 0; i < bahasaCheckboxId.length; i++) {
            bahasaCheckbox[i] = findViewById(bahasaCheckboxId[i]);
            bahasaCheckbox[i].setOnCheckedChangeListener(this);
        }

        edtHarga = findViewById(R.id.et_harga_tourguide);

        edtDeskripsi = findViewById(R.id.et_deskripsi_tourguide);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        kota = kotaId.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simpan_edit_servis:
                String harga = edtHarga.getText().toString();
                String deskripsi = edtDeskripsi.getText().toString();

                apiInterface.putServis(sharedPrefManager.getSpEmailUser(), servis, topik, bahasa,hari, kota, harga, deskripsi).enqueue(new Callback<EditServisResponse>() {
                    @Override
                    public void onResponse(Call<EditServisResponse> call, Response<EditServisResponse> response) {
                        try {
                            if(response.isSuccessful()){
                                Toast.makeText(EditServiceTourguideActivity.this, "Data berhasil Diubah !", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<EditServisResponse> call, Throwable t) {

                    }
                });
                break;
            case R.id.btn_batal_edit_servis:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

            //CASE CHECK BOX HARI
            case R.id.cb_hari_senin:
                if (!hari.contains(hariCheckbox[0].getText().toString())) {
                    hari.add(hariCheckbox[0].getText().toString());
                } else {
                    hari.remove(hariCheckbox[0].getText().toString());
                }
                break;
            case R.id.cb_hari_selasa:
                if (!hari.contains(hariCheckbox[1].getText().toString())) {
                    hari.add(hariCheckbox[1].getText().toString());
                } else {
                    hari.remove(hariCheckbox[1].getText().toString());
                }
                break;
            case R.id.cb_hari_rabu:
                if (!hari.contains(hariCheckbox[2].getText().toString())) {
                    hari.add(hariCheckbox[2].getText().toString());
                } else {
                    hari.remove(hariCheckbox[2].getText().toString());
                }
                break;
            case R.id.cb_hari_kamis:
                if (!hari.contains(hariCheckbox[3].getText().toString())) {
                    hari.add(hariCheckbox[3].getText().toString());
                } else {
                    hari.remove(hariCheckbox[3].getText().toString());
                }
                break;
            case R.id.cb_hari_jumat:
                if (!hari.contains(hariCheckbox[4].getText().toString())) {
                    hari.add(hariCheckbox[4].getText().toString());
                } else {
                    hari.remove(hariCheckbox[4].getText().toString());
                }
                break;
            case R.id.cb_hari_sabtu:
                if (!hari.contains(hariCheckbox[5].getText().toString())) {
                    hari.add(hariCheckbox[5].getText().toString());
                } else {
                    hari.remove(hariCheckbox[5].getText().toString());
                }
                break;
            case R.id.cb_hari_minggu:
                if (!hari.contains(hariCheckbox[6].getText().toString())) {
                    hari.add(hariCheckbox[6].getText().toString());
                } else {
                    hari.remove(hariCheckbox[6].getText().toString());
                }
                break;

            //CASE CHECK BOX TOPIK TOUR
            case R.id.cb_topik_wisata_alam:
                if (!topik.contains(topikCheckbox[0].getText().toString())) {
                    topik.add(topikCheckbox[0].getText().toString());
                } else {
                    topik.remove(topikCheckbox[0].getText().toString());
                }
                break;

            case R.id.cb_topik_sejarah:
                if (!topik.contains(topikCheckbox[1].getText().toString())) {
                    topik.add(topikCheckbox[1].getText().toString());
                } else {
                    topik.remove(topikCheckbox[1].getText().toString());
                }
                break;

            case R.id.cb_topik_seni:
                if (!topik.contains(topikCheckbox[2].getText().toString())) {
                    topik.add(topikCheckbox[2].getText().toString());
                } else {
                    topik.remove(topikCheckbox[2].getText().toString());
                }
                break;

            case R.id.cb_topik_olahraga:
                if (!topik.contains(topikCheckbox[3].getText().toString())) {
                    topik.add(topikCheckbox[3].getText().toString());
                } else {
                    topik.remove(topikCheckbox[3].getText().toString());
                }
                break;

            case R.id.cb_topik_wisata_kuliner:
                if (!topik.contains(topikCheckbox[4].getText().toString())) {
                    topik.add(topikCheckbox[4].getText().toString());
                } else {
                    topik.remove(topikCheckbox[4].getText().toString());
                }
                break;

            case R.id.cb_topik_lainnya:
                if (!topik.contains(topikCheckbox[5].getText().toString())) {
                    topik.add(topikCheckbox[5].getText().toString());
                } else {
                    topik.remove(topikCheckbox[5].getText().toString());
                }
                break;


                //CASE CHECK BOX FASILITAS

            case R.id.cb_fasilitas_jalan:
                if (!servis.contains(fasilitasCheckbox[0].getText().toString())) {
                    servis.add(fasilitasCheckbox[0].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[0].getText().toString());
                }
                break;

            case R.id.cb_fasilitas_sepeda:
                if (!servis.contains(fasilitasCheckbox[1].getText().toString())) {
                    servis.add(fasilitasCheckbox[1].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[1].getText().toString());
                }
                break;

            case R.id.cb_fasilitas_sepeda_motor:
                if (!servis.contains(fasilitasCheckbox[2].getText().toString())) {
                    servis.add(fasilitasCheckbox[2].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[2].getText().toString());
                }
                break;

            case R.id.cb_fasilitas_mobil:
                if (!servis.contains(fasilitasCheckbox[3].getText().toString())) {
                    servis.add(fasilitasCheckbox[3].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[3].getText().toString());
                }
                break;

            case R.id.cb_fasilitas_kapal:
                if (!servis.contains(fasilitasCheckbox[4].getText().toString())) {
                    servis.add(fasilitasCheckbox[4].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[4].getText().toString());
                }
                break;

            case R.id.cb_fasilitas_lainnya:
                if (!servis.contains(fasilitasCheckbox[5].getText().toString())) {
                    servis.add(fasilitasCheckbox[5].getText().toString());
                } else {
                    servis.remove(fasilitasCheckbox[5].getText().toString());
                }
                break;

                //CASE CHECK BOX BAHASA
            case R.id.cb_bahasa_indonesia:
                if (!bahasa.contains(bahasaCheckbox[0].getText().toString())) {
                    bahasa.add(bahasaCheckbox[0].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[0].getText().toString());
                }
                break;

            case R.id.cb_bahasa_inggris:
                if (!bahasa.contains(bahasaCheckbox[1].getText().toString())) {
                    bahasa.add(bahasaCheckbox[1].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[1].getText().toString());
                }
                break;

            case R.id.cb_bahasa_spanyol:
                if (!bahasa.contains(bahasaCheckbox[2].getText().toString())) {
                    bahasa.add(bahasaCheckbox[2].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[2].getText().toString());
                }
                break;

            case R.id.cb_bahasa_prancis:
                if (!bahasa.contains(bahasaCheckbox[3].getText().toString())) {
                    bahasa.add(bahasaCheckbox[3].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[3].getText().toString());
                }
                break;

            case R.id.cb_bahasa_korea:
                if (!bahasa.contains(bahasaCheckbox[4].getText().toString())) {
                    bahasa.add(bahasaCheckbox[4].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[4].getText().toString());
                }
                break;

            case R.id.cb_bahasa_thailand:
                if (!bahasa.contains(bahasaCheckbox[5].getText().toString())) {
                    bahasa.add(bahasaCheckbox[5].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[5].getText().toString());
                }
                break;

            case R.id.cb_bahasa_jepang:
                if (!bahasa.contains(bahasaCheckbox[6].getText().toString())) {
                    bahasa.add(bahasaCheckbox[6].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[6].getText().toString());
                }
                break;

            case R.id.cb_bahasa_china:
                if (!bahasa.contains(bahasaCheckbox[7].getText().toString())) {
                    bahasa.add(bahasaCheckbox[7].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[7].getText().toString());
                }
                break;

            case R.id.cb_bahasa_lainnya:
                if (!bahasa.contains(bahasaCheckbox[8].getText().toString())) {
                    bahasa.add(bahasaCheckbox[8].getText().toString());
                } else {
                    bahasa.remove(bahasaCheckbox[8].getText().toString());
                }
                break;


        }
    }
}

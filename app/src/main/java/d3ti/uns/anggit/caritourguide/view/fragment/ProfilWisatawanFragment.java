package d3ti.uns.anggit.caritourguide.view.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanItems;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanResponse;
import d3ti.uns.anggit.caritourguide.view.activity.EditProfilWisatawanActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilWisatawanFragment extends Fragment implements View.OnClickListener {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    ImageButton ib_edit_profil_wisatawan;
    ImageView iv_foto_wisatawan;
    TextView tv_nama_wisatawan;
    TextView tv_email_wisatawan;
    TextView tv_notelp_wisatawan;
    TextView tv_alamat_wisatawan;
    TextView tv_jenis_kelamin;
    TextView tv_umur_wisatawan;
    TextView tv_paspor_wisatawan;
    TextView tv_ktp_wisatawan;
    private View view;
    SharedPrefManager sharedPrefManager;

    public ProfilWisatawanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profil_wisatawan, container, false);

        ib_edit_profil_wisatawan = view.findViewById(R.id.ib_edit_profil_wisatawan);
        ib_edit_profil_wisatawan.setOnClickListener(this);
        initView();
        sharedPrefManager = new SharedPrefManager(getContext());
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getProfilWisatawan(sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ProfilWisatawanResponse>() {
            @Override
            public void onResponse(Call<ProfilWisatawanResponse> call, Response<ProfilWisatawanResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ProfilWisatawanItems> profilWisatawanItems = response.body().getResult();
                        Glide.with(view).load("http://192.168.43.25/caritourguide/assets/img/foto_wisatawan/" + response.body().getResult().get(0).getFotoWisatawan()).into(iv_foto_wisatawan);
//                        iv_foto_wisatawan.setImageBitmap(profilWisatawanItems.get(0).getFotoWisatawan());
                        tv_nama_wisatawan.setText(profilWisatawanItems.get(0).getNamaWisatawan());
                        tv_email_wisatawan.setText(profilWisatawanItems.get(0).getEmailWisatawan());
                        tv_notelp_wisatawan.setText(profilWisatawanItems.get(0).getNotelpWisatawan());
                        tv_alamat_wisatawan.setText(profilWisatawanItems.get(0).getAlamatWisatawan());
                        tv_jenis_kelamin.setText(profilWisatawanItems.get(0).getJenisKelamin());
                        tv_umur_wisatawan.setText(profilWisatawanItems.get(0).getUmurWisatawan());
                        tv_paspor_wisatawan.setText(profilWisatawanItems.get(0).getPasporWisatawan());
                        tv_ktp_wisatawan.setText(profilWisatawanItems.get(0).getKtpWisatawan());

                    } else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
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

    private void initView() {
        iv_foto_wisatawan = view.findViewById(R.id.iv_foto_wisatawan);
        tv_nama_wisatawan = view.findViewById(R.id.tv_nama_wisatawan);
        tv_email_wisatawan = view.findViewById(R.id.tv_email_wisatawan);
        tv_notelp_wisatawan = view.findViewById(R.id.tv_notelp_wisatawan);
        tv_alamat_wisatawan = view.findViewById(R.id.tv_alamat_wisatawan);
        tv_jenis_kelamin = view.findViewById(R.id.tv_jenis_kelamin);
        tv_umur_wisatawan = view.findViewById(R.id.tv_umur_wisatawan);
        tv_paspor_wisatawan = view.findViewById(R.id.tv_paspor_wisatawan);
        tv_ktp_wisatawan = view.findViewById(R.id.tv_ktp_wisatawan);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_edit_profil_wisatawan:
                Intent intent = new Intent(getActivity(), EditProfilWisatawanActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}

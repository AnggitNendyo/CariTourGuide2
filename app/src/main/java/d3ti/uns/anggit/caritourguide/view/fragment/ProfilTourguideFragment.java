package d3ti.uns.anggit.caritourguide.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideItems;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideResponse;
import d3ti.uns.anggit.caritourguide.view.activity.EditProfilTourguideActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilTourguideFragment extends Fragment implements View.OnClickListener {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    ImageButton ib_edit_profil_tourguide;
    ImageView iv_foto_tourguide;
    TextView tv_status_tourguide;
    TextView tv_nama_tourguide;
    TextView tv_email_tourguide;
    TextView tv_notelp_tourguide;
    TextView tv_alamat_tourguide;
    TextView tv_jenis_kelamin;
    TextView tv_umur_tourguide;
    TextView tv_ktp_tourguide;
    private View view;

    public ProfilTourguideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_profil_tourguide, container, false);

        ib_edit_profil_tourguide = view.findViewById(R.id.ib_edit_profil_tourguide);
        ib_edit_profil_tourguide.setOnClickListener(this);
        initView();
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getProfilTourguide().enqueue(new Callback<ProfilTourguideResponse>() {
            @Override
            public void onResponse(Call<ProfilTourguideResponse> call, Response<ProfilTourguideResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ProfilTourguideItems>profilTourguideItems = response.body().getResult();
                        Glide.with(view).load("http://192.168.43.25/caritourguide/assets/img/foto_tourguide/" + response.body().getResult().get(0).getFotoTourguide()).into(iv_foto_tourguide);
                        tv_nama_tourguide.setText(profilTourguideItems.get(0).getNamaTourguide());
                        tv_email_tourguide.setText(profilTourguideItems.get(0).getEmailTourguide());
                        tv_notelp_tourguide.setText(profilTourguideItems.get(0).getNotelpTourguide());
                        tv_alamat_tourguide.setText(profilTourguideItems.get(0).getAlamatTourguide());
                        tv_jenis_kelamin.setText(profilTourguideItems.get(0).getJenisKelamin());
                        tv_umur_tourguide.setText(profilTourguideItems.get(0).getUmurTourguide());
                        tv_ktp_tourguide.setText(profilTourguideItems.get(0).getKtpTourguide());
                        tv_status_tourguide.setText(profilTourguideItems.get(0).getStatusTourguide());

                    } else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ProfilTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initView() {
        iv_foto_tourguide = view.findViewById(R.id.iv_foto_tourguide);
        tv_status_tourguide = view.findViewById(R.id.tv_status_tourguide);
        tv_nama_tourguide = view.findViewById(R.id.tv_nama_tourguide);
        tv_email_tourguide = view.findViewById(R.id.tv_email_tourguide);
        tv_notelp_tourguide = view.findViewById(R.id.tv_notelp_tourguide);
        tv_alamat_tourguide = view.findViewById(R.id.tv_alamat_tourguide);
        tv_jenis_kelamin = view.findViewById(R.id.tv_jenis_kelamin);
        tv_umur_tourguide = view.findViewById(R.id.tv_umur_tourguide);
        tv_ktp_tourguide = view.findViewById(R.id.tv_ktp_tourguide);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_edit_profil_tourguide:
                Intent intent = new Intent(getActivity(), EditProfilTourguideActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}

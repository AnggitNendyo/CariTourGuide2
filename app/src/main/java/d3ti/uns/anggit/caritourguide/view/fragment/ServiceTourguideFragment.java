package d3ti.uns.anggit.caritourguide.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.BahasaItem;
import d3ti.uns.anggit.caritourguide.model.HariItem;
import d3ti.uns.anggit.caritourguide.model.ServiceTourguideItems;
import d3ti.uns.anggit.caritourguide.model.ServiceTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ServisItem;
import d3ti.uns.anggit.caritourguide.model.TopikItem;
import d3ti.uns.anggit.caritourguide.model.TourguideItem;
import d3ti.uns.anggit.caritourguide.view.activity.EditServiceTourguideActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceTourguideFragment extends Fragment implements View.OnClickListener {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    ImageButton ib_edit_service_tour;
    TextView tv_kota_tourguide;
    TextView tv_harga_tourguide;
    TextView tv_hari_tourguide;
    TextView tv_topik_tourguide;
    TextView tv_fasilitas_tourguide;
    TextView tv_bahasa_tourguide;
    TextView tv_deskripsi_tourguide;
    private View view;
    SharedPrefManager sharedPrefManager;

    public ServiceTourguideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_service_tourguide, container, false);

        ib_edit_service_tour = view.findViewById(R.id.ib_edit_service_tour);
        ib_edit_service_tour.setOnClickListener(this);
        sharedPrefManager = new SharedPrefManager(getContext());

        initView();
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getServiceTourguide(sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ServiceTourguideResponse>() {
            @Override
            public void onResponse(Call<ServiceTourguideResponse> call, Response<ServiceTourguideResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ServisItem> servisItemList = response.body().getResult().getServis();
                        List<TourguideItem> tourguideItemList = response.body().getResult().getTourguide();
                        List<HariItem> hariItemList = response.body().getResult().getHari();
                        List<TopikItem> topikItemList = response.body().getResult().getTopik();
                        List<BahasaItem> bahasaItemList = response.body().getResult().getBahasa();

//                        Log.d("WOYO",tourguideItemList.get(0).getIdKab());



                        tv_kota_tourguide.setText(tourguideItemList.get(0).getNama());
                        tv_harga_tourguide.setText(tourguideItemList.get(0).getHargaTourguide());
                        tv_deskripsi_tourguide.setText(tourguideItemList.get(0).getDeskripsiTourguide());

                        tv_hari_tourguide.setText(hariItemList.get(0).getNamaHari());
                        tv_bahasa_tourguide.setText(bahasaItemList.get(0).getNamaBahasa());
                        tv_topik_tourguide.setText(topikItemList.get(0).getNamaTopik());
                        tv_fasilitas_tourguide.setText(servisItemList.get(0).getNamaServis());

                    } else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ServiceTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initView() {
        tv_kota_tourguide = view.findViewById(R.id.tv_kota_tourguide);
        tv_harga_tourguide = view.findViewById(R.id.tv_harga_tourguide);
        tv_hari_tourguide = view.findViewById(R.id.tv_hari_tourguide);
        tv_topik_tourguide = view.findViewById(R.id.tv_topik_tourguide);
        tv_fasilitas_tourguide = view.findViewById(R.id.tv_fasilitas_tourguide);
        tv_bahasa_tourguide = view.findViewById(R.id.tv_bahasa_tourguide);
        tv_deskripsi_tourguide = view.findViewById(R.id.tv_deskripsi_tourguide);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_edit_service_tour:
                Intent intent = new Intent(getActivity(), EditServiceTourguideActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}

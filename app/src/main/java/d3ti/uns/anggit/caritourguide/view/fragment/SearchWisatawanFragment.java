package d3ti.uns.anggit.caritourguide.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.adapter.SearchTourguideAdapter;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.KotaItem;
import d3ti.uns.anggit.caritourguide.model.KotaResponse;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideItems;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideResponse;
import d3ti.uns.anggit.caritourguide.view.activity.EditServiceTourguideActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchWisatawanFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    List<SearchTourguideItems> searchTourguideItems = new ArrayList<>();
    List<KotaItem> kotaItemList = new ArrayList<>();
    List<String> kotaId = new ArrayList<>();
    List<String> kotaNama = new ArrayList<>();
    ArrayAdapter<String> adapterSpinner;
    SearchableSpinner spinnerKota;
    private View view;

    //Form Value
    String kota;

    RecyclerView rvTourguide;
    SearchTourguideAdapter rvAdapter;

    public SearchWisatawanFragment() {
        // Required empty public constructor
    }
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_wisatawan, container, false);
            
        rvTourguide = (RecyclerView)view.findViewById(R.id.rv_search_tourguide);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        rvTourguide.setHasFixedSize(true);
        rvTourguide.setLayoutManager(layoutManager);
        loadKota();
        loadData();
        initView();

        Toast.makeText(getActivity(), "Silahkan Pilih Kota Wisata Anda Terlebih Dahulu !", Toast.LENGTH_SHORT).show();

        adapterSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, kotaNama);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKota.setAdapter(adapterSpinner);
        spinnerKota.setOnItemSelectedListener(this);

        return view;
    }

    private void initView() {
        spinnerKota = view.findViewById(R.id.spinner_search_id);
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
                        Toast.makeText(getActivity(), "Mengambil Data Kota Gagal !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<KotaResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadData() {
        apiInterface.getSearchTourguide().enqueue(new Callback<SearchTourguideResponse>() {
            @Override

            public void onResponse(Call<SearchTourguideResponse> call, Response<SearchTourguideResponse> response) {
                try{
                    if (response.isSuccessful()){
                        searchTourguideItems = response.body().getResult();
                        rvAdapter = new SearchTourguideAdapter(getContext(), searchTourguideItems,
                                Glide.with(getActivity()));
                        rvTourguide.setAdapter(rvAdapter);

                    }else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SearchTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadDataByQuery(String kota){
        apiInterface.getSearchTourguideQuery(kota).enqueue(new Callback<SearchTourguideResponse>() {
            @Override
            public void onResponse(Call<SearchTourguideResponse> call, Response<SearchTourguideResponse> response) {
                try{
                    if (response.isSuccessful()){
                        searchTourguideItems = response.body().getResult();
                        rvAdapter = new SearchTourguideAdapter(getContext(), searchTourguideItems,
                                Glide.with(getActivity()));
                        rvTourguide.setAdapter(rvAdapter);

                    }else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SearchTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        kota = kotaId.get(position);
        // First item will be gray
//        if (position == 0) {
//
//            ((TextView) view).setTextColor(ContextCompat.getColor(getContext(), R.color.grey));
//        } else {
//            ((TextView) view).setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
//        }
        loadDataByQuery(kota);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


}
package d3ti.uns.anggit.caritourguide.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.adapter.ListViewAdapterWisatawan;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.PemesananItemW;
import d3ti.uns.anggit.caritourguide.model.PemesananWisatawanResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PemesananWisatawanFragment extends Fragment {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    List<PemesananItemW> pemesananItems = new ArrayList<>();
    SharedPrefManager sharedPrefManager;
    private View view;

    RecyclerView rvListPemesananWisatawan;

    ListViewAdapterWisatawan rvAdapter;


    public PemesananWisatawanFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pemesanan_wisatawan, container, false);

        rvListPemesananWisatawan = (RecyclerView)view.findViewById(R.id.rv_list_pemesanan_wisatawan);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvListPemesananWisatawan.setHasFixedSize(true);
        rvListPemesananWisatawan.setLayoutManager(layoutManager);
        sharedPrefManager = new SharedPrefManager(getContext());
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getPemesananWisatawan(sharedPrefManager.getSpEmailUser()).enqueue(new Callback<PemesananWisatawanResponse>() {
            @Override
            public void onResponse(Call<PemesananWisatawanResponse> call, Response<PemesananWisatawanResponse> response) {
                try{
                    if (response.isSuccessful()){
                        pemesananItems = response.body().getResult().getPemesanan();
                        rvAdapter = new ListViewAdapterWisatawan(getContext(), pemesananItems,
                                Glide.with(getActivity()));
                        rvListPemesananWisatawan.setAdapter(rvAdapter);

                    }else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PemesananWisatawanResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}





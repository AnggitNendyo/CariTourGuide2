package d3ti.uns.anggit.caritourguide.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.adapter.SearchTourguideAdapter;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideItems;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchWisatawanFragment extends Fragment {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    List<SearchTourguideItems> searchTourguideItems = new ArrayList<>();
    private View view;

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

        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getSearchTourguide().enqueue(new Callback<SearchTourguideResponse>() {
            @Override

            public void onResponse(Call<SearchTourguideResponse> call, Response<SearchTourguideResponse> response) {
                try{
                    if (response.isSuccessful()){
                        searchTourguideItems = response.body().getResult();
                        rvAdapter = new SearchTourguideAdapter(getContext(), searchTourguideItems, Glide.with(getActivity()));
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
}
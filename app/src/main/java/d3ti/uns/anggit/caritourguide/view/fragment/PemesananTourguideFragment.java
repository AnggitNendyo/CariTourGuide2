package d3ti.uns.anggit.caritourguide.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import d3ti.uns.anggit.caritourguide.adapter.ListViewAdapterTourguide;
import d3ti.uns.anggit.caritourguide.adapter.ListViewAdapterWisatawan;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.PemesananItemT;
import d3ti.uns.anggit.caritourguide.model.PemesananItemW;
import d3ti.uns.anggit.caritourguide.model.PemesananTourguideResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PemesananTourguideFragment extends Fragment {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    List<PemesananItemT> pemesananItemT = new ArrayList<>();
    SharedPrefManager sharedPrefManager;
    private View view;

    RecyclerView rvListPemesananTourguide;

    ListViewAdapterTourguide rvAdapter;

    public PemesananTourguideFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pemesanan_tourguide, container, false);

        rvListPemesananTourguide = (RecyclerView) view.findViewById(R.id.rv_list_pemesanan_tourguide);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvListPemesananTourguide.setHasFixedSize(true);
        rvListPemesananTourguide.setLayoutManager(layoutManager);
        sharedPrefManager = new SharedPrefManager(getContext());
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface.getPemesananTourguide(sharedPrefManager.getSpEmailUser()).enqueue(new Callback<PemesananTourguideResponse>() {
            @Override
            public void onResponse(Call<PemesananTourguideResponse> call, Response<PemesananTourguideResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        pemesananItemT = response.body().getResult().getPemesanan();
                        rvAdapter = new ListViewAdapterTourguide(getContext(), pemesananItemT,
                                Glide.with(getActivity()));
                        rvListPemesananTourguide.setAdapter(rvAdapter);

                    } else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PemesananTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
package d3ti.uns.anggit.caritourguide.view.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide._sliders.FragmentSlider;
import d3ti.uns.anggit.caritourguide._sliders.SliderIndicator;
import d3ti.uns.anggit.caritourguide._sliders.SliderPagerAdapter;
import d3ti.uns.anggit.caritourguide._sliders.SliderView;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanItems;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaWisatawanFragment extends Fragment {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    TextView tv_nama_wisatawan;
    ImageView foto_wisatawan_id;
    SharedPrefManager sharedPrefManager;
    private View view;

    private Toolbar toolbar;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    public BerandaWisatawanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beranda_wisatawan, container, false);
        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();
        initView();
        sharedPrefManager = new SharedPrefManager(getContext());
        loadData();
        return view;
    }

    private void loadData() { apiInterface.getProfilWisatawan
            (sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ProfilWisatawanResponse>() {
        @Override
        public void onResponse(Call<ProfilWisatawanResponse> call, Response<ProfilWisatawanResponse> response) {
            try{
                if (response.isSuccessful()){
                    List<ProfilWisatawanItems> profilWisatawanItems = response.body().getResult();
                    Glide.with(view).load("http://192.168.43.25/caritourguide/assets/img/foto_wisatawan/" + response.body().getResult().get(0).getFotoWisatawan()).into(foto_wisatawan_id);
                    tv_nama_wisatawan.setText(profilWisatawanItems.get(0).getNamaWisatawan());
                }else {
                    Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e) {
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
        foto_wisatawan_id = view.findViewById(R.id.foto_wisatawan_id);
        tv_nama_wisatawan = view.findViewById(R.id.tv_nama_wisatawan);
    }

    private void setupSlider(){
            sliderView.setDurationScroll(800);
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(FragmentSlider.newInstance("R.drawable.sliderctg2"));
            fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
            fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
            fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

            mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
            sliderView.setAdapter(mAdapter);
            mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
            mIndicator.setPageCount(fragments.size());
            mIndicator.show();
        }

    }

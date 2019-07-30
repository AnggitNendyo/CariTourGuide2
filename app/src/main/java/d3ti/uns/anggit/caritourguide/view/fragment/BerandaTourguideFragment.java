package d3ti.uns.anggit.caritourguide.view.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import d3ti.uns.anggit.caritourguide.model.BerandaTourguideItems;
import d3ti.uns.anggit.caritourguide.model.BerandaTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideItems;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaTourguideFragment extends Fragment  {
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    TextView tv_nama_tourguide, tv_status_pemesanan_t, tv_jumlah_pemesanan_t, tv_status_tourguide;
    ImageView foto_tourguide;
    SharedPrefManager sharedPrefManager;

    private View view;

    BerandaTourguideItems berandaTourguideItems;

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    public BerandaTourguideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beranda_tourguide, container, false);
        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();

        sharedPrefManager = new SharedPrefManager(getContext());
        initView();
        loadData();
        loadBeranda();
        return view;
    }

    private void initView() {
        tv_nama_tourguide = view.findViewById(R.id.tv_beranda_nama_tourguide);
        tv_jumlah_pemesanan_t = view.findViewById(R.id.tv_beranda_tourguide_jumlah);
        tv_status_pemesanan_t = view.findViewById(R.id.tv_beranda_tourguide_status);
        tv_status_tourguide = view.findViewById(R.id.tv_beranda_status_tourguide);
        foto_tourguide = view.findViewById(R.id.beranda_foto_tourguide);
    }

    private void loadData() {
        apiInterface.getProfilTourguide
                (sharedPrefManager.getSpEmailUser()).enqueue(new Callback<ProfilTourguideResponse>() {
            @Override
            public void onResponse(Call<ProfilTourguideResponse> call, Response<ProfilTourguideResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ProfilTourguideItems> profilTourguideItems = response.body().getResult();
                        Glide.with(view).load(BASE_URL + "caritourguide/assets/img/foto_tourguide/" + response.body().getResult().get(0).getFotoTourguide()).into(foto_tourguide);
                        tv_nama_tourguide.setText(profilTourguideItems.get(0).getNamaTourguide());
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

    private void loadBeranda() {
        apiInterface.getBerandaTourguide
                (sharedPrefManager.getSpEmailUser()).enqueue(new Callback<BerandaTourguideResponse>() {
            @Override
            public void onResponse(Call<BerandaTourguideResponse> call, Response<BerandaTourguideResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        berandaTourguideItems = response.body().getResult();
                        tv_jumlah_pemesanan_t.setText(Integer.toString(berandaTourguideItems.getJumlah()));
                        tv_status_pemesanan_t.setText(berandaTourguideItems.getStatus().getStatusPemesanan());
                    } else {
                        Toast.makeText(getActivity(), "Mengambil Data Gagal !", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BerandaTourguideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("slideshow"));
        fragments.add(FragmentSlider.newInstance("slideshowt1"));
        fragments.add(FragmentSlider.newInstance("slideshowt2"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}

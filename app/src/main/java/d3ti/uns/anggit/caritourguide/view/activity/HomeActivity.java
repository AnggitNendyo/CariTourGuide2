package d3ti.uns.anggit.caritourguide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.adapter.HomeViewPagerAdapter;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;


public class HomeActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getSPSudahLogin() && sharedPrefManager.getSpKetLogin().equals("wisatawan")) {
            Intent intent = new Intent(this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } else if(sharedPrefManager.getSPSudahLogin() && sharedPrefManager.getSpKetLogin().equals("tourguide")){
            Intent intent = new Intent(this, MainActivityTourguide.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(homeViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        ivLogo = (ImageView) findViewById(R.id.iv_logo);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }
}
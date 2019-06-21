package d3ti.uns.anggit.caritourguide.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.view.fragment.BerandaTourguideFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.PemesananTourguideFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.ProfilTourguideFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.ServiceTourguideFragment;

public class MainActivityTourguide extends AppCompatActivity {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tourguide);
        if(savedInstanceState == null) {
            fragment = new BerandaTourguideFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayoutTourguide, fragment);
            fragmentTransaction.commit();
        }
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationTourguide);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                if (item.getItemId() == R.id.nav_beranda_tourguide) {
                    fragment = new BerandaTourguideFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayoutTourguide, fragment);
                    fragmentTransaction.commit();

                } else if (item.getItemId() == R.id.nav_service_tourguide) {
                    fragment = new ServiceTourguideFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayoutTourguide, fragment);
                    fragmentTransaction.commit();

                } else if (item.getItemId() == R.id.nav_pesanan_tourguide) {
                    fragment = new PemesananTourguideFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayoutTourguide, fragment);
                    fragmentTransaction.commit();

                }else if (item.getItemId() == R.id.nav_profil_tourguide) {
                    fragment = new ProfilTourguideFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayoutTourguide, fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }
}
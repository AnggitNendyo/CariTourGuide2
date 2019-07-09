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
import d3ti.uns.anggit.caritourguide.view.fragment.BerandaWisatawanFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.PemesananWisatawanFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.ProfilWisatawanFragment;
import d3ti.uns.anggit.caritourguide.view.fragment.SearchWisatawanFragment;

public class MainActivity extends AppCompatActivity {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            fragment = new BerandaWisatawanFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_beranda_wisatawan) {
                    fragment = new BerandaWisatawanFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();

                } else if (item.getItemId() == R.id.nav_search_wisatawan) {
                    fragment = new SearchWisatawanFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();

                } else if (item.getItemId() == R.id.nav_pesanan_wisatawan) {
                    fragment = new PemesananWisatawanFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();

                }else if (item.getItemId() == R.id.nav_profil_wisatawan) {
                    fragment = new ProfilWisatawanFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }
}
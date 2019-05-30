package d3ti.uns.anggit.caritourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

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
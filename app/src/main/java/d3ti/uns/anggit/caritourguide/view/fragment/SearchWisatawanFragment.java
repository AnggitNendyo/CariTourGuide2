package d3ti.uns.anggit.caritourguide.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.adapter.RecyclerViewAdapter;
import d3ti.uns.anggit.caritourguide.view.activity.DaftarTourguide;

public class SearchWisatawanFragment extends Fragment {

    List<DaftarTourguide> tourguides;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_wisatawan, container, false);

        tourguides = new ArrayList<>();
        tourguides.add(new DaftarTourguide("Anggit Nendyo", "anggitnendyo9@gmail.com","aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 2", "anggitnendyo9@gmail.com","aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 3", "anggitnendyo9@gmail.com", "aktif", R.drawable.putri,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 4", "anggitnendyo9@gmail.com", "aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 5", "anggitnendyo9@gmail.com", "aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 6", "anggitnendyo9@gmail.com","aktif",  R.drawable.putri,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 7", "anggitnendyo9@gmail.com","aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 8", "anggitnendyo9@gmail.com","aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 9", "anggitnendyo9@gmail.com", "aktif", R.drawable.putri,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 10", "anggitnendyo9@gmail.com", "aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 11", "anggitnendyo9@gmail.com", "aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 12", "anggitnendyo9@gmail.com","aktif",  R.drawable.putri,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 13", "anggitnendyo9@gmail.com","aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 14", "anggitnendyo9@gmail.com","aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 15", "anggitnendyo9@gmail.com", "aktif", R.drawable.putri,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 16", "anggitnendyo9@gmail.com", "aktif", R.drawable.foto3,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 17", "anggitnendyo9@gmail.com", "aktif", R.drawable.nisa,"100000","Solo","Saya tourguide"));
        tourguides.add(new DaftarTourguide("Tour Guide 18", "anggitnendyo9@gmail.com","aktif",  R.drawable.putri,"100000","Solo","Saya tourguide"));


        RecyclerView rvTourguide = (RecyclerView)view.findViewById(R.id.rv_search_tourguide);
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(getContext(), tourguides);
        rvTourguide.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvTourguide.setAdapter(rvAdapter);
        return view;
    }
}
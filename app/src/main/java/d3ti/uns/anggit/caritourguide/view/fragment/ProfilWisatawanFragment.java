package d3ti.uns.anggit.caritourguide.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.view.activity.EditProfilWisatawanActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilWisatawanFragment extends Fragment implements View.OnClickListener {
ImageButton ib_edit_profil_wisatawan;

    public ProfilWisatawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_wisatawan, container, false);

        ib_edit_profil_wisatawan = view.findViewById(R.id.ib_edit_profil_wisatawan);
        ib_edit_profil_wisatawan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_edit_profil_wisatawan:
                Intent intent = new Intent(getActivity(), EditProfilWisatawanActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}

package d3ti.uns.anggit.caritourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d3ti.uns.anggit.caritourguide.adapter.ListViewAdapterWisatawan;


/**
 * A simple {@link Fragment} subclass.
 */
public class PemesananWisatawanFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected ListViewAdapterWisatawan mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset2, mDataset3, mDataset4;
    protected int[] mDataset1;

    int [] foto_tourguide = {R.drawable.foto3, R.drawable.nisa,R.drawable.putri};
    String [] nama_tourguide = {"Anggit Nendyo","Anggit Nendyo","Anggit Nendyo"};
    String [] harga_tourguide = {"50000","50000","50000"};
    String [] status_pemesanan = {"selesai","selesai","cancel"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pemesanan_wisatawan, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list_pemesanan_wisatawan);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new ListViewAdapterWisatawan(mDataset1,mDataset2,mDataset3,mDataset4);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset1 = new int[foto_tourguide.length];
        mDataset2 = new String[nama_tourguide.length];
        mDataset3 = new String[harga_tourguide.length];
        mDataset4 = new String[status_pemesanan.length];
        for (int i = 0; i < foto_tourguide.length; i++) {
            mDataset1[i] = foto_tourguide[i];
            mDataset2[i] = nama_tourguide[i];
            mDataset3[i] = harga_tourguide[i];
            mDataset4[i] = status_pemesanan[i];
        }
    }
}





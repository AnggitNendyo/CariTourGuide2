package d3ti.uns.anggit.caritourguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import d3ti.uns.anggit.caritourguide.R;

public class ListViewAdapterTourguide extends RecyclerView.Adapter<ListViewAdapterTourguide.ViewHolder> {
    private static final String TAG = "ListViewGuide";

    private int[] mDataSet1;
    private String[] mDataSet2,mDataSet3,mDataSet4;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_nama_wisatawan,tv_tanggal_tour,tv_status_pemesanan;
        private final ImageView foto_wisatawan;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            foto_wisatawan = (ImageView) view.findViewById(R.id.foto_wisatawan);
            tv_nama_wisatawan = (TextView) view.findViewById(R.id.tv_nama_wisatawan);
            tv_tanggal_tour = (TextView) view.findViewById(R.id.tv_tanggal_tour);
            tv_status_pemesanan = (TextView) view.findViewById(R.id.tv_status_pemesanan_tourguide);
        }

        public ImageView getFoto_wisatawan() {
            return foto_wisatawan;
        }
        public TextView getTv_nama_wisatawan() {return tv_nama_wisatawan;}
        public TextView getTv_tanggal_tour() {return tv_tanggal_tour;}
        public TextView getStatus_pemesanan() {
            return tv_status_pemesanan;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet1 String[] containing the data to populate views to be used by RecyclerView.
     */

    public ListViewAdapterTourguide(int[]dataSet1, String[]dataSet2, String[]dataSet3, String[]dataSet4) {
        this.mDataSet1 = dataSet1;
        this.mDataSet2 = dataSet2;
        this.mDataSet3 = dataSet3;
        this.mDataSet4 = dataSet4;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lv_pemesanan_tourguide, viewGroup, false);

        return new ViewHolder(view);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getFoto_wisatawan().setImageResource(mDataSet1[position]);
        viewHolder.getTv_nama_wisatawan().setText(mDataSet2[position]);
        viewHolder.getTv_tanggal_tour().setText(mDataSet3[position]);
        viewHolder.getStatus_pemesanan().setText(mDataSet4[position]);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet1.length;
    }
}
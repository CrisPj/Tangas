package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tiendita.com.tienda.R;
import tiendita.com.tienda.fragments.ProductosFragment.OnListFragmentInteractionListener;
import tiendita.com.tienda.entities.Image;
import tiendita.com.tienda.entities.Product;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Product} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {

    private final Product[] mValues;
    private final OnListFragmentInteractionListener mListener;

    Context context;

    public ProductoRecyclerViewAdapter(Product[] items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        this.context = context;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues[position];
        holder.mIdView.setText(""+mValues[position].getId());

        holder.mContentView.setText(mValues[position].getName());
        Image[] images = mValues[position].getImages();
        if (images.length > 0)
            Picasso.with(context).load(images[0].getSrc()).into(holder.mImageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public void DataChanged() {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public Product mItem;
        public ViewHolder(View view) {

            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView) view.findViewById(R.id.product_img);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}

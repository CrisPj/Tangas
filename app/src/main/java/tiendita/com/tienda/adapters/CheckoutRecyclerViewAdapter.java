package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import tiendita.com.tienda.R;
import tiendita.com.tienda.fragments.CheckoutFragment;
import tiendita.com.tienda.pojo.LineItem;
/**
 * Created by zero_ on 11/12/2016.
 */

public class CheckoutRecyclerViewAdapter extends RecyclerView.Adapter<CheckoutRecyclerViewAdapter.ViewHolder> {

    private LineItem[] products;
    private CheckoutFragment.CheckoutInteractionListener mListener;
    private Context context;

    public CheckoutRecyclerViewAdapter(LineItem[] products, CheckoutFragment.CheckoutInteractionListener mListener, Context context) {
        this.products = products;
        this.mListener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_producto, parent, false);
        return new CheckoutRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        LineItem product = products[position];

        holder.mItem = products[position];
        holder.mIdView.setText("" + holder.mItem.getQuantity());

        holder.mContentView.setText(""+product.getProductId());

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
        return products.length;
    }

    public void setProducts(LineItem[] products) {
        this.products = products;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public LineItem mItem;

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

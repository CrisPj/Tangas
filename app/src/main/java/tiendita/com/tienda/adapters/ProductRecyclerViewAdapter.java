package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tiendita.com.tienda.R;
import tiendita.com.tienda.entities.Product;
import tiendita.com.tienda.fragments.ProductsFragment;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private Products products;
    private ProductsFragment.ProductInteractionListener listener;
    private Context context;

    public ProductRecyclerViewAdapter(Products products, ProductsFragment.ProductInteractionListener mListener, Context context) {
        this.products = products;
        this.listener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return products.getSize();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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

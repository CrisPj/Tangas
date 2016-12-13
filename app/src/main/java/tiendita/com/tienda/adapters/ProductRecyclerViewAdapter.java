package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tiendita.com.tienda.R;
import tiendita.com.tienda.fragments.ProductsFragment;
import tiendita.com.tienda.pojo.Image;
import tiendita.com.tienda.pojo.Product;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private Product[] products;
    private ProductsFragment.ProductInteractionListener mListener;
    private Context context;

    public ProductRecyclerViewAdapter(Product[] products, ProductsFragment.ProductInteractionListener mListener, Context context) {
        this.products = products;
        this.mListener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_producto, parent, false);
        return new ProductRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Product product = products[position];

        holder.mItem = products[position];
        holder.mIdView.setText("" + holder.mItem.getId());

        holder.mContentView.setText(product.getName());
        List<Image> images = product.getImages();
        if (images.size() > 0)
            Picasso.with(context).load(images.get(0).getSrc()).into(holder.mImageView);

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

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public tiendita.com.tienda.pojo.Product mItem;

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

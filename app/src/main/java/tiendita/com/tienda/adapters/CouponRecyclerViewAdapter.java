package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tiendita.com.tienda.R;
import tiendita.com.tienda.fragments.CouponsFragment;
import tiendita.com.tienda.pojo.Coupons;

/**
 * Created by zero_ on 11/12/2016.
 */

public class CouponRecyclerViewAdapter extends RecyclerView.Adapter<CouponRecyclerViewAdapter.ViewHolder> {

    private Coupons[] coupons;
    private CouponsFragment.CouponInteractionListener mListener;
    private Context context;

    public CouponRecyclerViewAdapter(Coupons[] coupons, CouponsFragment.CouponInteractionListener mListener, Context context) {
        this.coupons = coupons;
        this.mListener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_coupon_list, parent, false);
        return new CouponRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Coupons coupon = coupons[position];

        holder.mItem = coupons[position];

        holder.mContentView.setText(coupon.getCode());

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
        return coupons.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Coupons mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.txtCoupon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}

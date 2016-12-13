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
import tiendita.com.tienda.fragments.CouponsFragment;
import tiendita.com.tienda.fragments.UsersFragment;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Customer;
import tiendita.com.tienda.pojo.Image;

/**
 * Created by zero_ on 11/12/2016.
 */

public class CustomersRecyclerViewAdapter extends RecyclerView.Adapter<CustomersRecyclerViewAdapter.ViewHolder> {

    private Customer[] customers;
    private UsersFragment.CustomerInteractionListener mListener;
    private Context context;

    public CustomersRecyclerViewAdapter(Customer[] customers, UsersFragment.CustomerInteractionListener mListener, Context context) {
        this.customers = customers;
        this.mListener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_customer_list, parent, false);
        return new CustomersRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Customer customer = customers[position];

        holder.mItem = customers[position];

        holder.mContentView.setText(customer.getEmail());
        holder.desc.setText(customer.getUsername());

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
        return customers.length;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final TextView desc;
        public Customer mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.txtEmail);
            desc = (TextView) view.findViewById(R.id.txtUser);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}

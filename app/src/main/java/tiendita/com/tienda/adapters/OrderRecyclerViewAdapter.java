package tiendita.com.tienda.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.CustomersAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.fragments.OrdersFragment;
import tiendita.com.tienda.pojo.Customer;
import tiendita.com.tienda.pojo.Order;

/**
 * Created by zero_ on 11/12/2016.
 */

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder> {

    private Order[] orders;
    private OrdersFragment.OrderInteractionListener mListener;
    private Context context;

    public OrderRecyclerViewAdapter(Order[] orders, OrdersFragment.OrderInteractionListener mListener, Context context) {
        this.orders = orders;
        this.mListener = mListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order, parent, false);
        return new OrderRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Order order = orders[position];

        holder.mItem = orders[position];
        holder.txtid.setText("" + holder.mItem.getId());

        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, context);
        api.getCustomer(order.getCustomerId()).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response.body() != null)
                holder.txtCustomer.setText(response.body().getUsername());
                else holder.txtCustomer.setText("sin user");
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                holder.txtCustomer.setText("NOT FOUND");
            }
        });

        holder.txtTotal.setText(order.getTotal());
        holder.txtStatus.setText(order.getStatus());

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
        return orders.length;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtCustomer;
        public final TextView txtid;
        public final TextView txtStatus;
        public final TextView txtTotal;
        public Order mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;
            txtCustomer = (TextView) view.findViewById(R.id.customer);
            txtid = (TextView) view.findViewById(R.id.id);
            txtTotal = (TextView) view.findViewById(R.id.total);
            txtStatus = (TextView) view.findViewById(R.id.status);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtid.getText() + "'";
        }
    }
}

package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.CouponRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.adapters.OrderRecyclerViewAdapter;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.OrdersAPI;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.api.WoocommerceAPI;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Order;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public class OrdersFragment extends CustomFragment {

    private OrderInteractionListener mListener;
    private OrderRecyclerViewAdapter adapter;
    private Order[] orders;

    public OrdersFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft, final String tag) {
        OrdersFragment pf = new OrdersFragment();
        ft.replace(R.id.fragment_container, pf,tag);
        ft.commit();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OrdersAPI api = ServiceGenerator.createAuthenticatedService(OrdersAPI.class, getContext());
        api.listOrders().enqueue(new Callback<Order[]>() {
            @Override
            public void onResponse(Call<Order[]> call, Response<Order[]> response) {
                orders = response.body();
                adapter = new OrderRecyclerViewAdapter(orders, mListener, getContext());
                recyclerView.setAdapter(adapter);
                EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        loadNextDataFromApi(page);
                    }
                };
                recyclerView.addOnScrollListener(scrollListener);
                progressContainer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Order[]> call, Throwable t) {
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        progressContainer = view.findViewById(R.id.progressContainer);
        final Context context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    void loadNextDataFromApi(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("offset",""+(offset+=10));
        OrdersAPI api = ServiceGenerator.createAuthenticatedService(OrdersAPI.class, getContext());
        api.listOrders().enqueue(new Callback<Order[]>() {
            @Override
            public void onResponse(Call<Order[]> call, Response<Order[]> response) {
                orders = (concat(orders,response.body()));
                adapter.setOrders(orders);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Order[]> call, Throwable t) {
                Toast.makeText(getContext(),"No hay mas ordenes",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new OrderInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public void addOrder() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());
        alert.setTitle("Creacion de Orden");

        LinearLayout layout = new LinearLayout(this.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView txtTicket = new TextView(this.getContext());
        txtTicket.setText("Customer:");
        layout.addView(txtTicket);

        final EditText input = new EditText(this.getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(input);

        final TextView txtNumber = new TextView(this.getContext());
        txtNumber.setText("Producto");
        layout.addView(txtNumber);

        final EditText percentage = new EditText(this.getContext());
        percentage.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(percentage);

        alert.setView(layout);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String m_Text = input.getText().toString();
                String percen = percentage.getText().toString();
                Order nuevo = new Order();
                OrdersAPI api = ServiceGenerator.createAuthenticatedService(OrdersAPI.class, getContext());
                api.addOrder(nuevo).enqueue(new Callback<Order>() {
                    @Override
                    public void onResponse(Call<Order> call, Response<Order> response) {
                        Toast.makeText(getContext(),"Creado correctamente",Toast.LENGTH_LONG).show();
                        orders = (concat(orders,response.body()));
                        ((OrderRecyclerViewAdapter)adapter).setOrders(orders);
                        ((OrderRecyclerViewAdapter)adapter).notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Order> call, Throwable t) {
                        Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        alert.setNegativeButton("Cancel",null);
        alert.show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Order item);
    }

    public class OrderInteractionListener implements OnListFragmentInteractionListener {

        @Override
        public void onListFragmentInteraction(Order item) {
        }
    }

}

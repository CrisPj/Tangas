package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.adapters.OrderRecyclerViewAdapter;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.OrdersAPI;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Order;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public class OrdersFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private OrderInteractionListener mListener;
    private OrderRecyclerViewAdapter adapter;
    private int mColumnCount;
    private int offset = 0;
    private Order[] orders;

    public OrdersFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft, final Context context, final ProgressBar requestProgress, final String tag) {
        requestProgress.setVisibility(View.VISIBLE);
        // Retrieve products
        OrdersAPI api = ServiceGenerator.createAuthenticatedService(OrdersAPI.class, context);
        api.listOrders().enqueue(new Callback<Order[]>() {
            @Override
            public void onResponse(Call<Order[]> call, Response<Order[]> response) {
                requestProgress.setVisibility(View.GONE);
                OrdersFragment pf = new OrdersFragment();
                pf.setOrders(response.body());
                ft.replace(R.id.fragment_container, pf,tag);
                ft.commit();
            }

            @Override
            public void onFailure(Call<Order[]> call, Throwable t) {
                requestProgress.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static OrdersFragment newInstance(int itemCount) {
        OrdersFragment fragment = new OrdersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            adapter = new OrderRecyclerViewAdapter(orders, mListener, context);
            recyclerView.setAdapter(adapter);
            EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    loadNextDataFromApi(page);
                }
            };
            recyclerView.addOnScrollListener(scrollListener);
        }
        return view;
    }

    private void loadNextDataFromApi(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("offset",""+(offset+=10));
        OrdersAPI api = ServiceGenerator.createAuthenticatedService(OrdersAPI.class, getContext());
        api.listOrders().enqueue(new Callback<Order[]>() {
            @Override
            public void onResponse(Call<Order[]> call, Response<Order[]> response) {
                orders = (concat(response.body()));
                adapter.setOrders(orders);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Order[]> call, Throwable t) {
                Toast.makeText(getContext(),"No hay mas ordenes",Toast.LENGTH_LONG).show();
            }
        });
    }

    private Order[] concat(Order[] b) {
                int bLen = b.length;
                int aLen = orders.length;
                Order[] c= new Order[aLen+bLen];
                System.arraycopy(orders, 0, c, 0, aLen);
                System.arraycopy(b, 0, c, aLen, bLen);
                return c;
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
            Gson gson = new Gson();
            String resultado = gson.toJson(item);
            //Intent i = new Intent(getActivity(), OneProductActivity.class);
            //i.putExtra("producto", resultado);
            //startActivity(i);
        }
    }

}

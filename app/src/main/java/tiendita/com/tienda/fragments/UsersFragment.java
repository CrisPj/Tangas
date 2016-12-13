package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import tiendita.com.tienda.activities.CustomerActivity;
import tiendita.com.tienda.adapters.CustomersRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.api.CustomersAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Customer;


public class UsersFragment extends CustomFragment {
    private View progressContainer;
    private CustomerInteractionListener mListener;
    private Customer[] customers;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private CustomersRecyclerViewAdapter adapter;
    private int offset = 0;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getContext());
        api.listCustomers().enqueue(new Callback<Customer[]>() {
            @Override
            public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
                adapter = new CustomersRecyclerViewAdapter(customers, mListener, getContext());
                recyclerView.setAdapter(adapter);
                EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        loadNextDataFromApi(page);
                    }
                };
                recyclerView.addOnScrollListener(scrollListener);
                progressContainer.setVisibility(View.GONE);

                adapter.setCustomers(response.body());
                setCustomers(response.body());

            }

            @Override
            public void onFailure(Call<Customer[]> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        progressContainer = view.findViewById(R.id.progressContainer);
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
            mLayoutManager = new LinearLayoutManager(context);
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    void loadNextDataFromApi(int page) {
        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getContext());
        Map<String, String> params = new HashMap<>();
        params.put("offset", "" + (offset += 10));
        api.listCustomers(params).enqueue(new Callback<Customer[]>() {
            @Override
            public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
                customers = (concat(customers,response.body()));
                adapter.setCustomers(customers);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Customer[]> call, Throwable t) {
                Toast.makeText(getContext(), "No hay mas products", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new CustomerInteractionListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null)
        {
            CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getContext());
            api.listCustomers().enqueue(new Callback<Customer[]>() {
                @Override
                public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
                    customers = response.body();
                    adapter.setCustomers(customers);
                    adapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<Customer[]> call, Throwable t) {
                    Toast.makeText(getContext(), "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static void replaceFragment(final FragmentTransaction ft, String up) {
        UsersFragment pf = new UsersFragment();
        ft.replace(R.id.fragment_container, pf,up);
        ft.commit();
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Customer customer);
    }

    public class CustomerInteractionListener implements OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Customer customer) {
            Gson gson = new Gson();
            String resultado = gson.toJson(customer);
            Intent i = new Intent(getActivity(), CustomerActivity.class);
            i.putExtra("customer", resultado);
            startActivity(i);
        }
    }
}

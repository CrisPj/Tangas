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
import tiendita.com.tienda.activities.CustomerActivity;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.CustomersRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.api.CustomersAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Customer;


public class UsersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CustomerInteractionListener mListener;
    private Customer[] customers;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private CustomersRecyclerViewAdapter adapter;
    private int offset = 0;

    public UsersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsersFragment newInstance(String param1, String param2) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            adapter = new CustomersRecyclerViewAdapter(customers, mListener, context);
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
        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getContext());
        Map<String, String> params = new HashMap<>();
        params.put("offset",""+(offset+=10));
        api.listCustomers(params).enqueue(new Callback<Customer[]>() {
            @Override
            public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
                customers = (concat(response.body()));
                adapter.setCustomers(customers);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Customer[]> call, Throwable t) {
                Toast.makeText(getContext(),"No hay mas products",Toast.LENGTH_LONG).show();
            }
        });

    }

    private Customer[] concat(Customer[] b) {
        int bLen = b.length;
        int aLen = customers.length;
        Customer[] c= new Customer[aLen+bLen];
        System.arraycopy(customers, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new CustomerInteractionListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getContext());
        api.listCustomers().enqueue(new Callback<Customer[]>() {
            @Override
            public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
               setCustomers(response.body());
                adapter.setCustomers(customers);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Customer[]> call, Throwable t) {
                Toast.makeText(getContext(),"Ocurrio un error",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static void replaceFragment(final FragmentTransaction ft, final Context context, final ProgressBar requestProgress, String up) {
        requestProgress.setVisibility(View.VISIBLE);
        // Retrieve products
        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, context);
        api.listCustomers().enqueue(new Callback<Customer[]>() {
            @Override
            public void onResponse(Call<Customer[]> call, Response<Customer[]> response) {
                requestProgress.setVisibility(View.GONE);
                UsersFragment pf = new UsersFragment();
                pf.setCustomers(response.body());
                ft.replace(R.id.fragment_container, pf);
                ft.commit();
            }

            @Override
            public void onFailure(Call<Customer[]> call, Throwable t) {
                requestProgress.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Customer customer);
    }

    public class CustomerInteractionListener implements OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Customer customer)
        {
            Gson gson = new Gson();
            String resultado = gson.toJson(customer);
            Intent i = new Intent(getActivity(),CustomerActivity.class);
            i.putExtra("customer", resultado);
            startActivity(i);
        }
    }
}

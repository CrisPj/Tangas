package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import tiendita.com.tienda.R;
import tiendita.com.tienda.adapters.CouponRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.api.WoocommerceAPI;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Product;

public class CouponsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CouponInteractionListener mListener;
    private Coupons coupons[];
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private CouponRecyclerViewAdapter adapter;
    private int offset = 0;

    public CouponsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CouponsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CouponsFragment newInstance(String param1, String param2) {
        CouponsFragment fragment = new CouponsFragment();
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
        View view = inflater.inflate(R.layout.fragment_coupons, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            adapter = new CouponRecyclerViewAdapter(coupons, mListener, context);

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



  void loadNextDataFromApi(int page)
  {
                WoocommerceAPI api = ServiceGenerator.createAuthenticatedService(WoocommerceAPI.class, getContext());
                Map<String, String> params = new HashMap<>();
                params.put("offset",""+(offset+=10));
                api.listCoupons(params).enqueue(new Callback<Coupons[]>() {
                    @Override
                    public void onResponse(Call<Coupons[]> call, Response<Coupons[]> response) {
                        coupons = (concat(response.body()));
                        adapter.setCoupons(coupons);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Coupons[]> call, Throwable t) {
                        Toast.makeText(getContext(),"No hay mas products",Toast.LENGTH_LONG).show();
                    }
                });
            }


    private Coupons[] concat(Coupons[] b) {
        int bLen = b.length;
        int aLen = coupons.length;
        Coupons[] c= new Coupons[aLen+bLen];
        System.arraycopy(coupons, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            mListener = new CouponInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static void replaceFragment(final FragmentTransaction ft, final Context context, final ProgressBar requestProgress, final String cp) {
        requestProgress.setVisibility(View.VISIBLE);
        WoocommerceAPI api = ServiceGenerator.createAuthenticatedService(WoocommerceAPI.class, context);
        api.listCoupons().enqueue(new Callback<Coupons[]>() {
            @Override
            public void onResponse(Call<Coupons[]> call, Response<Coupons[]> response) {
                requestProgress.setVisibility(View.GONE);
                CouponsFragment pf = new CouponsFragment();
                pf.setCoupons(response.body());
                ft.replace(R.id.fragment_container, pf, cp);
                ft.commit();
            }

            @Override
            public void onFailure(Call<Coupons[]> call, Throwable t) {
                requestProgress.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setCoupons(Coupons[] coupons) {
        this.coupons = coupons;
    }

    public void addCoupon() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());
        alert.setTitle("Creacion de Ticket");

        LinearLayout layout = new LinearLayout(this.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView txtTicket = new TextView(this.getContext());
        txtTicket.setText("Ticket");
        layout.addView(txtTicket);

        final EditText input = new EditText(this.getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(input);

        final TextView txtNumber = new TextView(this.getContext());
        txtNumber.setText("Porcentaje descuento");
        layout.addView(txtNumber);

        final EditText percentage = new EditText(this.getContext());
        percentage.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(percentage);

        alert.setView(layout);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String m_Text = input.getText().toString();
                String percen = percentage.getText().toString();
                Coupons nuevo = new Coupons();
                nuevo.setCode(m_Text);
                nuevo.setDiscountType();
                nuevo.setAmount(percen);
                WoocommerceAPI api = ServiceGenerator.createAuthenticatedService(WoocommerceAPI.class, getContext());
                api.addCoupon(nuevo).enqueue(new Callback<Coupons>() {
                    @Override
                    public void onResponse(Call<Coupons> call, Response<Coupons> response) {
                        Toast.makeText(getContext(),"Creado correctamente",Toast.LENGTH_LONG).show();
                        coupons = (concat(response.body()));
                        ((CouponRecyclerViewAdapter)adapter).setCoupons(coupons);
                        ((CouponRecyclerViewAdapter)adapter).notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Coupons> call, Throwable t) {
                        Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        alert.setNegativeButton("Cancel",null);
        alert.show();
    }

    private Coupons[] concat(Coupons b)
    {
        int aLen = coupons.length;
        Coupons[] c= new Coupons[aLen+1];
        System.arraycopy(coupons, 0, c, 0, aLen);
        c[aLen] = b;
        return c;
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
        void onListFragmentInteraction(Coupons cupon);
    }

    public class CouponInteractionListener implements CouponsFragment.OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Coupons cupon) {

        }
    }
}

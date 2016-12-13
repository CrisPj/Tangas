package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.adapters.CouponRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.api.WoocommerceAPI;
import tiendita.com.tienda.pojo.Coupons;

public class CouponsFragment extends CustomFragment {
    private CouponInteractionListener mListener;
    private Coupons coupons[];
    private CouponRecyclerViewAdapter adapter;

    public CouponsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WoocommerceAPI api = ServiceGenerator.createAuthenticatedService(WoocommerceAPI.class, getContext());
        api.listCoupons().enqueue(new Callback<Coupons[]>() {
            @Override
            public void onResponse(Call<Coupons[]> call, Response<Coupons[]> response) {
                coupons = response.body();
                adapter = new CouponRecyclerViewAdapter(coupons, mListener, getContext());
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
            public void onFailure(Call<Coupons[]> call, Throwable t) {
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
        recyclerView.setLayoutManager(mLayoutManager);
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
                        coupons = concat(coupons,response.body());
                        adapter.setCoupons(coupons);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Coupons[]> call, Throwable t) {
                        Toast.makeText(getContext(),"No hay mas products",Toast.LENGTH_LONG).show();
                    }
                });
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

    public static void replaceFragment(final FragmentTransaction ft, final String cp) {
        CouponsFragment pf = new CouponsFragment();
        ft.replace(R.id.fragment_container, pf,cp);
        ft.commit();
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
                        if (response.isSuccessful())
                        {
                            Toast.makeText(getContext(),"Creado correctamente",Toast.LENGTH_LONG).show();
                            coupons = (concat(coupons,response.body()));
                            ((CouponRecyclerViewAdapter)adapter).setCoupons(coupons);
                            ((CouponRecyclerViewAdapter)adapter).notifyDataSetChanged();
                        }
                        else
                        {
                            Toast.makeText(getContext(),"Cupon ya existente",Toast.LENGTH_LONG).show();
                        }
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

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Coupons cupon);
    }

    public class CouponInteractionListener implements CouponsFragment.OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Coupons cupon) {

        }
    }
}

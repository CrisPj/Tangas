package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.CheckoutRecyclerViewAdapter;
import tiendita.com.tienda.adapters.CouponRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.CarritoHax;
import tiendita.com.tienda.pojo.LineItem;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public class CheckoutFragment extends CustomFragment
{

    private LineItem[] products;
    private CheckoutFragment.CheckoutInteractionListener mListener;
    private CheckoutRecyclerViewAdapter adapter;

    public CheckoutFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft,String tag) {
        CheckoutFragment chf = new CheckoutFragment();
        ft.replace(R.id.fragment_container, chf,tag);
        ft.commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CheckoutRecyclerViewAdapter(products, mListener, getContext());
        recyclerView.setAdapter(adapter);
        products = CarritoHax.getItems();
        progressContainer.setVisibility(View.GONE);
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new CheckoutInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setProducts(LineItem[] products) {
        this.products = products;
    }

    public void addProduct() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());
        alert.setTitle("Nuevo Producto ");

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
                Product nuevo = new Product();
            }
        });

        alert.setNegativeButton("Cancel",null);
        alert.show();
    }

    @Override
    void loadNextDataFromApi(int offset) {

    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(LineItem item);
    }
    public class CheckoutInteractionListener implements OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(LineItem item) {
            Gson gson = new Gson();
            String resultado = gson.toJson(item);
            Intent i = new Intent(getActivity(), OneProductActivity.class);
            i.putExtra("producto", resultado);
            startActivity(i);
        }
    }
}

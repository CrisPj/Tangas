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

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.adapters.CategoryRecyclerViewAdapter;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Category;


/**
 * Created by zero_ on 11/12/2016.
 */

public class CategoriesFragment extends CustomFragment
{

    private Category[] categories;
    private CategoriesFragment.CategoryInteractionListener mListener;
    private CategoryRecyclerViewAdapter adapter;

    public CategoriesFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft,String tag) {
        CategoriesFragment cf = new CategoriesFragment();
        ft.replace(R.id.fragment_container, cf,tag);
        ft.commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, getContext());
        api.listCategories().enqueue(new Callback<Category[]>() {
            @Override
            public void onResponse(Call<Category[]> call, Response<Category[]> response) {
                categories = response.body();
                adapter = new CategoryRecyclerViewAdapter(categories, mListener, getContext());
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
            public void onFailure(Call<Category[]> call, Throwable t) {

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
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, getContext());
        Map<String, String> params = new HashMap<>();
        params.put("offset", "" + (offset += 10));
        api.listCategories(params).enqueue(new Callback<Category[]>() {
            @Override
            public void onResponse(Call<Category[]> call, Response<Category[]> response) {
                categories = (concat(categories,response.body()));
                adapter.setCategories(categories);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Category[]> call, Throwable t) {
                Toast.makeText(getContext(), "No hay mas categories", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new CategoryInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public void addCategory() {
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
                //Product nuevo = new Product();
            }
        });

        alert.setNegativeButton("Cancel",null);
        alert.show();
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Category item);
    }
    public class CategoryInteractionListener implements OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Category item) {
            Gson gson = new Gson();
            String resultado = gson.toJson(item);
//            Intent i = new Intent(getActivity(), OneProductActivity.class);
//            i.putExtra("producto", resultado);
//            startActivity(i);
        }
    }

}

package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.contents.ProductsContent;
import tiendita.com.tienda.entities.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsFragment extends Fragment {

    private ProductsContent content;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProductInteractionListener mListener;
    private ProductRecyclerViewAdapter adapter;

    public ProductsFragment() {
    }

    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            adapter = new ProductRecyclerViewAdapter(content.products, mListener, context);
            recyclerView.setAdapter(adapter);
            //recyclerView.addOnScrollListener(createInfiniteScrollListener());
        }
        return view;
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
        void onListFragmentInteraction(Product item);
    }

    public class ProductInteractionListener implements OnListFragmentInteractionListener {

        @Override
        public void onListFragmentInteraction(Product item) {
            Gson gson = new Gson();
            String resultado = gson.toJson(item);
            Intent i = new Intent(getActivity(), OneProductActivity.class);
            i.putExtra("producto", resultado);
            startActivity(i);
        }
    }
}

package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;
import com.google.gson.Gson;

import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.ProductoRecyclerViewAdapter;
import tiendita.com.tienda.contents.ProductContent;
import tiendita.com.tienda.entities.Product;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ProductosFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private LinearLayoutManager mLayoutManager;
    private int visibleItemCount;
    private int previousTotal = 0;
    private int visibleThreshold = 7;
    ProductContent pc;
    private int firstVisibleItem;
    private int totalItemCount;
    private boolean loading = true;
    private ProductoRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductosFragment() {
    }


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProductosFragment newInstance(int columnCount) {
        ProductosFragment fragment = new ProductosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            pc = new ProductContent(getContext());
            adapter = new ProductoRecyclerViewAdapter(pc.ITEMS, mListener, context);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnScrollListener(createInfiniteScrollListener());
        }
        return view;
    }

    @NonNull
    private InfiniteScrollListener createInfiniteScrollListener() {
        return new InfiniteScrollListener(10, mLayoutManager) {
            @Override
            public void onScrolledToEnd(final int firstVisibleItemPosition) {
                if (pc.addmora(getContext())) {
                    refreshView(recyclerView, new ProductoRecyclerViewAdapter(pc.ITEMS, mListener, getContext()), firstVisibleItemPosition);
                } else {
                    Toast.makeText(getContext(), "No hay mas products", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new ProductOnListInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

    private class ProductOnListInteractionListener implements OnListFragmentInteractionListener {

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

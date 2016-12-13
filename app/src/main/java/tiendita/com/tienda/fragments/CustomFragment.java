package tiendita.com.tienda.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Array;

import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.pojo.Order;

/**
 * Created by Cresh on 13/12/2016.
 */

public abstract class CustomFragment extends Fragment
{
    View progressContainer;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    int offset = 0;
    abstract void loadNextDataFromApi(int offset);
    public <T> T[] concat (T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen+bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    public <T> T[] concat(T[] a,T b)
    {
        int aLen = a.length;
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen+1);
        System.arraycopy(a, 0, c, 0, aLen);
        c[aLen] = b;
        return c;
    }
}

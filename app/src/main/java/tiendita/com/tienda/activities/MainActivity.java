package tiendita.com.tienda.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.CustomersAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.entities.UserData;
import tiendita.com.tienda.fragments.CategoriesFragment;
import tiendita.com.tienda.fragments.CheckoutFragment;
import tiendita.com.tienda.fragments.CouponsFragment;
import tiendita.com.tienda.fragments.LoginFragment;
import tiendita.com.tienda.fragments.Orders2Fragment;
import tiendita.com.tienda.fragments.OrdersFragment;
import tiendita.com.tienda.fragments.ProductsFragment;
import tiendita.com.tienda.fragments.ReportsFragment;
import tiendita.com.tienda.fragments.UsersFragment;
import tiendita.com.tienda.pojo.Customer;
import tiendita.com.tienda.sqlite.helpers.UserdataDbHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private ProgressBar requestProgress;
    private UserdataDbHelper userdataDbHelper;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        requestProgress = (ProgressBar) findViewById(R.id.progressRequest);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        // Check auth
        if (UserData.User.isAuthenticated(getApplicationContext())) {
            UserData user = UserData.User.fetchUserdata(getApplicationContext());
            long id = user.getId();
            if (user.getRol().equals("administrator")) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.activity_main_drawer_admin);
            } else {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.activity_main_drawer_silvestre);
            }
        } else {
            userdataDbHelper = new UserdataDbHelper(getApplicationContext());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        switch (id) {
            case R.id.products:
                ProductsFragment.replaceFragment(ft, "PP");
                setFabIcon(R.drawable.ic_add_shopping_cart_black_24dp);
                break;
            case R.id.admin_products:
                ProductsFragment.replaceFragment(ft, "PF");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.categories:
                CategoriesFragment.replaceFragment(ft, "CF");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.order:
                Orders2Fragment.replaceFragment(ft, "OF2");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.logout:
                userdataDbHelper = new UserdataDbHelper(getApplicationContext());
                userdataDbHelper.alv(userdataDbHelper.getWritableDatabase());
                fab.hide();
                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.activity_main_drawer);
                LoginFragment lf2 = new LoginFragment();
                ft.replace(R.id.fragment_container, lf2);
                ft.commit();
                break;
            case R.id.coupons:
                CouponsFragment.replaceFragment(ft, "CP");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.settings:
                String resultado = "";

                CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class, getApplicationContext());
                int id_cur = (int) UserData.User.fetchUserdata(getApplicationContext()).getId();
                api.getCustomer(id_cur).enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        final Gson gson = new Gson();
                        String resultado = gson.toJson(response.body());
                        Intent i = new Intent(MainActivity.this, CustomerActivity.class);
                        i.putExtra("customer", resultado);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {

                    }
                });

                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.clients:
                UsersFragment.replaceFragment(ft, "UP");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.orders:
                OrdersFragment.replaceFragment(ft, "OF");
                setFabIcon(R.drawable.ic_add_white_24dp);
                break;
            case R.id.reportes:
                ReportsFragment reportsFragment = new ReportsFragment();
                ft.replace(R.id.fragment_container, reportsFragment);
                ft.commit();
                break;
            default:
                fab.hide();
                userdataDbHelper = new UserdataDbHelper(getApplicationContext());
                LoginFragment lf = new LoginFragment();
                ft.replace(R.id.fragment_container, lf);
                ft.commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void launchSettings(MenuItem item) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private void setFabIcon(final int resId) {
        fab.show();
        fab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
            @Override
            public void onHidden(FloatingActionButton fab) {
                fab.setImageResource(resId);
                fab.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        android.support.v4.app.Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        String tag = "";
        if (currentFragment != null) {
            tag = currentFragment.getTag();
        }
        if (tag == null) // jacky
            tag = "";
        switch (tag) {
            case "CP":
                ((CouponsFragment) currentFragment).addCoupon();
                break;
            case "OF":
                ((OrdersFragment) currentFragment).addOrder();
                break;
            case "OF2":
                ((Orders2Fragment) currentFragment).addOrder();
                break;
            case "PF":
                ((ProductsFragment) currentFragment).addProduct();
                break;
            case "CPF":
                Snackbar.make(view, "crear cuentas", Snackbar.LENGTH_SHORT).show();
                break;
            case "PP":
                CheckoutFragment rf = new CheckoutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, rf, "GH").commit();
                break;
            case "GH":
                if (UserData.User.isAuthenticated(getApplicationContext())) {
                    ((CheckoutFragment) currentFragment).addOrder();
                }
                else {
                    fab.hide();
                    userdataDbHelper = new UserdataDbHelper(getApplicationContext());
                    LoginFragment lf = new LoginFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, lf).commit();
                }
                break;
            default:
                Snackbar.make(view, "Not sure what to do...my bad", Snackbar.LENGTH_SHORT).show();
                break;
        }


    }
}

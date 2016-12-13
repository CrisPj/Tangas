package tiendita.com.tienda.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.CustomersAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Customer;

public class CustomerActivity extends AppCompatActivity {

    private String[] estados = { "Guanajuato","Colima","DF","Morelos", "Oaxaca", "Durango", "Monterrey", "Nayarit",
    "Coahuila","Baja California Sur", "Baja California Norte", "Guerrero", "Veracruz"};
    private TextView mpEmail;
    private TextView mpUser;
    private EditText mpNombre;
    private EditText mpApaterno;
    private AutoCompleteTextView mpEstado;
    private Customer c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        String customer = extras.getString("customer");
        Gson gson = new Gson();
        c = gson.fromJson(customer, Customer.class);
        mpEmail = (TextView) findViewById(R.id.cemail);
        mpUser = (TextView) findViewById(R.id.cusername);
        mpNombre = (EditText) findViewById(R.id.cnombre);
        mpApaterno = (EditText) findViewById(R.id.capaterno);
        mpEstado = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        mpEmail.setText(c.getEmail());
        mpUser.setText(c.getUsername());
        mpNombre.setText(c.getFirstName());
        mpApaterno.setText(c.getLastName());
        mpEstado.setText(c.getBilling().getState());
        mpEstado.setThreshold(3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, estados);
        mpEstado.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateCustomer();
            }
        });
    }

    private void UpdateCustomer() {
        c.setEmail(mpEmail.getText().toString());
        c.setFirstName(mpNombre.getText().toString());
        c.setLastName(mpApaterno.getText().toString());
        c.getBilling().setState(mpEstado.getText().toString());

        CustomersAPI api = ServiceGenerator.createAuthenticatedService(CustomersAPI.class,getApplicationContext());
        api.updateCustomer(c.getId(),c).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Toast.makeText(getApplicationContext(),"Actualizado Correctamente",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error al procesar lo solicitado",Toast.LENGTH_LONG).show();
            }
        });
    }
}

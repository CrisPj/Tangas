package tiendita.com.tienda.activities;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import tiendita.com.tienda.R;
import tiendita.com.tienda.pojo.CarritoHax;
import tiendita.com.tienda.pojo.LineItem;
import tiendita.com.tienda.pojo.Product;

public class OneProductActivity extends AppCompatActivity {

    private EditText edtQty;
    private Product p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        String producto = extras.getString("producto");
        Gson gson = new Gson();
        p = gson.fromJson(producto, Product.class);
        ImageView mImageView = (ImageView) findViewById(R.id.oneproduct_img);
        TextView mpName = (TextView) findViewById(R.id.pname);
        TextView mpPrecio = (TextView) findViewById(R.id.pprecio);
        TextView mpDesc = (TextView) findViewById(R.id.pdesc);
        mpPrecio.setText(p.getPrice());
        mpName.setText(p.getName());
        setTitle(p.getName());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            mpDesc.setText(Html.fromHtml(p.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        else mpDesc.setText(Html.fromHtml(p.getDescription()));
        Picasso.with(getApplicationContext()).load(p.getImages().get(0).getSrc()).into(mImageView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                 fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addToCart();
                }
            });
        }

    private void addToCart() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Cantidad de articulos");
        alert.setMessage("Escriba la cantidad de articulos");
        LayoutInflater inflater = this.getLayoutInflater();
        View alertView = inflater.inflate(R.layout.layout_dialog_quantity, null);
        edtQty = (EditText) alertView.findViewById(R.id.dialogItemQty);
        alert.setView(alertView);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                insertItemToCart();
                Toast.makeText(getApplicationContext(),"Añadido al carro",Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();
    }

    private void insertItemToCart() {
        int inputQty = Integer.valueOf(edtQty.getText().toString());
        if (inputQty > 0)
        {
            LineItem item = new LineItem(p.getId(),inputQty);
            CarritoHax.add2Carrito(item);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Introduce una cantidad valuda",Toast.LENGTH_LONG).show();
        }
    }

}

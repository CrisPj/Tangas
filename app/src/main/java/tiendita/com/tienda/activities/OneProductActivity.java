package tiendita.com.tienda.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import tiendita.com.tienda.R;
import tiendita.com.tienda.entities.Product;

public class OneProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        String producto = extras.getString("producto");
        Gson gson = new Gson();
        Product p = gson.fromJson(producto, Product.class);
        ImageView mImageView = (ImageView) findViewById(R.id.oneproduct_img);
        TextView mpName = (TextView) findViewById(R.id.pname);
        TextView mpPrecio = (TextView) findViewById(R.id.pprecio);
        TextView mpDesc = (TextView) findViewById(R.id.pdesc);
        Button mBtnPrecio = (Button) findViewById(R.id.btnprecio);
        mpPrecio.setText(p.getPrice());
        mpName.setText(p.getName());
        setTitle(p.getName());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            mpDesc.setText(Html.fromHtml(p.getShort_description(), Html.FROM_HTML_MODE_COMPACT));
        else mpDesc.setText(Html.fromHtml(p.getShort_description()));
        Picasso.with(getApplicationContext()).load(p.getImages()[0].getSrc()).into(mImageView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
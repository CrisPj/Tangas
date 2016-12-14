package tiendita.com.tienda.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.filterType);
        radioGroup.setOnCheckedChangeListener(new FilterListener());

        final View progressContainer = (View) view.findViewById(R.id.progressContainer);
        // Test
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, getContext());
        api.getProduct("1").enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                progressContainer.setVisibility(View.GONE);
                Toast.makeText(getContext(), "OK!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
        return view;
    }

    private class FilterListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            DatePickerFragment datePicker = new DatePickerFragment();
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.dayFilter:
                    datePicker.setDateSetListener(new DateSetListener(TYPE.DAY));
                    datePicker.show(getFragmentManager(), "datePicker");
                    break;
                case R.id.weeklyFilter:
                    datePicker.setDateSetListener(new DateSetListener(TYPE.WEEK));
                    datePicker.show(getFragmentManager(), "datePicker");
                    break;
                case R.id.monthlyFilter:
                    datePicker.setDateSetListener(new DateSetListener(TYPE.MONTH));
                    datePicker.show(getFragmentManager(), "datePicker");
                    break;
                case R.id.annualFilter:
                    datePicker.setDateSetListener(new DateSetListener(TYPE.ANNUAL));
                    datePicker.show(getFragmentManager(), "datePicker");
                    break;
                default:
                    Toast.makeText(getContext(), "No option selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    enum TYPE {
        DAY, WEEK, MONTH, ANNUAL
    }

    public class DateSetListener implements DatePickerDialog.OnDateSetListener {

        private TYPE type;

        public DateSetListener(TYPE type) {
            this.type = type;
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String message = "";
            switch (type) {
                case DAY:
                    message = "DAY";
                    break;
                case WEEK:
                    message = "WEEK";
                    break;
                case MONTH:
                    message = "MONTH";
                    break;
                case ANNUAL:
                    message = "ANNUAL";
                    break;
            }
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}

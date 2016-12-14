package tiendita.com.tienda.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import tiendita.com.tienda.R;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportsFragment extends Fragment {

    private View progressContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.filterType);
        radioGroup.setOnCheckedChangeListener(new FilterListener());
        progressContainer = (View) view.findViewById(R.id.progressContainer);
        return view;
    }

    private class FilterListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            DatePickerFragment datePicker = new DatePickerFragment();
            switch (radioGroup.getCheckedRadioButtonId()) {
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
        WEEK, MONTH, ANNUAL
    }

    public class DateSetListener implements DatePickerDialog.OnDateSetListener {

        private TYPE type;

        public DateSetListener(TYPE type) {
            this.type = type;
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Bundle args = new Bundle();
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth();
            int year = datePicker.getYear();
            // Parse date to date string
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(year).append("-").append(checkDigit(month + 1)).append("-").append(checkDigit(day));
            String date = stringBuilder.toString();
            // Put in on args
            args.putString(ReportDataFragment.DATE_MIN, date);
            args.putString(ReportDataFragment.TYPE, String.valueOf(type));

            ReportDataFragment dataFragment = new ReportDataFragment();

            dataFragment.setArguments(args);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.report_fragment, dataFragment);
            fragmentTransaction.commit();
        }

        public String checkDigit(int number) {
            return number <= 9 ? "0" + number : String.valueOf(number);
        }
    }
}

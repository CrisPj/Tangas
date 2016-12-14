package tiendita.com.tienda.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.RawServiceGenerator;
import tiendita.com.tienda.api.ReportsAPI;
import tiendita.com.tienda.pojo.SalesReport;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportDataFragment extends Fragment {

    public static final String DATE_MIN = "DATE_MIN";
    public static final String TYPE = "TYPE";
    private ProgressBar progressBar;
    private View reportData;

    public ReportDataFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String date = arguments.getString(DATE_MIN);
            String type = arguments.getString(TYPE, "");
            // API
            ReportsAPI reportApi = RawServiceGenerator.createAuthenticatedService(ReportsAPI.class, getContext());
            switch (type) {
                case "WEEK":
                    reportApi.getReportWeekly(date).enqueue(new ReportCallback());
                    break;
                case "MONTH":
                    reportApi.getReportMonthly(date, "month").enqueue(new ReportCallback());
                    break;
                case "ANNUAL":
                    break;
                default:
                    Toast.makeText(getContext(), "No type", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void updateDataView(SalesReport report) {
        TextView totalSales = (TextView) reportData.findViewById(R.id.totalSales);
        TextView netSales = (TextView) reportData.findViewById(R.id.netSales);
        TextView averageSales = (TextView) reportData.findViewById(R.id.averageSales);
        TextView totalOrders = (TextView) reportData.findViewById(R.id.totalOrders);
        TextView totalItems = (TextView) reportData.findViewById(R.id.totalItems);
        TextView totalTax = (TextView) reportData.findViewById(R.id.totalTax);
        TextView totalShipping = (TextView) reportData.findViewById(R.id.totalShipping);
        TextView totalRefunds = (TextView) reportData.findViewById(R.id.totalRefunds);
        TextView totalDiscount = (TextView) reportData.findViewById(R.id.totalDiscount);

        totalSales.setText(report.getTotalSales());
        netSales.setText(report.getNetSales());
        averageSales.setText(report.getAverageSales());
        totalOrders.setText(String.valueOf(report.getTotalOrders()));
        totalItems.setText(String.valueOf(report.getTotalItems()));
        totalTax.setText(report.getTotalTax());
        totalShipping.setText(report.getTotalShipping());
        totalRefunds.setText(String.valueOf(report.getTotalRefunds()));
        totalDiscount.setText(String.valueOf(report.getTotalDiscount()));

        reportData.setVisibility(View.VISIBLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_content, container, false);
        progressBar = (ProgressBar) view.findViewById(R.id.loadingDataProgress);
        reportData = view.findViewById(R.id.reportDataView);
        return view;
    }

    private class ReportCallback implements Callback<String> {
        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            JSONArray jsonArray;
            try {
                String body = response.body();
                jsonArray = new JSONArray(body);
                JSONObject jsonObject = jsonArray.optJSONObject(0);
                SalesReport salesReport = new SalesReport(jsonObject);
                updateDataView(salesReport);
            } catch (Exception e) {
                e.printStackTrace();
            }
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

package tiendita.com.tienda.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.ReportBars;
import tiendita.com.tienda.activities.ReportPie;
import tiendita.com.tienda.api.RawServiceGenerator;
import tiendita.com.tienda.api.ReportsAPI;
import tiendita.com.tienda.pojo.SalesReport;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportDataFragment extends Fragment {

    private Button barGraphics;
    private Button pieGraphics;
    private SalesReport report;
    public static final String DATE_MIN = "DATE_MIN";
    public static final String TYPE = "TYPE";
    private ProgressBar progressBar;
    private View reportData;

    private String reportType;
    private String dateMin;

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
            reportType = type;
            dateMin = date;
            // API
            ReportsAPI reportApi = RawServiceGenerator.createAuthenticatedService(ReportsAPI.class, getContext());
            switch (type) {
                case "WEEK":
                    reportApi.getReportWeekly(date).enqueue(new ReportCallback());
                    break;
                case "LAST_MONTH":
                    reportApi.getReportPeriod("last_month").enqueue(new ReportCallback());
                    break;
                case "MONTH":
                    reportApi.getReportPeriod("month").enqueue(new ReportCallback());
                    break;
                case "ANNUAL":
                    reportApi.getReportPeriod("year").enqueue(new ReportCallback());
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
        barGraphics = (Button) view.findViewById(R.id.barGraphics);
        pieGraphics = (Button) view.findViewById(R.id.pieGraphics);
        barGraphics.setOnClickListener(new GraphsListener(GRAPHTYPE.BAR));
        pieGraphics.setOnClickListener(new GraphsListener(GRAPHTYPE.PIE));
        return view;
    }

    public void setReport(SalesReport report) {
        this.report = report;
    }

    public String getDateMin() {
        return dateMin;
    }

    public String getReportType() {
        return reportType;
    }

    enum GRAPHTYPE {
        BAR, PIE
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
                setReport(salesReport);
                updateDataView(salesReport);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Algo salió mal, intente nuevamente", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private class GraphsListener implements View.OnClickListener {

        private final GRAPHTYPE graphtype;

        public GraphsListener(GRAPHTYPE graphtype) {
            this.graphtype = graphtype;
        }

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (graphtype) {
                case BAR:
                    intent = new Intent(getContext(), ReportBars.class);
                    intent.putExtra(ReportBars.DATE_MIN, getDateMin());
                    intent.putExtra(ReportBars.PERIOD, getReportType());
                    break;
                case PIE:
                    intent = new Intent(getContext(), ReportPie.class);
                    intent.putExtra(ReportBars.DATE_MIN, getDateMin());
                    intent.putExtra(ReportBars.PERIOD, getReportType());
                    break;
                default:
                    intent = null;
            }
            if (intent != null)
                startActivity(intent);
            else
                Toast.makeText(getContext(), "Hubo un problema al realizar el intento", Toast.LENGTH_SHORT).show();
        }
    }
}

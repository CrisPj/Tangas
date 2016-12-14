package tiendita.com.tienda.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.RawServiceGenerator;
import tiendita.com.tienda.api.ReportsAPI;
import tiendita.com.tienda.pojo.SalesReport;

public class ReportBars extends AppCompatActivity {

    public static String PERIOD = "PERIOD";
    public static String DATE_MIN = "DATE_MIN";

    private String period;
    private String date_min;

    private SalesReport salesReport;
    private String label;

    private BarChart salesChart;
    private BarChart itemsChart;
    private BarChart ordersChart;
    private BarChart taxChart;
    private BarChart averageChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bars);
        salesChart = (BarChart) findViewById(R.id.graficaBarras);
        itemsChart = (BarChart) findViewById(R.id.graficaBarrasArtículos);
        ordersChart = (BarChart) findViewById(R.id.graficaBarrasOrdenes);
        taxChart = (BarChart) findViewById(R.id.graficaBarrasImpuestos);
        averageChart = (BarChart) findViewById(R.id.graficaBarrasPromedio);
        // Fetch args
        Intent intent = getIntent();
        period = intent.getStringExtra(PERIOD);
        date_min = intent.getStringExtra(DATE_MIN);
        // Begin fetch
        ReportsAPI reportApi = RawServiceGenerator.createAuthenticatedService(ReportsAPI.class, getApplicationContext());
        if (date_min == null) {
            switch (period) {
                case "LAST_MONTH":
                    reportApi.getReportPeriod("last_month").enqueue(new GraphicsCallback());
                    break;
                case "MONTH":
                    reportApi.getReportPeriod("month").enqueue(new GraphicsCallback());
                    break;
                case "ANNUAL":
                    reportApi.getReportPeriod("year").enqueue(new GraphicsCallback());
                    break;
            }
        } else {
            // Weekly report
            reportApi.getReportWeekly(date_min).enqueue(new GraphicsCallback());
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    private class GraphicsCallback implements Callback<String> {
        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            JSONArray jsonArray;
            try {
                String body = response.body();
                jsonArray = new JSONArray(body);
                JSONObject jsonObject = jsonArray.optJSONObject(0);
                salesReport = new SalesReport(jsonObject);
                // Update graphics
                salesChart.setData(new BarData(salesReport.getSalesDataset(period)));
                itemsChart.setData(new BarData(salesReport.getItemsDataset(period)));
                ordersChart.setData(new BarData(salesReport.getOrdersDataset(period)));
                taxChart.setData(new BarData(salesReport.getTaxDataset(period)));
                averageChart.setData(new BarData(salesReport.getAverageDataset(period)));
                salesChart.invalidate();
                itemsChart.invalidate();
                ordersChart.invalidate();
                taxChart.invalidate();
                averageChart.invalidate();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Algo salió mal, intente nuevamente", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            //progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

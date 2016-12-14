package tiendita.com.tienda.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.RawServiceGenerator;
import tiendita.com.tienda.api.ReportsAPI;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportDataFragment extends Fragment {

    private ProgressBar progressBar;
    private View reportData;

    public ReportDataFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // API
        ReportsAPI reportApi = RawServiceGenerator.createAuthenticatedService(ReportsAPI.class, getContext());
        reportApi.getReportWeekly().enqueue(new ReportCallback());
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
                int x = 0;
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

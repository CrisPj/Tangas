package tiendita.com.tienda.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zero_ on 13/12/2016.
 */

public interface ReportsAPI {

    @GET("wp-json/wc/v1/reports/sales")
    Call<String> getReportWeekly();

}

package id.technologue.jauharibill.technologue;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jauharibill on 7/9/2018.
 */

public interface APIInterface {

    @GET("/api/unknown")
    Call<NewsResource> doGetListResources();
}

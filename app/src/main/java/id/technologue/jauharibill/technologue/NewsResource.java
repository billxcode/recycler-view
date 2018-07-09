package id.technologue.jauharibill.technologue;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jauharibill on 7/9/2018.
 */

class NewsResource {
    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data = new ArrayList();

    public class Datum{
        @SerializedName("id")
        public Integer id;
        @SerializedName("title")
        public String title;
        @SerializedName("author")
        public String author;
        @SerializedName("photo")
        public String photo;
        @SerializedName("date")
        public String date;
        @SerializedName("content")
        public String content;
    }
}

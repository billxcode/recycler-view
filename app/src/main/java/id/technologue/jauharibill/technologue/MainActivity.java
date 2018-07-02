package id.technologue.jauharibill.technologue;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President>list;
    private ArrayList<News>listNews;

    CarouselView carouselView;
    String[] sampleImages = {
            "https://technologue.id/wp-content/uploads/2018/07/Peresmian-Infinix-Hot-6-Pro-di-Indonesia-eksklusif-Technologue.id_-324x160.jpg",
            "https://technologue.id/wp-content/uploads/2018/06/wifi-324x160.jpg",
            "https://technologue.id/wp-content/uploads/2018/07/Ongki-Kurniawan-Executive-Director-Grab-Indonesia-kanan-berbincang-bersama-Subhan-Aksa-CEO-Bosowa-Automotive-Group-di-dep-324x160.jpg",
            "https://technologue.id/wp-content/uploads/2018/07/motorola-2018-event-324x160.jpg",
            "https://technologue.id/wp-content/uploads/2018/07/Ilustrasi-Facebook-source-Facebook--324x160.jpg"
    };
    int[] imageDrawable = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView =(CarouselView)findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        listNews = new ArrayList<>();

        listNews.addAll(NewsData.getListData());
        showRecyclerCardView();
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
//            imageView.setImageURI(Uri.parse(sampleImages[position]));
            imageView.setImageResource(imageDrawable[position]);
        }
    };

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidentAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_list :
                    showRecyclerList();
                    setTitleActionBar("Mode List");
                break;
            case R.id.action_grid :
                    showRecyclerGrid();
                    setTitleActionBar("Mode Grid");
                break;
            case R.id.action_cardview :
                    showRecyclerCardView();
                    setTitleActionBar("Mode Card View");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    public void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewNewsAdapter cardViewViewHolder = new CardViewNewsAdapter(this);
        cardViewViewHolder.setListNews(listNews);
        rvCategory.setAdapter(cardViewViewHolder);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedNews(listNews.get(position));
            }
        });
    }

    public void setTitleActionBar(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedPresident(President president){
        Toast.makeText(this, "Kamu memilih "+president.getName(), Toast.LENGTH_SHORT).show();
    }
    private void showSelectedNews(News news){
        Toast.makeText(this, "Kamu memilih "+news.getTitle(), Toast.LENGTH_SHORT).show();
    }
}

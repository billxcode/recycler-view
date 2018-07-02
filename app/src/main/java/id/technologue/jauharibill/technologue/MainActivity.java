package id.technologue.jauharibill.technologue;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President>list;
    private ArrayList<News>listNews;

    private boolean onDetailView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        addAllListToView();
        showRecyclerCardView();
    }

    private void addAllListToView(){
        listNews = new ArrayList<>();
        listNews.addAll(NewsData.getListData());
    }

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
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                News dataNewsPosition = listNews.get(position);
                intent.putExtra("title", dataNewsPosition.getTitle());
                intent.putExtra("author", dataNewsPosition.getAuthor());
                intent.putExtra("date", dataNewsPosition.getDate());
                intent.putExtra("content", dataNewsPosition.getContent());
                intent.putExtra("photo", dataNewsPosition.getPhoto());
                startActivity(intent);
            }
        });
    }

    public void setTitleActionBar(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedPresident(President president){
        Toast.makeText(this, "Kamu memilih "+president.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showTitleChoosen(String title){
        Toast.makeText(this, "Kamu memilih "+title, Toast.LENGTH_SHORT).show();
    }

}

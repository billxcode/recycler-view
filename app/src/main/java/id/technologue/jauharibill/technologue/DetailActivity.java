package id.technologue.jauharibill.technologue;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private TextView title,author,date,content;
    private ImageView photo;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_news);

        title = (TextView) findViewById(R.id.detail_title);
        author = (TextView) findViewById(R.id.detail_author);
        date = (TextView) findViewById(R.id.detail_date);
        content = (TextView) findViewById(R.id.detail_content);
        photo = (ImageView) findViewById(R.id.detail_photo);

        Intent bundle = getIntent();
        title.setText(bundle.getStringExtra("title"));
        author.setText(bundle.getStringExtra("author"));
        date.setText(bundle.getStringExtra("date"));
        content.setText(bundle.getStringExtra("content"));

        Glide.with(this)
                .load(bundle.getStringExtra("photo"))
                .into(photo);

    }
}

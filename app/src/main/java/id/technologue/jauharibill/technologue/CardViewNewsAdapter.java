package id.technologue.jauharibill.technologue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jauharibill on 7/2/2018.
 */

public class CardViewNewsAdapter extends RecyclerView.Adapter<CardViewNewsAdapter.CardViewViewHolder>{

    private ArrayList<News> listNews;
    private Context context;

    public CardViewNewsAdapter(Context context){
        this.context = context;
    }

    public ArrayList<News> getListNews(){
        return listNews;
    }

    public void setListNews(ArrayList<News> listNews){
        this.listNews = listNews;
    }

    @Override
    public CardViewNewsAdapter.CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_news, parent, false);
        CardViewNewsAdapter.CardViewViewHolder viewHolder = new CardViewNewsAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CardViewNewsAdapter.CardViewViewHolder holder, int position){
        News p = getListNews().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .into(holder.cardPhoto);
        holder.cardTitle.setText(p.getTitle());
        holder.cardAuthor.setText(p.getAuthor());
        holder.cardDate.setText(p.getDate());

    }

    @Override
    public int getItemCount() {
        return getListNews().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView cardPhoto;
        TextView cardTitle, cardAuthor, cardDate;

        public CardViewViewHolder(View itemView){
            super(itemView);
            cardPhoto = (ImageView)itemView.findViewById(R.id.card_photo);
            cardTitle = (TextView)itemView.findViewById(R.id.card_title);
            cardAuthor = (TextView)itemView.findViewById(R.id.card_author);
            cardDate = (TextView)itemView.findViewById(R.id.card_date);
        }
    }

}

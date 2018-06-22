package id.technologue.jauharibill.technologue;

import android.view.LayoutInflater;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jauharibill on 6/22/2018.
 */

public class ListPresidentAdapter {
    private Context context;

    public ArrayList<President> getListPresident(){
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident){
        this.listPresident = listPresident;
    }

    private ArrayList<President> listPresident;

    public ListPresidentAdapter(Context context){
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder (CategoryViewHolder parent, int position){
        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    public int getItemCount(){
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
    }
}

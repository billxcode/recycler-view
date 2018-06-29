package id.technologue.jauharibill.technologue;

import android.view.View;

/**
 * Created by jauharibill on 6/29/2018.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view){
        onItemClickCallback.onItemClicked(view, position);
    }

    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }
}

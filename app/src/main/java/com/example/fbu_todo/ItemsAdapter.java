package com.example.fbu_todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//displays data from m model into row of recycler view
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    List<String> items;
    OnLongClickListener longCLickListener;

    public interface OnLongClickListener{
        void onItemLongClick(int position);
    }

    //Constructor
    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longCLickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //use layout inflator to inflate a view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    //binding data to a particular viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item at position
        String item = items.get(position);
        //bind item into specified view holder
        holder.bind(item);
    }

    //tells recycler view num items in list
    @Override
    public int getItemCount() {
        return items.size();
    }

    //First define the view holder--container that provides access to view of each row of list
    class ViewHolder extends RecyclerView.ViewHolder //member inner class
    {
        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        public void bind(String item) {
            //updates the view inside view holder with data of string item
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() { //Is this all a parameter??
                @Override
                public boolean onLongClick(View view) {
                    //remove item from the recycler view
                        //at this point can't talk to adapter behind recycler view. Need to communicate
                        //that this item was clicked to main activity. Need to pass info from Main activity to
                        //item adapter --> interface that mainActivity implements: LongCLickListener

                    //notifying  which pos was long clicked
                    longCLickListener.onItemLongClick(getAdapterPosition());//getPos called on recycler view
                    return true; //callback consuming the long click
                }
            });
        }
    }
}
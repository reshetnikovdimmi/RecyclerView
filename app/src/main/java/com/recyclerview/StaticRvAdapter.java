package com.recyclerview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recyclerview.RVInterface.UpdateRv;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StatisRvVievHolder> {

    private ArrayList<StaticRvModel> items;
    int row_index = -1;
    UpdateRv updateRv;
    Activity activity;
    boolean chek = true;
    boolean select = true;

    public StaticRvAdapter(ArrayList<StaticRvModel> items, Activity activity, UpdateRv updateRv) {
        this.items = items;
        this.activity = activity;
        this.updateRv = updateRv;
    }

    @NonNull
    @Override
    public StatisRvVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StatisRvVievHolder statisRvVievHolder = new StatisRvVievHolder(view);
        return statisRvVievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatisRvVievHolder holder, @SuppressLint("RecyclerView") int position) {
        StaticRvModel currentItem = items.get(position);

            holder.textView.setText(currentItem.getText());

            if (chek){
                Log.d("dencal", String.valueOf(currentItem.getText()) );
                ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                for (int i=1;i<=15;i++) {
                    items.add(new DynamicRvModel(currentItem.getText(), currentItem.getText()));
                                   }
                updateRv.callback(position,items);
                chek=false;
            }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            row_index = position;
            notifyDataSetChanged();
                ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                for (int i=1;i<=15;i++) {
                    items.add(new DynamicRvModel(currentItem.getText(), currentItem.getText()));
                }

                updateRv.callback(position,items);



        }
        });
           if (select){
               if (position==0)
                   holder.linearLayout.setBackgroundResource(R.drawable.color_2);
                   select=false;
               }else {
                   if (row_index == position){
                       holder.linearLayout.setBackgroundResource(R.drawable.color_2);
                   }
                   else {
                       holder.linearLayout.setBackgroundResource(R.drawable.color);
                   }
               }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static  class StatisRvVievHolder extends RecyclerView.ViewHolder{

        TextView textView;
        LinearLayout linearLayout;

        public StatisRvVievHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.Text);
            linearLayout = itemView.findViewById(R.id.LinerLayuot);
        }


    }
}

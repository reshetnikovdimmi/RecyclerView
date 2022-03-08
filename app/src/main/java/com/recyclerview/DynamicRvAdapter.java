package com.recyclerview;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DynamicRvAdapter extends RecyclerView.Adapter<DynamicRvAdapter.DynamicRvHolder> {
public  interface OnItemOnClickListner{

}
    public ArrayList<DynamicRvModel> dynamicRvModel;
    public DynamicRvAdapter(ArrayList<DynamicRvModel> dynamicRvModel){
        this.dynamicRvModel=dynamicRvModel;
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder {

        public TextView Remanis,TMC;

        public DynamicRvHolder(@NonNull View itemView) {
            super(itemView);
            Remanis = itemView.findViewById(R.id.Remanis);
            TMC = itemView.findViewById(R.id.TMC);
            }
    }

    @NonNull
    @Override
    public DynamicRvAdapter.DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinamic_rv_layout,parent,false);
        DynamicRvHolder dynamicRvHolder = new DynamicRvHolder(view);
        return dynamicRvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRvAdapter.DynamicRvHolder holder, int position) {
        DynamicRvModel currentItem = dynamicRvModel.get(position);
        holder.TMC.setText(currentItem.getTmc());
        holder.Remanis.setText(currentItem.getRemanis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), currentItem.getRemanis(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dynamicRvModel.size();
    }


}
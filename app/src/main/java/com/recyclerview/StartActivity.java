package com.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.recyclerview.RVInterface.UpdateRv;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements UpdateRv {

    private RecyclerView recyclerView,recyclerView_2;
    private StaticRvAdapter staticRvAdapter;
    ArrayList<DynamicRvModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel("1a"));
        item.add(new StaticRvModel("2a"));
        item.add(new StaticRvModel("3a"));
        item.add(new StaticRvModel("4a"));
        item.add(new StaticRvModel("5a"));
        item.add(new StaticRvModel("6a"));
        item.add(new StaticRvModel("7a"));
        item.add(new StaticRvModel("8a"));
        item.add(new StaticRvModel("9a"));
        item.add(new StaticRvModel("10a"));
        item.add(new StaticRvModel("11a"));
        item.add(new StaticRvModel("12a"));
        item.add(new StaticRvModel("13a"));
        item.add(new StaticRvModel("14a"));
        item.add(new StaticRvModel("15a"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item, this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        items = new ArrayList<>();

        recyclerView_2 = findViewById(R.id.rv_2);

        dynamicRvAdapter = new DynamicRvAdapter(items);
        recyclerView_2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView_2.setAdapter(dynamicRvAdapter);

    }

    @Override
    public void callback(int position, ArrayList<DynamicRvModel> items) {
        dynamicRvAdapter = new DynamicRvAdapter(items);
        dynamicRvAdapter.notifyDataSetChanged();

        recyclerView_2.setAdapter(dynamicRvAdapter);

    }
}
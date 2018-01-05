package com.sadikul.nestedrecycler;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.sadikul.nestedrecycler.Adapter.AdapterMainRecycler;
import com.sadikul.nestedrecycler.Model.InnerRecyclerItem;
import com.sadikul.nestedrecycler.Model.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private Toolbar toolbar;
    private static final int count = 10;
    private List<RecyclerViewItem> recyclerViewItems;
    private AdapterMainRecycler adapterMainRecycler;

    List<InnerRecyclerItem> innerRecyclerItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //innitialize all value
        mainRecyclerView = findViewById(R.id.mainRecyclerView);
        toolbar = findViewById(R.id.mainactivityToolbar);
        setSupportActionBar(toolbar);

        //set Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //innitialize arraylist
        innerRecyclerItems = new ArrayList<>();

        recyclerViewItems = new ArrayList<>();

        //set layout manager on recyclerview
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set adapter on recyclerview
        adapterMainRecycler = new AdapterMainRecycler(this);
        mainRecyclerView.setAdapter(adapterMainRecycler);

        //add items on arrylist
        fillList();

        //add items on recyclerview
        adapterMainRecycler.setRecyclerViewItems(recyclerViewItems);
    }

    public synchronized void fillList(){
        for(int i = 0; i<count ; i++){
            //Random random = new Random(6);
            int innerCount = getRandomNumberInRange(0,7);


            Log.d("innerItems"," c " +innerCount);
            innerRecyclerItems.clear();

            for (int j=0;j<innerCount ; j++){


                innerRecyclerItems.add(new InnerRecyclerItem("innerItem "+ j));
            }

            recyclerViewItems.add(new RecyclerViewItem("item "+ i,innerRecyclerItems));
        }
    }

    private static synchronized int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

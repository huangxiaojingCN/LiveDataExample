package com.honey.livedataexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.honey.livedataexample.model.FoodList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Kevin";

    public static final String APPKEY = "26d32d911acdde59";

    private Toolbar mToolbar;

    private MainViewModel mainViewModel;

    private RecyclerView mFoodRecyclerView;

    private FoodAdapter mFoodAdapter;

    private static final int NUM = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mFoodRecyclerView = findViewById(R.id.recyclerView);
        setSupportActionBar(mToolbar);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getFoodList().observe(this, foodListObser);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        mFoodRecyclerView.setLayoutManager(layoutManager);
        mFoodAdapter = new FoodAdapter();
        mFoodRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFoodRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10, 20, 10, 0);
            }
        });
        mFoodRecyclerView.setAdapter(mFoodAdapter);
    }

    private void requestFood(String keyword, int start) {
        if (TextUtils.isEmpty(keyword)) {
            return;
        }

        mainViewModel.getFoodList(keyword, NUM, start, APPKEY)
                .observe(this, foodListObser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);//指定Toolbar上的视图文件
        MenuItem item = menu.findItem(R.id.ab_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) item.getActionView();

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    requestFood(query, 0);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

        return true;
    }

    private Observer<FoodList> foodListObser = foodList -> {
        mFoodAdapter.addDatas(foodList.getFoodList());
        mFoodAdapter.notifyDataSetChanged();
    };
}


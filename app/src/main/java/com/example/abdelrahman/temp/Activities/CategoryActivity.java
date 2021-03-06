package com.example.abdelrahman.temp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.abdelrahman.temp.Adapters.CategoryAdapter;
import com.example.abdelrahman.temp.Models.Category;
import com.example.abdelrahman.temp.Presenter.CategoryPresenter;
import com.example.abdelrahman.temp.R;
import com.example.abdelrahman.temp.View.CategoryView;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryView {

    CategoryPresenter categoryPresenter;
    RecyclerView categoryRecyclerView;
    CategoryAdapter categoryAdapter;
    RecyclerView.LayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryRecyclerView = findViewById(R.id.rv_category);
        gridLayoutManager = new LinearLayoutManager(this);
        categoryRecyclerView.setLayoutManager(gridLayoutManager);
        categoryPresenter = new CategoryPresenter(this, this);
        categoryPresenter.getCategory("1");
    }

    @Override
    public void categoryList(List<Category> categoryList) {
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_cart) {
            Intent intent = new Intent(getApplicationContext(),CartActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

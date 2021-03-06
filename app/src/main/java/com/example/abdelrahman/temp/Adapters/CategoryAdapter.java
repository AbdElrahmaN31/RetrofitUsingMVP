package com.example.abdelrahman.temp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdelrahman.temp.Activities.ItemsActivity;
import com.example.abdelrahman.temp.Models.Category;
import com.example.abdelrahman.temp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    Context context;
    List<Category> categoryList;


    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_category_item,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.CategoryHolder holder,final int position) {
        final Category category = categoryList.get(position);
        holder.arabicName.setText(category.getArabicName());
        Picasso.get().load(category.getImage()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryId = category.getCategoryId().toString();
                Intent intent = new Intent(context, ItemsActivity.class);
                intent.putExtra("categoryId", categoryId);
                context.startActivity(intent);
            }
        });
            }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        TextView arabicName, code;
        ImageView imageView;

        public CategoryHolder(View itemView) {
            super(itemView);
            this.arabicName = itemView.findViewById(R.id.arabic_name);
            this.imageView = itemView.findViewById(R.id.card_image);
        }
    }
}



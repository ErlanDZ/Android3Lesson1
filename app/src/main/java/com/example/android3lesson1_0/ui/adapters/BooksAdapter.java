package com.example.android3lesson1_0.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1_0.databinding.ItemTaskBinding;
import com.example.android3lesson1_0.models.Books;
import com.example.android3lesson1_0.ui.iterface.OnClick;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    ItemTaskBinding binding;
    List<Books> list = new ArrayList<>();
    private OnClick onItemClickListener;

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent ,false);
        return new ViewHolder(binding.getRoot());
    }
    public void addText ( List<Books> moviesList){
        this.list = moviesList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnClick onClick){
        this.onItemClickListener = onClick;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(Books books) {
            binding.txtTitle.setText(books.getTitle());
            binding.imageItem.setImageResource(books.getImage());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.itemClick(getAdapterPosition(), books);
                }
            });
        }
    }
}

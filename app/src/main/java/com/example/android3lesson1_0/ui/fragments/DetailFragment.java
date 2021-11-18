package com.example.android3lesson1_0.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android3lesson1_0.databinding.FragmentDetailBinding;
import com.example.android3lesson1_0.models.Books;
import com.example.android3lesson1_0.utils.Constants;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    Books books;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDate();
    }

    private void getDate() {
        if (getArguments() != null) {
            books = (Books) getArguments().getSerializable(Constants.MOD);

            binding.txtTitleDetail.setText(books.getTitle());
            binding.txtDescriptionDetail.setText(books.getDescription());
            binding.imageItemDetail.setImageResource(books.getImage());

        }
    }
}
package com.example.android3lesson1_0.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson1_0.R;
import com.example.android3lesson1_0.databinding.FragmentDetailBinding;
import com.example.android3lesson1_0.models.Books;
import com.example.android3lesson1_0.ui.activity.MainViewModel;

public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initialization();
        getDate();
        return root;
    }

    private void getDate() {
        mainViewModel.mutableLiveData.observe(getViewLifecycleOwner(), books -> {
            binding.txtTitleDetail.setText(books.getTitle());
            binding.txtDescriptionDetail.setText(books.getDescription());
            binding.imageItemDetail.setImageResource(books.getImage());
        });
    }

    private void initialization() {
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }
}
package com.example.android3lesson1_0.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson1_0.R;
import com.example.android3lesson1_0.databinding.FragmentHomeBinding;
import com.example.android3lesson1_0.models.Books;
import com.example.android3lesson1_0.ui.activity.MainViewModel;
import com.example.android3lesson1_0.ui.adapters.BooksAdapter;
import com.example.android3lesson1_0.ui.iterface.OnClick;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    BooksAdapter adapter = new BooksAdapter();
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setupViews();
        onClickBTNFILL();
        initialization();
        setUpObservers();
        detail();
        binding.txtTitleHom.setVisibility(View.GONE);
        return root;
    }

    private void detail() {
        adapter.setOnItemClickListener((position, model) -> {
            mainViewModel.getBook(model);
            NavController navController = Navigation.findNavController(HomeFragment.this.requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment);
        });
    }

    private void setUpObservers() {
        mainViewModel.dataBooks.observe(getViewLifecycleOwner(), books -> {
            adapter.addText(books);
            binding.btnFill.setVisibility(View.GONE);
            binding.txtTitleHom.setVisibility(View.VISIBLE);
        });
    }

    private void initialization() {
       mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    private void onClickBTNFILL() {
        binding.btnFill.setOnClickListener(view -> {
            binding.btnFill.setVisibility(View.GONE);
            mainViewModel.fetchData();

        });
    }

    private void setupViews() {
        binding.recyclerHomeFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerHomeFragment.setAdapter(adapter);
    }
}
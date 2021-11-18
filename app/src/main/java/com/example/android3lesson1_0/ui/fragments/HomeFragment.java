package com.example.android3lesson1_0.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.android3lesson1_0.R;
import com.example.android3lesson1_0.databinding.FragmentHomeBinding;
import com.example.android3lesson1_0.ui.adapters.BooksAdapter;
import com.example.android3lesson1_0.utils.Constants;
import com.example.android3lesson1_0.viewModel.BooksViewModel;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    BooksAdapter adapter = new BooksAdapter();
    private BooksViewModel booksViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        onClickBTNFILL();
        initialization();
        setUpObservers();
        detail();
        binding.txtTitleHom.setVisibility(View.GONE);
    }

    private void detail() {
        adapter.setOnItemClickListener((position, model) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.MOD, model);
            NavController navController = Navigation.findNavController(HomeFragment.this.requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
        });
    }

    private void setUpObservers() {
        booksViewModel.dataBooks.observe(getViewLifecycleOwner(), books -> {
            adapter.addText(books);
            binding.btnFill.setVisibility(View.GONE);
            binding.txtTitleHom.setVisibility(View.VISIBLE);
        });
    }

    private void initialization() {
        booksViewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);
    }

    private void onClickBTNFILL() {
        binding.btnFill.setOnClickListener(view -> {
            binding.btnFill.setVisibility(View.GONE);
            booksViewModel.fetchData();

        });
    }

    private void setupViews() {
        binding.recyclerHomeFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerHomeFragment.setAdapter(adapter);
    }
}
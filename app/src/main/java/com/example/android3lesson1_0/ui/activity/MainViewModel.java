package com.example.android3lesson1_0.ui.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson1_0.data.Client;
import com.example.android3lesson1_0.models.Books;

import java.util.List;

public class MainViewModel extends ViewModel {
    private  final Client client = new Client();
    private final MutableLiveData<List<Books>> _dataBooks = new MutableLiveData<>();
    public MutableLiveData<Books> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<Books>> dataBooks = _dataBooks;


    public void fetchData(){
        _dataBooks.setValue(client.fetchBooks());
    }

    public void getBook(Books model){
        mutableLiveData.setValue(model);
    }

}

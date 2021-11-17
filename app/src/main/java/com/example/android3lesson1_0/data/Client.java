package com.example.android3lesson1_0.data;

import com.example.android3lesson1_0.R;
import com.example.android3lesson1_0.models.Books;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public List<Books> fetchBooks(){
        List<Books> booksList = new ArrayList<>();
        booksList.add(new Books("Первая заповедь ","Национальная честь и патриотизм", R.drawable.flag));
        booksList.add(new Books("Вторая заповедь ","Единство и сплоченность нации", R.drawable.edinstvo));
        booksList.add(new Books("Третья заповедь ","Межнациональное согласие, дружба и сотрудничество", R.drawable.mir));
        booksList.add(new Books("Четвертая заповедь ","Укрепление и защита кыргызской государственности", R.drawable.kgz));
        booksList.add(new Books("Пятая заповедь ","Гуманизм, великодушие, терпимость", R.drawable.imaje));
        booksList.add(new Books("Шестая заповедь ","Гармония с природой", R.drawable.priroda));
        booksList.add(new Books("Седьмая заповедь ","Неутомимый труд, стремление достичь всех благ за счет умения и знаний", R.drawable.mozg));
        return booksList;
}
}

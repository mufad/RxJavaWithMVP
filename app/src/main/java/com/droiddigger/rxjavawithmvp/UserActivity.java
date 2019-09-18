package com.droiddigger.rxjavawithmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.droiddigger.rxjavawithmvp.adapter.UserAdapter;
import com.droiddigger.rxjavawithmvp.model.User;

import java.util.List;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private UserPresenter userPresenter;
    private RecyclerView recyclerview;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPresenter = new UserPresenter(this);
        userPresenter.start();
    }

    @Override
    public void init() {
        recyclerview = findViewById(R.id.rv_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        userPresenter.loadUsers();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadDataInList(List<User> users) {
        userAdapter = new UserAdapter(users);
        recyclerview.setAdapter(userAdapter);
    }
}

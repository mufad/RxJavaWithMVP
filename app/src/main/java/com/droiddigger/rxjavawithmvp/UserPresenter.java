package com.droiddigger.rxjavawithmvp;

import com.droiddigger.rxjavawithmvp.model.User;
import com.droiddigger.rxjavawithmvp.network.Callback;
import com.droiddigger.rxjavawithmvp.network.UserTask;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {
    UserContract.View mView;

    UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> users) {
                mView.loadDataInList(users);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }

    @Override
    public void start() {
        mView.init();
    }
}

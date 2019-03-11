package com.johan.android.mvp.presenter;

import com.johan.android.mvp.data.User;
import com.johan.android.mvp.data.UserService;
import com.johan.frame.mvp.Presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by johan on 2019/3/11.
 */

public class LoginPresenter extends Presenter<LoginContract.LoginView> implements LoginContract.Presenter {

    @Override
    public void login(String name, String password) {
        UserService.login(name, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        if (user != null) {
                            view.loginSuccess();
                        } else {
                            view.loginFail();
                        }
                    }
                });
    }

}

package com.johan.android.mvp.presenter;

import com.johan.frame.mvp.IView;

/**
 * Created by johan on 2019/3/11.
 */

public interface LoginContract {

    interface LoginView extends IView {
        void loginSuccess();
        void loginFail();
    }

    interface Presenter {
        void login(String name, String password);
    }

}

package com.johan.android.mvp.presenter;

import com.johan.frame.mvp.IView;

/**
 * Created by johan on 2019/3/11.
 */

public interface CodeContract {

    interface CodeView extends IView {
        void getCodeSuccess(String code);
        void getCodeFail();
    }

    interface Presenter {
        void getCode(String phone);
    }

}

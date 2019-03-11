package com.johan.android.mvp.presenter;

import com.johan.android.mvp.data.UserService;
import com.johan.frame.mvp.Presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by johan on 2019/3/11.
 */

public class CodePresenter extends Presenter<CodeContract.CodeView> implements CodeContract.Presenter {

    @Override
    public void getCode(String phone) {
        UserService.getCode(phone)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String code) throws Exception {
                        view.getCodeSuccess(code);
                    }
                });
    }

}

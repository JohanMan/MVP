package com.johan.frame.mvp;

/**
 * Created by johan on 2019/3/11.
 */

public abstract class Presenter<V extends IView> {

    protected V view;

    public void attachView(V view) {
        this.view = ViewProxy.create(view);
    }

    public void detachView() {
        this.view = null;
    }

}

package com.johan.frame.mvp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by johan on 2019/3/11.
 */

public class ViewProxy<V extends IView> implements InvocationHandler {

    private V view;

    public ViewProxy(V view) {
        this.view = view;
    }

    public static <V extends IView> V create(IView view) {
        return (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new ViewProxy<>(view));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (view == null) return null;
        return method.invoke(view, args);
    }

}

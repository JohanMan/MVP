package com.johan.frame.mvp;

import java.lang.reflect.Field;

/**
 * Created by johan on 2019/3/11.
 */

public class PresenterHelper {

    public static void create(IView view) {
        try {
            Class viewClass = view.getClass();
            Field[] fields = viewClass.getDeclaredFields();
            for (Field field : fields) {
                Class fieldType = field.getType();
                if (fieldType.getSuperclass() != Presenter.class) continue;
                Presenter presenter = (Presenter) fieldType.newInstance();
                presenter.attachView(view);
                field.setAccessible(true);
                field.set(view, presenter);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void destroy(IView view) {
        try {
            Class viewClass = view.getClass();
            Field[] fields = viewClass.getDeclaredFields();
            for (Field field : fields) {
                Class fieldType = field.getType();
                if (fieldType.getSuperclass() != Presenter.class) continue;
                field.setAccessible(true);
                if (field.get(view) == null) continue;
                Presenter presenter = (Presenter) field.get(view);
                presenter.detachView();
                field.set(view, null);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

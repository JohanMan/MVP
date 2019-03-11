package com.johan.android.mvp.data;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by johan on 2019/3/11.
 */

public class UserService {

    public static Observable<String> getCode(String phone) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                // 模拟网络
                Thread.sleep(3000);
                emitter.onNext("123456");
            }
        });
    }

    public static Observable<User> login(final String name, final String password) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<User> emitter) throws Exception {
                // 模拟网络
                Thread.sleep(5000);
                if (name.equals("johan")) {
                    emitter.onNext(new User(name, password));
                } else {
                    emitter.onNext(null);
                }
            }
        });
    }

}

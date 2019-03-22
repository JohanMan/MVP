package com.johan.android.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.johan.android.mvp.R;
import com.johan.android.mvp.presenter.CodeContract;
import com.johan.android.mvp.presenter.CodePresenter;
import com.johan.android.mvp.presenter.LoginContract;
import com.johan.android.mvp.presenter.LoginPresenter;
import com.johan.frame.mvp.PresenterHelper;

public class MainActivity extends AppCompatActivity implements CodeContract.CodeView, LoginContract.LoginView {

    CodePresenter codePresenter;
    LoginPresenter loginPresenter;

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.result_view);
        PresenterHelper.create(this);
    }

    @Override
    protected void onDestroy() {
        PresenterHelper.destroy(this);
        super.onDestroy();
    }

    public void getCode(View view) {
        codePresenter.getCode("183********");
        resultView.setText("正在获取验证码 ...");
    }

    @Override
    public void getCodeSuccess(String code) {
        resultView.setText("验证码 : " + code);
    }

    @Override
    public void getCodeFail() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail() {

    }

}

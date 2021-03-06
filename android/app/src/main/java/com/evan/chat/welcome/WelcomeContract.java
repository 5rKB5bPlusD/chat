package com.evan.chat.welcome;


import android.graphics.Bitmap;
import com.evan.chat.BasePresenter;
import com.evan.chat.BaseView;

/**
 * Created by IntelliJ IDEA
 * User: Evan
 * Date: 2018/2/19
 * Time: 下午1:29
 */
public interface WelcomeContract {

    interface View extends BaseView<Presenter> {

        void setTitle(String title);

        void setWelcomeIV(Bitmap bitmap);

        void showMessage(String msg);

        void showLogView();
    }

    interface Presenter extends BasePresenter {

        int getAutoUserId();

        void timeStop();
    }
}

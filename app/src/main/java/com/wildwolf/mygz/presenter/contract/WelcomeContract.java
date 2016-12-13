package com.wildwolf.mygz.presenter.contract;

import com.wildwolf.mygz.base.BasePresenter;
import com.wildwolf.mygz.base.BaseView;
import com.wildwolf.mygz.model.WelcomeBean;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public interface WelcomeContract {
    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}

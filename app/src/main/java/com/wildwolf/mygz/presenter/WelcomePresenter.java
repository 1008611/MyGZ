package com.wildwolf.mygz.presenter;

import com.wildwolf.mygz.base.RxPresenter;
import com.wildwolf.mygz.model.WelcomeBean;
import com.wildwolf.mygz.model.http.RetrofitHelper;
import com.wildwolf.mygz.model.http.RxUtil;
import com.wildwolf.mygz.presenter.contract.WelcomeContract;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WelcomePresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getWelcomeData() {
        Subscription subscription = mRetrofitHelper.fetchWelcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("");
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(subscription);
    }

    private void startCountDown() {
        Subscription subscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MICROSECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(subscription);
    }
}

package com.wildwolf.mygz.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

}

package com.wildwolf.mygz.base;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}

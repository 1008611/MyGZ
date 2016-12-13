package com.wildwolf.mygz.component;

import com.wildwolf.mygz.app.App;
import com.wildwolf.mygz.di.AppModule;
import com.wildwolf.mygz.di.ContextLife;
import com.wildwolf.mygz.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    @ContextLife("Application")
    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

//    RealmHelper realmHelper();    //提供数据库帮助类
}

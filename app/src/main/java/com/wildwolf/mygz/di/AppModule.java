package com.wildwolf.mygz.di;


import com.wildwolf.mygz.app.App;
import com.wildwolf.mygz.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

//    @Provides
//    @Singleton
//    RealmHelper provideRealmHelper() {
//        return new RealmHelper(application);
//    }
}

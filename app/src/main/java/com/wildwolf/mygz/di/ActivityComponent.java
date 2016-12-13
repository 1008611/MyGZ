package com.wildwolf.mygz.di;

import android.app.Activity;


import com.wildwolf.mygz.MainActivity;
import com.wildwolf.mygz.ui.WelcomeActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);


}

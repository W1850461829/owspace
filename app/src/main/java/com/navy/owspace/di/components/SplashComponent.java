package com.navy.owspace.di.components;



import com.navy.owspace.di.modules.SplashModule;
import com.navy.owspace.di.scopes.UserScope;
import com.navy.owspace.view.activity.SplashActivity;

import dagger.Component;

/**
 * Created by Mr.Yangxiufeng
 * DATE 2016/10/25
 * owspace
 */
@UserScope
@Component(modules = SplashModule.class,dependencies = NetComponent.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}


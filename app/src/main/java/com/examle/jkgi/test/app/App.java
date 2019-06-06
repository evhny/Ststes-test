package com.examle.jkgi.test.app;

import android.app.Application;

import com.examle.api.dagger.ApiComponent;
import com.examle.api.dagger.DaggerApiComponent;
import com.examle.api.dagger.module.ApiModule;
import com.examle.api.dagger.module.AppModule;

public class App extends Application {
    private static App app;
    private ApiComponent apiComponent;

    public static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();

        Api.init(apiComponent);
    }

}

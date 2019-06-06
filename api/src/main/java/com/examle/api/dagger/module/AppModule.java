package com.examle.api.dagger.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Application context) {
        this.context = context;
    }

    @Provides
    Context context(){
        return context;
    }

}

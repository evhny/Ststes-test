package com.examle.api.dagger;

import com.examle.api.ApiManager;
import com.examle.api.dagger.module.ApiModule;
import com.examle.api.dagger.module.AppModule;

import dagger.Component;

@ApiScope
@Component(modules = {
        AppModule.class,
        ApiModule.class})
public interface ApiComponent {

    ApiManager apiManager();

}

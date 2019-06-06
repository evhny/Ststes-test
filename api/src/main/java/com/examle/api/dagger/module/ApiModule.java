package com.examle.api.dagger.module;

import com.examle.api.dagger.ApiScope;
import com.examle.api.rest.Urls;
import com.examle.api.rest.states.StatesService;
import com.examle.api.util.ServerUtil;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @ApiScope
    StatesService provideStateService(){
        return ServerUtil.buildRetrofit(
                Urls.GROUPKT_SERVICE,
                StatesService.class
        );
    }
}

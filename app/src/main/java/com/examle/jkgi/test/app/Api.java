package com.examle.jkgi.test.app;


import com.examle.api.ApiManager;
import com.examle.api.dagger.ApiComponent;

import org.jetbrains.annotations.NotNull;

public class Api {

    static ApiManager apiManager;

    public static void init(@NotNull ApiComponent apiComponent) {
        apiManager = apiComponent.apiManager();
    }

    public static ApiManager apiManager() {
        return apiManager;
    }
}

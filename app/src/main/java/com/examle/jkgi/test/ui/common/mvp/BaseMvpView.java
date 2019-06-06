package com.examle.jkgi.test.ui.common.mvp;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseMvpView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void onError(@NonNull Throwable throwable);

}

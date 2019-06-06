package com.examle.jkgi.test.ui.common.mvp;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseRxPresenter<View extends MvpView> extends MvpPresenter<View> {

    protected CompositeSubscription subscriptions = new CompositeSubscription();

    protected void addSubscription(@NonNull Subscription s) {
        subscriptions.add(s);
    }

    protected void clearSubscriptions(){
        subscriptions.unsubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearSubscriptions();
        subscriptions = null;
    }
}

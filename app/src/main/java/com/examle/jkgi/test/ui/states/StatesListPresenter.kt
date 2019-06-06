package com.examle.jkgi.test.ui.states

import com.arellomobile.mvp.InjectViewState
import com.examle.jkgi.test.app.Api
import com.examle.jkgi.test.ui.common.mvp.BaseRxPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@InjectViewState
class StatesListPresenter : BaseRxPresenter<StatesListView>() {

    fun getStates() {
        addSubscription(Api.apiManager().getStates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list -> viewState.onLoadStatesSuccess(list) },
                        { e -> viewState.onError(e) }
                ))
    }
}

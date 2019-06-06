package com.examle.jkgi.test.ui.states

import com.examle.api.rest.states.entity.ui.State
import com.examle.jkgi.test.ui.common.mvp.BaseMvpView


interface StatesListView : BaseMvpView {

    fun onLoadStatesSuccess(statesList: List<State>)
}

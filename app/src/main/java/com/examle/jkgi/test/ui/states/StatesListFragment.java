package com.examle.jkgi.test.ui.states;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.examle.api.rest.states.entity.ui.State;
import com.examle.jkgi.test.R;
import com.examle.jkgi.test.ui.common.BaseFragment;
import com.examle.jkgi.test.ui.states.detail.StateDetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StatesListFragment extends BaseFragment implements StatesListView, StatesAdapter.StateListener {

    @InjectPresenter
    StatesListPresenter presenter;

    RecyclerView recyclerView;
    StatesAdapter adapter;
    ProgressBar progressBar;

    public static StatesListFragment newInstance() {
        return new StatesListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_states, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getStates();
        showProgress();
    }

    private void initAdapter(List<State> statesList) {
        adapter = new StatesAdapter(statesList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        showError(throwable, getString(R.string.error_load_data));
        hideProgress();
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadStatesSuccess(@NotNull List<State> statesList) {
        initAdapter(statesList);
        hideProgress();
    }

    @Override
    public void onItemClick(@NotNull State state) {
        Intent intent = new Intent(getActivity(), StateDetailActivity.class);
        intent.putExtra(StateDetailActivity.STATE_KEY, state);
        startActivity(intent);
    }
}

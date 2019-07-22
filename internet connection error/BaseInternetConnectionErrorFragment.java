package com.fusap.sanofi.ui.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.fusap.sanofi.R;

import javax.annotation.Nullable;

public abstract class BaseInternetConnectionErrorFragment extends BaseFragment {

    private Button retryConnection;
    private ConstraintLayout layoutContainerUseCase;
    private ConstraintLayout layoutErrorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View errorView = inflater.inflate(R.layout.internet_connection_error, container, false);
        layoutContainerUseCase = (ConstraintLayout) errorView.findViewById(R.id.container_layout);
        layoutErrorView = (ConstraintLayout) errorView.findViewById(R.id.connection_error);
        View viewUseCase = customOnCreateView(inflater, layoutContainerUseCase);
        layoutContainerUseCase.addView(viewUseCase);
        bindButton(errorView);
        return errorView;
    }

    private void bindButton(View errorView) {
        retryConnection = errorView.findViewById(R.id.retry_connection);
        retryConnection.setOnClickListener(v -> onReconnectionButtonClick());
    }

    protected abstract View customOnCreateView(LayoutInflater inflater, ViewGroup container);

    protected abstract void onReconnectionButtonClick();

    public void showUseCaseLayout() {
        layoutContainerUseCase.setVisibility(View.VISIBLE);
        layoutErrorView.setVisibility(View.GONE);
    }

    public void showConnectionError() {
        layoutErrorView.setVisibility(View.VISIBLE);
        layoutContainerUseCase.setVisibility(View.GONE);
    }


}

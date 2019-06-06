package com.examle.jkgi.test.ui.common;

import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.examle.jkgi.test.R;
import com.examle.jkgi.test.util.ErrorUtil;


public abstract class BaseFragment extends MvpAppCompatFragment {

    public void showError(Throwable throwable, String mess) {
        throwable.printStackTrace();
        if (ErrorUtil.networkDisabled(throwable)) {
            makeToast(getString(R.string.no_internet_connection));
        } else {
            makeToast(mess == null ? getString(R.string.no_data) : mess);
        }
    }

    public void makeToast(String mess) {
        Toast.makeText(getContext(), mess, Toast.LENGTH_LONG).show();
    }
}

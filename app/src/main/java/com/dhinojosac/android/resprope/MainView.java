package com.dhinojosac.android.resprope;

import android.view.View;

/**
 * Created by negro-PC on 09-Feb-17.
 */

public interface MainView {
    void showProgress();
    void hideProgress();

    void showToolbar(String title, boolean upButton);
    void changeCityToolbar(String title, View toolbar);

    void showList();
    void updateList();



}

package com.dhinojosac.android.resprope;

import android.location.Location;


/**
 * Created by negro-PC on 09-Feb-17.
 */

public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void getIncidents(Location location);
    void getLocation();

}

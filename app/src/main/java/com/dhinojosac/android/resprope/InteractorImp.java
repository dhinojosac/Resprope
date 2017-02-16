package com.dhinojosac.android.resprope;

import android.location.Location;
import android.util.Log;

/**
 * Created by negro-PC on 09-Feb-17.
 */
public class InteractorImp implements MainInteractor {
    @Override
    public void getIncidents(Location location) {

    }

    @Override
    public void getLocation() {
        Log.i("INTERACTOR", "GET_LOCATION");
    }
}

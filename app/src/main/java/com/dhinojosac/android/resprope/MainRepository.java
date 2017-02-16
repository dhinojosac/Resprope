package com.dhinojosac.android.resprope;

import android.location.Location;

/**
 * Created by negro-PC on 09-Feb-17.
 */

public interface MainRepository {
    void execute(Location location);
    String getResult();
    void postEvent(int type, String error);
}

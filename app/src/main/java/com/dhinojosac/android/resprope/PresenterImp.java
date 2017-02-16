package com.dhinojosac.android.resprope;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


/**
 * Created by negro-PC on 09-Feb-17.
 */
public class PresenterImp implements MainPresenter {
    private MainView view;
    private MainInteractor interactor;

    public PresenterImp(MainView view) {
        this.view = view;
        this.interactor = new InteractorImp();
    }

    @Override
    public void onCreate() {
        view.showToolbar("Incidentes",false);
        getLocation();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getIncidents(Location location) {

    }

    @Override
    public void getLocation() {
        if(view!= null){
            view.showProgress();
        }
        interactor.getLocation();
    }



}

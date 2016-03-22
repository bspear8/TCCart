package edu.gatech.seclass.tccart;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by ddersch on 3/19/16.
 */
public class CartApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();

    }
}

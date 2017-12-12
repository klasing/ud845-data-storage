package com.example.pets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*****************************************************************************
 *                      CatalogActivity
 */
public class CatalogActivity extends AppCompatActivity {

    /*************************************************************************
     *                  declare
     */
    private static final String LOG_TAG = "***" + CatalogActivity.class.getSimpleName();

    /*************************************************************************
     *                  onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Log.i(LOG_TAG, "onCreate()");
    }
}

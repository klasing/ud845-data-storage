package com.example.pets;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pets.data.PetContract.PetEntry;
import com.example.pets.data.PetDbHelper;

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

        // set up FAB to open EditorActivity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        displayDatabaseInfo();
    }

    /*************************************************************************
     * displayDatabaseInfo
     */
    private void displayDatabaseInfo() {
        Log.i(LOG_TAG, "displayDatabaseInfo()");
        // instantiate class PetDbHelper
        PetDbHelper mDbHelper = new PetDbHelper(this);
        // create and/or open database to read
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // perform a SELECT with Cursor
        Cursor cursor = db.rawQuery("SELECT * FROM " + PetEntry.TABLE_NAME, null);
        try {
            TextView displayView = findViewById(R.id.text_view_pet);
            displayView.setText("Number of rows in pets database table: " + cursor.getCount());
        } finally {
            // close cursor
            cursor.close();
        }


    }

    /*************************************************************************
     * onCreateOptionsMenu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(LOG_TAG, "onCreateOptionsMenu()");
        // inflate the menu options from the res/menu/menu_catalog.xml file
        // and add the menu items to the app bar
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    /*************************************************************************
     * onOptionsItemSelected
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(LOG_TAG, "onOptionsItemSelected()");
        // user clicked a menu item in the app bar overflow menu
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                // TODO
                return true;
            case R.id.action_delete_all_entries:
                // TODO
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

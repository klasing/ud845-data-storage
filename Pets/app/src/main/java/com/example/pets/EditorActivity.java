package com.example.pets;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditorActivity extends AppCompatActivity {

    /*************************************************************************
     *                  declare
     */
    private static final String LOG_TAG = "***" + EditorActivity.class.getSimpleName();
    private EditText mNameEditText; // pet's name
    private EditText mBreedEditText; // pet's breed
    private EditText mWeightEditText; // pet's weight
    private Spinner mGenderSpinner; // pet's gender

    /**
     * Gender of pet. Possible values are:
     * 0: unknown gender, 1: male, 2: female
     */
    private  int mGender = 0;

    /*************************************************************************
     *                  onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Log.i(LOG_TAG, "onCreate()");

        mNameEditText = findViewById(R.id.edit_pet_name);
        mBreedEditText = findViewById(R.id.edit_pet_breed);
        mWeightEditText = findViewById(R.id.edit_pet_weight);
        mGenderSpinner = findViewById(R.id.spinner_gender);

        setUpSpinner();
    }

    /*************************************************************************
     * setUpSpinner
     */
    private void setUpSpinner() {
        Log.i(LOG_TAG, "setUpSpinner()");
        // create an adapter for spinner
        // the list options are from the string array
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // specify dropdown layout style, a simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // apply the adapter to the spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        // set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(LOG_TAG, "onItemSelected()");
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = 1; // male
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = 2; // female
                    } else {
                        mGender = 0; // unknown
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(LOG_TAG, "onNothingSelected()");
                mGender = 0; // unknown
            }
        });

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
        getMenuInflater().inflate(R.menu.menu_editor, menu);
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
            case R.id.action_save:
                // TODO
                return true;
            case R.id.action_delete:
                // TODO
                return true;
            case R.id.home:
                // navigate back to parent activity
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
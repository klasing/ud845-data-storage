package com.example.pets;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.pets.data.PetContract.PetEntry;

/*****************************************************************************
 * PetCursorAdapter
 */
public class PetCursorAdapter extends CursorAdapter {
    /*************************************************************************
     * declare
     */
    private static final String LOG_TAG = "***" + PetCursorAdapter.class.getSimpleName();

    protected PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        Log.i(LOG_TAG, "<<constructor>> PetCursorAdapter()");
    }

    /*************************************************************************
     * newView
     * @param context
     * @param cursor
     * @param parent
     * @return
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        Log.i(LOG_TAG, "newView()");
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /*************************************************************************
     * bindView
     * @param view
     * @param context
     * @param cursor
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Log.i(LOG_TAG, "bindView()");
        TextView nameTextView = view.findViewById(R.id.name);
        TextView summaryTextView = view.findViewById(R.id.summary);

        int nameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED);

        String petName = cursor.getString(nameColumnIndex);
        String petBreed = cursor.getString(breedColumnIndex);

        nameTextView.setText(petName);
        summaryTextView.setText(petBreed);
    }
}
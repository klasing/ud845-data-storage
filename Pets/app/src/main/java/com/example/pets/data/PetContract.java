package com.example.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

/*****************************************************************************
 * PetContract
 */
public final class PetContract {
    /*************************************************************************
     * declare
     */
    private static final String LOG_TAG = "***" + PetContract.class.getSimpleName();

    public static final String CONTENT_AUTHORITY = "com.example.pets";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PETS = "pets";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

    public static final String CONTENT_LIST_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


//    public static final int GENDER_UNKNOWN = 0;
//    public static final int GENDER_MALE = 1;
//    public static final int GENDER_FEMALE = 2;

    // empty constructor
    private PetContract() {}

    /*************************************************************************
     * PetEntry
     * inner class
     */
    public static final class PetEntry implements BaseColumns {
        public static final String TABLE_NAME = "pets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        /**
         * possible values
         * {@link #GENDER_UNKNOWN},
         * {@link #GENDER_MALE},
         * {@link #GENDER_FEMALE},
         */
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        // already assigned public static final String TABLE_NAME = "pets";
        /*************************************************************************
         * isValidgender
         * @param gender
         * @return
         */
        public static boolean isValidGender(int gender) {
            Log.i(LOG_TAG, "isValidGender()");
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }
    }

}
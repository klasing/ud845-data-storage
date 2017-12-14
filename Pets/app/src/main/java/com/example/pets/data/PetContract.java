package com.example.pets.data;

import android.provider.BaseColumns;

/*****************************************************************************
 * PetContract
 */
public final class PetContract {
    /*************************************************************************
     * declare
     */
    private static final String LOG_TAG = "***" + PetContract.class.getSimpleName();

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
    }
}
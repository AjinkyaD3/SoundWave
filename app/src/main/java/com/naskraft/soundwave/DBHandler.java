package com.naskraft.soundwave;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "frienddb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "tbl_info";


    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String EMAIL_COL = "email";
    private static final String CONTACT_COL = "contact";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + CONTACT_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }


    public void addNewRow(String name, String email, String contactno) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(CONTACT_COL, contactno);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // this method is called to check if the table exists already.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}











package com.fz5.quizclient.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;

/**
 * Created by Francis Ilechukwu 28/09/2017.
 */

public class QuizServerDataSource {

    private QuizServerOpenHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    /**
     * DataSource Constructor
     *
     * @param context the context of the current running activity.
     */
    public QuizServerDataSource(Context context) {
        dbHelper = new QuizServerOpenHelper(context);
        this.context = context;
    }

    /**
     * the function that opens the database.
     *
     * @throws SQLiteException on failure to get writable database.
     */
    public void open() throws SQLiteException {
        database = dbHelper.getWritableDatabase();
    }

    /**
     * closes the database object.
     */
    public void close() {
        dbHelper.close();
    }

    public boolean createDataBaseObject(DataBaseObject object) {
        boolean success;
        try {
            success = database.insertOrThrow(object.getTableName(), null, object.getContentValues()) != -1;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public ArrayList<Quiz> getQuizzes() {
        return null;
    }

}

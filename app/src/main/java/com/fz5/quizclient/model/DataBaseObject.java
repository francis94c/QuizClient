package com.fz5.quizclient.model;

import android.content.ContentValues;

/**
 * Created by Francis Francis 29/09/2017.
 */

public interface DataBaseObject {
    ContentValues getContentValues();

    String getTableName();
}

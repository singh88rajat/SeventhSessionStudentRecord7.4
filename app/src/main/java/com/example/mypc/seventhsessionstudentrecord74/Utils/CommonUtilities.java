package com.example.mypc.seventhsessionstudentrecord74.Utils;

import android.content.Context;

import com.example.mypc.seventhsessionstudentrecord74.Database.DBHelper;

/**
 * Created by my pc on 4/5/2017.
 */

public class CommonUtilities {
    public static DBHelper getDBObject(Context mContext) {
        DBHelper dbhelper = DBHelper.getInstance(mContext);
        return dbhelper;
    }
}

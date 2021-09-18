package com.abhinay.wsdc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DBhandler extends SQLiteOpenHelper
{
    private static final String DB_NAME = "devathon.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "studentdetails";
    private static final String name_COL = "name";
    private static final String roll_COL = "roll";
    private static final String branch_COL = "branch";
    private static final String mobile_COL = "mobile";
    private static final String email_COL = "email";
    private static final String loginid_COL = "loginid";
    private static final String password_COL ="password";
    public DBhandler(@Nullable Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            Log.i("Data Entry","Sucess");
            String query = "CREATE TABLE " + TABLE_NAME + " (" + roll_COL + " TEXT PRIMARY KEY, " + name_COL + " TEXT," + branch_COL + " TEXT," + mobile_COL + " TEXT," + email_COL + " TEXT," + loginid_COL +" TEXT,"+ password_COL + " TEXT);";
            db.execSQL(query);
        }
        catch (Exception e)
        {
            Log.e("cat", "Error when creating table: " + e.getMessage());
        }
    }

    public void addStudent(String name,String roll,String branch,String mobile,String email,String LoginId,String password)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(name_COL, name);
            values.put(roll_COL, roll);
            values.put(branch_COL, branch);
            values.put(mobile_COL, mobile);
            values.put(email_COL, email);
            values.put(loginid_COL, LoginId);
            values.put(password_COL, password);
            db.insert(TABLE_NAME, null, values);
            Log.i("Data Entry",name);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Boolean check(String a,String b)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        try
        {
            String query ="SELECT * FROM "+TABLE_NAME;
            Cursor cursor = db.rawQuery(query,null);
            String c="",d="";
            //cursor.moveToNext();
            if (cursor.moveToFirst())
            {
                do {
                    d=cursor.getString(5);
                    c=cursor.getString(6);
                    if(a.equals(d)&&c.equals(b))
                    {
                        return true;
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
            return false;
        }
        catch(Exception e)
        {
            Log.e("cat", "Error when creating table: " + e.getMessage());
            return false;
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

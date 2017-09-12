package com.vishwas.database113;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vishwas on 1/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //all static variable
    //database name
    public static final String DATABASE_NAME = "employeeDBName.db";
    //database version
    private static final int DATABASE_VERSION = 1;
    //table name
    public static final String TABLE_NAME = "employees";
    public static final String NAME_OF_EMPLOYEE = "employeeName";
    public static final String ID_OF_EMPLOYEE_ = "id";
    public static final String AGE_OF_EMPLOYEE = "employeeAge";
    private static final String IMAGE_OF_EMPLOYEE = "employeeImage";

    private static final String CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + " ("
            + ID_OF_EMPLOYEE_ + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_OF_EMPLOYEE + " text,"
            + AGE_OF_EMPLOYEE + " text,"
            + IMAGE_OF_EMPLOYEE + " BLOB NOT NULL );");

    private SQLiteDatabase db = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //implementing methods..onCreate
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;


    }

    @Override
    //implementing methods..onUpgrade
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS employees");
        onCreate(db);
    }

    // opening the database
    public void open() {
        if (this.db == null) {
            this.db = this.getWritableDatabase();
        }
    }

    //close the db
    public void close() {
        if (this.db != null) {
            if (this.db.isOpen())
                this.db.close();
        }
    }

    /**
     * creating insertEmployee() method for insert employee..
     * and created an object of contentValues..
     * and putting employee name, age and image in it..
     * and in last inserting table name in db.
     *
     * @param employee
     * @return
     */
    public boolean employeeInsert(Employee employee) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_OF_EMPLOYEE, employee.getTheNameOfEmployee());
        contentValues.put(AGE_OF_EMPLOYEE, employee.getTheAgeOfEmployee());
        contentValues.put(IMAGE_OF_EMPLOYEE, Utilities.getBytes(employee.getImageInByte()));
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    /**
     * creating retriveEmployeeDetails() method..
     * this method will set an query..
     * by applying a condition
     * @return
     */

    public Employee retriveEmployeeDetails() throws SQLException {
        Cursor cur = db.query(true, TABLE_NAME, new String[]{IMAGE_OF_EMPLOYEE,
                NAME_OF_EMPLOYEE, AGE_OF_EMPLOYEE}, null, null, null, null, null, null);
        if (cur.moveToLast()) {
            String employeeName = cur.getString(cur.getColumnIndex(NAME_OF_EMPLOYEE));
            int employeeAge = cur.getInt(cur.getColumnIndex(AGE_OF_EMPLOYEE));
            byte[] blob = cur.getBlob(cur.getColumnIndex(IMAGE_OF_EMPLOYEE));
            cur.close();
            return new Employee(employeeName, employeeAge, Utilities.getImage(blob));

        }
        cur.close();
        return null;
    }
}


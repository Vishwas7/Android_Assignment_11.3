package com.vishwas.database113;

import android.graphics.Bitmap;

/**
 * Created by Vishwas on 1/9/2017.
 */

public class Employee
{
    //Declaring variables
    String TheNameOfEmployee;
    int TheAgeOfEmployee;
    Bitmap imageInByte;

    //using gatter and setter

    public String getTheNameOfEmployee() {
        return TheNameOfEmployee;
    }

    public void setTheNameOfEmployee(String theNameOfEmployee) {
        TheNameOfEmployee = theNameOfEmployee;
    }

    public int getTheAgeOfEmployee() {
        return TheAgeOfEmployee;
    }

    public void setTheAgeOfEmployee(int theAgeOfEmployee) {
        TheAgeOfEmployee = theAgeOfEmployee;
    }

    public Bitmap getImageInByte() {
        return imageInByte;
    }

    public void setImageInByte(Bitmap imageInByte) {
        this.imageInByte = imageInByte;
    }
    //creating constructor of Employee class..
    public Employee(String theNameOfEmployee, int theAgeOfEmployee, Bitmap imageInByte) {
        TheNameOfEmployee = theNameOfEmployee;
        TheAgeOfEmployee = theAgeOfEmployee;
        this.imageInByte = imageInByte;
    }
}

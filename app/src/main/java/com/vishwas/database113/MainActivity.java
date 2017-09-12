package com.vishwas.database113;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaring variables
    TextView textViewForEmpName,textViewForEmpAge;
    ImageView imageViewForEmployeePhoto;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DBHelper(this);
        //Creating object of Employee class and adding employee name, age and image..
        Employee employee=new Employee("Vishwas",23,(BitmapFactory.decodeResource(getResources(),R.drawable.photo)));
        /**
         * and than in here calling open Method for dbHelper class..
         * and inserting Employee class all the methods..
         *
         */
        dbHelper.open();
        dbHelper.employeeInsert(employee);
        Employee empl=dbHelper.retriveEmployeeDetails();
        //casting variable textViewForEmpName..
        textViewForEmpName=(TextView)findViewById(R.id.employeeName);
        //setting employee name..
        textViewForEmpName.setText(empl.getTheNameOfEmployee());
        //casting variable textViewForEmpAge..
        textViewForEmpAge=(TextView)findViewById(R.id.employeeAge);
        //Setting Employee Age..
        textViewForEmpAge.setText(String.valueOf(empl.getTheAgeOfEmployee()));
        //casting variable imageViewForEmployeePhoto..
        imageViewForEmployeePhoto=(ImageView)findViewById(R.id.EmployeeImageView);
        //Setting employee Image..
        imageViewForEmployeePhoto.setImageBitmap(empl.imageInByte);


    }
}
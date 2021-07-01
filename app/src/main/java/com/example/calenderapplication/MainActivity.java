package com.example.calenderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
        TextView tdate;
        EditText edate;
    private DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tdate=findViewById(R.id.tdate);
        edate=findViewById(R.id.edate);
        
        Calendar calender=Calendar.getInstance();
        final int year=calender.get(Calendar.YEAR);
        final int month=calender.get(Calendar.MONTH);
        final int day=calender.get(Calendar.DAY_OF_MONTH);

       tdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DatePickerDialog datePickerDialog =new DatePickerDialog(
                   MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                   setListener,year,month,day);
               datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               datePickerDialog.show();
               
           } 
       });
       
       setListener = new DatePickerDialog.OnDateSetListener(){

           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              month=month+1;
              String date=day+"/"+month+"/"+year;
              tdate.setText(date);
           }
       };
       edate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DatePickerDialog datePickerDialog=new DatePickerDialog(
                       MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       month=month+1;
                       String date=day+"/"+month+"/"+year;
                       edate.setText(date);
                   }
               },year,month,day);
               datePickerDialog.show();
               
           }
       });
    }
}
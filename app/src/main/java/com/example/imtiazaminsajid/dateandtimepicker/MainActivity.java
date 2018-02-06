package com.example.imtiazaminsajid.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int year, month, day, hour,min;
    private Calendar calendar;
    private TextView showTimeDate;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showTimeDate = findViewById(R.id.showTime);
        year =Calendar.YEAR;
        month = Calendar.MONTH;
        day = Calendar.DAY_OF_MONTH;
        hour = Calendar.HOUR_OF_DAY;
        min =Calendar.MINUTE;


    }

    public void timePicker(View view) {
        TimePickerDialog tpd = new TimePickerDialog(this, timeListener, hour, min,false);
        tpd.show();
    }

    public void datePicker(View view) {

        DatePickerDialog dpd = new DatePickerDialog(this, dateListener,year,month,day);
                dpd.show();
    }

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {

            showTimeDate.setText("Your Picked Date is: "+year+" "+month+" "+day);

        }
    };

    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int min) {

            showTimeDate.setText("Your Picked Time is: "+hour+" "+min);

        }
    };
}

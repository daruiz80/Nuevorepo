package com.example.senasoft_1.registrovehiculo.Splahs;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senasoft_1.registrovehiculo.MainActivity;
import com.example.senasoft_1.registrovehiculo.R;

public class SplahsActivity extends AppCompatActivity {

    Sensor sensor;
    SensorManager semanager;
    SensorEventListener eventListener;
    TextView textView;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splahs_activity);

        textView=findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                semanager=(SensorManager)getSystemService(SENSOR_SERVICE);
                sensor=semanager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                semanager.registerListener(eventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);

            }
        });

        eventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if (event.values[0]<sensor.getMaximumRange()){
                    contador++;
                    if (contador==3){
                    Intent intent=new Intent(SplahsActivity.this, MainActivity.class);
                    startActivity(intent);}
                }else {
                 //   Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

    }
}

package com.ejemplos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch swMostrar = findViewById(R.id.swMostrar);
        final Group grMostrar = findViewById(R.id.grMostrar);

        swMostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    grMostrar.setVisibility(View.VISIBLE);
                else
                    grMostrar.setVisibility(View.GONE);
            }
        });
    }
}

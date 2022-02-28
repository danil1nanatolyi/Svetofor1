package com.example.myapplication45;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity<start_stop> extends AppCompatActivity {
    private LinearLayout b1, b2, b3;
    private boolean start_stop=false;
    private Button button1;
    private int counter=0;
    private int gray=Color.rgb(190,190,190);
    private int yellow=Color.rgb(255,255,0);
    private int green=Color.rgb(0,255,0);
    private int red=Color.rgb(255,0,0);
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.bulb1);
        b2 = findViewById(R.id.bulb2);
        b3 = findViewById(R.id.bulb3);
        button1=findViewById(R.id.start_stop);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (start_stop==true)
                    start_stop=false;
                else start_stop=true;
                OnClickStart(view);
            }
        });
    }

    public void OnClickStart(View view) {
        if (start_stop) {
            button1.setText("stop");
            System.out.println("222222222");
            thread= new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("11111111");
                    while (start_stop) {
                        counter++;
                        if (counter==4)
                            counter=1;
                        switch (counter)
                        {
                            case 1:
                            b1.setBackgroundColor(red);
                            b2.setBackgroundColor(gray);
                            b3.setBackgroundColor(gray);
                            break;
                            case 2:
                                b1.setBackgroundColor(gray);
                                b2.setBackgroundColor(yellow);
                                b3.setBackgroundColor(gray);
                            break;
                            case 3:
                                b1.setBackgroundColor(gray);
                                b2.setBackgroundColor(gray);
                                b3.setBackgroundColor(green);
                            break;
                        }

                        try {

                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                }
            });
            thread.start();
        }else{
            thread.interrupt();
              start_stop=false;
              button1.setText("Start");
            }
        }

        protected void OnDestroy(){
            start_stop = false;
        }
    }


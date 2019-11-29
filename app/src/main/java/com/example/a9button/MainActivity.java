package com.example.a9button;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private int hp = 5;
    private int points = 0;
    private Random rnd = new Random();
    private TextView tvhp, tvpoints;
    private Thread i = (new Thread(new Timed()));
    private int active1 = 1, active2 = 0, active3 = 0, active4 = 0, active5 = 0, active6 = 0, active7 = 0, active8 = 0, active9 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        tvhp.setText(String.valueOf(hp));
        hppoints();
        i.start();
    }

    protected void onStop()
    {
        i.interrupt();
        super.onStop();
    }
    public void hppoints()
    {
        LoseHPwinPoints(btn1, active1);
        LoseHPwinPoints(btn2, active2);
        LoseHPwinPoints(btn3, active3);
        LoseHPwinPoints(btn4, active4);
        LoseHPwinPoints(btn5, active5);
        LoseHPwinPoints(btn6, active6);
        LoseHPwinPoints(btn7, active7);
        LoseHPwinPoints(btn8, active8);
        LoseHPwinPoints(btn9, active9);

    }
    public void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        tvhp = findViewById(R.id.tvhp);
        tvpoints = findViewById(R.id.tvpoints);

    }
    public class Timed implements Runnable
    {
        public void run() {
            buttons();
        };
    }
    public void buttons()
    {
        while (hp != 0)
        {
            int random = rnd.nextInt(9);
            int button = random+1;
            switch (button)
            {
                case 1:
                    //colorChanger(btn1, active1);
                    btn1.setBackgroundColor(Color.rgb(255,0,0));
                    active1 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn1.setBackgroundColor(Color.rgb(0,255,0));
                    active1 = 0;
                    break;
                case 2:
                    btn2.setBackgroundColor(Color.rgb(255,0,0));
                    active2 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn2.setBackgroundColor(Color.rgb(0,255,0));
                    active2 = 0;
                    //colorChanger(btn2, active2);
                    break;
                case 3:
                    btn3.setBackgroundColor(Color.rgb(255,0,0));
                    active3 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn3.setBackgroundColor(Color.rgb(0,255,0));
                    active3 = 0;
                    //colorChanger(btn3, active3);
                    break;
                case 4:
                    btn4.setBackgroundColor(Color.rgb(255,0,0));
                    active4 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn4.setBackgroundColor(Color.rgb(0,255,0));
                    active4 = 0;
                    //colorChanger(btn4, active4);
                    break;
                case 5:
                    //colorChanger(btn5, active5);
                    btn5.setBackgroundColor(Color.rgb(255,0,0));
                    active5 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn5.setBackgroundColor(Color.rgb(0,255,0));
                    active5 = 0;
                    break;
                case 6:
                    //colorChanger(btn6, active6);
                    btn6.setBackgroundColor(Color.rgb(255,0,0));
                    active6 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn6.setBackgroundColor(Color.rgb(0,255,0));
                    active6 = 0;
                    break;
                case 7:
                    //colorChanger(btn7, active7);
                    btn7.setBackgroundColor(Color.rgb(255,0,0));
                    active7 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn7.setBackgroundColor(Color.rgb(0,255,0));
                    active7 = 0;
                    break;
                case 8:
                    //colorChanger(btn8, active8);
                    btn8.setBackgroundColor(Color.rgb(255,0,0));
                    active8 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn8.setBackgroundColor(Color.rgb(0,255,0));
                    active8 = 0;
                    break;
                case 9:
                    //colorChanger(btn9, active9);
                    btn9.setBackgroundColor(Color.rgb(255,0,0));
                    active9 = 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    btn9.setBackgroundColor(Color.rgb(0,255,0));
                    active9 = 0;
                    break;
            }
        }
    }
   /* public void colorChanger(Button change, int active)
    {
        change.setBackgroundColor(Color.rgb(255,0,0));
        active = 1;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        change.setBackgroundColor(Color.rgb(0,255,0));
        active = 0;
    }*/
    public void LoseHPwinPoints(final Button change, int active)
    {
        if (active == 1) {
            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    points++;
                    tvpoints.setText(String.valueOf(points));
                }
            });
        }
        if (active == 0) {
            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hp--;
                    tvhp.setText(String.valueOf(hp));
                }
            });
        }
    }
    @Override
    public void onClick(View v) {

    }
}

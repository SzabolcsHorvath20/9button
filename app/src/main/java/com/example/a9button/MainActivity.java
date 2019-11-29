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
    private boolean bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9;
    private BooleanReplacer active1 = new BooleanReplacer(bool1);
    private BooleanReplacer active2 = new BooleanReplacer(bool2);
    private BooleanReplacer active3 = new BooleanReplacer(bool3);
    private BooleanReplacer active4 = new BooleanReplacer(bool4);
    private BooleanReplacer active5 = new BooleanReplacer(bool5);
    private BooleanReplacer active6 = new BooleanReplacer(bool6);
    private BooleanReplacer active7 = new BooleanReplacer(bool7);
    private BooleanReplacer active8 = new BooleanReplacer(bool8);
    private BooleanReplacer active9 = new BooleanReplacer(bool9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        tvhp.setText(String.valueOf(hp));
        i.start();
        hppoints();
    }

    protected void onStop()
    {
        i.interrupt();
        super.onStop();
    }
    public void hppoints()
    {
        active1.setBool(false);
        active2.setBool(false);
        active3.setBool(false);
        active4.setBool(false);
        active5.setBool(false);
        active6.setBool(false);
        active7.setBool(false);
        active8.setBool(false);
        active9.setBool(false);


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
                    colorChanger(btn1, active1);
                    break;
                case 2:
                    colorChanger(btn2, active2);
                    break;
                case 3:
                    colorChanger(btn3, active3);
                    break;
                case 4:
                    colorChanger(btn4, active4);
                    break;
                case 5:
                    colorChanger(btn5, active5);
                    break;
                case 6:
                    colorChanger(btn6, active6);
                    break;
                case 7:
                    colorChanger(btn7, active7);
                    break;
                case 8:
                    colorChanger(btn8, active8);
                    break;
                case 9:
                    colorChanger(btn9, active9);
                    break;
            }
        }
    }
    public void colorChanger(Button change, BooleanReplacer active)
    {
        change.setBackgroundColor(Color.rgb(255,0,0));
        active.setBool(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        change.setBackgroundColor(Color.rgb(0,255,0));
        active.setBool(false);
    }
    public void LoseHPwinPoints(final Button change, BooleanReplacer active)
    {
        if (active.getBool() == true) {
            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    points++;
                    tvpoints.setText(String.valueOf(points));
                }
            });
        }
        if (active.getBool() == false) {
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

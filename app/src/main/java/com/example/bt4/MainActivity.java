package com.example.bt4;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        Switch s =  (Switch) findViewById(R.id.switch1);
        Switch s2 = (Switch) findViewById(R.id.switch2);
        RadioGroup radioGroup =  (RadioGroup) findViewById(R.id.grRadio);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        bg.setBackgroundColor(Color.BLUE);
//        bg.setBackgroundResource(R.drawable.bg2);   // la mot Integer

        TextView textView = findViewById(R.id.textView);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);

        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long l) {
//                        int current = progressBar.getProgress();
                        int current = (int) ((10000 - l) / 100);
                        if (current >= progressBar.getMax()){
                            current = 0;
                        }
                        progressBar.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        progressBar.setProgress(100);
                        Toast.makeText(MainActivity.this,"Het gio",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Wifi dang bat", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Wifi dang tat", Toast.LENGTH_SHORT).show();
                }
            }
        });

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    bg.setBackgroundResource(R.drawable.bg1);
                }
                else {
                    bg.setBackgroundResource(R.drawable.bg2);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton){
                    bg.setBackgroundResource(R.drawable.bg1);
                }
                else if (checkedId == R.id.radioButton2){
                    bg.setBackgroundResource(R.drawable.bg2);
                }
                else if (checkedId == R.id.radioButton3){
                    bg.setBackgroundResource(R.drawable.bg3);
                }
                else if (checkedId == R.id.radioButton4){
                    bg.setBackgroundResource(R.drawable.bg4);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("Gia tri: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
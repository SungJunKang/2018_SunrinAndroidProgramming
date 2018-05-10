package com.example.myspinner;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView auto;
    ProgressBar progressBar;
    SeekBar seekBar;
    TextView seekText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        auto = findViewById(R.id.auto);
        progressBar = findViewById(R.id.progress);
        seekBar = findViewById(R.id.seek);
        seekText = findViewById(R.id.seekText);

        // Spinner
        String[] datas = getResources().getStringArray(R.array.spinner_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datas);
        spinner.setAdapter(arrayAdapter);

        // AutoCompleteTextView
        String[] autoDatas = getResources().getStringArray(R.array.auto_array);
        ArrayAdapter<String> autoArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, autoDatas);
        auto.setAdapter(autoArrayAdapter);

        // ProgressBar
        progressBar.setProgress(0);
        ProgressThread thread = new ProgressThread();
        thread.start();

        // SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seekText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    class ProgressThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                SystemClock.sleep(1000);
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(15);
            }
            super.run();
        }
    }

}

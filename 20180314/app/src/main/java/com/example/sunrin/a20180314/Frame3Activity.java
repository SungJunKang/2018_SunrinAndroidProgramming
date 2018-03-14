package com.example.sunrin.a20180314;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Frame3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame3);

        TabHost host = (TabHost)findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec;
        spec = host.newTabSpec("tab1");
        spec.setIndicator("첫번째");
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator("두번째");
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator("세번째");
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);
    }
}

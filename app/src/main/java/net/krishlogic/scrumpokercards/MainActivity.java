package net.krishlogic.scrumpokercards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mLabelPLanning;
    private TextView mLabelTshirtSizing;
    private TextView mLabelAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init() {
        mLabelPLanning = (TextView) findViewById(R.id.label_planning);
        mLabelTshirtSizing = (TextView) findViewById(R.id.label_tshirt);
        mLabelAbout = (TextView) findViewById(R.id.label_about);

        mLabelPLanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlanningActivity.openActivity(MainActivity.this);
            }
        });

        mLabelTshirtSizing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mLabelAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
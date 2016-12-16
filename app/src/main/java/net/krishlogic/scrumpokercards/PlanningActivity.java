package net.krishlogic.scrumpokercards;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.io.IOException;

public class PlanningActivity extends AppCompatActivity {

    private GridView mGridView;

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, PlanningActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        setTitle("Scrum Planning Cards");

        init();
    }

    private void init() {

        mGridView = (GridView) findViewById(R.id.gridview_cards);
        AssetManager assetManager = getAssets();
        String [] imgPath = null;
        try {
           imgPath = assetManager.list("cards");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mGridView.setAdapter(new ImageAdapter(this, imgPath));
    }
}

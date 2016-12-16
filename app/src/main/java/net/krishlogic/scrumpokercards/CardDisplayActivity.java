package net.krishlogic.scrumpokercards;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CardDisplayActivity extends AppCompatActivity {

    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card_display);

        getSupportActionBar().hide();

        Bundle bundle = this.getIntent().getExtras();
        String imageCard = bundle.getString("card", "0.png");

        init(imageCard);
    }

    private void init(String imageCard) {

        mImageView = (ImageView) findViewById(R.id.imageview_card_display);

        InputStream is = null;
        try {
            is = getAssets().open("cards/" + imageCard);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Bitmap bitmap = BitmapFactory.decodeStream(is);

        mImageView.setImageBitmap(bitmap);
    }

}

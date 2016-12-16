package net.krishlogic.scrumpokercards;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kvenkat on 12/14/16.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    String[] mImages;

    public ImageAdapter(Context context, String[] images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int i) {
        return mImages[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {

        ImageView imageView;

        InputStream is = null;
        try {
            is = mContext.getAssets().open("cards/" + mImages[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Bitmap bitmap = BitmapFactory.decodeStream(is);

        if (view == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setBackground(null);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageBitmap(bitmap);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("card", mImages[i]);

                Intent intent = new Intent(mContext, CardDisplayActivity.class);
                intent.putExtras(bundle);

                mContext.startActivity(intent);
            }
        });

        return imageView;

     }
}

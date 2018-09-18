package helloandroid.qushi.com.mylistviewdome.RecyclerViewActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

public class Item {
    public Drawable color;
    public  String des;
    private Drawable bgColor;

    public Item(String des) {
        this.des = des;
        color = getBgColor();
    }

    public Drawable getBgColor() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(4);
        drawable.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        return drawable;
    }
}

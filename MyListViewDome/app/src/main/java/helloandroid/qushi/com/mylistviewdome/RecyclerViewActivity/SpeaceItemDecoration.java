package helloandroid.qushi.com.mylistviewdome.RecyclerViewActivity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpeaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    public  SpeaceItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = space;
        outRect.bottom = space;
    }
}

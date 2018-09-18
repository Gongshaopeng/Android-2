package helloandroid.qushi.com.mylistviewdome.RecyclerViewActivity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CustomLayoutManager extends RecyclerView.LayoutManager {
    private int verticalScrollOffset;
    private int offsetH;
    private int leftMargin,rightMargin;

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) recycler.getViewForPosition(0).getLayoutParams();
        leftMargin = params.leftMargin;
        rightMargin = params.rightMargin;
        detachAndScrapAttachedViews(recycler);
        layoutItme(recycler);

    }

    private void layoutItme(RecyclerView.Recycler recycler) {
        offsetH = getPaddingTop();
        int width = (Resources.getSystem().getDisplayMetrics().widthPixels - getRightDecorationWidth(recycler.getViewForPosition(0))-getLeftDecorationWidth(recycler.getViewForPosition(0)) - leftMargin - rightMargin)/3;
        int round = 0;
        for (int i = 0 ; i < getItemCount();i++ ){
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int height = getDecoratedMeasuredHeight(view) + getBottomDecorationHeight(view);
            Rect mTmpRect = new Rect();
            calculateItemDecorationsForChild(view,mTmpRect);
            switch (i - round) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:

                    break;
            }
            if (i + 1 - round == 6) {

            }
        }
    }
}

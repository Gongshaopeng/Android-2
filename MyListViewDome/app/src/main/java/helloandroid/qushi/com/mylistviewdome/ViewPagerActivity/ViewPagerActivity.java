package helloandroid.qushi.com.mylistviewdome.ViewPagerActivity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import helloandroid.qushi.com.mylistviewdome.R;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerFragment.OneFragment;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerFragment.TabFragmentPagerAdapter;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerFragment.ThreeFragment;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerFragment.TwoFragment;

public class ViewPagerActivity extends AppCompatActivity implements OnClickListener{

    private TextView tv_item_one;
    private TextView tv_item_two;
    private TextView tv_item_three;
    private ViewPager myViewPager;
    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
       InitView();
       setOnClick();
       newPager();
    }

    private void newPager() {
        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());

        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面
        tv_item_one.setBackgroundColor(Color.RED);//被选中就为红色
    }

    private void setOnClick() {
        // 设置菜单栏的点击事件
        tv_item_one.setOnClickListener(this);
        tv_item_two.setOnClickListener(this);
        tv_item_three.setOnClickListener(this);
        myViewPager.addOnPageChangeListener(new MyPagerChangeListener());

    }

    private void InitView() {
        tv_item_one = (TextView) findViewById(R.id.tv_itme_one);
        tv_item_two = (TextView) findViewById(R.id.tv_itme_two);
        tv_item_three = (TextView) findViewById(R.id.tv_itme_Three);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_itme_one:
                myViewPager.setCurrentItem(0);
                tv_item_one.setBackgroundColor(Color.RED);
                tv_item_two.setBackgroundColor(Color.WHITE);
                tv_item_three.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_itme_two:
                myViewPager.setCurrentItem(1);
                tv_item_one.setBackgroundColor(Color.WHITE);
                tv_item_two.setBackgroundColor(Color.RED);
                tv_item_three.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_itme_Three:
                myViewPager.setCurrentItem(2);
                tv_item_one.setBackgroundColor(Color.WHITE);
                tv_item_two.setBackgroundColor(Color.WHITE);
                tv_item_three.setBackgroundColor(Color.RED);
                break;
        }
    }


    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                    tv_item_one.setBackgroundColor(Color.RED);
                    tv_item_two.setBackgroundColor(Color.WHITE);
                    tv_item_three.setBackgroundColor(Color.WHITE);
                    break;
                case 1:
                    tv_item_one.setBackgroundColor(Color.WHITE);
                    tv_item_two.setBackgroundColor(Color.RED);
                    tv_item_three.setBackgroundColor(Color.WHITE);
                    break;
                case 2:
                    tv_item_one.setBackgroundColor(Color.WHITE);
                    tv_item_two.setBackgroundColor(Color.WHITE);
                    tv_item_three.setBackgroundColor(Color.RED);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}

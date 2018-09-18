package helloandroid.qushi.com.mylistviewdome.NewNavigationActivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import helloandroid.qushi.com.mylistviewdome.MainActivity;
import helloandroid.qushi.com.mylistviewdome.R;


public class NewNavigationActivity extends AppCompatActivity {
    private TitlebarView titlebarView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_navigation);
        setHideNavigation();
        init();
    }


    private void setHideNavigation() {
        //隐藏导航栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    private void init() {
        intent =getIntent();
        String text =intent.getStringExtra(MainActivity.Intent_key);
        titlebarView= (TitlebarView) findViewById(R.id.title);
        titlebarView.setTitleSize(20);
        titlebarView.setTitle(text);
        titlebarView.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
//                Toast.makeText(NewNavigationActivity.this,"左边",Toast.LENGTH_SHORT).show();
                //这里使用bundle绷带来传输数据
                Bundle bundle =new Bundle();
                //传输的内容仍然是键值对的形式
                bundle.putString(MainActivity.Intent_key,"来自于NavigationActivity的返回");//回发的消息,hello world from secondActivity!
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }

            @Override
            public void rightClick() {
                Toast.makeText(NewNavigationActivity.this,"右边",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && requestCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String text = null;
            if (bundle != null){


            }
        }
    }
}

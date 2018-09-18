package helloandroid.qushi.com.mylistviewdome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import helloandroid.qushi.com.mylistviewdome.ListViewActivity.ListViewActivity;
import helloandroid.qushi.com.mylistviewdome.NewNavigationActivity.NewNavigationActivity;
import helloandroid.qushi.com.mylistviewdome.NewNavigationActivity.TitlebarView;
import helloandroid.qushi.com.mylistviewdome.RecyclerViewActivity.RecyclerViewActivity;
import helloandroid.qushi.com.mylistviewdome.TestProtocol.TestProtocolAcitvity;
import helloandroid.qushi.com.mylistviewdome.UpLoad.UpLoadActivity;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerActivity;

public  class MainActivity extends AppCompatActivity {
    private TitlebarView titlebarView;

    public static final  String Intent_key ="MESSAGE";


    private String[] listArr = {"ViewPager","ListView","NewNavigation","RecyclerView","UpLoadActivity","TestProtocolAcitvity"};

    private List<Class> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = new ArrayList<>();
        myList.add(ViewPagerActivity.class);
        myList.add(ListViewActivity.class);
        myList.add(NewNavigationActivity.class);
        myList.add(RecyclerViewActivity.class);
        myList.add(UpLoadActivity.class);
        myList.add(TestProtocolAcitvity.class);

        setHideNavigation();
        init();
        initView();




    }


    private void setHideNavigation() {
        //隐藏导航栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    private void init() {

        titlebarView = (TitlebarView) findViewById(R.id.title);
        titlebarView.setTitleSize(20);
        titlebarView.setTitle("测试");
        titlebarView.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"左边",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"右边",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView() {


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,listArr);
        ListView listView = (ListView)findViewById(R.id.gs_listview);
        listView.setAdapter(adapter);
//        listView.getOnItemClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                pushActivity(myList.get(position),listArr[position]);

                Toast.makeText(MainActivity.this,"列表"+listArr[position],Toast.LENGTH_LONG).show();

            }
        });

    }


    private void pushActivity(Class activity ,String string){
        Intent intent = new Intent(this,activity);
        intent.putExtra(Intent_key,string);
        startActivityForResult(intent,0);
    }
    //留着获取返回参数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      //
        if (requestCode == 0 && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String text = null;
            if (bundle != null){
                text = bundle.getString(Intent_key);
                Toast.makeText(MainActivity.this,"Pop返回值-"+text,Toast.LENGTH_LONG).show();

            }
        }
    }


    //    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
}

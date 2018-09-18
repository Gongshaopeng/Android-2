package helloandroid.qushi.com.mylistviewdome.ListViewActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import helloandroid.qushi.com.mylistviewdome.MainActivity;
import helloandroid.qushi.com.mylistviewdome.R;
import helloandroid.qushi.com.mylistviewdome.ViewPagerActivity.ViewPagerActivity;

public class ListViewActivity extends AppCompatActivity {

    private static final String TAG = "ListERROR";
    private String[] listArr = {"ViewPager","ListView"};

    private List<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        initView();
    }


    private void initData() {
        String  string ;
        myList = new ArrayList<>();
        for (int j = 0; j < 16; j++) {

            string = String.format("ListView_Itme_"+"%d",j);
            Log.e(TAG, "string"+string);

            myList.add(string);
        }
        Log.e(TAG, "myList"+myList);

    }

    private void initView() {
        ArrayAdapter adapter = new ArrayAdapter(ListViewActivity.this,android.R.layout.simple_expandable_list_item_1,myList);
        ListView listView = (ListView)findViewById(R.id.gs_listview);
        listView.setAdapter(adapter);
//        listView.getOnItemClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                switch (position){
//                    case 0 :
//                        //语句
//
//                        pushActivity(ViewPagerActivity.class);
//                        break; //可选
//                    case 1 :
//                        //语句
//
//                        pushActivity(ListViewActivity.class);
//
//                        break; //可选
//                    //你可以有任意数量的case语句
//                    default : //可选
//                        //语句
//                }

                Toast.makeText(ListViewActivity.this,"列表"+ myList.get(position),Toast.LENGTH_LONG).show();

            }
        });
    }
}

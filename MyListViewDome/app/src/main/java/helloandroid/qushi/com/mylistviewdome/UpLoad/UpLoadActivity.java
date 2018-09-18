package helloandroid.qushi.com.mylistviewdome.UpLoad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import helloandroid.qushi.com.mylistviewdome.R;

public class UpLoadActivity extends AppCompatActivity {
    private final static String TAG = "UpLoadActivity";

    private Button btnChoseFile;
    private Button btnStartSplit;
    private Button btnStartMerge;

    private EditText txtResult;
    private EditText newFileName;

    private DocumentManagement documentManagement;//文件管理

    private final static int backCode = 0x11;
    private static String patch = Environment.getExternalStorageDirectory().getPath();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_load);
        //初始化UI
        findView();

        newClick();
    }

    private void newClick() {
        View.OnClickListener btnListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String toastMsg ;
                String strPath =  txtResult.getText().toString().trim();
                Log.d(TAG, "@txtResult:file"+strPath);

                //文件
                File file = new File(strPath);

                switch (v.getId()) {
                    case R.id.choseFile:

                        Intent intent = new Intent();
                        intent.setClass(UpLoadActivity.this, ChoseFileToolActivity.class);
                        startActivityForResult(intent, backCode);
                        break;
                    case R.id.startSplit:

                        if (documentManagement.isFileExist(file)) {
                            documentManagement.log("开始——汪汪汪汪");

                            //切割文件
                            documentManagement.getSplitFile(file,1*1024*1024 );

                            toastMsg =  file.getName()+"切割文件完成" ;
                        }else {
                            toastMsg =  "切割文件失败切割主文件路径不能为空" ;

                        }
                        Toast.makeText(UpLoadActivity.this, toastMsg,Toast.LENGTH_LONG).show();

                        break;
                    case R.id.startMerge:

                        if (documentManagement.isFileExist(file)) {

                            //合并文件
                            String merFileName = newFileName.getText().toString().trim();
                            if (merFileName == null && merFileName.trim().length() == 0) {
                                merFileName = "AApple";//自定义合并文件名字
                            }
                            //创建合并文件路径
                            String filePath = Environment.getExternalStorageDirectory().getPath() + "/" + merFileName;

                            documentManagement.merge(filePath, file, 1 * 1024 * 1024);
                            documentManagement.log("结束——汪汪汪汪");
                            toastMsg =  merFileName + "合并文件成功" ;
                        }else {
                            toastMsg =  "合并文件失败合并主文件路径不能为空" ;

                        }
                        Toast.makeText(UpLoadActivity.this, toastMsg, Toast.LENGTH_LONG).show();


                        break;
                    default:
                        break;
                }
            }
        };
        btnChoseFile.setOnClickListener(btnListener);
        btnStartSplit.setOnClickListener(btnListener);
        btnStartMerge.setOnClickListener(btnListener);

    }

    private void pushActivity(Class activity){
        Intent intent = new Intent(this,activity);
//        Intent intent = new Intent;
//        intent.setClass(UpLoadActivity.this, activity);
        startActivityForResult(intent,backCode);
    }
    private void findView() {
        btnChoseFile = (Button) findViewById(R.id.choseFile);
        txtResult = (EditText) findViewById(R.id.tvData);
        btnStartSplit = (Button) findViewById(R.id.startSplit);
        btnStartMerge = (Button) findViewById(R.id.startMerge);
        newFileName = (EditText) findViewById(R.id.newFile);
        documentManagement = new DocumentManagement();
//        txtResult.setText(upDataPath);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "@onActivityResult");
        if(requestCode == backCode){
            if(resultCode == ChoseFileToolActivity.resultCode){
                Bundle bundle = data.getExtras();
                String str = bundle.getString("current_path");
                Log.d(TAG, "获取的 文件路径： "+str);
                txtResult.setText(str);
                if(str != null){
//                    btnStartUpload.setBackgroundColor(Color.rgb(96, 96, 96));
                }
            }
//            else if(resultCode == ChoseFolderToolActivity.resultCode) {
//                Bundle bundle = data.getExtras();
//                String str = bundle.getString("current_path");
//                String testStr = bundle.getString("testStr");
//                Log.d(TAG, "获取的 文件夹路径： "+str);
//                Log.d(TAG, "testStr : "+testStr);
//                txtResult.setText(str);
//                if(str != null){
//                    btnStartUpload.setBackgroundColor(Color.rgb(96, 96, 96));
//                }
//            }
        }
    }

    //截取字符串
    private String getFilePath(String path){
        if(path == null){
            return new String();
        }
        String result = path.substring(4);
        Log.d(TAG, "result : "+ result);
        return result;
    }



    /**
     * 判断点击按下是否在EditText上
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                newFileName.setFocusable(false);

                newFileName.setFocusableInTouchMode(false);
                return false;
            } else {
                newFileName.setFocusableInTouchMode(true);

                newFileName.setFocusable(true);

                newFileName.requestFocus();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

}

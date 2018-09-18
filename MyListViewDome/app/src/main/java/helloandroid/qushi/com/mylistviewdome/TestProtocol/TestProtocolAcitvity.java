package helloandroid.qushi.com.mylistviewdome.TestProtocol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import helloandroid.qushi.com.mylistviewdome.R;

public class TestProtocolAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_protocol_acitvity);

        LLLProtocol laoluo = new Laoluo();
        LLLProtocol lawyer = new Lawyer(laoluo);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
        Log.i("GSTestProtocol", "TestProtocolAcitvity: "+lawyer.baifen());
    }


}

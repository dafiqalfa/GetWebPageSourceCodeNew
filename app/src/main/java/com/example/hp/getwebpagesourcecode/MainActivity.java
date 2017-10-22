package com.example.hp.getwebpagesourcecode;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    EditText et1;
    static TextView myText;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);
        et1 = (EditText)findViewById(R.id.editText);

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        if(myInfo != null && myInfo.isConnected()){
            c1 = new ConnectInternetTask(this);
            c1.execute(et1.getText().toString());
        }
        else {
            Toast.makeText(this,"Internet Not Connected",Toast.LENGTH_SHORT).show();
        }
    }
}

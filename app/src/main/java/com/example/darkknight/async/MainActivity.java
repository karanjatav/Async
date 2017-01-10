package com.example.darkknight.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn;
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn = (Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String s = et.getText().toString();
        myAsync myAsyncObj = new myAsync();
myAsyncObj.execute(s);
        }
    });
    }

     class myAsync extends AsyncTask<String,String,String>{
         @Override
         protected String doInBackground(String... params) {
             int x= Integer.parseInt(params[0]);
             int i;
             for(i=0;i<=x;i++){
                 Log.d("karan","Threadrunning");
             }
             return "Thread Executed.!";
         }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            tv.setText(aVoid);
        }


     }
}

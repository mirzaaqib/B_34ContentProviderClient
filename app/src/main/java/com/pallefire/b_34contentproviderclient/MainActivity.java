package com.pallefire.b_34contentproviderclient;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button bt1,bt2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        bt1= (Button) findViewById(R.id.bt1);
        bt2= (Button) findViewById(R.id.bt2);
        tv= (TextView) findViewById(R.id.tv1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //client want to insert student details into first url(content://com.techpalle.b34/student)
                ContentResolver contentResolver=getContentResolver();
                String name=et1.getText().toString();
                String sub=et2.getText().toString();
                ContentValues contentValues=new ContentValues();
                contentValues.put(UriProvider.NAME , name);
                contentValues.put(UriProvider.SUB,sub);
                //now insert
                contentResolver.insert(UriProvider.STUDENT_URI,contentValues);
                et1.setText("");
                Toast.makeText(MainActivity.this, "Insert Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //client want to read data from first uri--student detait((content://com.techpalle.b34/student))
                //prepare resolver
                ContentResolver contentResolver=getContentResolver();
                Cursor c=contentResolver.query(UriProvider.STUDENT_URI,null,null,null,null);
                StringBuilder stringBuilder=new StringBuilder();
                if(c!=null){
                    while(c.moveToNext()){
                        int no=c.getInt(0); //this reads _id column name
                        String name=c.getString(1); //this reads sudent name value
                        String sub=c.getString(2);   //this reads sdent subject value
                        stringBuilder.append("no: "+no+" name :"+name+"sub :"+sub);
                    }
                    tv.setText(stringBuilder.toString());
                }
            }
        });
    }
}

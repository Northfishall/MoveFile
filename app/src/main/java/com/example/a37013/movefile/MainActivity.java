package com.example.a37013.movefile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Service.*;

public class MainActivity extends AppCompatActivity {

    private EditText etTxt;
    private EditText etFilename;
    private EditText etSDFilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTxt = findViewById(R.id.etTxt);
        etFilename = findViewById(R.id.etFilename);
        etSDFilename = findViewById(R.id.etSDFileName);
    }

    public void Write(View view) {
        String msg = etTxt.getText().toString();
        String filename = etFilename.getText().toString().trim();
        boolean ret = service.saveMsg(this,msg,filename);
        if(ret){
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void Copy(View view) {
        String filename = etFilename.getText().toString().trim();
        String sdfilename = etSDFilename.getText().toString().trim();
        boolean ret = service.copyMsg(this,filename,sdfilename);
        if(ret){
            Toast.makeText(this, "复制成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "复制失败", Toast.LENGTH_SHORT).show();
        }
    }


}

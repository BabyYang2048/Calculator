package com.example.babyyang.calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BabyYang on 2017/10/19.
 */

public class ThirdActivity extends Activity{
    protected void onCreate(Bundle savedInstateState) {
        super.onCreate(savedInstateState);
        setContentView(R.layout.unittransfromlayout);
        processExtraData();
        Button bn = (Button) findViewById(R.id.buttonexit);


        bn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(0, intent);
                finish();
            }
        });

        Button btSelect = (Button) findViewById(R.id.textSelect);
        btSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.unitchooselayout, null);  //同时声明两个布局
                builder.setView(view).setTitle("输入数字单位选择");

                final RadioButton two = (RadioButton) view.findViewById(R.id.mm);
                final RadioButton eight = (RadioButton) view.findViewById(R.id.cm);
                final RadioButton ten = (RadioButton) view.findViewById(R.id.m);
                final RadioButton sixteen = (RadioButton) view.findViewById(R.id.km);
                final RadioButton empty = (RadioButton) view.findViewById(R.id.empty);

                final TextView textView = (TextView) findViewById(R.id.jinzhinumber);

                View.OnClickListener handle = new View.OnClickListener() {
                    public void onClick(View v) {
                        RadioButton btn = (RadioButton) v;
                        switch (btn.getId()) {
                            case R.id.mm: {
                                textView.setText("MM");
                                break;
                            }
                            case R.id.cm: {
                                textView.setText("CM");
                                break;
                            }
                            case R.id.m: {
                                textView.setText("M");
                                break;
                            }
                            case R.id.km: {
                                textView.setText("KM");
                                break;
                            }
                            case R.id.empty: {
                                textView.setText(" ");
                                break;
                            }
                            default:
                                break;
                        }
                    }
                };
                two.setOnClickListener(handle);
                eight.setOnClickListener(handle);
                ten.setOnClickListener(handle);
                sixteen.setOnClickListener(handle);
                empty.setOnClickListener(handle);


                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        Button btE = (Button)findViewById(R.id.textView);
        Button btB = (Button)findViewById(R.id.textView1);
        Button btS = (Button)findViewById(R.id.textView2);
        Button btSL = (Button)findViewById(R.id.textView3);

        btE.setOnClickListener(transfrom);
        btB.setOnClickListener(transfrom);
        btS.setOnClickListener(transfrom);
        btSL.setOnClickListener(transfrom);
    }
    public View.OnClickListener transfrom = new View.OnClickListener() {
        public void onClick(View v) {
            EditText editText =(EditText)findViewById(R.id.input);

            EditText output2 = (EditText)findViewById(R.id.editText);
            EditText output8 = (EditText)findViewById(R.id.editText1);
            EditText output10 = (EditText)findViewById(R.id.editText2);
            EditText output16 = (EditText)findViewById(R.id.editText3);

            Button btn = (Button) v;
            TextView textView = (TextView)findViewById(R.id.jinzhinumber);
            String input = "",output="";
            input = editText.getText().toString();

            switch (btn.getId()){
                case R.id.textView:{   // X单位转MM
                    if(textView.getText().toString()=="MM"){
                        output = String.valueOf(Double.parseDouble(input)*1.0);
                        output2.setText(output+"mm");
                    }
                    else if(textView.getText().toString()=="CM"){
                        output = String.valueOf(Double.parseDouble(input)*10.0);
                        output2.setText(output+"mm");
                    }
                    else if(textView.getText().toString()=="M"){
                        output = String.valueOf(Double.parseDouble(input)*1000.0);
                        output2.setText(output+"mm");
                    }
                    else if(textView.getText().toString()=="KM"){
                        output = String.valueOf(Double.parseDouble(input)*1000000.0);
                        output2.setText(output+"mm");
                    }
                    break;
                }
                case R.id.textView1:{ //X单位转CM
                    if(textView.getText().toString()=="MM"){
                        output = String.valueOf(Double.parseDouble(input)/10);
                        output8.setText(output+"cm");
                    }
                    else if(textView.getText().toString()=="CM"){
                        output = String.valueOf(Double.parseDouble(input)*1.0);
                        output8.setText(output+"cm");
                    }
                    else if(textView.getText().toString()=="M"){
                        output = String.valueOf(Double.parseDouble(input)*100.0);
                        output8.setText(output+"cm");
                    }
                    else if(textView.getText().toString()=="KM"){
                        output = String.valueOf(Double.parseDouble(input)*100000.0);
                        output8.setText(output+"cm");
                    }
                    break;
                }
                case R.id.textView2:{ //X单位转M
                    if(textView.getText().toString()=="MM"){
                        output = String.valueOf(Double.parseDouble(input)/1000.0);
                        output10.setText(output+"m");
                    }
                    else if(textView.getText().toString()=="CM"){
                        output = String.valueOf(Double.parseDouble(input)/100.0);
                        output10.setText(output+"m");
                    }
                    else if(textView.getText().toString()=="M"){
                        output = String.valueOf(Double.parseDouble(input)*1.0);
                        output10.setText(output+"m");
                    }
                    else if(textView.getText().toString()=="KM"){
                        output = String.valueOf(Double.parseDouble(input)*1000.0);
                        output10.setText(output+"m");
                    }
                    break;
                }
                case R.id.textView3:{ //X单位转KM
                    if(textView.getText().toString()=="MM"){
                        output = String.valueOf(Double.parseDouble(input)/1000000.0);
                        output16.setText(output+"km");
                    }
                    else if(textView.getText().toString()=="CM"){
                        output = String.valueOf(Double.parseDouble(input)/100000.0);
                        output16.setText(output+"km");
                    }
                    else if(textView.getText().toString()=="M"){
                        output = String.valueOf(Double.parseDouble(input)/1000.0);
                        output16.setText(output+"km");
                    }
                    else if(textView.getText().toString()=="KM"){
                        output = String.valueOf(Double.parseDouble(input)*1.0);
                        output16.setText(output+"km");
                    }
                    break;
                }
                default:
                    break;
            }
        }};

    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        processExtraData();
    }
    private void processExtraData(){
        Intent intent = getIntent();
        Toast.makeText(this,"欢迎来到单位转换界面！",Toast.LENGTH_LONG).show();
    }
}

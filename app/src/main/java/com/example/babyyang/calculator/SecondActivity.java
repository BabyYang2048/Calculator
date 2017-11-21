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

public class SecondActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstateState){
        super.onCreate(savedInstateState);
        setContentView(R.layout.ablayout);
        processExtraData();

        Button bn = (Button)findViewById(R.id.buttonexit);


        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = getIntent();
                setResult(0,intent);
                finish();
            }
        });

        Button btSelect = (Button)findViewById(R.id.textSelect);
        btSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.numberchooselayout, null);  //同时声明两个布局
                builder.setView(view).setTitle("输入数字进制选择");

                final RadioButton two = (RadioButton)view.findViewById(R.id.E);
                final RadioButton eight = (RadioButton)view.findViewById(R.id.B);
                final RadioButton ten = (RadioButton)view.findViewById(R.id.S);
                final RadioButton sixteen = (RadioButton)view.findViewById(R.id.SL);
                final RadioButton empty = (RadioButton)view.findViewById(R.id.empty);

                final TextView textView = (TextView)findViewById(R.id.jinzhinumber);

                View.OnClickListener handle = new View.OnClickListener(){
                    public void onClick(View v){
                        RadioButton btn = (RadioButton) v;
                        switch(btn.getId()){
                            case R.id.E:{
                                textView.setText("二进制");
                                break;
                            }
                            case R.id.B:{
                                textView.setText("八进制");
                                break;
                            }
                            case R.id.S:{
                                textView.setText("十进制");
                                break;
                            }
                            case R.id.SL:{
                                textView.setText("十六进制");
                                break;
                            }
                            case R.id.empty:{
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
                case R.id.textView:{   // X进制转二进制
                    if(textView.getText().toString()=="二进制"){
                        output2.setText(input);
                    }
                    else if(textView.getText().toString()=="八进制"){
                        output= Integer.toBinaryString(Integer.parseInt(input,8));
                        output2.setText(output);
                    }
                    else if(textView.getText().toString()=="十进制"){
                        output = Integer.toBinaryString(Integer.valueOf(input));
                        output2.setText(output);
                    }
                    else if(textView.getText().toString()=="十六进制"){
                        output=Integer.toBinaryString(Integer.valueOf(input,16));
                        output2.setText(output);
                    }
                    break;
                }
                case R.id.textView1:{ //X进制转八进制
                    input = editText.getText().toString();
                    if(textView.getText().toString()=="二进制"){
                        output= Integer.toOctalString(Integer.parseInt(input,2));
                        output8.setText(output);
                    }
                    else if(textView.getText().toString()=="八进制"){
                        output8.setText(input);
                    }
                    else if(textView.getText().toString()=="十进制"){
                        output = Integer.toOctalString(Integer.valueOf(input));
                        output8.setText(output);
                    }
                    else if(textView.getText().toString()=="十六进制"){
                        output = Integer.toOctalString(Integer.valueOf(input,16));
                        output8.setText(output);
                    }
                    break;
                }
                case R.id.textView2:{ //X进制转十进制
                    input = editText.getText().toString();
                    if(textView.getText().toString()=="二进制"){
                        output = Integer.valueOf(input,2).toString();
                        output10.setText(output);
                    }
                    else if(textView.getText().toString()=="八进制"){
                        output = Integer.valueOf(input,8).toString();
                        output10.setText(output);
                    }
                    else if(textView.getText().toString()=="十进制"){
                        output10.setText(input);
                    }
                    else if(textView.getText().toString()=="十六进制"){
                        output = Integer.valueOf(input,16).toString();
                        output10.setText(output);
                    }
                    break;
                }
                case R.id.textView3:{ //X进制转十六进制
                    input = editText.getText().toString();
                    if(textView.getText().toString()=="二进制"){
                        output=Integer.toHexString(Integer.valueOf(input,2));
                        output16.setText(output);
                    }
                    else if(textView.getText().toString()=="八进制"){
                        output=Integer.toHexString(Integer.valueOf(input,8));
                        output16.setText(output);
                    }
                    else if(textView.getText().toString()=="十进制"){
                        output=Integer.toHexString(Integer.valueOf(input));
                        output16.setText(output);
                    }
                    else if(textView.getText().toString()=="十六进制"){
                        output16.setText(input);
                    }
                    break;
                }
                default:
                    break;

            }


        }};

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        processExtraData();
    }
    private void processExtraData(){
        Intent intenlt = getIntent();
        Toast.makeText(this,"欢迎来到进制转换界面！",Toast.LENGTH_LONG).show();
    }

}


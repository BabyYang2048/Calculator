package com.example.babyyang.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0;
    private Button btAdd,btSub,btMul,btDiv,btEqu;
    private Button btC,btPoint,btBack,btPercent;

    private Button  btSin,btCos,btTan,btZ,btY;


    private TextView textResult;
    private TextView textInput;
    private String operation = "";

    boolean didEqualClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewComponent();
    }

    public boolean onCreateOptionsMenu(Menu menu) {  //创建右上角菜单
        getMenuInflater().inflate(R.menu.menulayout, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {  //菜单栏选项
        switch (item.getItemId()){
            case R.id.action:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.action2:
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent2, 0);
                break;  
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    private void setupViewComponent() {
        textResult = (TextView)findViewById(R.id.result);
        textInput = (TextView)findViewById(R.id.input);

        bt0 = (Button)findViewById(R.id.button0);
        bt1 = (Button)findViewById(R.id.button1);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        bt4 = (Button)findViewById(R.id.button4);
        bt5 = (Button)findViewById(R.id.button5);
        bt6 = (Button)findViewById(R.id.button6);
        bt7 = (Button)findViewById(R.id.button7);
        bt8 = (Button)findViewById(R.id.button8);
        bt9 = (Button)findViewById(R.id.button9);
        btAdd = (Button)findViewById(R.id.buttonjia);
        btSub = (Button)findViewById(R.id.buttonjian);
        btMul = (Button)findViewById(R.id.buttoncheng);
        btDiv = (Button)findViewById(R.id.buttonchu);
        btEqu = (Button)findViewById(R.id.buttondeng);
        btPoint = (Button)findViewById(R.id.buttondian);
        btBack = (Button)findViewById(R.id.buttonzf);
        btC = (Button)findViewById(R.id.buttonC);
        btPercent = (Button)findViewById(R.id.buttonbai);
        btSin = (Button)findViewById(R.id.buttonSin);
        btCos = (Button)findViewById(R.id.buttonCos);
        btTan = (Button)findViewById(R.id.buttonTan);
        btZ = (Button)findViewById(R.id.buttonzuokuo);
        btY = (Button)findViewById(R.id.buttonyoukuo);


       Button[] button = {bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,
                btAdd,btSub,btMul,btDiv,btC,btPoint,btBack,btPercent,
                btSin,btCos,btTan,btZ,btY};



        for(int i=0;i<button.length;i++){
            button[i].setOnClickListener(listener);
        }
       btEqu.setOnClickListener(equOnClick);

    }

    public View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {
            Button btn = (Button) v;
            String number1="";
            double number2=0.0;
            switch (btn.getId()) {
                case R.id.button0: {  //0
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "0";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button1: {  //1
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;
                    }
                    operation += "1";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button2: {  //2
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "2";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button3: {  //3
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "3";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button4: {  //4
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "4";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button5: {  //5
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;
                    }
                    operation += "5";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button6: {   //6
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "6";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button7: {   //7
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "7";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button8: {    //8
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;
                    }
                    operation += "8";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.button9: {   //9
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "9";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonjia: {   //+
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "+";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonjian: {   //-
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "-";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttoncheng: {  //*
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "*";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonchu: {   //  /
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "/";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttondian: { // .
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += ".";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonzf: {  //退格
                    if(operation.length()>1){
                        operation=operation.substring(0,operation.length()-1);
                        textInput.setText(operation);
                        textResult.setText(operation);
                        break;
                    }
                    else{
                        operation = "";
                        textInput.setText(operation);
                        textResult.setText(operation);
                        break;
                    }
                }
                case R.id.buttonC: {
                    operation = "";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonbai:{  //%
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation += "%";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }

                case R.id.buttonzuokuo:{
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;
                    }
                    operation +="(";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonyoukuo:{
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    operation +=")";
                    textInput.setText(operation);
                    textResult.setText(operation);
                    break;
                }
                case R.id.buttonSin:{
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    number1 = textInput.getText().toString();
                    textInput.setText("sin"+number1);
                    number2 = Double.parseDouble(number1);
                    number1 = String.valueOf(Math.sin(Math.toRadians(number2)));
                    textResult.setText(number1);
                    break;
                }
                case R.id.buttonCos:{
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;

                    }
                    number1 = textInput.getText().toString();
                    textInput.setText("cos"+number1);
                    number2 = Double.parseDouble(number1);
                    number1 = String.valueOf(Math.cos(Math.toRadians(number2)));
                    textResult.setText(number1);
                    break;
                }
                case R.id.buttonTan:{
                    if(didEqualClicked==true){
                        operation ="";
                        didEqualClicked=false;
                    }
                    number1 = textInput.getText().toString();
                    textInput.setText("tan"+number1);
                    number2 = Double.parseDouble(number1);
                    number1 = String.valueOf(Math.tan(Math.toRadians(number2)));
                    textResult.setText(number1);
                    break;
                }
                default: {
                    break;
                }
            }
        }



    };


    public View.OnClickListener equOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            operation+="=";
            if(operation.charAt(0)=='-'
                    || operation.charAt(0)=='+'
                    || operation.charAt(0)=='*'
                    || operation.charAt(0)=='/'
                    || operation.charAt(0)=='%'){
                operation="0"+operation;
            }

            Stack OPTR = new java.util.Stack(); //操作符
            Stack OPND = new java.util.Stack(); //操作数

            OPTR.push('=');//changed
            char theta;
            double a=0f,b=0f,q=0f;
            int i=0;
            int flag=0;  //flag作为标志处理多位数  q用来保存多位数
            char c=operation.charAt(i++);
            String result="result";


            while( c != '='|| (Character)OPTR.peek() != '=' ){ //循环处理表达式中的每一个字符
                if(isOper(c)==1){  //如果是运算符
                    if(flag==1){
                        OPND.push(q);  //操作数入栈
                        q=0;  //操作数清零
                        flag=0;  //标志清零，表示操作数已经进栈
                    }
                   switch(Priority((Character)OPTR.peek(),c)){  //判定运算符的优先级
                       case -1:  //op1<op2
                           OPTR.push(c);
                           c=operation.charAt(i++);
                           break;
                       case 0://op1,op2为左右括号
                           c=(Character) OPTR.peek();
                           OPTR.pop();
                           c=operation.charAt(i++);
                           break;
                       case 1: //op1>op2
                           theta = (Character) OPTR.peek();
                           OPTR.pop();
                           b=(double)OPND.peek();
                           OPND.pop();
                           a=(double)OPND.peek();
                           OPND.pop();
                           result = Operate(a,theta,b);
                           if(result==""){
                               textResult.setText("除数不能为0！");}
                           else{
                               OPND.push(Double.valueOf(result));}
                           break;
                       default:
                           textResult.setText("error");
                           break;

                   }
                }
                else if(c>='0'&&c<='9'){  //输入的数字在0-9
                    c -= '0';
                    q=q*10+c;
                    c=operation.charAt(i++);
                    flag = 1; //设置标志，表示操作数未入栈
                }
                else if(c=='%'){
                    if(flag==1){
                        OPND.push(q);  //操作数入栈
                        q=0;  //操作数清零
                        flag=0;  //标志清零，表示操作数已经进栈
                    }
                    double num1 =(double)OPND.peek();
                    OPND.pop();
                    num1=num1/100;
                    OPND.push(num1);
                    c=operation.charAt(i++);
                }
                else if(c=='.'){
                    if(flag==1){
                        OPND.push(q);  //操作数入栈
                        q=0;  //操作数清零
                        flag=0;  //标志清零，表示操作数已经进栈
                    }
                    double num2=(double)OPND.peek();
                    OPND.pop();
                    int h=i,p=1;
                    double n1 = 0f;
                    while(operation.charAt(h)>='0'&&operation.charAt(h)<='9'){
                        h++;
                        double X = (double)operation.charAt(i++)-'0';
                        n1 = num2 * 10 + X;
                        num2 = n1;
                        p *= 10;
                    }
                    double nresult = n1/p;
                    OPND.push(nresult);
                    c=operation.charAt(i++);
                }
                else{ textResult.setText("输入错误");}
                OPTR.peek();

            }
            if(result!=""){
                operation=String.valueOf(OPND.peek()) ;// changed (String)OPND.peek()
                OPND.pop();
                didEqualClicked = true;
                textResult.setText(operation);
            }
            else{
                didEqualClicked = true;
                textResult.setText("error");
            }
        }

        String Operate(double a,char op,double b){
            String result= "";
            switch (op){
                case '+': {
                    result = String.valueOf(a+b);
                    break;
                }case '-': {
                    result = String.valueOf(a-b);
                    break;
                }
                case '*':{
                    result= String.valueOf(a*b);
                    break;
                }
                case '/':{
                    if(b!=0) {
                        result = String.valueOf(a/b);
                        break;
                    }
                    else{ break; }
                }
            }
            return result;
        }

        int Priority(char op1, char op2) {
            int pri = -2;
            switch (op2) {
                case '+':
                case '-':
                    if (op1 == '(' || op1 == '=') {pri = -1;}
                    else {pri = 1;}
                    break;
                case '*':
                case '/':
                    if (op1 == ')' || op1 == '*' || op1 == '/') {pri = 1;}
                    else {pri = -1;}
                    break;
                case '(':
                    if (op1 == ')') {
                        textResult.setText("表达式有误");
                        return 0;
                    }
                    else {pri = -1;}
                    break;
                case ')':
                    if (op1 == '(') {pri = 0;}
                    else {pri = 1;}
                    break;
                case '=':
                    if (op1 == '(') {
                        textResult.setText("括号不匹配");
                        return 0;
                    }
                    else if (op1 == '=') {pri = 0;}
                    else {pri = 1;}
                    break;
            }
            return pri;
        }


        int isOper(char c){
            switch (c){
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                case '=':
                    return 1;
                default:
                    return 0;
            }
        }




    };


}

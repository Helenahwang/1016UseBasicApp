package com.appdev.a503_02.a1016usebasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    int value = 0;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        TextView title =(TextView)findViewById(R.id.title);
        title.setText(getIntent().getStringExtra("title"));


        final TextView textView = (TextView)findViewById(R.id.count);
        Button btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value + 1;
                textView.setText(value+"");
            }
        });








    }

    //엑티비티가 종료되기 직전에 호출되는 메소드
    //복원할 데이터를 저장
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        //데이터 저장
        bundle.putInt("value", value);
        final EditText editText = (EditText)findViewById(R.id.editcount);
        number=editText.getText().toString();
        bundle.putString("number",number);
    }

    //엑티비티가 시작할 때 호출되는 메소드
    //데이터를 복원한다.
    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);

        int value = bundle.getInt("value");
        this.value = value;
        TextView textView = (TextView)findViewById(R.id.count);
        textView.setText(value+"");



        String number = bundle.getString("number");
        EditText editText = (EditText)findViewById(R.id.editcount);
        editText.setText(number);

    }
}

package com.example.loginapp;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int cnt=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button) findViewById(R.id.btnLogin);
        Info.setText("No. of attempts remaining = 5");
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void  onClick(View view)
            {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String usrName,String psw)
    {
        if((usrName.equals("Vivek"))&& (psw.equals("7714")))
        {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            cnt--;
            Info.setText("No. of attempts remaining: "+String.valueOf(cnt));
            if(cnt==0)
            {
                Login.setEnabled(false);
            }
        }
    }
}

package com.example.sqrts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kotlin.contracts.Returns;

public abstract class MainActivity extends AppCompatActivity {
    EditText etA,etB,etC;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectComponents();
    }


    private void connectComponents() {
        etA=findViewById(R.id.etAMain);
        etB=findViewById(R.id.etBMain);
        etC=findViewById(R.id.etCMain);
        btnCalculate=findViewById(R.id.btnCalculateMain);
    }

    public void CalculateDelta(View view) {
        String sA=etA.getText().toString();
        String sB=etB.getText().toString();
        String sC=etB.getText().toString();
        Double dA,dB,dC;
        if(sA.isEmpty()||!TextUtils.isDigitsOnly(sA)||sB.isEmpty()||!TextUtils.isDigitsOnly(sB)||sA.isEmpty()||!TextUtils.isDigitsOnly(sC))
        { Toast.makeText(this, "Please Check Input!", Toast.LENGTH_LONG).show();
            return;}
        dA=Double.parseDouble(sA);
        dB=Double.parseDouble(sB);
        dC=Double.parseDouble(sC);
        Double Delta=Math.pow(dB,2)-(4*dA*dC);
        if(Delta<0){
            Toast.makeText(this, "ERROR!", Toast.LENGTH_LONG).show();
            return;
        }
        if(Delta==0)
        {
            Toast.makeText(this, "X="+((-1*dB)/(2*dA)), Toast.LENGTH_LONG).show();
            return;
        }
        Double x1=(-dB+Math.sqrt(Delta))/(2*dA);
        Double x2=(-dB-Math.sqrt(Delta))/(2*dA);
        Toast.makeText(this, "X1="+x1, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "X2="+x2, Toast.LENGTH_LONG).show();
    }





}
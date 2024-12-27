package com.naskraft.soundwave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OTPPage extends AppCompatActivity {

    String otpp;
    TextView otp,verifyotp;

    Button generateotp,continuetohomepage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otppage);

        generateotp=(Button)findViewById(R.id.btn_genearteotp);
        continuetohomepage=(Button)findViewById(R.id.btn_otp);
        otp=(EditText)findViewById(R.id.txt_otp);
        verifyotp=(EditText)findViewById(R.id.edt_otp);
        generateotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String phoneno = intent.getStringExtra("PHONENO").toString();
                sendmessage(phoneno);
                otp.setText("OTP="+otpp);
                Toast.makeText(getApplicationContext(), otpp,Toast.LENGTH_LONG).show();
            }
        });

        continuetohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verifyotp.getText().toString().equals(otpp)){
                    Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),Interest.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
                }
            }
        });





    }




    void sendmessage(String phoneno)
    {
        Random rand = new Random();
        otpp = String.format("%04d", rand.nextInt(10000));
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneno, null, "Your OTP is "+otpp, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }}











}
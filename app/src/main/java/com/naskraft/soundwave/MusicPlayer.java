package com.naskraft.soundwave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MusicPlayer extends AppCompatActivity {
    Button obj_btn_url;
    EditText obj_urlstring;
    WebView myWebView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        obj_btn_url = (Button)findViewById(R.id.btn_url);
        obj_urlstring=(EditText)findViewById(R.id.edt_url);
        myWebView = (WebView) findViewById(R.id.webview);



        obj_btn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myWebView = new WebView(getApplicationContext());
                setContentView(myWebView);
                myWebView.loadUrl(obj_urlstring.getText().toString());
//                if(obj_urlstring.getText().toString().contains("https"))
//                {
//                    if(obj_urlstring.getText().toString().contains("www"))
//                    {
//                        Uri uri = Uri.parse(obj_urlstring.getText().toString()); // missing 'http://' will cause crashed
//                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                        startActivity(intent);
//
//                    }
//                }
//                else {
//                    if(obj_urlstring.getText().toString().contains("www"))
//                    {
//
//                        String url = "https://";
//                        url = url + obj_urlstring.getText().toString();
//                        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
//                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                        startActivity(intent);
//                    }else {
//                        String url = "https://www.";
//                        url = url + obj_urlstring.getText().toString();
//                        System.out.println("-->> LANDED HERE");
//                        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
//                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                        startActivity(intent);
//
//                    }


//                }
            }
        });




    }
}
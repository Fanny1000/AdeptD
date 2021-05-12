package com.example.adeptdiction;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.TRANSPARENT;

public class AboutUs extends AppCompatActivity {
    private String phone = "5586529532";
    private String wa = "+5610672419";
    private TextView a1ya2,b1yb2;
    private Spanned a2,a1,b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        a1ya2 = (TextView) findViewById(R.id.a1ya2);
        b1yb2 = (TextView) findViewById(R.id.b1yb2);
        a1 = Html.fromHtml(getResources().getString(R.string.AboutA1));
        a2 = Html.fromHtml(getResources().getString(R.string.AboutA2));
        //Html.fromHtml(getResources().getString(R.string.AboutA1));
    }
    public void FB(View v) {
        Uri uri = Uri.parse("https://www.facebook.com/adeptdiction/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void llamar (View v){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        startActivity(intent);

    }
    @SuppressLint("NewApi")
    public void WA (View v){
        String toNumber = "+5215610672419"; // contains spaces.
        toNumber = toNumber.replace("+", "").replace("","");
        Intent sendIntent = new Intent("android.intent.action.MAIN");
    sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
       // sendIntent.putExtra(Intent.EXTRA_TEXT, "Me interesa");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setPackage("com.whatsapp");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }
   public void a1(View v){
        findViewById(R.id.a1ya2);
       if(a1ya2.getText().toString().equals("")||a1ya2.getText().toString().equals(null)){
           a1ya2.setBackgroundColor(Color.WHITE);
           a1ya2.setText(Html.fromHtml(getResources().getString(R.string.AboutA1)));
       }else if(a1ya2.getText().toString().equals(a2.toString())){
           a1ya2.setBackgroundColor(Color.WHITE);
           a1ya2.setText(Html.fromHtml(getResources().getString(R.string.AboutA1)));
       }else{
           a1ya2.setBackgroundColor(TRANSPARENT);
           a1ya2.setText("");
       }
    }
    public void a2(View v){
        findViewById(R.id.a1ya2);
        if(a1ya2.getText().toString().equals("")||a1ya2.getText().toString().equals(null)){
            a1ya2.setBackgroundColor(Color.WHITE);
            a1ya2.setText(Html.fromHtml( getResources().getString(R.string.AboutA2)));
        }else if(a1ya2.getText().toString().equals(a1.toString())){
            a1ya2.setBackgroundColor(Color.WHITE);
            a1ya2.setText(Html.fromHtml(getResources().getString(R.string.AboutA2)));
        }else{
            a1ya2.setBackgroundColor(TRANSPARENT);
            a1ya2.setText("");
        }
    }
    public void b1(View v){
        findViewById(R.id.b1yb2);
        if(b1yb2.getText().toString().equals("")||b1yb2.getText().toString().equals(null)){
            b1yb2.setBackgroundColor(Color.WHITE);
            b1yb2.setText(Html.fromHtml(getResources().getString(R.string.AboutB1)));
        }else{
            b1yb2.setBackgroundColor(TRANSPARENT);
            b1yb2.setText("");
        }
    }

}

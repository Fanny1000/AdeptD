package com.example.adeptdiction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class unitsb1l1 extends AppCompatActivity {
        ImageView h1,h2,h3,h4,h5,h6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitsb1l1);

        h1 = (ImageView) findViewById(R.id.h1);
        h2 = (ImageView) findViewById(R.id.h2);
        h3 = (ImageView) findViewById(R.id.h3);
        h4 = (ImageView) findViewById(R.id.h4);
        h5 = (ImageView) findViewById(R.id.h5);
        h6 = (ImageView) findViewById(R.id.h6);
        recibirdatos();


    }
    private void recibirdatos() {
//Recibiendo los datos
        Bundle extras = getIntent().getExtras();
        String Libro= extras.getString("Libro");
        String Unidad = extras.getString("Unidad");

        imagenes(Libro,Unidad);
    }
    @SuppressLint("ResourceType")
    public void imagenes (String l, String u){
        String lu=l+u;
       switch(lu){
           case "Studen't book 3I":
               h1.setImageResource(R.raw.p1);
               h2.setImageResource(R.raw.p2);
               h3.setImageResource(R.raw.p3);
               h4.setImageResource(R.raw.p4);
               h5.setImageResource(R.raw.p5);
               break;
           case "Studen't book 31":
               h1.setImageResource(R.raw.p6);
               h2.setImageResource(R.raw.p7);
               h3.setImageResource(R.raw.p8);
               h4.setImageResource(R.raw.p9);
               h5.setImageResource(R.raw.p10);
               h6.setImageResource(R.raw.p11);
               break;
           case "Studen't book 32":
               h1.setImageResource(R.raw.p12);
               h2.setImageResource(R.raw.p13);
               h3.setImageResource(R.raw.p14);
               h4.setImageResource(R.raw.p15);
               h5.setImageResource(R.raw.p16);
               h6.setImageResource(R.raw.p17);
               break;
           case "Studen't book 33":
               h1.setImageResource(R.raw.p20);
               h2.setImageResource(R.raw.p21);
               h3.setImageResource(R.raw.p22);
               h4.setImageResource(R.raw.p23);
               h5.setImageResource(R.raw.p24);
               h6.setImageResource(R.raw.p25);
               break;
           case "Studen't book 34":
               h1.setImageResource(R.raw.p26);
               h2.setImageResource(R.raw.p27);
               h3.setImageResource(R.raw.p28);
               h4.setImageResource(R.raw.p29);
               h5.setImageResource(R.raw.p30);
               h6.setImageResource(R.raw.p31);
               break;
           case "Studen't book 35":
               h1.setImageResource(R.raw.p34);
               h2.setImageResource(R.raw.p35);
               h3.setImageResource(R.raw.p36);
               h4.setImageResource(R.raw.p37);
               h5.setImageResource(R.raw.p38);
               h6.setImageResource(R.raw.p39);
               break;
           case "Studen't book 36":
               h1.setImageResource(R.raw.p40);
               h2.setImageResource(R.raw.p41);
               h3.setImageResource(R.raw.p42);
               h4.setImageResource(R.raw.p43);
               h5.setImageResource(R.raw.p44);
               h6.setImageResource(R.raw.p45);
               break;
           case "Studen't book 37":
               h1.setImageResource(R.raw.p48);
               h2.setImageResource(R.raw.p49);
               h3.setImageResource(R.raw.p50);
               h4.setImageResource(R.raw.p51);
               h5.setImageResource(R.raw.p52);
               h6.setImageResource(R.raw.p53);
               break;
           case "Studen't book 38":
               h1.setImageResource(R.raw.p54);
               h2.setImageResource(R.raw.p55);
               h3.setImageResource(R.raw.p56);
               h4.setImageResource(R.raw.p57);
               h5.setImageResource(R.raw.p58);
               h6.setImageResource(R.raw.p59);
               break;
           case "Studen't book 39":
               h1.setImageResource(R.raw.p62);
               h2.setImageResource(R.raw.p63);
               h3.setImageResource(R.raw.p64);
               h4.setImageResource(R.raw.p65);
               h5.setImageResource(R.raw.p66);
               h6.setImageResource(R.raw.p67);
               break;
           case "Studen't book 310":
               h1.setImageResource(R.raw.p68);
               h2.setImageResource(R.raw.p69);
               h3.setImageResource(R.raw.p70);
               h4.setImageResource(R.raw.p71);
               h5.setImageResource(R.raw.p72);
               h6.setImageResource(R.raw.p73);
               break;
           case "Studen't book 311":
               h1.setImageResource(R.raw.p76);
               h2.setImageResource(R.raw.p77);
               h3.setImageResource(R.raw.p78);
               h4.setImageResource(R.raw.p79);
               h5.setImageResource(R.raw.p80);
               h6.setImageResource(R.raw.p81);
               break;
           case "Studen't book 312":
               h1.setImageResource(R.raw.p82);
               h2.setImageResource(R.raw.p83);
               h3.setImageResource(R.raw.p84);
               h4.setImageResource(R.raw.p85);
               h5.setImageResource(R.raw.p86);
               h6.setImageResource(R.raw.p87);
               break;
           case "Studen't book 313":
               h1.setImageResource(R.raw.p90);
               h2.setImageResource(R.raw.p91);
               h3.setImageResource(R.raw.p92);
               h4.setImageResource(R.raw.p93);
               h5.setImageResource(R.raw.p94);
               h6.setImageResource(R.raw.p95);
               break;
           case "Studen't book 314":
               h1.setImageResource(R.raw.p96);
               h2.setImageResource(R.raw.p97);
               h3.setImageResource(R.raw.p98);
               h4.setImageResource(R.raw.p99);
               h5.setImageResource(R.raw.p100);
               h6.setImageResource(R.raw.p101);
               break;
           case "Studen't book 315":
               h1.setImageResource(R.raw.p104);
               h2.setImageResource(R.raw.p105);
               h3.setImageResource(R.raw.p106);
               h4.setImageResource(R.raw.p107);
               h5.setImageResource(R.raw.p108);
               h6.setImageResource(R.raw.p109);
               break;
           case "Studen't book 316":
               h1.setImageResource(R.raw.p110);
               h2.setImageResource(R.raw.p111);
               h3.setImageResource(R.raw.p112);
               h4.setImageResource(R.raw.p113);
               h5.setImageResource(R.raw.p114);
               h6.setImageResource(R.raw.p115);
               break;
        }

    }
}
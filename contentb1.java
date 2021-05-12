package com.example.adeptdiction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adeptdiction.entidades.usuario;

public class contentb1 extends AppCompatActivity implements View.OnClickListener{

    LinearLayout i,u1,u2,pc12,u3,u4,pc34,u5,u6,pc56,u7,u8,pc78,u9,u10,pc910,u11,u12,pc1112,u13,u14,pc1314,u15,u16,pc1516;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentb1);
        i=(LinearLayout)findViewById(R.id.I);
        u1=(LinearLayout)findViewById(R.id.u1);
        u2=(LinearLayout)findViewById(R.id.u2);
        pc12=(LinearLayout)findViewById(R.id.pc12);
        u3=(LinearLayout)findViewById(R.id.u3);
        u4=(LinearLayout)findViewById(R.id.u4);
        pc34=(LinearLayout)findViewById(R.id.pc34);
        u5=(LinearLayout)findViewById(R.id.u5);
        u6=(LinearLayout)findViewById(R.id.u6);
        pc56=(LinearLayout)findViewById(R.id.pc56);
        u7=(LinearLayout)findViewById(R.id.u7);
        u8=(LinearLayout)findViewById(R.id.u8);
        pc78=(LinearLayout)findViewById(R.id.pc78);
        u9=(LinearLayout)findViewById(R.id.u9);
        u10=(LinearLayout)findViewById(R.id.u10);
        pc910=(LinearLayout)findViewById(R.id.pc910);
        u11=(LinearLayout)findViewById(R.id.u11);
        u12=(LinearLayout)findViewById(R.id.u12);
        pc1112=(LinearLayout)findViewById(R.id.pc1112);
        u13=(LinearLayout)findViewById(R.id.u13);
        u14=(LinearLayout)findViewById(R.id.u14);
        pc1314=(LinearLayout)findViewById(R.id.pc1314);
        u15=(LinearLayout)findViewById(R.id.u15);
        u16=(LinearLayout)findViewById(R.id.u16);
        pc1516=(LinearLayout)findViewById(R.id.pc1516);


    }

    @Override
    public void onClick(View v) {
        if (v == i) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "I");
            startActivity(i);
        } else if (v == u1) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "1");
            startActivity(i);
        } else if (v == u2) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "2");
            startActivity(i);
        } else if (v == pc12) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc12");
            startActivity(i);
        } else if (v == u3) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "3");
            startActivity(i);
        } else if (v == u4) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "4");
            startActivity(i);
        } else if (v == pc34) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc34");
            startActivity(i);
        }else if (v == u5) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "5");
            startActivity(i);
        } else if (v == u6) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "6");
            startActivity(i);
        } else if (v == pc56) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc56");
            startActivity(i);
        }else if (v == u7) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "7");
            startActivity(i);
        } else if (v == u8) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "8");
            startActivity(i);
        } else if (v == pc78) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc78");
            startActivity(i);
        }else if (v == u9) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "9");
            startActivity(i);
        } else if (v == u10) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "10");
            startActivity(i);
        } else if (v == pc910) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc910");
            startActivity(i);
        }else if (v == u11) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "11");
            startActivity(i);
        } else if (v == u12) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "12");
            startActivity(i);
        } else if (v == pc1112) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc1112");
            startActivity(i);
        }else if (v == u13) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "13");
            startActivity(i);
        } else if (v == u14) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "14");
            startActivity(i);
        } else if (v == pc1314) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc1314");
            startActivity(i);
        }else if (v == u15) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "15");
            startActivity(i);
        } else if (v == u16) {
            Intent i = new Intent(contentb1.this, unitsb1l1.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "16");
            startActivity(i);
        } else if (v == pc1516) {
            Intent i = new Intent(contentb1.this, progressCheck.class);
            i.putExtra("Libro", "Studen't book 3");
            i.putExtra("Unidad", "pc1516");
            startActivity(i);
        }
    }
}
   /* public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            scale=scale*detector.getScaleFactor();
            scale=Math.max(0.1f,Math.min(scale,5f));
            matrix.setScale(scale,scale);
            //imagen
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        SGD.onTouchEvent(event);
        return true;
    }
}*/
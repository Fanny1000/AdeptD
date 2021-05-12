package com.example.adeptdiction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.view.View.OnClickListener;
import org.w3c.dom.Text;

import java.util.Calendar;


public class calendar extends AppCompatActivity implements OnClickListener {
    private TextView diaRT,horaRT;
    private String mesRT,anoRT,minutosRT,dia,hora;
    private EditText nombre,descripcion;
    private int dias, mes, ano, minutos, horas;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
        diaRT=(TextView) findViewById(R.id.diaRT);
       // horaRT=(TextView) findViewById(R.id.horaRT);
        nombre=(EditText) findViewById(R.id.nombreT);
        descripcion=(EditText) findViewById(R.id.descripcionT);
        registrar=(Button) findViewById(R.id.registrar);
        registrar.setOnClickListener(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    //Insertando el calendario para capturar el día y hora de la cita
    public void dias(View v) {

            //Mostrar el calendario
            final Calendar c = Calendar.getInstance();
            dias = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    //Mostrar en el text view el día seleccionado
                    anoRT=String.valueOf(year);
                    mesRT=String.valueOf(monthOfYear);
                    dia=String.valueOf(dayOfMonth);
                    diaRT.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                }
            }
                    , ano, mes, dias);
            datePickerDialog.show();
        }
        //Si se entra a la seccion de hora mostrar el menu de hora
       /* public void horasC(View v) {
            //Mostrar el reloj
            final Calendar c = Calendar.getInstance();
            horas = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    //Mostrar en el text view la hora seleccionada
                    horaRT.setText(hourOfDay+":"+minute);
                    hora=String.valueOf(hourOfDay);
                    minutosRT=String.valueOf(minute);

                }
            }
                    //mostrar primero la hora y depues del minuto
                    , horas, minutos, false);
            timePickerDialog.show();
        }*/
    @Override
        public void onClick(View v){
        Calendar cal=Calendar.getInstance();
        boolean val=false;
        Intent inten=null;
        if(nombre.getText().toString().equals("")||nombre.getText().toString().equals("Ex.Homewok1")||descripcion.getText().toString().equals("")||
        descripcion.getText().toString().equals("Ex.Pages 12 to 20")||diaRT.getText().toString().equals("20")){
            Toast.makeText(getApplicationContext(), "Please enter all data", Toast.LENGTH_SHORT).show();
        }else if(nombre.getText().toString().equals("")||nombre.getText().toString().equals("Ex.Homewok1")&&descripcion.getText().toString().equals("")||
                descripcion.getText().toString().equals("Ex.Pages 12 to 20")&&diaRT.getText().toString().equals("20")){
            Toast.makeText(getApplicationContext(), "The empy homeworks will be not saved", Toast.LENGTH_SHORT).show();
        }else{
        while(val==false) {
            try {
               cal.set(Calendar.YEAR, Integer.parseInt(anoRT));
                cal.set(Calendar.MONTH, Integer.parseInt(mesRT));
                cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
               // cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
              //  cal.set(Calendar.MINUTE, Integer.parseInt(minutosRT));

                inten = new Intent(Intent.ACTION_EDIT);
                inten.setType("vnd.android.cursor.item/event");

                inten.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
                inten.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis() + 60 + 60 + 100);

                inten.putExtra(CalendarContract.Events.TITLE, nombre.getText().toString());
                inten.putExtra(CalendarContract.Events.EVENT_COLOR, "0xffff0000");
                inten.putExtra(CalendarContract.Events.EVENT_LOCATION, "ADEPT DICTION");
                inten.putExtra(CalendarContract.Events.ALL_DAY, true);
                inten.putExtra(CalendarContract.Events.DESCRIPTION, descripcion.getText().toString());
                startActivity(inten);
                val = true;

            } catch (Exception e) {
                diaRT.setText("");
                Toast.makeText(getApplicationContext(), "Invalid date", Toast.LENGTH_SHORT).show();
            }
        }
        }
        }

    //@string/nombre_string
}
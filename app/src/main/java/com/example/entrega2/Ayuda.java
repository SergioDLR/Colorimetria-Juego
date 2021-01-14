package com.example.entrega2;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Ayuda extends AppCompatActivity {

    LinearLayout tablero5;
    LinearLayout tablero6;
    LinearLayout tablero7;

    int dificultad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        tablero5 = (LinearLayout)findViewById(R.id.tablero5);
        tablero6 = (LinearLayout)findViewById(R.id.tablero6);
        tablero7 = (LinearLayout)findViewById(R.id.tablero7);

        tablero5.setVisibility(View.INVISIBLE);
        tablero6.setVisibility(View.INVISIBLE);
        tablero7.setVisibility(View.INVISIBLE);

        Bundle datos = getIntent().getExtras();
        if(datos !=null){
            dificultad = datos.getInt("dato1");
            if(dificultad == 1){
                tablero5.setVisibility(View.VISIBLE);
            }else if(dificultad == 2){
                tablero6.setVisibility(View.VISIBLE);
            } else if(dificultad == 3){
                tablero7.setVisibility(View.VISIBLE);
            }
        }
    }
}

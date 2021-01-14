package com.example.entrega2;



import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int dificultad = 0;
    TextView dif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dif=(TextView)findViewById(R.id.dif);
    }
    public void click(View v){
        if (v.getId() == R.id.baja) {
            dificultad = 1;
            dif.setText(R.string.Baja);
        }
        else if (v.getId() == R.id.Media){
                dificultad = 2;
            dif.setText(R.string.Media);
            }
        else  if (v.getId() == R.id.Alta){
            dificultad = 3;
            dif.setText(R.string.Alta);
        }
    }
    public void iniciar(View v){
        if (dificultad != 0){
            Intent i = new Intent(this,Tablero.class);
            i.putExtra("dato1",dificultad);
            startActivity(i);
        }else{
            dif.setText(R.string.dificultad);
        }
    }
    public void verRanking(View v){
        Intent i = new Intent(this,ranking.class);
        startActivity(i);
    }

    public void onBackPressed()
    {
        CloseDialogFragment d = new CloseDialogFragment();
        d.show(getSupportFragmentManager(),"tagConfimation");
    }


}

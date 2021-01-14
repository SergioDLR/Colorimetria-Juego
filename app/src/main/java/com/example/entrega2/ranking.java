package com.example.entrega2;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ranking extends AppCompatActivity {
    boolean mostrar =false;

    String[] nombreFacil = new String[5];
    String[] nombreMedio = new String[5];
    String[] nombreDificil = new String[5];

    int[] puntuacionFacil = new int[5];
    int[] puntuacionMedia = new int[5];
    int[] puntuacionDificil = new int[5];

    String nombre;
    String pos;
    int puntuacion;

    TextView[] nomFacil = new TextView[5];
    TextView[] nomMedio = new TextView[5];
    TextView[] nomDificil = new TextView[5];

    TextView[] movFacil = new TextView[5];
    TextView[] movMedio = new TextView[5];
    TextView[] movDificil = new TextView[5];

    String compartirRank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mostrar = false;
        Context applicationContext = Tablero.getContextOfApplication();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        nomFacil[0] = (TextView) findViewById(R.id.jugador1);
        nomFacil[1] = (TextView) findViewById(R.id.jugador2);
        nomFacil[2] = (TextView) findViewById(R.id.jugador3);
        nomFacil[3] = (TextView) findViewById(R.id.jugador4);
        nomFacil[4] = (TextView) findViewById(R.id.jugador5);
        nomMedio[0] = (TextView) findViewById(R.id.jugador6);
        nomMedio[1] = (TextView) findViewById(R.id.jugador7);
        nomMedio[2] = (TextView) findViewById(R.id.jugador8);
        nomMedio[3] = (TextView) findViewById(R.id.jugador9);
        nomMedio[4] = (TextView) findViewById(R.id.jugador10);
        nomDificil[0] = (TextView) findViewById(R.id.jugador11);
        nomDificil[1] = (TextView) findViewById(R.id.jugador12);
        nomDificil[2] = (TextView) findViewById(R.id.jugador13);
        nomDificil[3] = (TextView) findViewById(R.id.jugador14);
        nomDificil[4] = (TextView) findViewById(R.id.jugador15);
        movFacil[0] = (TextView)findViewById(R.id.movimientos1);
        movFacil[1] = (TextView)findViewById(R.id.movimientos2);
        movFacil[2] = (TextView)findViewById(R.id.movimientos3);
        movFacil[3] = (TextView)findViewById(R.id.movimientos4);
        movFacil[4] = (TextView)findViewById(R.id.movimientos5);
        movMedio[0] = (TextView)findViewById(R.id.movimientos6);
        movMedio[1] = (TextView)findViewById(R.id.movimientos7);
        movMedio[2] = (TextView)findViewById(R.id.movimientos8);
        movMedio[3] = (TextView)findViewById(R.id.movimientos9);
        movMedio[4] = (TextView)findViewById(R.id.movimientos10);
        movDificil[0] = (TextView)findViewById(R.id.movimientos11);
        movDificil[1] = (TextView)findViewById(R.id.movimientos12);
        movDificil[2] = (TextView)findViewById(R.id.movimientos13);
        movDificil[3] = (TextView)findViewById(R.id.movimientos14);
        movDificil[4] = (TextView)findViewById(R.id.movimientos15);

        Bundle datos = getIntent().getExtras();
        if(datos !=null) {
         mostrar = true;
         pos = datos.getString("posicion");
         nombre = datos.getString("nombre");
         puntuacion = datos.getInt("puntuacion");
         guardar(pos,puntuacion,nombre);

        }
        leerPreferencias();
        String text = nomFacil[0].getText() + "";
        Log.d("dsasa",text +"");
        cargarNombres();

        compartirRank = getString(R.string.rank);
        for (int i=0;i < 5; i++) {
            if (puntuacionFacil[i] != -10) {
                compartirRank = compartirRank + " " + nombreFacil[i] + " " + getString(R.string.facil) + " " + puntuacionFacil[i] + " - ";
            }
            if (puntuacionMedia[i] != -10) {
                compartirRank = compartirRank + " " + nombreMedio[i] + " " + getString(R.string.medio) + " " + puntuacionMedia[i] + " - ";
            }
            if (puntuacionDificil[i] != -10) {
                compartirRank = compartirRank + " " + nombreDificil[i] + " " + getString(R.string.dificil) + " " + puntuacionDificil[i] + " - ";
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manushare, menu);
        return super.onCreateOptionsMenu(menu);

    }
    public void cargarNombres(){
        for (int i=0;i < 5; i++){

            nomFacil[i].setText(nombreFacil[i]);
            nomMedio[i].setText(nombreMedio[i]);
            nomDificil[i].setText(nombreDificil[i]);

            if(puntuacionFacil[i] != -10) {
                movFacil[i].setText(puntuacionFacil[i] + "");
            }else{
                movFacil[i].setText("-");
            }
            if(puntuacionMedia[i] != -10) {
                movMedio[i].setText(puntuacionMedia[i] + "");
            }else{
                movMedio[i].setText("-");
            }
            if(puntuacionDificil[i] != -10) {
                movDificil[i].setText(puntuacionDificil[i] + "");
            }else{
                movDificil[i].setText("-");
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.share){
            Log.e("fk","fk");
            Intent shareItent = new Intent(Intent.ACTION_SEND);
            shareItent.setType("text/plain");
            String s= String.valueOf(puntuacion);
            String body = compartirRank;
            String tit = getString(R.string.sh) ;
            shareItent.putExtra(Intent.EXTRA_TEXT,body);
            shareItent.putExtra(Intent.EXTRA_SUBJECT,tit);

            startActivity(Intent.createChooser(shareItent,getString(R.string.wna)));


        }
        if (item.getItemId() == R.id.exitRanking){
            this.finish();
        }
        return true;
    }

    public void guardar(String posicion, int puntuacion, String nombre){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(posicion,puntuacion);
        editor.putString("jugador"+posicion,nombre);
        editor.apply();
    }
    public void leerPreferencias(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        for (int i = 0;i<puntuacionFacil.length;i++) {
            puntuacionFacil[i] = preferences.getInt("facil"+i,-10);
            puntuacionMedia[i] = preferences.getInt("medio"+i,-10);
            puntuacionDificil[i] = preferences.getInt("dificil"+i,-10);

            nombreFacil[i] =preferences.getString("jugadorfacil"+i,"-");
            nombreMedio[i] =preferences.getString("jugadormedio"+i,"-");
            nombreDificil[i] =preferences.getString("jugadordificil"+i,"-");
        }


    }

}

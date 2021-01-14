package com.example.entrega2;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Tablero extends AppCompatActivity {
    public static Context contextOfApplication;
    ColorDrawable[]buttonBackground = new ColorDrawable[25];
    ColorDrawable[]holders = new ColorDrawable[25];
    ColorDrawable[]holders6 = new ColorDrawable[36];

    ColorDrawable[]buttonBackground6 = new ColorDrawable[36];
    ColorDrawable[]holders7 = new ColorDrawable[49];

    TextView[] button = new TextView[25];
    TextView[] button6 = new TextView[36];
    ColorDrawable[]buttonBackground7 = new ColorDrawable[49];
    TextView[] button7 = new TextView[49];
    boolean selected;
    String stateFlow;
    int cualBoton;
    int botonAnterior;
    ColorDrawable holder;
    int cantidad;
    int movimientos;
    ColorDrawable work;
    int dificultad;

    int posi;

    Integer[] facil = new Integer[5];
    Integer[] medio = new Integer[5];
    Integer[] dificil = new Integer[5];


    EditText nombre2;


    TextView puntuacion;

    TextView ganar5Texto;
    LinearLayout panel5Ganar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        selected = false;
        stateFlow = "stop";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        Bundle datos = getIntent().getExtras();

        if(datos != null){
            dificultad = datos.getInt("dato1");
            if (dificultad == 1){
                Log.e("dsads","skere");
                setContentView(R.layout.activity_tablero);
                button[0] = (TextView)findViewById(R.id.botton1);
                button[1] = (TextView)findViewById(R.id.botton2);
                button[2] = (TextView)findViewById(R.id.botton3);
                button[3] = (TextView)findViewById(R.id.botton4);
                button[4] = (TextView)findViewById(R.id.botton5);
                button[5] = (TextView)findViewById(R.id.botton6);
                button[6] = (TextView)findViewById(R.id.botton7);
                button[7] = (TextView)findViewById(R.id.botton8);
                button[8] = (TextView)findViewById(R.id.botton9);
                button[9] = (TextView)findViewById(R.id.botton10);
                button[10] = (TextView)findViewById(R.id.botton11);
                button[11] = (TextView)findViewById(R.id.botton12);
                button[12] = (TextView)findViewById(R.id.botton13);
                button[13] = (TextView)findViewById(R.id.botton14);
                button[14] = (TextView)findViewById(R.id.botton15);
                button[15] = (TextView)findViewById(R.id.botton16);
                button[16] = (TextView)findViewById(R.id.botton17);
                button[17] = (TextView)findViewById(R.id.botton18);
                button[18] = (TextView)findViewById(R.id.botton19);
                button[19] = (TextView)findViewById(R.id.botton20);
                button[20] = (TextView)findViewById(R.id.botton21);
                button[16] = (TextView)findViewById(R.id.botton17);
                button[17] = (TextView)findViewById(R.id.botton18);
                button[18] = (TextView)findViewById(R.id.botton19);
                button[19] = (TextView)findViewById(R.id.botton20);
                button[20] = (TextView)findViewById(R.id.botton21);
                button[21] = (TextView)findViewById(R.id.botton22);
                button[22] = (TextView)findViewById(R.id.botton23);
                button[23] = (TextView)findViewById(R.id.botton24);
                button[24] = (TextView)findViewById(R.id.botton25);

                cantidad = 25;
                for(int i = 0;i<cantidad;i++){
                    buttonBackground[i] = (ColorDrawable)button[i].getBackground();
                    holders[i] = (ColorDrawable)button[i].getBackground();

                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mezclar(holders,button);
                        stateFlow = "playing";
                    }
                }, 5000);

                panel5Ganar = (LinearLayout)findViewById(R.id.panel5Ganar);
                panel5Ganar.setVisibility(View.INVISIBLE);
                ganar5Texto = (TextView)findViewById(R.id.ganar5Texto);

                leerPreferencias(facil,"facil");


                minimoONulo(facil);
                Log.e("posicon",posi+"");


            }
            else if (dificultad == 2){
                setContentView(R.layout.tablero6);
                button6[0] = (TextView)findViewById(R.id.botton1);
                button6[1] = (TextView)findViewById(R.id.botton2);
                button6[2] = (TextView)findViewById(R.id.botton3);
                button6[3] = (TextView)findViewById(R.id.botton4);
                button6[4] = (TextView)findViewById(R.id.botton5);
                button6[5] = (TextView)findViewById(R.id.bottona1);

                button6[6] = (TextView)findViewById(R.id.botton6);
                button6[7] = (TextView)findViewById(R.id.botton7);
                button6[8] = (TextView)findViewById(R.id.botton8);
                button6[9] = (TextView)findViewById(R.id.botton9);
                button6[10] = (TextView)findViewById(R.id.botton10);
                button6[11] = (TextView)findViewById(R.id.bottona2);


                button6[12] = (TextView)findViewById(R.id.botton11);
                button6[13] = (TextView)findViewById(R.id.botton12);
                button6[14] = (TextView)findViewById(R.id.botton13);
                button6[15] = (TextView)findViewById(R.id.botton14);
                button6[16] = (TextView)findViewById(R.id.botton15);
                button6[17] = (TextView)findViewById(R.id.bottona3);

                button6[18] = (TextView)findViewById(R.id.botton16);
                button6[19] = (TextView)findViewById(R.id.botton17);
                button6[20] = (TextView)findViewById(R.id.botton18);
                button6[21] = (TextView)findViewById(R.id.botton19);
                button6[22] = (TextView)findViewById(R.id.botton20);
                button6[23] = (TextView)findViewById(R.id.bottona4);

                button6[24] = (TextView)findViewById(R.id.botton21);
                button6[25] = (TextView)findViewById(R.id.botton22);
                button6[26] = (TextView)findViewById(R.id.botton23);
                button6[27] = (TextView)findViewById(R.id.botton24);
                button6[28] = (TextView)findViewById(R.id.botton25);
                button6[29] = (TextView)findViewById(R.id.bottona5);

                button6[30] = (TextView)findViewById(R.id.bottona21);
                button6[31] = (TextView)findViewById(R.id.bottona22);
                button6[32] = (TextView)findViewById(R.id.bottona23);
                button6[33] = (TextView)findViewById(R.id.bottona24);
                button6[34] = (TextView)findViewById(R.id.bottona25);
                button6[35] = (TextView)findViewById(R.id.bottonb5);

                cantidad= 36;
                for(int i = 0;i<cantidad;i++){
                    buttonBackground6[i] = (ColorDrawable)button6[i].getBackground();
                    holders6[i] = (ColorDrawable)button6[i].getBackground();
                }

                panel5Ganar = (LinearLayout)findViewById(R.id.panel5Ganar);
                panel5Ganar.setVisibility(View.INVISIBLE);
                ganar5Texto = (TextView)findViewById(R.id.ganar5Texto);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mezclar(holders6,button6);
                        stateFlow = "playing";
                    }
                }, 5000);
                leerPreferencias(medio,"medio");
                minimoONulo(medio);

            }
            else if(dificultad == 3){
                setContentView(R.layout.tablero7);
                button7[0] = (TextView)findViewById(R.id.botton1);
                button7[1] = (TextView)findViewById(R.id.botton2);
                button7[2] = (TextView)findViewById(R.id.botton3);
                button7[3] = (TextView)findViewById(R.id.botton4);
                button7[4] = (TextView)findViewById(R.id.botton5);
                button7[5] = (TextView)findViewById(R.id.bottona1);
                button7[6] = (TextView)findViewById(R.id.bottonb1);

                button7[7] = (TextView)findViewById(R.id.botton6);
                button7[8] = (TextView)findViewById(R.id.botton7);
                button7[9] = (TextView)findViewById(R.id.botton8);
                button7[10] = (TextView)findViewById(R.id.botton9);
                button7[11] = (TextView)findViewById(R.id.botton10);
                button7[12] = (TextView)findViewById(R.id.bottona2);
                button7[13] = (TextView)findViewById(R.id.bottonb2);

                button7[14] = (TextView)findViewById(R.id.botton11);
                button7[15] = (TextView)findViewById(R.id.botton12);
                button7[16] = (TextView)findViewById(R.id.botton13);
                button7[17] = (TextView)findViewById(R.id.botton14);
                button7[18] = (TextView)findViewById(R.id.botton15);
                button7[19] = (TextView)findViewById(R.id.bottona3);
                button7[20] = (TextView)findViewById(R.id.bottonb3);

                button7[21] = (TextView)findViewById(R.id.botton16);
                button7[22] = (TextView)findViewById(R.id.botton17);
                button7[23] = (TextView)findViewById(R.id.botton18);
                button7[24] = (TextView)findViewById(R.id.botton19);
                button7[25] = (TextView)findViewById(R.id.botton20);
                button7[26] = (TextView)findViewById(R.id.bottona4);
                button7[27] = (TextView)findViewById(R.id.bottonb4);

                button7[28] = (TextView)findViewById(R.id.botton21);
                button7[29] = (TextView)findViewById(R.id.botton22);
                button7[30] = (TextView)findViewById(R.id.botton23);
                button7[31] = (TextView)findViewById(R.id.botton24);
                button7[32] = (TextView)findViewById(R.id.botton25);
                button7[33] = (TextView)findViewById(R.id.bottona5);
                button7[34] = (TextView)findViewById(R.id.bottonb5);

                button7[35] = (TextView)findViewById(R.id.bottona21);
                button7[36] = (TextView)findViewById(R.id.bottona22);
                button7[37] = (TextView)findViewById(R.id.bottona23);
                button7[38] = (TextView)findViewById(R.id.bottona24);
                button7[39] = (TextView)findViewById(R.id.bottona25);
                button7[40] = (TextView)findViewById(R.id.bottona6);
                button7[41] = (TextView)findViewById(R.id.bottonb6);

                button7[42] = (TextView)findViewById(R.id.bottonc21);
                button7[43] = (TextView)findViewById(R.id.bottonc22);
                button7[44] = (TextView)findViewById(R.id.bottonc23);
                button7[45] = (TextView)findViewById(R.id.bottonc24);
                button7[46] = (TextView)findViewById(R.id.bottonc25);
                button7[47] = (TextView)findViewById(R.id.bottonc6);
                button7[48] = (TextView)findViewById(R.id.bottonc7);


                cantidad = 49;

                for(int i = 0;i<cantidad;i++){
                    buttonBackground7[i] = (ColorDrawable)button7[i].getBackground();
                    holders7[i] = (ColorDrawable)button7[i].getBackground();
                }


                panel5Ganar = (LinearLayout)findViewById(R.id.panel5Ganar);
                panel5Ganar.setVisibility(View.INVISIBLE);
                ganar5Texto = (TextView)findViewById(R.id.ganar5Texto);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mezclar(holders7,button7);
                        stateFlow = "playing";
                    }
                }, 5000);
                leerPreferencias(dificil,"dificil");
                minimoONulo(dificil);
            }
        }
        puntuacion = (TextView)findViewById(R.id.cantidadMov);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menuppal,menu);
        return true;
    }
    public void clik(View v){
        if (stateFlow.equals("playing")) {
            botonAnterior = cualBoton;
            for (int i = 0; i < 25; i++) {
                if (v.getId() == button[i].getId()) {
                    cualBoton = i;
                    button[cualBoton].setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                }
            }
            if (selected) {
                button[botonAnterior].setBackground(button[cualBoton].getBackground());
                button[cualBoton].setBackground(holder);
                selected = false;
                button[botonAnterior].setText("");
                Boolean sameColors=true;
                movimientos++;
                String cantmovimientos = Integer.toString(movimientos);
                puntuacion.setText(cantmovimientos);
                for (int i =0;i<25;i++){
                    work = (ColorDrawable) button[i].getBackground();
                    if(!work.equals( buttonBackground[i])){
                        sameColors=false;
                    }
                }
                if(sameColors){
                    stateFlow = "pause";
                   // String leyenda = "Juego finalizado, cantidad de movimientos: " + getString(movimientos);
                    //Toast toast1 =
                                  //Toast.makeText(getApplicationContext(), "la cantidad de moviemtientos es de " + String.valueOf(movimientos) , Toast.LENGTH_SHORT);

                    //toast1.show();
                    if(movimientos < facil[posi] || facil[posi] == -10){
                        ganarPormas("facil");
                    }else{
                        ganar();

                    }

            }

            }
            else {
                selected = true;
                holder = (ColorDrawable)button[cualBoton].getBackground();
                button[cualBoton].setText("Selected");
            }
        }
    }

    public void clik2(View v){
        if (stateFlow.equals("playing")) {
            botonAnterior = cualBoton;
            for (int i = 0; i < 36; i++) {
                if (v.getId() == button6[i].getId()) {
                    cualBoton = i;
                    button6[cualBoton].setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                }
            }
            if (selected) {
                button6[botonAnterior].setBackground(button6[cualBoton].getBackground());
                button6[cualBoton].setBackground(holder);
                selected = false;
                button6[botonAnterior].setText("");
                Boolean sameColors=true;
                movimientos++;
                String cantmovimientos = Integer.toString(movimientos);
                puntuacion.setText(cantmovimientos);
                for (int i =0;i<36;i++){
                    work = (ColorDrawable) button6[i].getBackground();
                    if(!work.equals( buttonBackground6[i])){
                        sameColors=false;
                    }
                }
                if(sameColors){
                    stateFlow = "pause";
                    // String leyenda = "Juego finalizado, cantidad de movimientos: " + getString(movimientos);
                    //Toast toast1 =
                            //Toast.makeText(getApplicationContext(), "la cantidad de moviemtientos es de " + String.valueOf(movimientos) , Toast.LENGTH_SHORT);

                    //toast1.show();
                    if(movimientos < medio[posi] || medio[posi] == -10){
                        ganarPormas("medio");
                    }else {
                        ganar();
                    }
                }

            }
            else {
                selected = true;
                holder = (ColorDrawable)button6[cualBoton].getBackground();
                button6[cualBoton].setText("Selected");

            }
        }
    }

    public void clik3(View v){
        if (stateFlow.equals("playing")) {
            botonAnterior = cualBoton;
            for (int i = 0; i < 49; i++) {
                if (v.getId() == button7[i].getId()) {
                    cualBoton = i;
                    button7[cualBoton].setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                }
            }
            if (selected) {
                button7[botonAnterior].setBackground(button7[cualBoton].getBackground());
                button7[cualBoton].setBackground(holder);
                selected = false;
                button7[botonAnterior].setText("");
                Boolean sameColors=true;
                movimientos++;
                String cantmovimientos = Integer.toString(movimientos);
                puntuacion.setText(cantmovimientos);
                for (int i =0;i<49;i++){
                    work = (ColorDrawable) button7[i].getBackground();
                    if(!work.equals( buttonBackground7[i])){
                        sameColors=false;
                    }
                }
                if(sameColors){
                    stateFlow = "pause";
                    // String leyenda = "Juego finalizado, cantidad de movimientos: " + getString(movimientos);
                    //Toast toast1 =
                            //Toast.makeText(getApplicationContext(), "la cantidad de moviemtientos es de " + String.valueOf(movimientos) , Toast.LENGTH_SHORT);

                    //toast1.show();
                    if(movimientos < dificil[posi] || dificil[posi] == -10){
                        ganarPormas("dificil");
                    }else {
                        ganar();
                    }
                }

            }
            else {
                selected = true;
                holder = (ColorDrawable)button7[cualBoton].getBackground();
                button7[cualBoton].setText("Selected");
            }
        }
    }

    public void mezclar(ColorDrawable[] arreglo, TextView[] arreglo2){
        List<ColorDrawable> coloresMesclados = Arrays.asList(arreglo);
        Collections.shuffle(coloresMesclados);
        for (int i = 0; i < cantidad; i++) {
            arreglo2[i].setBackground(coloresMesclados.get(i));
        }
    }


    public void mostrarPista(View v){
        Intent i = new Intent(this,Ayuda.class);
        i.putExtra("dato1",dificultad);
        startActivity(i);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.salir){
            salirTablero();
        }
        if (item.getItemId() == R.id.ayuda){
            Intent i = new Intent(this,Ayuda.class);
            i.putExtra("dato1",dificultad);
            startActivity(i);
        }
        return true;
    }

    public  void ganar(){
            String str = getString(R.string.ganaste);
            str = str +" " +String.valueOf(movimientos);
            ganar5Texto.setText(str);
            panel5Ganar.setVisibility(View.VISIBLE);
            //String.valueOf(movimientos)
    }

    public void reiniciar5(View v){

        this.finish();
        Intent i = new Intent(this,Tablero.class);
        i.putExtra("dato1",1);
        startActivity(i);
    }

    public void reiniciar6(View v){
        this.finish();
        Intent i = new Intent(this,Tablero.class);
        i.putExtra("dato1",2);
        startActivity(i);
    }
    public void reiniciar7(View v){
        this.finish();
        Intent i = new Intent(this,Tablero.class);
        i.putExtra("dato1",3);
        startActivity(i);
    }

    public void volver(View v){
       this.finish();
    }
    public void salirTablero(){
       ConfirmDialogFragment d = new ConfirmDialogFragment();
       d.show(getSupportFragmentManager(),"tagConfimation");

    }

    private void ganarPormas(String def){
        WinDialogframent f = new WinDialogframent();
        f.show(getSupportFragmentManager(),"tagGanar");
        f.setCancelable(false);
        Instancia e = new Instancia(def+posi,movimientos,dificultad);
        f.mandar(e);
        //String s;
        //nombre2.findViewById(R.id.nombreusuario);
        //s = nombre2.getText().toString();
        //guardar(s,posi,dificultad);
    }



    private void leerPreferencias(Integer[] array,String dif){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        for(int i =0;i<array.length;i++){
            String s = dif + i;
            array[i] = preferences.getInt(s,-10);
            Log.e("posi" + i,array[i]+"");
        }
    }




    private void minimoONulo(Integer[] facil){
        boolean noHay = false;
        posi =0;
        int max = -20;
        while(posi<5 && !noHay) {
            if(facil[posi] == -10){
                noHay = true;
            }
            if(!noHay){
                posi = posi +1;
            }
        }
        if(!noHay) {
            for (int i = 0; i < facil.length; i++) {
                if (facil[i] > max) {
                    max= facil[i];
                    posi = i;
                }
            }
        }


    }
    private void guardar(String s,int posi, String dif){
       SharedPreferences preferences = getPreferences(MODE_PRIVATE);
       SharedPreferences.Editor editor = preferences.edit();

       String str = dif + posi;
       editor.putString("nombre"+posi,s);
       editor.putInt(str,movimientos);

    }
    public static Context getContextOfApplication(){
        return contextOfApplication;
    }



    public void onBackPressed()
    {
        ConfirmDialogFragment d = new ConfirmDialogFragment();
        d.show(getSupportFragmentManager(),"tagConfimation");
    }
  
}

package com.example.entrega2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;



public class WinDialogframent extends DialogFragment {
    private EditText editTextUsername;
    int p;
    public String nombre = "valor ";
    public Instancia e;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);

        b.setCancelable(false);
        b.setMessage(R.string.ganador);
        b.setTitle(R.string.ganas);
        b.setView(view);
        b.setPositiveButton(R.string.jugarotravez, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Tablero)getContext()).finish();
                int diicultad =e.getDificultad();
                Intent rein = new Intent(getContext(),Tablero.class);

                if( diicultad == 1){
                    rein.putExtra("dato1",1);
                    Log.e("dsada","entre");
                }else if(diicultad== 2){
                    rein.putExtra("dato1",2);
                }else if(diicultad== 3){
                    rein.putExtra("dato1",3);
                }
                startActivity(rein);
            }
        });
        b.setNeutralButton(R.string.elegir, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Tablero)getContext()).finish();
            }
        });
        b.setNegativeButton("Ranking", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Tablero)getContext()).finish();
                 nombre = editTextUsername.getText().toString();
                Intent rank = new Intent(getContext(),ranking.class);
                rank.putExtra("posicion",e.getPosicion());
                rank.putExtra("puntuacion",e.getPuntuacion());
                rank.putExtra("nombre",nombre);
                startActivity(rank);
            }
        });

        editTextUsername = view.findViewById(R.id.nombreusuario);
        return b.create();
    }
   public void mandar(Instancia esta){
        e = esta;
   }
}

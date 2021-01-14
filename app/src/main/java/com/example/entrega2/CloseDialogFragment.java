package com.example.entrega2;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;


public class CloseDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setMessage(R.string.cerrarApp);
        b.setTitle(R.string.cerrarAppTitulo);
        b.setCancelable(true);
        b.setPositiveButton(R.string.salir, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                ((MainActivity)getContext()).finish();
            }
        });
        b.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return b.create();
    }
}

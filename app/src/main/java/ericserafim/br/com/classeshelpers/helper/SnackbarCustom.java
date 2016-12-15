package ericserafim.br.com.classeshelpers.helper;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import ericserafim.br.com.classeshelpers.R;

public final class SnackbarCustom {

    //Add in build.gradle app compile 'com.android.support:design:25.0.0'
    public static void show(View view, String texto) {
        if (view == null) return;

        Snackbar snackbar = Snackbar.make(view, texto, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorBlackAlfa));
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(view.getContext(), android.R.color.white));
        textView.setTextSize(16f);
        snackbar.show();
    }

}

package ericserafim.br.com.classeshelpers.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import ericserafim.br.com.classeshelpers.R;

public final class DialogCustom {

    private static Context context;
    private static AlertDialog.Builder dialog;
    private static DialogCustomInterface.OnClickListenerPositive callbackPositive;
    private static DialogCustomInterface.OnClickListenerNegative callbackNegative;
    private static String textPositiveButton;
    private static String textNegativeButton;

    private static AlertDialog builder(Context c) {
        context = c;
        dialog = new AlertDialog.Builder(c, R.style.MyAlertDialogStyle);
        return dialog.create();
    }

    private static void show() {
        dialog.create();
        dialog.show();
    }

    private static void settings(View view, String titulo, String mensagem, boolean modal) {
        dialog.setTitle(titulo);
        dialog.setMessage(mensagem);
        dialog.setCancelable(!modal);

        if (view != null) {
            dialog.setView(view);
        }

        dialog.setPositiveButton(textPositiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callbackPositive != null) callbackPositive.onClick();
            }
        });

        dialog.setNegativeButton(textNegativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callbackNegative != null) callbackNegative.onClick();
            }
        });
    }

    public static void information(Context c, String title, String message, String textButton,
                                   boolean modal, final DialogCustomInterface.OnClickListenerPositive callback_Positive) {
        textPositiveButton = textButton;
        callbackPositive = callback_Positive;

        builder(c);
        settings(null, title, message, modal);
        show();
    }

    public static void confirmation(Context c, String title, String message,
                                    String text_PositiveButton,
                                    String text_NegativeButton,
                                    boolean modal,
                                    final DialogCustomInterface.OnClickListenerPositive callback_Positive,
                                    final DialogCustomInterface.OnClickListenerNegative callback_Negative) {
        textPositiveButton = text_PositiveButton;
        textNegativeButton = text_NegativeButton;
        callbackPositive = callback_Positive;
        callbackNegative = callback_Negative;

        builder(c);
        settings(null, title, message, modal);
        show();
    }

    public static void confirmation(Context c, View view,
                                    String title, String message,
                                    String text_PositiveButton,
                                    String text_NegativeButton,
                                    boolean modal,
                                    final DialogCustomInterface.OnClickListenerPositive callback_Positive,
                                    final DialogCustomInterface.OnClickListenerNegative callback_Negative) {

        textPositiveButton = text_PositiveButton;
        textNegativeButton = text_NegativeButton;
        callbackPositive = callback_Positive;
        callbackNegative = callback_Negative;

        builder(c);
        settings(view, title, message, modal);
        show();
    }

}


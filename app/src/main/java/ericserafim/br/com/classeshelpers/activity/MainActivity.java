package ericserafim.br.com.classeshelpers.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ericserafim.br.com.classeshelpers.R;
import ericserafim.br.com.classeshelpers.helper.Browser;
import ericserafim.br.com.classeshelpers.helper.DialogCustom;
import ericserafim.br.com.classeshelpers.helper.DialogCustomInterface;
import ericserafim.br.com.classeshelpers.helper.MailTo;
import ericserafim.br.com.classeshelpers.helper.Maps;
import ericserafim.br.com.classeshelpers.helper.Phone;
import ericserafim.br.com.classeshelpers.helper.SnackbarCustom;
import ericserafim.br.com.classeshelpers.helper.Video;

public class MainActivity extends AppCompatActivity {

    private Button btnBrowser;
    private Button btnMaps;
    private Button btnVideo;
    private Button btnMail;
    private Button btnDialog;
    private Button btnSnackBar;
    private Button btnImei;
    private Button btnDial;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = (Button) findViewById(R.id.btnBrowser);
        btnMaps = (Button) findViewById(R.id.btnMaps);
        btnVideo = (Button) findViewById(R.id.btnVideo);
        btnMail = (Button) findViewById(R.id.btnMail);
        btnDialog = (Button) findViewById(R.id.btnDialog);
        btnSnackBar = (Button) findViewById(R.id.btnSnackBar);
        btnImei = (Button) findViewById(R.id.btnIMEI);
        btnDial = (Button) findViewById(R.id.btnDial);
        fab = (FloatingActionButton) findViewById(R.id.fab);


        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Browser.navigateURL(MainActivity.this, "www.linkedin.com/in/ericserafim");
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open address
                Maps.open(MainActivity.this, "English Bay Beach");

                //Open lat and long, with zoom anda caption
                //Maps.open(MainActivity.this, 49.2851114f,-123.1426406f, 100, "English Bay Beach");
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Video.open(MainActivity.this, "https://youtu.be/v-08_7IbGdQ");
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MailTo.send(MainActivity.this,
                        "ericserafim@gmail.com",
                        "Email via app example",
                        "Body message");
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCustom.information(MainActivity.this,
                        "Information",
                        "Message",
                        "Ok",
                        true,//modal
                        null
                );

                DialogCustom.confirmation(MainActivity.this,
                        "Confirmation",
                        "Message",
                        "Yes",
                        "No",
                        true,//modal
                        new DialogCustomInterface.OnClickListenerPositive() {
                            @Override
                            public void onClick() {
                                //say "yes"
                            }
                        },
                        new DialogCustomInterface.OnClickListenerNegative() {
                            @Override
                            public void onClick() {
                                //say "no"
                            }
                        }
                );

                EditText editText = new EditText(MainActivity.this);
                editText.setHint("something...");

                DialogCustom.confirmation(MainActivity.this,
                        editText,
                        "Confirmation with view",
                        "Message",
                        "Yes",
                        "No",
                        true,//modal
                        new DialogCustomInterface.OnClickListenerPositive() {
                            @Override
                            public void onClick() {
                                //say "yes"
                            }
                        },
                        new DialogCustomInterface.OnClickListenerNegative() {
                            @Override
                            public void onClick() {
                                //say "no"
                            }
                        }
                );
            }
        });

        btnSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnackbarCustom.show(fab, "Message for you!!!");
            }
        });

        btnImei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnackbarCustom.show(fab, Phone.getIMEI(MainActivity.this));
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phone.dial(MainActivity.this, "123456789");
            }
        });

    }

}

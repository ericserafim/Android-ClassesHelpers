package ericserafim.br.com.classeshelpers.helper;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public final class Phone {

    public static void dial(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Default app dial not found!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public static String getIMEI(Activity activity) {
        //Build.VERSION.SDK_INT < Marshmallow you have add in AndroidManifest <uses-permission android:name="android.permission.READ_PHONE_STATE"/>

        //Marshmallow +
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Request permission
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
                return "";
            }
        }

        String dispositivoId = "";
        TelephonyManager mTelephony = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);

        if (mTelephony.getDeviceId() != null) {
            dispositivoId = mTelephony.getDeviceId();
        } else {
            dispositivoId = Settings.Secure.getString(
                    activity.getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID
            );
        }
        return dispositivoId;
    }
}

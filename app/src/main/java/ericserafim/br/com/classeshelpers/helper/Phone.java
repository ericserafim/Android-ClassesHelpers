package ericserafim.br.com.classeshelpers.helper;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
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
        //Add in AndroidManifest <uses-permission android:name="android.permission.READ_PHONE_STATE"/>

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

package ericserafim.br.com.classeshelpers.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public final class MailTo {

    public static void send(Context context, String to, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?to=" + to + "&subject=" + subject + "&body=" + body);
        intent.setData(data);

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Default app map not found!!!", Toast.LENGTH_SHORT).show();
        }
    }

}

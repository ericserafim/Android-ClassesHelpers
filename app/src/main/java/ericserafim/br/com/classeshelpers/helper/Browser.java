package ericserafim.br.com.classeshelpers.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public final class Browser {

    public static void navigateURL(Context context, String url) {
        if (!url.toLowerCase().startsWith("http") || !url.toLowerCase().startsWith("https")) {
            url = "http://" + url;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse(url);
        intent.setData(data);

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Default app browser not found!!!", Toast.LENGTH_SHORT).show();
        }
    }
}

package ericserafim.br.com.classeshelpers.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.util.Locale;

public final class Maps {

    public static void open(Context context, String address) {
        address = address.replaceAll(" ", "%20");
        Uri intentUri = Uri.parse("geo:?q=" + address);
        openDefaultAppMaps(context, intentUri);
    }

    public static void open(Context context, float lat, float lng, int zoom, String label) {
        String uri = String.format(Locale.ENGLISH,
                "geo:%f,%f?z=%d&q=%f,%f (%s)",
                lat, lng, zoom, lat, lng, label);
        Uri intentUri = Uri.parse(uri);
        openDefaultAppMaps(context, intentUri);
    }

    private static void openDefaultAppMaps(Context context, Uri uri) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);

        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
        } else {
            Toast.makeText(context, "Default app map not found!!!", Toast.LENGTH_SHORT).show();
        }
    }
}


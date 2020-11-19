package nidhal.tp3.tris.infosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }


    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent i = new Intent();//Intent.ACTION_VIEW, webpage);
        i.setAction(Intent.ACTION_VIEW);
        i.setData((webpage));

        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }


    public void openLocation(View view) {

        String loc = mLocationEditText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }


    public void shareText(View view) {
        Intent i = new Intent();

        String msg = this.mShareTextEditText.getText().toString();

        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT, msg);
        i.setType("text/plain");
        startActivity(i);
    }
}
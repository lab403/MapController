package fud.geodoermap;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TestGoogleApi extends ActionBarActivity implements View.OnClickListener {

    TextView a;
    Button b;
    EditText c;
    Button b2;
    EditText c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_google_api);
        a = (TextView)findViewById(R.id.textView);
        b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(this);
        c =(EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button3);
        b2.setOnClickListener(this);
        c2 =(EditText)findViewById(R.id.editText3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test_google_api, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button2:
                GeocodingAPI a = new GeocodingAPI(getApplicationContext(),c.getText().toString());
                a.getGeocodingApiAddress(this.a);
                break;
            case R.id.button3:
                GeocodingAPI b = new GeocodingAPI(getApplicationContext(),c2.getText().toString());
                b.getGeocodingApiLatLng();
                break;
        }
    }
}

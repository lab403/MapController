package fud.geodoermap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GeodoerMapActivity extends ActionBarActivity implements View.OnClickListener,MapController.onGeoLoadedLisitener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Toolbar toolBar;

    TextView show;
    EditText searchText;
    Button button;
    MapController mapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geodoer_map);

        show = (TextView)findViewById(R.id.textView2);
        searchText =(EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        setUpMapIfNeeded();
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        if (toolBar != null) {
            setSupportActionBar(toolBar);
        }

        toolBar.setNavigationContentDescription(R.drawable.ic_launcher);
        toolBar.setTitle("ToolBar Title");//设置标题
        toolBar.setSubtitle("This is subtitle");//设置子标题
        toolBar.setTitleTextColor(Color.parseColor("#ff0000"));//设置标题颜色
        toolBar.setLogo(R.drawable.ic_launcher);//设置logo图片
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        LatLng nowLocation=new LatLng(23.6978, 120.961);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().title("當前位置").draggable(true).position(nowLocation));

        mapController = new MapController(getApplicationContext(),mMap,show);
        mapController.isMoveGet(true);
        mapController.setOnGeoLoadedLisitener(this);

    }

    @Override
    public void onClick(View v) {
        mapController.searchPlace(searchText);
    }

    @Override
    public void onGeoLoaded(GeoInfo geo) {
        Toast.makeText(getApplicationContext(),geo.name,Toast.LENGTH_SHORT).show();
        //儲存寫在這裡
    }
}

package fud.geodoermap;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by dan on 2015/1/30.
 */
public class GeoInfo {
    public String name = "null";
    public LatLng latlng = new LatLng(-1,-1);

    GeoInfo(){}

    GeoInfo(LatLng latlng){
        this.latlng=latlng;
    }

    GeoInfo(String name){
        this.name=name;
    }

    public void setName(String str){
        this.name=str;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

}

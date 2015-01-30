package fud.geodoermap;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


public class GeocodingAPIJsonDecode {
	Context context;
    JsonObject j;
    GeocodingAPIJsonDecode(Context context,JsonObject Json){
		this.context=context;
        j= Json;
    }
	
	public String getAddress(){
		String Address="";
		try {
			if(j.get("status").getAsString().equals("OK"))
			{
                JsonArray PlaceArray = j.getAsJsonArray("results");
                JsonObject address =  PlaceArray.get(0).getAsJsonObject();
                Address = address.get("formatted_address").getAsString();
			}else{
                Address="null";
                Log.e("Error", "沒有拿到json");
            }
		} catch (JsonParseException e) {
			e.printStackTrace();
		}
		return Address;
	}
	
	
	public LatLng getLatLng(){
		LatLng LatLng = null ;
		try {
			if(j.get("status").getAsString().equals("OK"))
			{
                JsonArray PlaceArray = j.getAsJsonArray("results");
                JsonObject JsonObjectLanLng =  PlaceArray.get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
                LatLng = new LatLng(JsonObjectLanLng.get("lat").getAsDouble(),JsonObjectLanLng.get("lng").getAsDouble());
			}
			else
			{
                LatLng = new LatLng(-1,-1);
                Log.e("Error", "沒有拿到json");
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		}
		return LatLng;
	}
	
	
}

# MapController

能在Android GoogleMap元件上獲取地址、經緯度

# Usage

### 宣告MapController

給予GooglMap、TextView元件，TextView元件用於顯示地址非必要
```java
MapController mapController = new MapController(getApplicationContext(),mMap,show);

//可關閉拖移GoogleMap就獲取地址、經緯度，能改善數據流量
mapController.isMoveGet(true);

//可設定是否僅使用Wifi抓取位置
mapController.isWifiOnly(true);
```


### 使用Lisitener

```java
implements MapController.onGeoLoadedLisitener
mapController.setOnGeoLoadedLisitener(this);

//當獲取地址或經緯度時geo能直接拿取資料
@Override
public void onGeoLoaded(GeoInfo geo) {
    Toast.makeText(getApplicationContext(), geo.name, Toast.LENGTH_SHORT).show();
}

//開始載入資料的時候觸發
public void onGeoLoading() {
    Log.d("Loading","開始載入");
}
```
### Features

**v1.15.6**
* 新增onGeoLoading Lisitener
* 新增網路判斷
* 新增設定WifiOnly抓取資料

**v1.15.5**
* 拖移Map獲取地址、經緯度
* 點擊Map獲取地址、經緯度
* 搜尋地址、經緯度能跳轉Map上的位置
package com.example.bike;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import android.os.Build;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class bike_seoul extends AppCompatActivity implements OnMapReadyCallback {

    public GoogleMap map;
    private Geocoder geocoder;

    static StringBuilder json6_2bd = new StringBuilder();
    static StringBuilder json6_3bd = new StringBuilder();
    static StringBuilder json6_5bd = new StringBuilder();
    static StringBuilder json6_6bd = new StringBuilder();
    static StringBuilder json6_21bd = new StringBuilder();
    static StringBuilder json6_31bd = new StringBuilder();
    static StringBuilder json6_51bd = new StringBuilder();
    static StringBuilder json6_61bd = new StringBuilder();

    static String json6_2 = new String();
    static String json6_3 = new String();
    static String json6_4 = new String();
    static String json6_5 = new String();

    static String[] json6_2sp = new String[200];
    static String[] json6_3sp = new String[200];
    static String[] json6_5sp = new String[200];
    static String[] json6_6sp = new String[200];
    static String[] json6_21sp = new String[200];
    static String[] json6_31sp = new String[200];
    static String[] json6_51sp = new String[200];
    static String[] json6_61sp = new String[200];


    static int count = 0;
    static Marker[] marker_arr = new Marker[200];

    static String json6_6 = new String();

    int count4 = 0;
    Marker[] m_arr = new Marker[200];
    static int i;
    public static LatLng search_point;
    public static LatLng marker_point;

    static View inflate_view;
    Button link2;
    Button photo_btn;
    Button call;
    Button url;
    ImageView imageView;
    static Bitmap bitmap;
    PhotoMetadata photoMetadata;
    static Place place_var;

    String place_phone;
    String place_url;


    List<Address> adress = null;
    String adress_result;
    String adress_result2;
    private String json6_11;
    private String json99;
    private JSONArray json11;
    static StringBuilder json6_33bd = new StringBuilder();
    static String[] json6_22sp = new String[200];
    static Bitmap bitmap_click;
    public static int count10;
   static Marker staticmarker;
    static String[] json6_33sp = new String[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike11);

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        link2 = findViewById(R.id.link2);
        link2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bike_seoul.this, streetview.class);
                bike_seoul.this.startActivity(i);

            }
        });
        photo_btn = findViewById(R.id.link3);
        photo_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bike_seoul.this, picture.class);
                bike_seoul.this.startActivity(i);

            }
        });

        call = findViewById(R.id.call);
        call.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + place_phone));
                bike_seoul.this.startActivity(i);

            }
        });

        url = findViewById(R.id.url);
        url.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(place_url));
                startActivity(intent);
            }
        });
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        map = googleMap;
        geocoder = new Geocoder(this,Locale.KOREA);
        Marker bike_m;
        try {
            geonggi2();
            gwangyang();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < json6_5sp.length; i++) { //서울

            double tmp1 = Double.parseDouble(json6_5sp[i]);
            double tmp2 = Double.parseDouble(json6_6sp[i]);


            LatLng SEOUL = new LatLng(tmp1, tmp2);


            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(SEOUL);
            BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.maker3);
            Bitmap b = bitmapdraw.getBitmap();
            Bitmap bitmarker = Bitmap.createScaledBitmap(b, 50, 50, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmarker));

           bike_m= map.addMarker(markerOptions);
            bike_m.setTitle(json6_2sp[i] + "\n" + json6_3sp[i]);
            bike_m.setTag("bike_m");
            if(MainActivity.city==1) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 12));
            }
        }

        for (int i = 0; i < json6_51sp.length; i++) {//광양
            double gwangyang1 = 0;
            double gwangyang2 = 0;
            try {
                 gwangyang1 = Double.parseDouble(json6_51sp[i]);
                 gwangyang2 = Double.parseDouble(json6_61sp[i]);
            }catch (NullPointerException e){
                Toast.makeText(this.getApplicationContext(),"서버 통신오류 다시시도해주세요", Toast.LENGTH_SHORT).show();
            }
            LatLng point = new LatLng(gwangyang1, gwangyang2);

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(point);
            BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.maker3);
            Bitmap b = bitmapdraw.getBitmap();
            Bitmap bitmarker = Bitmap.createScaledBitmap(b, 50, 50, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmarker));

            bike_m= map.addMarker(markerOptions);
            bike_m.setTitle(json6_31sp[i]);
            bike_m.setTag("bike_m");
            if(MainActivity.city==6) {
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10));
            }
        }


        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Nullable
            @org.jetbrains.annotations.Nullable
            @Override
            public View getInfoWindow(@NonNull @NotNull Marker marker) {
                staticmarker=marker;

                inflate_view = getLayoutInflater().inflate(R.layout.activity_adapter3, null);
                imageView = (ImageView) inflate_view.findViewById(R.id.imageView);
                TextView textView2 = (TextView) inflate_view.findViewById(R.id.textView2);

                ImageView nemo_b = (ImageView) inflate_view.findViewById(R.id.nemo_big3);



                if (marker.getTag() == "a") {
                    imageView.setImageBitmap(bitmap);
                    if(photoMetadata!=null) {
                        photo_btn.setVisibility(View.VISIBLE);
                    }
                    if(place_phone!=null) {
                        call.setVisibility(View.VISIBLE);
                    }else{call.setVisibility(View.INVISIBLE);  }
                    if(place_url!=null) {
                        url.setVisibility(View.VISIBLE);
                    }else{url.setVisibility(View.INVISIBLE);  }



                    photo_btn.setText("사진");
                    textView2.getLayoutParams().width=750;
                    textView2.getLayoutParams().height=300;
                    textView2.setTranslationY(40);
                }
                
                if (marker.getTag() == "click_m") {
                    imageView.setImageBitmap(bitmap_click);
                    System.out.println("bitmap_click"+bitmap_click+"bitmap_click"+bitmap_click);
                    photo_btn.setText("주변 사진");



                    if (bitmap_click != null && adress_result2 != null) {
                        photo_btn.setVisibility(View.VISIBLE);
                    }else{photo_btn.setVisibility(View.INVISIBLE);}

                    url.setVisibility(View.INVISIBLE);
                    call.setVisibility(View.INVISIBLE);





                    textView2.getLayoutParams().width=650;
                    textView2.getLayoutParams().height=300;

                }


                    textView2.setText(marker.getTitle().replaceAll("null", ""));


                link2.setVisibility(View.VISIBLE);

                System.out.println("클릭된 모든마커의 위치" + marker.getPosition());
                marker_point = marker.getPosition();

                BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.maker5);
                Bitmap b = bitmapdraw.getBitmap();
                Bitmap bitmarker = Bitmap.createScaledBitmap(b, 50, 50, false);




                if (marker.getTag()=="bike_m") {
                    marker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmarker));
                    photo_btn.setVisibility(View.INVISIBLE);
                    call.setVisibility(View.INVISIBLE);
                    url.setVisibility(View.INVISIBLE);

                    nemo_b.getLayoutParams().height=460;
                    nemo_b.getLayoutParams().width=480;
                    nemo_b.setTranslationX(85);
                    nemo_b.setTranslationY(330);

                    textView2.setTranslationY(-80);

                }

                marker_arr[count] = marker;


                if (count > 0) {
                    BitmapDrawable bitmapdraw2 = (BitmapDrawable) getResources().getDrawable(R.drawable.maker3);
                    Bitmap b2 = bitmapdraw2.getBitmap();
                    Bitmap bitmarker2 = Bitmap.createScaledBitmap(b2, 50, 50, false);
                    marker_arr[count - 1].setIcon(BitmapDescriptorFactory.fromBitmap(bitmarker2));

                }

                if  (marker.getTag()=="bike_m"){
                    count++;
                }

                return inflate_view;
            }

            @Nullable
            @org.jetbrains.annotations.Nullable
            @Override
            public View getInfoContents(@NonNull @NotNull Marker marker) {
                return null;
            }
        });



        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull @NotNull LatLng latLng) {
                link2.setVisibility(View.INVISIBLE);
                photo_btn.setVisibility(View.INVISIBLE);
                call.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);

                try {
                    adress = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    adress_result = adress.get(0).getAddressLine(0).toString();
                    adress_result2 = adress.get(0).getSubLocality().toString();


                } catch (NullPointerException | IOException | IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("데이터없을때");

                    bitmap_click = BitmapFactory.decodeResource(getResources(), R.drawable.img2);

                    json11 = null;
                   json6_22sp[0] = null;
                    adress_result2 = null;
                }



                MarkerOptions markerOptions2 = new MarkerOptions();
                markerOptions2.position(latLng);
                m_arr[count4] = map.addMarker(markerOptions2);

                if(adress_result != null) { //grpc failed 오류시
                    m_arr[count4].setTitle("주소: " + adress_result);
                }else{
                    m_arr[count4].setTitle("사진없음");
                }
                
                m_arr[count4].setTag("click_m");
                if (count4 > 0) {
                    m_arr[count4 - 1].remove();
                }
                count4++;


                try {
                    geonggi11();
                    geonggi22();
                    geonggi3();
                    geonggi4();
                    geonggi5();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }



            }
        });


        Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio", Locale.KOREA);
        PlacesClient placesClient = Places.createClient(this);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio");
        }

        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);


        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.ADDRESS, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.PHOTO_METADATAS,
                Place.Field.WEBSITE_URI, Place.Field.PHONE_NUMBER));
        autocompleteFragment.setHint("검색하세요");


        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                place_var = place;
                System.out.println("setPlaceFields리턴=  " + place);


                search_point = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(search_point, 15));
                MarkerOptions markerOptions2 = new MarkerOptions();
                markerOptions2.position(search_point);
                m_arr[count4] = map.addMarker(markerOptions2);


                String url_str = null;
                String phone_str = null;
                String adress_str = null;

                if(place.getPhoneNumber()!=null){
                    phone_str="번호: "+place.getPhoneNumber();
                    place_phone=place.getPhoneNumber();     }
                else{place_phone=null; }

                    if(place.getWebsiteUri()!=null){
                        url_str="홈페이지: "+String.valueOf(place.getWebsiteUri());
                        place_url=String.valueOf(place.getWebsiteUri());        }
                    else{place_url=null; }

                m_arr[count4].setTitle(place.getName() + "\n"+ "주소: "+place.getAddress()+ "\n"+phone_str+ "\n"+url_str);


                m_arr[count4].setTag("a");
                if (count4 > 0) {
                    m_arr[count4 - 1].remove();
                }
                count4++;


                try {
                    photoMetadata = place.getPhotoMetadatas().get(0);
                    final String attributions = photoMetadata.getAttributions();
                    System.out.println("attributions=" + attributions);

                    final FetchPhotoRequest photoRequest = FetchPhotoRequest.builder(photoMetadata)
                            .setMaxWidth(500)
                            .setMaxHeight(300)
                            .build();
                    placesClient.fetchPhoto(photoRequest).addOnSuccessListener((fetchPhotoResponse) -> {
                        bitmap = fetchPhotoResponse.getBitmap();

                        System.out.println("bitmap.toString()" + bitmap.toString());

                    }).addOnFailureListener((exception) -> {
                        if (exception instanceof ApiException) {
                            final ApiException apiException = (ApiException) exception;
                            System.out.println("Place not found: " + exception.getMessage());
                            final int statusCode = apiException.getStatusCode();
                            System.out.println("statusCode=" + statusCode);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("오류" + e);
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
                }



            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                System.out.println("An error occurred: " + status);
            }


        });

    }



    public static String geonggi1() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"
                + "/4a667a6b6c7469643130386c426d4842"
                + "/json"
                + "/bikeList"
                + "/1"
                + "/100");


        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }

        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public static String geonggi2() throws Exception {

        System.out.print(geonggi1());
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(geonggi1());
        JSONObject json1 = (JSONObject) jsonObject.get("rentBikeStatus");

        JSONArray json4 = (JSONArray) json1.get("row");


        for (int i = 0; i < json4.size(); i++) {
            JSONObject json5 = (JSONObject) json4.get(i);
            json6_2 = (String) json5.get("stationName");
            json6_3 = (String) json5.get("parkingBikeTotCnt");
            json6_4 = (String) json5.get("rackTotCnt");
            json6_5 = (String) json5.get("stationLatitude");
            json6_6 = (String) json5.get("stationLongitude");


            json6_2bd.append(json6_2 + "split");
            json6_3bd.append("거치대 수:" + "\t" + json6_4 + "\n" + "현재 거치 수:" + json6_3 + "split");

            json6_5bd.append(json6_5 + "split");
            json6_6bd.append(json6_6 + "split");


        }

        json6_2sp = json6_2bd.toString().split("split");
        json6_3sp = json6_3bd.toString().split("split");
        json6_5sp = json6_5bd.toString().split("split");
        json6_6sp = json6_6bd.toString().split("split");

        return json6_2bd.toString();

    }


    public static void gwangyang() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/4840000/bcycllend1/getbcycllendList1");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8")     +"=" + URLEncoder.encode("전라남도 광양시 광양읍 덕례리 543-2", "UTF-8"));





        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(urlBuilder.toString());
        doc.getDocumentElement().normalize();
        String first = doc.getDocumentElement().getNodeName();
        System.out.println("최상위노드 " + first);
        NodeList nList = doc.getElementsByTagName("rows");
        System.out.println("파싱할 리스트 수 : " + nList.getLength());


        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nList.item(i);



                String latitude = eElement.getElementsByTagName("latitude").item(0).getChildNodes().item(0).getNodeValue();
                json6_51bd.append(latitude + "split");
                String longitude = eElement.getElementsByTagName("longitude").item(0).getChildNodes().item(0).getNodeValue();
                json6_61bd.append(longitude + "split");

                String bcyclLendNm = eElement.getElementsByTagName("bcyclLendNm").item(0).getChildNodes().item(0).getNodeValue();

                String lnmadr = eElement.getElementsByTagName("lnmadr").item(0).getChildNodes().item(0).getNodeValue();
                json6_31bd.append(bcyclLendNm+"\n"+lnmadr + "split");


                json6_51sp = json6_51bd.toString().split("split");
                json6_61sp = json6_61bd.toString().split("split");

                json6_31sp = json6_31bd.toString().split("split");

            }
        }


    }



    public String geonggi11() throws IOException {

        String asd = adress_result2.replaceAll(" ", "+");

        System.out.print("좌표구역" + asd + adress_result2);
        StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json"
                + "?query=" + adress_result2
                + "&key=AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio"
                + "&language=ko"
        );


        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }

        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public void geonggi22() throws Exception {//장소검색

        StringBuilder json6_2bd = new StringBuilder();

        System.out.print("장소검색" + geonggi1());

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(geonggi11());
        JSONArray json0 = (JSONArray) jsonObject.get("results");


        for (int i = 0; i < json0.size(); i++) {
            JSONObject json5 = (JSONObject) json0.get(i);
            json6_11 = (String) json5.get("place_id");
            json6_2bd.append(json6_11);

            JSONArray json7 = (JSONArray) json5.get("photos");
            for (int k = 0; k < json7.size(); k++) {
                JSONObject json8 = (JSONObject) json7.get(i);
                json99 = (String) json8.get("photo_reference");

            }
        }

    }

    public String geonggi3() throws IOException {//장소상세검색
        StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json"
                + "?place_id=" + json6_11
                + "&key=AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio"
                + "&language=ko"
        );

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }

        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public void geonggi4() throws Exception {
        StringBuilder json6_2bd = new StringBuilder();

        System.out.print("\n\n\n\n\n\n\n장소상세검색" + geonggi3());

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(geonggi3());
        JSONObject json0 = (JSONObject) jsonObject.get("result");

        json11 = (JSONArray) json0.get("photos");
        for (int i = 0; i < json11.size(); i++) {
            JSONObject json5 = (JSONObject) json11.get(i);
            String json6_1 = (String) json5.get("photo_reference");

            JSONArray html_attributions = (JSONArray) json5.get("html_attributions");
            for (int j = 0; j < html_attributions.size(); j++) {
                String href_String = (String) html_attributions.get(0);
                String href_cut = href_String.substring(9, 67);
                json6_33bd.append(href_cut + "split");
            }
            json6_2bd = json6_2bd.append(json6_1 + "split");
        }


        System.out.println("json6_2bd" + json6_2bd);
        System.out.println("json6_33bd" + json6_33bd);
        json6_22sp = json6_2bd.toString().split("split");


    }

    public void geonggi5() throws IOException {
        System.out.println("json99"+json99);


        StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/photo"
                + "?maxwidth=2500"
                + "&photoreference="+json99
                + "&key=AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio"

        );

        bitmap_click = getBitmapFromURL(urlBuilder.toString());

    }

    public static String geonggi6() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/photo"
                + "?maxwidth=2000"
                + "&photoreference=" + json6_22sp[count10]
                + "&key=AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio"

        );

        return urlBuilder.toString();
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            System.out.println("Response code: " + connection.getResponseCode());
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {

            return null;
        }
    }












}
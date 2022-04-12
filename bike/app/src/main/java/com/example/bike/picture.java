package com.example.bike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.Places;

import android.os.Build;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class picture extends AppCompatActivity {

    ImageView[] imageView_arr = new ImageView[100];
    int a = 0;

    ArrayList<ImageView> litor_ImageView=new ArrayList<ImageView>();
    FetchPhotoRequest photoRequest;
    PlacesClient placesClient;
    PhotoMetadata photoMetadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        litor_ImageView.add(findViewById(R.id.imageView0));
        litor_ImageView.add(findViewById(R.id.imageView1));
        litor_ImageView.add(findViewById(R.id.imageView2));
        litor_ImageView.add(findViewById(R.id.imageView3));
        litor_ImageView.add(findViewById(R.id.imageView4));
        litor_ImageView.add(findViewById(R.id.imageView5));
        litor_ImageView.add(findViewById(R.id.imageView6));
        litor_ImageView.add(findViewById(R.id.imageView7));
        litor_ImageView.add(findViewById(R.id.imageView8));
        litor_ImageView.add(findViewById(R.id.imageView9));
        litor_ImageView.add(findViewById(R.id.imageView10));
        litor_ImageView.add(findViewById(R.id.imageView11));
        litor_ImageView.add(findViewById(R.id.imageView12));
        litor_ImageView.add(findViewById(R.id.imageView13));
        litor_ImageView.add(findViewById(R.id.imageView14));
        litor_ImageView.add(findViewById(R.id.imageView15));
        litor_ImageView.add(findViewById(R.id.imageView16));
        litor_ImageView.add(findViewById(R.id.imageView17));



        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio", Locale.KOREA);
        placesClient = Places.createClient(this);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio");
        }

        if (bike_seoul.staticmarker.getTag() == "a") {
            for (int i = 0; i < bike_seoul.place_var.getPhotoMetadatas().size(); i++) {
                photoMetadata = bike_seoul.place_var.getPhotoMetadatas().get(i);
                photoRequest = FetchPhotoRequest.builder(photoMetadata)
                        .setMaxWidth(1500)
                        .setMaxHeight(1500)
                        .build();
                placesClient.fetchPhoto(photoRequest).addOnSuccessListener((fetchPhotoResponse) -> {
                    Bitmap bitmap0 = fetchPhotoResponse.getBitmap();
                    litor_ImageView.get(a).setImageBitmap(bitmap0);
                    a++;
                });
            }

            System.out.println(" bike_seoul.place_var.getPhotoMetadatas().size()" + bike_seoul.place_var.getPhotoMetadatas().size());
            System.out.println("bike_seoul.place_var.getPhotoMetadatas().toArray().length" + bike_seoul.place_var.getPhotoMetadatas().toArray().length);

        }



        if (bike_seoul.staticmarker.getTag() == "click_m") {
            bike_seoul.count10=0;
            ArrayList<ImageView> litor_ImageView2=new ArrayList<ImageView>();


                try {
                    Iterator<ImageView> iter2 = litor_ImageView.iterator();
                    while(iter2.hasNext() && bike_seoul.count10<bike_seoul.json6_22sp.length){
                        litor_ImageView.get(bike_seoul.count10).setImageBitmap(bike_seoul.getBitmapFromURL(bike_seoul.geonggi6()));

                        ImageView iternext= (ImageView) iter2.next();
                        litor_ImageView2.add(iternext);
                        litor_ImageView2.get(bike_seoul.count10).setId(bike_seoul.count10);
                        System.out.println("litor_ImageView2.get(bike_seoul.count10).getId())   " +litor_ImageView2.get(bike_seoul.count10).getId());
                        System.out.println("bike_seoul.count10  " +bike_seoul.count10);

                        iternext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                System.out.println("litor_ImageView2" +litor_ImageView2);

                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[view.getId()])));
                                picture.this.startActivity(intent);

                                System.out.println("bike_seoul.json6_33sp[bike_seoul.count10]   " + bike_seoul.json6_33sp[iternext.getId()]);

                                System.out.println("iternext.getId()   " +iternext.getId());
                            }
                        });
                        bike_seoul.count10++;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            bike_seoul.json6_33sp = bike_seoul.json6_33bd.toString().split("split");
        }







    }

/*
    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(this, picture.class);
        picture.this.startActivity(registerintent);
        super.onBackPressed();
    }
*/

}

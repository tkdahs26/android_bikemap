package com.example.bike;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.Places;

import android.os.Build;
import android.os.StrictMode;
import android.widget.ImageView;


import java.util.Locale;

public class picture extends AppCompatActivity {




    ImageView[] imageView_arr = new ImageView[100];
    int a = 0;

    FetchPhotoRequest photoRequest;
    PlacesClient placesClient;
    PhotoMetadata photoMetadata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        imageView_arr[0] = findViewById(R.id.imageView1);
        imageView_arr[1] = findViewById(R.id.imageView2);
        imageView_arr[2] = findViewById(R.id.imageView3);
        imageView_arr[3] = findViewById(R.id.imageView4);
        imageView_arr[4] = findViewById(R.id.imageView5);
        imageView_arr[5] = findViewById(R.id.imageView6);
        imageView_arr[6] = findViewById(R.id.imageView7);
        imageView_arr[7] = findViewById(R.id.imageView8);
        imageView_arr[8] = findViewById(R.id.imageView9);
        imageView_arr[9] = findViewById(R.id.imageView10);
        imageView_arr[10] = findViewById(R.id.imageView11);
        imageView_arr[11] = findViewById(R.id.imageView12);
        imageView_arr[12] = findViewById(R.id.imageView13);
        imageView_arr[13] = findViewById(R.id.imageView14);
        imageView_arr[14] = findViewById(R.id.imageView15);
        imageView_arr[15] = findViewById(R.id.imageView16);
        imageView_arr[16] = findViewById(R.id.imageView17);
        imageView_arr[17] = findViewById(R.id.imageView18);

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio", Locale.KOREA);
        placesClient = Places.createClient(this);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyCZfMZxF4Ds1j8uBwRBcbgOZJT1-1cxVio");
        }





        for(int i = 0; i< bike_seoul.place_var.getPhotoMetadatas().size(); i++) {
            photoMetadata = bike_seoul.place_var.getPhotoMetadatas().get(i);
            photoRequest = FetchPhotoRequest.builder(photoMetadata)
                    .setMaxWidth(500)
                    .setMaxHeight(300)
                    .build();
            placesClient.fetchPhoto(photoRequest).addOnSuccessListener((fetchPhotoResponse) -> {
                Bitmap bitmap0 = fetchPhotoResponse.getBitmap();
                imageView_arr[a].setImageBitmap(bitmap0);
                a++;
            });


        }




        System.out.println(" bike_seoul.place_var.getPhotoMetadatas().size()"+ bike_seoul.place_var.getPhotoMetadatas().size());
        System.out.println("bike_seoul.place_var.getPhotoMetadatas().toArray().length"+bike_seoul.place_var.getPhotoMetadatas().toArray().length);





        }


    }





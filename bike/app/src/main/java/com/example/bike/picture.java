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


import java.io.IOException;
import java.util.Locale;

public class picture extends AppCompatActivity implements View.OnClickListener {




    ImageView[] imageView_arr = new ImageView[100];
    int a = 0;

    FetchPhotoRequest photoRequest;
    PlacesClient placesClient;
    PhotoMetadata photoMetadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        imageView_arr[0] = findViewById(R.id.imageView0);
        imageView_arr[1] = findViewById(R.id.imageView1);
        imageView_arr[2] = findViewById(R.id.imageView2);
        imageView_arr[3] = findViewById(R.id.imageView3);
        imageView_arr[4] = findViewById(R.id.imageView4);
        imageView_arr[5] = findViewById(R.id.imageView5);
        imageView_arr[6] = findViewById(R.id.imageView6);
        imageView_arr[7] = findViewById(R.id.imageView7);
        imageView_arr[8] = findViewById(R.id.imageView8);
        imageView_arr[9] = findViewById(R.id.imageView9);
        imageView_arr[10] = findViewById(R.id.imageView10);
        imageView_arr[11] = findViewById(R.id.imageView11);
        imageView_arr[12] = findViewById(R.id.imageView12);
        imageView_arr[13] = findViewById(R.id.imageView13);
        imageView_arr[14] = findViewById(R.id.imageView14);
        imageView_arr[15] = findViewById(R.id.imageView15);
        imageView_arr[16] = findViewById(R.id.imageView16);
        imageView_arr[17] = findViewById(R.id.imageView17);


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
                    imageView_arr[a].setImageBitmap(bitmap0);
                    a++;
                });


            }
            System.out.println(" bike_seoul.place_var.getPhotoMetadatas().size()" + bike_seoul.place_var.getPhotoMetadatas().size());
            System.out.println("bike_seoul.place_var.getPhotoMetadatas().toArray().length" + bike_seoul.place_var.getPhotoMetadatas().toArray().length);

        }



        if (bike_seoul.staticmarker.getTag() == "click_m") {
            bike_seoul.count10=0;
            for (int i = 0; i < bike_seoul.json6_22sp.length; i++) {

                try {

                    imageView_arr[bike_seoul.count10].setImageBitmap(bike_seoul.getBitmapFromURL(bike_seoul.geonggi6()));

                    System.out.println("bike_seoul.count10   " + bike_seoul.count10);
                    bike_seoul.count10++;
                    imageView_arr[i].setOnClickListener(this);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            bike_seoul.json6_33sp = bike_seoul.json6_33bd.toString().split("split");
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView0:
                imageView_arr[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Intent intent1 = getIntent().setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[0])));

                        picture.this.startActivity(intent);


                    }


                });
            case R.id.imageView1:
                imageView_arr[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[1])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView2:
                imageView_arr[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[2])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView3:
                imageView_arr[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[3])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView4:
                imageView_arr[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[4])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView5:
                imageView_arr[5].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[5])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView6:
                imageView_arr[6].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[6])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView7:
                imageView_arr[7].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[7])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView8:
                imageView_arr[8].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[8])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView9:
                imageView_arr[9].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[9])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView10:
                imageView_arr[10].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[10])));
                        picture.this.startActivity(intent);
                    }
                });
            case R.id.imageView11:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[11])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView12:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[12])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView13:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[13])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView14:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[14])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView15:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[15])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView16:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[16])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView17:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[17])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView18:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[18])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView19:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[19])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView20:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[20])));
                        picture.this.startActivity(intent);
                    }
                });

            case R.id.imageView21:
                imageView_arr[11].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(String.valueOf(bike_seoul.json6_33sp[21])));
                        picture.this.startActivity(intent);
                    }
                });


        }


    }


}

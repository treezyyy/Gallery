package com.example.gallery;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageSize extends AppCompatActivity {

    int NUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        ImageView image = findViewById(R.id.activity_image);
        Intent intent = getIntent();
        String path = intent.getStringExtra("image");
        NUMBER = intent.getIntExtra("num", -1);
        File imgFile = new File(path);
        if (imgFile.exists()) {
            image.setImageURI(Uri.fromFile(imgFile));
        }
}
    public void OnClickNext(View view){
        ImageView image = findViewById(R.id.activity_image);
        Intent intent = getIntent();
        ArrayList<Cell> array = intent.getParcelableArrayListExtra("array");
        if((NUMBER + 1) < array.size()){
            NUMBER++;
            File imgFile = new File(array.get(NUMBER).getPath());
            if (imgFile.exists()) {
                image.setImageURI(Uri.fromFile(imgFile));
            }}
    }

    public void OnClickBack(View view){
        ImageView image = findViewById(R.id.activity_image);
        Intent intent = getIntent();
        ArrayList<Cell> array = intent.getParcelableArrayListExtra("array");
        if((NUMBER - 1) > 0){
            NUMBER--;
            File imgFile = new File(array.get(NUMBER).getPath());
            if (imgFile.exists()) {
                image.setImageURI(Uri.fromFile(imgFile));
        }}
    }
}

package com.mitchellkopczyk.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button picBtn;
    private ImageView picView;
    private final static int CAMERACODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picBtn = findViewById(R.id.button);
        picView = findViewById(R.id.imageView);
        picBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageCapture = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(imageCapture,CAMERACODE);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERACODE){
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                picView.setImageBitmap(thumbnail);
            }
        }
        else{
            Toast.makeText(this,"No picture was taken", Toast.LENGTH_SHORT).show();
        }
    }
}

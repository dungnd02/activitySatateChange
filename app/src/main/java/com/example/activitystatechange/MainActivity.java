package com.example.activitystatechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private static final String TAG = "Main Activity";
MediaPlayer mediaPlayer;
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"Oncreate ()");
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ex_3);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    protected void onResume(){
        super.onResume();
        Log.e(TAG, "onResume()");
        mediaPlayer.start();
    }
    protected void onStop(){
        super.onStop();
        Log.e(TAG, "onStop()");
    }
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
        Log.e(TAG, "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
            Log.e(TAG, "onSaveInstanceState");
            outState.putInt("position",mediaPlayer.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
        position = savedInstanceState.getInt("position");
        mediaPlayer.seekTo(position);

    }
}
package com.naskraft.soundwave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class VideoPlayer extends AppCompatActivity {
    Button play;
    Button pause;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        play=findViewById(R.id.play2);

        seekBar=findViewById(R.id.seekBar2);
        surfaceView=findViewById(R.id.surfaceView);

        mediaPlayer=MediaPlayer.create(this,R.raw.animevideo);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });


        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setText("Play");
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());


                }else{
                    mediaPlayer.start();
                    play.setText("Pause");
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                }




            }
        });
    }
}
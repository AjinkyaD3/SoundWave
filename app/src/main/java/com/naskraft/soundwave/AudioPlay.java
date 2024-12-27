package com.naskraft.soundwave;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class AudioPlay extends AppCompatActivity {
    Button play;
    Button pause;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        play=findViewById(R.id.play);
//        pause=findViewById(R.id.pause);
        seekBar=findViewById(R.id.seekBar);
        //Playing Media from Device
        mediaPlayer=MediaPlayer.create(this,R.raw.fourmendown);

        //For playing Media From Online Source
//        mediaPlayer=new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource("https://themamaship.com/music/Catalog/Bad%20Guy%20-%20Billie%20Eilish.mp3");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.start();
//            }
//        });
//        mediaPlayer.prepareAsync();

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
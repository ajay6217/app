package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer MediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        seekBar=findViewById(R.id.seekBar);
        //media play local source
        //MediaPlayer =MediaPlayer.create(this,R.raw.song);





        // media player using remote source
        MediaPlayer=new MediaPlayer();
        try {
            MediaPlayer.setDataSource("http://bigbeatradio.com/static/media/music/-/-/(02)%20%5bThe%20Crystal%20Method%5d%20Wild.%20Sweet%20and%20Cool.mp3");
        } catch (IOException e) {

            e.printStackTrace();
        }

        // MediaPlayer.start();
       MediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
           @Override
           public void onPrepared(android.media.MediaPlayer mediaPlayer) {
               Toast.makeText(MainActivity.this, "Ready to play", Toast.LENGTH_SHORT).show();
               MediaPlayer.start();
               seekBar.setMax(mediaPlayer.getDuration());
               seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                   @Override
                   public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                       if(b) {
                           MediaPlayer.seekTo(i);
                       }

                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {

                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {

                   }
               });
           }
       });
        MediaPlayer.prepareAsync();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer.start();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer.pause();

            }
        });
    }
    }


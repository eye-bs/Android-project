package com.example.boony.alarmpickerv2;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

/**
 * Created by boony on 5/7/2017.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // fetch the extra string from the alarm on/alarm off values
        String state = intent.getExtras().getString("extra");
        // fetch the whale choice integer values
        Integer whale_sound_choice = intent.getExtras().getInt("whale_choice");

        Log.e("Ringtone extra is ", state);
        Log.e("Whale choice is ", whale_sound_choice.toString());

        // put the notification here, test it out

        // notification
        // set up the notification service

            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            // set up an intent that goes to the Main Activity
            Intent intent_main_activity = new Intent(this.getBaseContext(), AlarmOffPage.class);
            // set up a pending intent
            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0,
                    intent_main_activity, 0);

            // make the notification parameters
            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("An alarm is going off!")
                    .setContentText("Click me!")
                    .setSmallIcon(R.drawable.ic_action_call)
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .build();


            // this converts the extra strings from the intent
            // to start IDs, values 0 or 1
            assert state != null;
            switch (state) {
                case "alarm on":
                    startId = 1;
                    break;
                case "alarm off":
                    startId = 0;
                    Log.e("Start ID is ", state);
                    break;
                default:
                    startId = 0;
                    break;
            }


            // if else statements

            // if there is no music playing, and the user pressed "alarm on"
            // music should start playing
            if (!this.isRunning && startId == 1) {
                Log.e("there is no music, ", "and you want start");

                this.isRunning = true;
                this.startId = 0;

                // set up the start command for the notification
                notify_manager.notify(0, notification_popup);


                // play the whale sound depending on the passed whale choice id

                if (whale_sound_choice == 0) {
                    // play a randomly picked audio file

                    int minimum_number = 1;
                    int maximum_number = 13;

                    Random random_number = new Random();
                    int whale_number = random_number.nextInt(maximum_number + minimum_number);
                    Log.e("random number is ", String.valueOf(whale_number));


                    if (whale_number == 1) {
                        media_song = MediaPlayer.create(this, R.raw.ievan_polkka);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 2) {
                        media_song = MediaPlayer.create(this, R.raw.banana);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 3) {
                        media_song = MediaPlayer.create(this, R.raw.chiken);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 4) {
                        media_song = MediaPlayer.create(this, R.raw.conan);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 5) {
                        media_song = MediaPlayer.create(this, R.raw.extreamalarmsound);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 6) {
                        media_song = MediaPlayer.create(this, R.raw.hamtaro);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 7) {
                        media_song = MediaPlayer.create(this, R.raw.osas);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 8) {
                        media_song = MediaPlayer.create(this, R.raw.pinkpanther);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 9) {
                        media_song = MediaPlayer.create(this, R.raw.ppap);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 10) {
                        media_song = MediaPlayer.create(this, R.raw.rain_drop);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 11) {
                        media_song = MediaPlayer.create(this, R.raw.shinjung);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 12) {
                        media_song = MediaPlayer.create(this, R.raw.supermario);
                        media_song.setLooping(true);
                        media_song.start();
                    } else if (whale_number == 13) {
                        media_song = MediaPlayer.create(this, R.raw.weakupthailand);
                        media_song.setLooping(true);
                        media_song.start();
                    } else {
                        media_song = MediaPlayer.create(this, R.raw.supermario);
                        media_song.setLooping(true);
                        media_song.start();
                    }


                } else if (whale_sound_choice == 1) {
                    // create an instance of the media player
                    media_song = MediaPlayer.create(this, R.raw.ievan_polkka);
                    media_song.setLooping(true);
                    // start the ringtone
                    media_song.start();
                } else if (whale_sound_choice == 2) {
                    // create an instance of the media player
                    media_song = MediaPlayer.create(this, R.raw.banana);
                    media_song.setLooping(true);
                    // start the ringtone
                    media_song.start();
                } else if (whale_sound_choice == 3) {
                    media_song = MediaPlayer.create(this, R.raw.chiken);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 4) {
                    media_song = MediaPlayer.create(this, R.raw.conan);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 5) {
                    media_song = MediaPlayer.create(this, R.raw.extreamalarmsound);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 6) {
                    media_song = MediaPlayer.create(this, R.raw.hamtaro);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 7) {
                    media_song = MediaPlayer.create(this, R.raw.osas);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 8) {
                    media_song = MediaPlayer.create(this, R.raw.pinkpanther);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 9) {
                    media_song = MediaPlayer.create(this, R.raw.ppap);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 10) {
                    media_song = MediaPlayer.create(this, R.raw.rain_drop);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 11) {
                    media_song = MediaPlayer.create(this, R.raw.shinjung);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 12) {
                    media_song = MediaPlayer.create(this, R.raw.supermario);
                    media_song.setLooping(true);
                    media_song.start();
                } else if (whale_sound_choice == 13) {
                    media_song = MediaPlayer.create(this, R.raw.weakupthailand);
                    media_song.setLooping(true);
                    media_song.start();
                } else {
                    media_song = MediaPlayer.create(this, R.raw.supermario);
                    media_song.setLooping(true);
                    media_song.start();
                }


            }

            // if there is music playing, and the user pressed "alarm off"
            // music should stop playing
            else if (this.isRunning && startId == 0) {
                Log.e("there is music, ", "and you want end");

                // stop the ringtone
                media_song.stop();
                media_song.reset();

                this.isRunning = false;
                this.startId = 0;
            }

            // these are if the user presses random buttons
            // just to bug-proof the app
            // if there is no music playing, and the user pressed "alarm off"
            // do nothing
            else if (!this.isRunning && startId == 0) {
                Log.e("there is no music, ", "and you want end");

                this.isRunning = false;
                this.startId = 0;

            }

            // if there is music playing and the user pressed "alarm on"
            // do nothing
            else if (this.isRunning && startId == 1) {
                Log.e("there is music, ", "and you want start");


                    this.isRunning = true;
                    this.startId = 1;

            }

            // can't think of anything else, just to catch the odd event
            else {
                Log.e("else ", "somehow you reached this");

            }


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Log.e("on Destroy called", "ta da");

        super.onDestroy();
        this.isRunning = false;
    }



}


package com.example.saandeepa.alarmexample;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


/**
 * @author Prabu
 *
 */
public class MyBroadcastReceiver extends BroadcastReceiver {


    public void onReceive(Context context, Intent intent) {




        Toast.makeText(context, "Time is up!!!!.",
                Toast.LENGTH_LONG).show();
        // Vibrate the mobile phone
        Vibrator vibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        genNoti(context,intent);
    }
    public void genNoti(Context context, Intent intent){
        NotificationCompat.Builder notification;
       int uniqueID =34243 ;

        notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);


        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is the title");
        notification.setContentText("I m the body of your nootification");

        Intent bintent=new Intent(context ,MainActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(context, 0, bintent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);


        //builds notification and issues it
        NotificationManager nm = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());



    }
}
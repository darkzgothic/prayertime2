package com.zahidhasan.app.prayertimeapp;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.zahidhasan.app.prayertimeapp.adapters.SelectionsPageAdapter;
import com.zahidhasan.app.prayertimeapp.data.DataBaseCreate;
import com.zahidhasan.app.prayertimeapp.data.DataBaseHelper;
import com.zahidhasan.app.prayertimeapp.fragments.HadithFragment;
import com.zahidhasan.app.prayertimeapp.fragments.HomeFragment;
import com.zahidhasan.app.prayertimeapp.model.Hadith;
import com.zahidhasan.app.prayertimeapp.services.MainNotification;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String hadithFragmentTitle = "হাদিস";
    private static final String homeFragmentTitle = "হোম";

    private SelectionsPageAdapter selectionsPageAdapter;
    private ViewPager viewPager;

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private Context context;
    private RemoteViews remoteViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        Log.d(TAG, "onCreate: Tab");

        selectionsPageAdapter = new SelectionsPageAdapter(getSupportFragmentManager());

        //Set up view pager with the selection adapter
        viewPager = (ViewPager) findViewById(R.id.container);
        setViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //DataBase Create
        Log.d(TAG, "onCreate: Database");

        DataBaseCreate db = new DataBaseCreate(this);
        db.createDataBase();

//        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
//        ArrayList<Hadith> hadiths = new ArrayList<>();
//        hadiths = dataBaseHelper.getHadiths();

//        Log.d(TAG, hadiths.get(0).getInBangla());

        //Notification
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(this);
        remoteViews = new RemoteViews(getPackageName(), R.layout.main_notification);

        notification_id = (int) System.currentTimeMillis();
        Intent intent = new Intent(this, MainNotification.class);
        intent.putExtra("id", notification_id);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, notification_id, intent, 0);

        remoteViews.setOnClickPendingIntent(R.id.month_txt_view, pendingIntent);
        remoteViews.setTextViewText(R.id.month_txt_view, "August");
        Intent intent1 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 0, intent1, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .setContent(remoteViews)
                .setContentIntent(pendingIntent1);
        notificationManager.notify(notification_id,builder.build());

        /*notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(this);

        remoteViews = new RemoteViews(getPackageName(),R.layout.main_notification);
//        remoteViews.setImageViewResource(R.id.notif_icon,R.mipmap.ic_launcher);
//        remoteViews.setTextViewText(R.id.notif_title,"TEXT");
//        remoteViews.setProgressBar(R.id.progressBar,100,40,true);

        notification_id = (int) System.currentTimeMillis();

        Intent button_intent = new Intent(context, MainNotification.class);
        button_intent.putExtra("id",notification_id);
        PendingIntent button_pending_event = PendingIntent.getBroadcast(context,notification_id,
                button_intent,0);

//        remoteViews.setOnClickPendingIntent(R.id.button,button_pending_event);

        Intent notification_intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notification_intent,0);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContent(remoteViews)
                .setContentIntent(pendingIntent);

        notificationManager.notify(notification_id,builder.build());*/

    }

    private void setViewPager(ViewPager viewPager){
        SelectionsPageAdapter adapter = new SelectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), homeFragmentTitle);
        adapter.addFragment(new HadithFragment(), hadithFragmentTitle);
        viewPager.setAdapter(adapter);
    }
}

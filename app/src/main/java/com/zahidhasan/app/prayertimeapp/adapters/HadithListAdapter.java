package com.zahidhasan.app.prayertimeapp.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zahidhasan.app.prayertimeapp.R;
import com.zahidhasan.app.prayertimeapp.model.Hadith;

import java.util.List;

/**
 * Created by DarkzGothic on 8/29/2017.
 */

public class HadithListAdapter extends ArrayAdapter<Hadith> {

    private Activity context;
    private List<Hadith> hadithList;

    public HadithListAdapter(Activity context, List<Hadith> hadithList){
        super(context, R.layout.hadith_list_layout, hadithList);
        this.context = context;
        this.hadithList = hadithList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View hadithListViewItem = inflater.inflate(R.layout.hadith_list_layout, null, true);

        TextView hadithTitle = (TextView) hadithListViewItem.findViewById(R.id.hadith_title_txt_view);

        Hadith hadith = hadithList.get(position);

        hadithTitle.setText(hadith.getTitle());

        return hadithListViewItem;
    }
}

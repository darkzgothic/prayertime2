package com.zahidhasan.app.prayertimeapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.zahidhasan.app.prayertimeapp.HadithDetailsActivity;
import com.zahidhasan.app.prayertimeapp.R;
import com.zahidhasan.app.prayertimeapp.adapters.HadithListAdapter;
import com.zahidhasan.app.prayertimeapp.data.DataBaseHelper;
import com.zahidhasan.app.prayertimeapp.model.Hadith;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HadithFragment extends Fragment {

    ListView hadithListView;
    List<Hadith> hadithList;

    DataBaseHelper dataBaseHelper;

    public HadithFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hadith, container, false);

        dataBaseHelper = new DataBaseHelper(getContext());

        hadithList = new ArrayList<>();
        hadithList = dataBaseHelper.getHadiths();

        hadithListView = (ListView) v.findViewById(R.id.hadith_list_view);

        HadithListAdapter hadithListAdapter = new HadithListAdapter(getActivity(), hadithList);
        hadithListView.setAdapter(hadithListAdapter);
        hadithListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hadith hadith = (Hadith) parent.getItemAtPosition(position);
                int hadithId = hadith.getId();

                startActivity(new Intent(getActivity(), HadithDetailsActivity.class));
//                Toast.makeText(getContext(), String.valueOf(hadithId), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}

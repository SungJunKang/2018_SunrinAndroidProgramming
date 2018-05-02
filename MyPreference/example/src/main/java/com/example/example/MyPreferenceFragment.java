package com.example.example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public class MyPreferenceFragment extends PreferenceFragment {

    ListPreference network_list;
    SharedPreferences prefs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_interface);

        network_list = (ListPreference)findPreference("network_list");
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // 처음 화면 보여줄 때 SharedPreferences 에 저장된 값 불러오기
        if(!prefs.getString("network_list", "").equals("")){
            network_list.setSummary(prefs.getString("network_list", "LTE(권장)"));
        }

        prefs.registerOnSharedPreferenceChangeListener(prefListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if(key.equals("network_list")){
                        network_list.setSummary(prefs.getString("network_list", "LTE(권장)"));
                    }
                }
            };
}

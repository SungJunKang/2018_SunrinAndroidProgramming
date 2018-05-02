package com.example.sunrin.mypreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public class MyPreferenceFragment extends PreferenceFragment {

    ListPreference sound_list;
    SharedPreferences prefs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.kakao_setting);

        sound_list = (ListPreference)findPreference("sound_list");
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // 처음 화면 보여줄 때 SharedPreferences 에 저장된 값 불러오기
        if(!prefs.getString("sound_list", "").equals("")){
            sound_list.setSummary(prefs.getString("sound_list", "카톡"));
        }

        prefs.registerOnSharedPreferenceChangeListener(prefListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if(key.equals("sound_list")){
                        sound_list.setSummary(prefs.getString("sound_list", "카톡"));
                    }
                }
            };
}

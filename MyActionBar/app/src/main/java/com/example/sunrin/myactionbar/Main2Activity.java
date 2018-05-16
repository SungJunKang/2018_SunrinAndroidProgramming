package com.example.sunrin.myactionbar;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    SearchView searchView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder)menu;
            m.setOptionalIconsVisible(true);
        }

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요.");
        searchView.setOnQueryTextListener(queryTextListener);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 0, 0, "서버 전송");
        menu.add(0, 1, 0, "보관함에 보관");
        menu.add(0, 2, 0, "삭제");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 0:
                showToast("서버 전송이 선택되었습니다.");
                break;

            case 1:
                showToast("보관함에 보관이 선택되었습니다.");
                break;

            case 2:
                showToast("삭제가 선택되었습니다.");
                break;
        }
        return true;
    }

    // Option Menu Click 할 때 실행
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu1){
            showToast("Menu1 Clicked!");
        }
        else if(item.getItemId() == R.id.menu2){
            showToast("Menu2 Clicked!");
        }
        else if(item.getItemId() == R.id.subMenu){
            showToast("SubMenu Clicked!");
        }
        return true;
    }

    SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            // 검색 창이 Clear 된다.
            searchView.setIconified(true);
            showToast(query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

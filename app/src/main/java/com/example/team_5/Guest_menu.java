package com.example.team_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Guest_menu extends AppCompatActivity {

    private ImageView rightIcon, rightIcon2;

    RecyclerView recyclerView;
    ArrayList<ClipData.Item> itemArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_menu);

        GuestMenuListAdapter guestMenuListAdapter = new GuestMenuListAdapter();

        guestMenuListAdapter.setOnItemClickListener(
                new GuestMenuListAdapter.OnItemClickListener() {
                    @Override
                    public void onitemClick(View v, int pos){

                    }
                });

        recyclerView = findViewById(R.id.recyclerView);
        GuestMenuListAdapter adapter = new GuestMenuListAdapter();

        rightIcon = findViewById(R.id.right_icon);
        rightIcon2 = findViewById(R.id.right_icon2);

        ImageView leftIcon = findViewById(R.id.left_icon);    //뒤로가기 버튼
        ImageView rightIcon = findViewById(R.id.right_icon);  //메뉴버튼
        ImageView rightIcon2 = findViewById(R.id.right_icon2);  //메뉴버튼
        registerForContextMenu(rightIcon);
        registerForContextMenu(rightIcon2);

        TextView title = findViewById(R.id.toolbar_title);
        title.setText("메뉴판");   //툴바 제목

        leftIcon.setOnClickListener(new View.OnClickListener() {                  //뒤로가기 버튼
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guest_menu.this, GuestActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,              //상단 메뉴
                                    ContextMenu.ContextMenuInfo menuInfo) {
        //view는 롱클릭한 위젯
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = getMenuInflater();
        if(v == rightIcon){
            mi.inflate(R.menu.main_menu, menu);
        }
        if (v == rightIcon2){
            mi.inflate(R.menu.menu_call, menu);
        }
    }//end of ContextMenu()



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:      //점주화면 전환
                Intent intent = new Intent(Guest_menu.this, Owner_manager.class);
                startActivity(intent);
                return true;
            case R.id.btn_logout:   //로그아웃
                return true;
            case R.id.call:     //알림
                return true;
            case R.id.call1:    //알림
                return true;
            case R.id.call2:    //알림
                return true;
        }
        return false;
    }
 }

package com.t3h.chatfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Friend> friends;
    private RecyclerView rcFriend;
    Api api;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        inits();
        rcFriend = findViewById(R.id.rc_friend);
        FriendAdapter adapter = new FriendAdapter(friends);
        rcFriend.setLayoutManager(new LinearLayoutManager(this));
        rcFriend.setAdapter(adapter);

        findViewById(R.id.btn_add_friend).setOnClickListener(this);
    }
    private void inits(){
        friends = new ArrayList<>();
        Friend friend = new Friend();
        friend.setAvatar("https://ss-images.catscdn.vn/2016/07/09/609399/mantien-1.jpg");
        friend.setOnline(true);
        friend.setLastMessage("Ahihi Friend");
        friend.setdisplayNameFriend("Maria");
        friend.setId(null);
        friend.setDateLastMessage(new Date());
        friends.add(friend);


        friend = new Friend();
        friend.setAvatar("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwnUvV3LgR64AzpPaz6-8t8BfH-PWYDTTI_NZluFTDV-gHqEdG");
        friend.setOnline(false);
        friend.setLastMessage("Ahihi Juuu");
        friend.setdisplayNameFriend("Juuu");
        friend.setId(null);
        friend.setDateLastMessage(new Date());
        friends.add(friend);

    }

    @Override
    public void onClick(View view) {
        //mo man hinh friend
        Intent intent = new Intent();
        intent.setClass(this, AddFriendActivity.class);
        startActivity(intent);
    }
    private void initApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.150:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(Api.class);
    }
}

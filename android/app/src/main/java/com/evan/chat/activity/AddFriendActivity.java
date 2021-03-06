package com.evan.chat.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import com.evan.chat.R;
import com.evan.chat.data.source.User.model.User;
import com.evan.chat.view.EditButton;
import com.evan.chat.view.FriendsButton;
import com.evan.chat.view.TopTitleButton;
import com.evan.chat.util.DynAdd;
import com.evan.chat.util.SetImageButton;

import java.util.ArrayList;
import java.util.List;

public class AddFriendActivity extends Activity {
    private LinearLayout body;
    private Handler han;
    private TopTitleButton top;
    private EditButton edit;
    private ArrayList<FriendsButton> arrayList=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        top= findViewById(R.id.top);
        SetImageButton.setTopTitleButton(top,R.mipmap.back,"添加好友",R.mipmap.transparent);
        top.onClickBack(this);
        body= findViewById(R.id.body);
        edit=new EditButton(this,null);

        edit.setSendText("查找");
        edit.getSend().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str=edit.getChat().getText().toString();
                if (!"".equals(str)) {
                    for (FriendsButton anArrayList : arrayList) {
                        ((LinearLayout) findViewById(R.id.body)).removeView(anArrayList);
                    }
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
//                            Message msg= Data.client.get("search-"+str);
//                            han.sendMessage(msg);
                        }
                    }.start();
                }
            }
        });
        DynAdd.addView(body, edit);

        han=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle b = msg.getData();
                String result = b.getString("result");
//                if (result != null && !result.equals("")) {
//                    List<User> frds= JSON.parseArray(result,User.class);
//                    for (User frd : frds) {
//                        FriendsButton fbtn = new FriendsButton(AddFriendActivity.this, null);
//                        SetImageButton.setFriendsButton(fbtn, R.mipmap.logo, frd.getUsername(), frd.getSignature(), frd.getState());
//                        DynAdd.addView(body, fbtn);
//                        arrayList.add(fbtn);
//                        fbtn.getButton().setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(AddFriendActivity.this, UserActivity.class);
//                                startActivity(intent);
//                            }
//                        });
//                    }
//                }
            }
        };
    }

    public void onBackPressed() {
//        返回键方法
        finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }
}
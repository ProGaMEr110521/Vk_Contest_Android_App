package com.example.vk_contest;

import android.view.View;

public class onCallButton {
    public void onCallButtonClick(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}

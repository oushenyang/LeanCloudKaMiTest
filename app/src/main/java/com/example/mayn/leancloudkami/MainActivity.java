package com.example.mayn.leancloudkami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"N0zN10QwVcjf0K54SunJRxjI-gzGzoHsz","HfvqcQBPrk7bF1EScvpOrCyD");

        // 测试 SDK 是否正常工作的代码
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }else {
                    Log.d("saved",e.getMessage());
                }
            }
        });

        AVObject todoFolder = new AVObject("TodoFolder");// 构建对象
        todoFolder.put("name", "工作");// 设置名称
        todoFolder.put("priority", 1);// 设置优先级
        todoFolder.saveInBackground();// 保存到服务端
    }
}

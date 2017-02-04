package com.soubu.walledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEnv = (TextView) findViewById(R.id.tv_env);
        TextView tvChannel = (TextView) findViewById(R.id.tv_channel);
        TextView tvPackage = (TextView) findViewById(R.id.tv_package);

        String channel = WalleChannelReader.getChannel(this.getApplicationContext());
        int envType = BuildConfig.ENV_TYPE;
        String packageName = getPackageName();

        switch (envType) {
            case EnvType.DEVELOP:
                tvEnv.setText("envType=" + "开发环境");
                break;
            case EnvType.CHECK:
                tvEnv.setText("envType=" + "测试环境");
                break;
            case EnvType.PRODUCT:
                tvEnv.setText("envType=" + "生产环境");
                break;
        }
        tvChannel.setText("channel=" + channel);
        tvPackage.setText("package=" + packageName);

    }
}

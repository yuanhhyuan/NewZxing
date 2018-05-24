package com.hy.newzxing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author xtich
 */
public class MainActivity extends Activity {

    private String content;
    String content1;
    private String ssid;
    private String pass;
    private EditText et_pass;
    private EditText et_ssid;

    private Button mchinaqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_ssid = (EditText) findViewById(R.id.et_ssid);
        ssid = et_ssid.getText().toString().trim();
        pass = et_pass.getText().toString().trim();
        content = "ssid:" + ssid + "_" + "pass:" + pass;

        TextView tv_btn = (TextView) findViewById(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(et_ssid.getText()) && !TextUtils.isEmpty(et_pass.getText())) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap(content, 880, 880);
                    imageView.setImageBitmap(mBitmap);
                } else {
                    Toast.makeText(MainActivity.this, "请输入账户和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });

        content1 = "zxcgtesttest";

        TextView tv_btn1 = (TextView) findViewById(R.id.tv_btn1);
        tv_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, content1, Toast.LENGTH_SHORT).show();

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap mBitmap = QRCodeUtil.generate(MainActivity.this, content1);
                imageView.setImageBitmap(mBitmap);
            }
        });

        mchinaqr = findViewById(R.id.mchinaQR);
        mchinaqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ChinaQRActivity.class));
            }
        });
    }
}


/**
 * 二维码生成客制化：
 *
 * 1、生成二维码图片大小：修改xml中Imageview的长宽
 * 2、颜色修改
 * 3、空白边距修改
 * 4、创建中间带图片的二维码位图
 *
 * */
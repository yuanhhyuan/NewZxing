package com.hy.newzxing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

/**
 * @author xtich
 */
public class ChinaQRActivity extends Activity {

    private String TAG = "060_ChinaQRActivity";

    private String content;
    String content1;

    private EditText et_china;
    private String schina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinaqr);
        initView();
    }

    private void initView() {
        et_china = (EditText) findViewById(R.id.et_china);

        et_china.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                et_china.setTextColor(Color.BLUE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                schina = s.toString();
                content = "shedingtou"+"_"+ schina ;
                Log.e(TAG, "content : " + content);
            }
        });


        TextView tv_btn = (TextView) findViewById(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChinaQRActivity.this, content, Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(et_china.getText())) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    try {
                        Bitmap mBitmap = QRCodeUtil.create2DCode(content);
                        imageView.setImageBitmap(mBitmap);
                    }catch (WriterException e){
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(ChinaQRActivity.this, "请输入中文", Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView tv_btn1 = (TextView) findViewById(R.id.tv_btn1);
        tv_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChinaQRActivity.this, content1, Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap mBitmap = QRCodeUtil.generate(ChinaQRActivity.this, content);
                imageView.setImageBitmap(mBitmap);
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
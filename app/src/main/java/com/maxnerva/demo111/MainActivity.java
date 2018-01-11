package com.maxnerva.demo111;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Fullscreen
@EActivity(R.layout.activity_main)
@WindowFeature(Window.FEATURE_NO_TITLE)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.this";
    @ViewById(R.id.container)
    LinearLayout container;
    @ViewById(R.id.imageView)
    ImageView imageView;
    @ViewById(R.id.tvjingxi)
    TextView tvjingxi;

    @Click(R.id.invisitTv1)
    public void invisitTv1() {
        container.setVisibility(View.GONE);
        setPic();
    }

    @Background
    public void setPic() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .head()
                .url(Constrants.getUrl())
                .build();
        String string;
        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 200){
                string = "请检查网络连接";
            }else{
                string = "惊喜吧?";

            }
        } catch (Exception e) {
                string = "请检查网络连接";
            e.printStackTrace();
        }
        jingxi(string);
    }

    @org.androidannotations.annotations.UiThread
    public void jingxi(String string){

        System.out.println("daemon" + Thread.currentThread().getName());
        Glide.with(this).load(Constrants.getUrl()).into(imageView);
        tvjingxi.setText(string);
    }
}

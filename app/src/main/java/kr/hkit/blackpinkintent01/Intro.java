package kr.hkit.blackpinkintent01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상태바 사라지게 하기
        //무조건 여기에 적어야한다.
        //contentView를 사용하기 전에 사용
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.intro);

        //액션바 사라지게 하기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
       // getSupportActionBar().hide(); 한줄로 쓰기

        Handler handler = new Handler();
        // delay 시간을 가지는 것 그 후 finish하면됨 근데 스레드 필요
        //왜? 인트로가 나가고 메인 activity가 들어와야하니까
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this, MainActivity.class); //intro에서 main으로 넘김
                startActivity(intent); // 시작

                overridePendingTransition(android.R.anim.fade_in|android.R.anim.slide_in_left,
                        android.R.anim.fade_out|android.R.anim.slide_out_right);
                Intro.this.finish();
            }
        }, 2000);
    }
}

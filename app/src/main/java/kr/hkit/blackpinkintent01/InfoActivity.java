package kr.hkit.blackpinkintent01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        //up button
        //메타데이타를 꼭 넣어줘야한다
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onInfoLayoutClicked(View view){
        InfoActivity.this.finish();
    }
}

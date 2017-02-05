package kr.hkit.blackpinkintent01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;

    boolean isMusicPlayed = false;
    Intent musicIntent;
    ImageView imageMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageMusic = (ImageView) findViewById(R.id.imageMusic);

        //intent를 만들어서 서비스 시작
        musicIntent = new Intent(MainActivity.this, MusicService.class);
        startService(musicIntent);
    }


    //액션바에 아이콘 붙여주는 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //액션바에 붙어있는 아이콘을 클릭했을때 일어나느 이벤트 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent infointent= new Intent(MainActivity.this, InfoActivity.class);
        startActivity(infointent);
        return super.onOptionsItemSelected(item);
    }

    // onClick 속성으로 연결된 메소드
    public void onButtonClicked(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnJisoo:
                intent = new Intent(MainActivity.this, JisooActivity.class);
                break;
            case R.id.btnJennie:
                intent = new Intent(MainActivity.this, JennieActivity.class);
                break;
            case R.id.btnRose:
                intent = new Intent(MainActivity.this, RoseActivity.class);
                break;
            case R.id.btnLisa:
                intent = new Intent(MainActivity.this, LisaActivity.class);
                break;
        }

        if (intent != null)
            startActivity(intent);
    }

    //뒤로 가기 버튼을 눌렀을 때 일어나는 이벤트 메소드
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2000){
            Toast.makeText(getApplicationContext(),"\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
            backKeyPressedTime = System.currentTimeMillis();
            return;
        } else if(System.currentTimeMillis() <= backKeyPressedTime + 2000){
            MainActivity.this.finish();
            stopService(musicIntent);
        }
    }

    //onClick으로 연결된 메소드
    public void onMusicIconClicked(View view) {

        isMusicPlayed = !isMusicPlayed;

        if (isMusicPlayed) {
            imageMusic.setImageResource(R.mipmap.ic_start);
            stopService(musicIntent);
        } else {
            imageMusic.setImageResource(R.mipmap.ic_stop);
            startService(musicIntent);
        }
    }
}
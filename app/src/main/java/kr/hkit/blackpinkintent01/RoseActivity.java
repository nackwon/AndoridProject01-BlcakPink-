package kr.hkit.blackpinkintent01;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RoseActivity extends AppCompatActivity {
    Button btnPrev, btnProfile;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rose);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoseActivity.this.finish();
            }
        });

        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoseActivity.this, RoseProfileActivity.class);
                startActivity(intent);
            }
        });
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    public void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        //먼저 레이아웃부터 붙임
        dialog.setContentView(R.layout.rose_custom_dialog);

        //붙일때 dialog에 붙여야한다 꼭 기억!
        ImageView imageDialog = (ImageView) dialog.findViewById(R.id.imageDialog);
        imageDialog.setBackgroundResource(R.drawable.rose_anim);
        AnimationDrawable roseanim = (AnimationDrawable) imageDialog.getBackground();
        roseanim.start();
        Button btnDialog = (Button) dialog.findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //둘다 똑같다.
                dialog.dismiss();
                //dialog.cancel();
            }
        });
        dialog.show();
    }
}

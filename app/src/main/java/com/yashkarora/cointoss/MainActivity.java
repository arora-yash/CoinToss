package com.yashkarora.cointoss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView iv;

    Random r;
    int side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.flip);
        iv = findViewById(R.id.coin);

        r = new Random();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side = r.nextInt(2);

                if(side == 0) {
                    iv.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "HEADS",Toast.LENGTH_SHORT).show();
                }
                else {
                    iv.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "TAILS", Toast.LENGTH_SHORT).show();
                }

                // For Rotation

                RotateAnimation rotate = new RotateAnimation(0,360,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(1000);
                iv.startAnimation(rotate);
            }
        });
    }
}

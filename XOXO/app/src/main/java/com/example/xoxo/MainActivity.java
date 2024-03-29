package com.example.xoxo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int i=0;
    private ImageButton im1, im2, im3, im4, im5, im6, im7, im8, im9;
    private TextView show;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im1 = (ImageButton) findViewById(R.id.Button1);
        im2 = (ImageButton) findViewById(R.id.Button2);
        im3 = (ImageButton) findViewById(R.id.Button3);
        im4 = (ImageButton) findViewById(R.id.Button4);
        im5 = (ImageButton) findViewById(R.id.Button5);
        im6 = (ImageButton) findViewById(R.id.Button6);
        im7 = (ImageButton) findViewById(R.id.Button7);
        im8 = (ImageButton) findViewById(R.id.Button8);
        im9 = (ImageButton) findViewById(R.id.Button9);
        show = (TextView) findViewById(R.id.showdata);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                im1.setBackgroundResource(R.drawable.white_box);
                im2.setBackgroundResource(R.drawable.white_box);
                im3.setBackgroundResource(R.drawable.white_box);
                im4.setBackgroundResource(R.drawable.white_box);
                im5.setBackgroundResource(R.drawable.white_box);
                im6.setBackgroundResource(R.drawable.white_box);
                im7.setBackgroundResource(R.drawable.white_box);
                im8.setBackgroundResource(R.drawable.white_box);
                im9.setBackgroundResource(R.drawable.white_box);
                im1.setEnabled(true);
                im2.setEnabled(true);
                im3.setEnabled(true);
                im4.setEnabled(true);
                im5.setEnabled(true);
                im6.setEnabled(true);
                im7.setEnabled(true);
                im8.setEnabled(true);
                im9.setEnabled(true);
                show.setText("");
            }
        });
    }

    public void onImageClick(View view) {
        i=i+1;
        if (i % 2 == 0) {
            view.setBackgroundResource(R.drawable.o);

            AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(500);
            view.startAnimation(animation);
            if (i == 9) {
                show.setText("It's a draw!");
                disable();
            }
        } else {
            view.setBackgroundResource(R.drawable.x);
            AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
            animation2.setDuration(500);
            view.startAnimation(animation2);
            if (i == 9) {
                show.setText("It's a Draw!");
                disable();
            }
        }
        view.setEnabled(false);
        logic(view);
    }

    public void logic(View view) {
        ImageView[] images = {im1, im2, im3, im4, im5, im6, im7, im8, im9};

        if (checkWinCondition(images, R.drawable.x)) {
            showx();
            disable();
        } else if (checkWinCondition(images, R.drawable.o)) {
            showo();
            disable();
        }
    }

    private boolean checkWinCondition(ImageView[] images, int drawableId) {
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combination : winCombinations) {
            if (images[combination[0]].getBackground().getConstantState().equals(getResources().getDrawable(drawableId).getConstantState()) &&
                    images[combination[1]].getBackground().getConstantState().equals(getResources().getDrawable(drawableId).getConstantState()) &&
                    images[combination[2]].getBackground().getConstantState().equals(getResources().getDrawable(drawableId).getConstantState())) {
                return true;
            }
        }
        return false;
    }


    private void showo() {

        show.setText("Player O Win");

    }
    private void showx() {

        show.setText("Player X Win");
    }

    

    public void disable() {
        im1.setEnabled(false);
        im2.setEnabled(false);
        im3.setEnabled(false);
        im4.setEnabled(false);
        im5.setEnabled(false);
        im6.setEnabled(false);
        im7.setEnabled(false);
        im8.setEnabled(false);
        im9.setEnabled(false);
    }
}
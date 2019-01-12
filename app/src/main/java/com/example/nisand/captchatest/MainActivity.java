package com.example.nisand.captchatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView i1,i2;
EditText e1,e2;
Button b,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=findViewById(R.id.imageView);
        i2 = findViewById(R.id.imageView2);
        e1=findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b=findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        final TextCaptcha textCaptcha = new TextCaptcha(600, 150, 4, TextCaptcha.TextOptions.LETTERS_ONLY);
        final MathCaptcha mathCaptcha = new MathCaptcha(600, 150, MathCaptcha.MathOptions.PLUS_MINUS);
        i1.setImageBitmap(textCaptcha.getImage());
        i2.setImageBitmap(mathCaptcha.getImage());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textCaptcha.checkAnswer(e1.getText().toString().trim())) {
                    e1.setError("Captcha is not match");
                //    numberOfCaptchaFalse++;
                } else {
                    Log.d("Main", "captcha is match!");
                    Toast.makeText(getApplicationContext(),"match",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

package vyom.com.androidlock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences settings=getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(password.equals("")) {
                    //if there is no password
                    Intent in = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                    startActivity(in);
                    finish();
                }else{
                        //if there is a password
                    Intent in = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(in);
                    finish();

                }
            }
        },2000);
    }
}

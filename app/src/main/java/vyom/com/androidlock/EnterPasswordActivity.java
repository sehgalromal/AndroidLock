package vyom.com.androidlock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText edittext;
    Button button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings=getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        edittext=(EditText)findViewById(R.id.pass_enter);
        button=(Button)findViewById(R.id.button_enter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text=edittext.getText().toString();
                if(text.equals(password)){
                    Intent in=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(in);
                    finish();
                }else{
                    Toast.makeText(EnterPasswordActivity.this,"Wrong password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

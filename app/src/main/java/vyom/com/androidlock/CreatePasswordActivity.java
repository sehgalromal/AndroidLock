package vyom.com.androidlock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText edittext1,edittext2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        edittext1=(EditText)findViewById(R.id.editText1);
        edittext2=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1=edittext1.getText().toString();
                String text2=edittext2.getText().toString();

                if(text1.equals("") || text2.equals("")){
                    //there's no password
                    Toast.makeText(CreatePasswordActivity.this,"No password entered",Toast.LENGTH_SHORT).show();
                }else if(text1.equals(text2)){
                        //save the password
                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor=settings.edit();
                        editor.putString("password",text1);
                        editor.apply();

                        //enter the app
                        Intent in = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(in);
                        finish();
                }else{
                         //there is no match on the passwords
                         Toast.makeText(CreatePasswordActivity.this,"Passwords does not match",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

package joker.persona.ngrocken.androidfirebaseloginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEdtTxt;
    private EditText passwordEdtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView() {
        emailEdtTxt = findViewById(R.id.main_email_edit);
        passwordEdtTxt = findViewById(R.id.main_pass_edit);

        findViewById(R.id.main_login_btn).setOnClickListener(this);

        findViewById(R.id.main_signup_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "HELLO", Toast.LENGTH_SHORT).show();
    }
}

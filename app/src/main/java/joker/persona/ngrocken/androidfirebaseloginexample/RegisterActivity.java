package joker.persona.ngrocken.androidfirebaseloginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEdt;
    private EditText emailEdt;
    private EditText passEdt;
    private EditText confirmEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    private void setUpView() {
        userNameEdt = findViewById(R.id.regis_username_edit);
        emailEdt = findViewById(R.id.regis_email_edit);
        passEdt = findViewById(R.id.regis_password_edit);
        confirmEdt = findViewById(R.id.regis_confirm_edit);

        findViewById(R.id.regis_regis_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}

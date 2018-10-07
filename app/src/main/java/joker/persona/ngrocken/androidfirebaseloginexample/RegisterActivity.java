package joker.persona.ngrocken.androidfirebaseloginexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEdt;
    private EditText emailEdt;
    private EditText passEdt;
    private EditText confirmEdt;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        setUpView();
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
        String password = passEdt.getText().toString().trim();
        String confirm = confirmEdt.getText().toString().trim();
        String email = emailEdt.getText().toString().trim();
        String username = userNameEdt.getText().toString().trim();

        boolean hasError = false;
        if(TextUtils.isEmpty(username)) {
            userNameEdt.setError("Please enter a user .");
            hasError = true;
        }
        if (TextUtils.isEmpty(email)) {
            emailEdt.setError("Please enter an email.");
            hasError = true;
        }
        if(TextUtils.isEmpty(password)) {
            passEdt.setError("Please enter a password.");
            hasError = true;
        }
        if(password != null && !password.equals(confirm)) {
            confirmEdt.setError("Your passwords do not match.");
            hasError = true;
        }
        
        if(hasError) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package com.example.vaibh.gobiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibh.gobiz.pojos.ModuleMapLock;
import com.example.vaibh.gobiz.pojos.User;
import com.example.vaibh.gobiz.utils.DatabaseConnection;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreen extends AppCompatActivity {
    private Button btnSignUp;
    private Button btnSignIn;
    private TextView txtForgotPass;
    private EditText edtEmail, edtPassword;
    private String strEmail, strPass;
    private DatabaseConnection dao;
    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnSignUp = findViewById(R.id.btnSignup);

        edtEmail = findViewById(R.id.edtEmailSignIn);
        edtPassword = findViewById(R.id.edtPasswordSignIn);

        txtForgotPass = findViewById(R.id.txtForgotDetails);

        dao = new DatabaseConnection();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });

        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    VerifyIDPass();
            }
        });


    }

    public void ResetPassword(View v){
        Intent i = new Intent(getApplicationContext(), PasswordReset.class);
        startActivity(i);
    }

    public void VerifyIDPass(){
        strEmail = edtEmail.getText().toString();
        strPass = edtPassword.getText().toString();

        if(strEmail.isEmpty() || strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"EmailID or Password is empty.", Toast.LENGTH_LONG).show();
            return;
        }

        dao.mAuth.signInWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    dao.userAccepted = true;
                    currentUser = new User(dao);
                    Log.d("User Email : ", currentUser.getEmail());
                    ModuleMapLock.getFromDatabase(currentUser.getObjectId());
                    Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(i);
                }
                else{
                    dao.userAccepted = false;
                    currentUser = null;
                    Toast.makeText(getApplicationContext(),"SignIn Error. "+ task.getException(),Toast.LENGTH_LONG).show();
               }
            }
        });



    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
}

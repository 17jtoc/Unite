package com.example.jtoco.unite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    private Button mloginButton;
    private Button mCreateAccountButton;
    private EditText mEmailField;
    private EditText mPasswordField;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);

        mEmailField = findViewById(R.id.emailField);
        mPasswordField = findViewById(R.id.passwordField);
        mloginButton = findViewById(R.id.loginButton);
        mCreateAccountButton = findViewById(R.id.createAccount);
        mAuth = FirebaseAuth.getInstance();

//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                if (firebaseAuth.getCurrentUser() != null) {
//                    Intent goToUserProfile = new Intent(SignIn.this, Movies.class);
//                    startActivity(goToUserProfile);
//                }
//            }
//        };

        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
            }
        });

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAccountCreation = new Intent(SignIn.this, AccountCreation.class);
                startActivity(goToAccountCreation);
            }
        });

    }

    public void startSignIn() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        final ProgressDialog processDialog = ProgressDialog.show(SignIn.this, "Please wait...", "Processing...", true);

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(SignIn.this, "Sign in error, some fields are empty", Toast.LENGTH_LONG).show();

            } else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        processDialog.dismiss();

                        if (!task.isSuccessful()) {

                            Toast.makeText(SignIn.this, "Sign in error, check that you have entered your username and password correctly", Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(SignIn.this, "Sign in error, check that you have entered your username and password correctly", Toast.LENGTH_LONG).show();
                            Intent goToUserProfile = new Intent(SignIn.this, Movies.class);
                            startActivity(goToUserProfile);

                        }
                    }
                });
            }
        }

}

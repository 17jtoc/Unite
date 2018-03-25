package com.example.jtoco.unite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountCreation extends AppCompatActivity {

    private Button mAccountCreationButton;
    private Button mReturnToSignInButton;

    private EditText mUserEmail;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private EditText mFirstName;
    private EditText mLastName;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_creation);

        mAuth = FirebaseAuth.getInstance();

        mFirstName = findViewById(R.id.firstName);
        mLastName = findViewById(R.id.lastName);
        mUserPassword = findViewById(R.id.registerPassword);
        mUserConfirmPassword = findViewById(R.id.registerConfirmPassword);
        mUserEmail = findViewById(R.id.registerEmail);

        mAccountCreationButton = findViewById(R.id.accountCreationButton);
        mReturnToSignInButton = findViewById(R.id.returnToSignInButton);

        mReturnToSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBackToSignIn = new Intent(AccountCreation.this, SignIn.class);
                startActivity(goBackToSignIn);
            }
        });

        mAccountCreationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();
            }
        });
    }

    public void startRegister() {
        String firstName = mFirstName.getText().toString().trim();
        String lastName = mLastName.getText().toString().trim();
        String userEmail = mUserEmail.getText().toString().trim();
        String userPassword = mUserPassword.getText().toString().trim();
        String userConfirmPassword = mUserConfirmPassword.getText().toString().trim();

        final ProgressDialog processDialog = ProgressDialog.show(AccountCreation.this, "Please wait...", "Processing...", true);

        if (!userPassword.equals(userConfirmPassword)) {
            Toast.makeText(AccountCreation.this, "Registration error, passwords do not match", Toast.LENGTH_LONG).show();

        } else {

            if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPassword) || TextUtils.isEmpty(userConfirmPassword)) {

                Toast.makeText(AccountCreation.this, "Registration error, some fields are empty", Toast.LENGTH_LONG).show();

            } else {

                mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        processDialog.dismiss();

                        if (task.isSuccessful()) {
                            String lastName = mLastName.getText().toString().trim();
                            Toast.makeText(AccountCreation.this, "Registration successful!", Toast.LENGTH_LONG).show();

                            Intent goToUserProfile = new Intent(AccountCreation.this, Movies.class);
//                            goToUserProfile.putExtra("First Name", mAuth.getCurrentUser().getDisplayName());
//                            goToUserProfile.putExtra("Last Name", mAuth.getCurrentUser().getEmail());
                            startActivity(goToUserProfile);

                        } else {
                            Toast.makeText(AccountCreation.this, "Something went wrong with the registration process, please try again", Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        }
    }
}

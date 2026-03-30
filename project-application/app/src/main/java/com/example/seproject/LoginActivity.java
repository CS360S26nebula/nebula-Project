package com.example.seproject;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        emailInput = findViewById(R.id.emailEditText);
        passwordInput = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }


            loginUser(email, password);
        });
    }

    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        String userId = mAuth.getCurrentUser().getUid();
                        fetchUserRoleAndRedirect(userId);
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void fetchUserRoleAndRedirect(String userId) {

        db.collection("users").document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        User user = documentSnapshot.toObject(User.class);
                        String role = user.getRole();


                        if ("Guard".equals(role)) {
                            startActivity(new Intent(LoginActivity.this, GuardHomeActivity.class));
                        } else if ("Admin".equals(role)) {
                            startActivity(new Intent(LoginActivity.this, AdminHomeActivity.class));
                        } else if ("Faculty".equals(role)) {
                            startActivity(new Intent(LoginActivity.this, FacultyHomeActivity.class));
                        }
                        finish();
                    } else {
                        Toast.makeText(this, "User data not found in database.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show();
                });
    }
}
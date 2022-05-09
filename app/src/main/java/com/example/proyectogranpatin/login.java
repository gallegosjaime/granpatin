package com.example.proyectogranpatin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button volver = findViewById(R.id.volver);
        Button iniciarSesion = findViewById(R.id.iniciar_sesion);
        EditText correo = findViewById(R.id.et_correo_electronico);
        EditText contrasena = findViewById(R.id.et_contrasena);
        //DocumentReference docRef = db.collection("users").document("jaimeg42001@gmail.com");
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String correo2 = correo.getText().toString();
                //String contra = contrasena.getText().toString();
                //loginUserAccount(correo2,contra);
                startActivity(new Intent(login.this,Menu.class));
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,MainActivity.class));
                finish();
            }
        });
    }

    private void loginUserAccount(String correo, String contrasena)
    {
        mAuth.signInWithEmailAndPassword(correo, contrasena)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Bundle extras = new Bundle();
                                    extras.putString("correo", correo);
                                    Intent intent = (new Intent(login.this,Menu.class));
                                    intent.putExtras(extras);

                                    finish();
                                }
                                else {
                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                            "Usuario o contraseña incorrectos",
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });
    }
}
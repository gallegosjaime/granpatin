package com.example.proyectogranpatin;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.Duration;
import java.util.Map;

public class actividades_consultar extends AppCompatActivity {
    Boolean consultando = false;
    String currentUser;
    TextView paciente;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentUser = getIntent().getExtras().getString("correo");
        setContentView(R.layout.activity_actividades_consultar);
        //Linear layout
        LinearLayout consulta = findViewById(R.id.consulta_actividades);
        LinearLayout buscar = findViewById(R.id.buscar_pacientes);
        //Animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_fade_in);
        //Buttons
        Button volver = findViewById(R.id.volver);
        Button aceptar = findViewById(R.id.eliminar);
        paciente = findViewById(R.id.txt_consulta_paciente);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (consultando) {
                    consulta.clearAnimation();
                    consulta.setVisibility(View.GONE);
                    buscar.setVisibility(View.VISIBLE);
                    buscar.startAnimation(fadeIn);
                    aceptar.setVisibility(View.VISIBLE);
                    consultando = false;
                } else {
                    startActivity(new Intent(actividades_consultar.this, Menu.class));
                    finish();
                }
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar.clearAnimation();
                consulta.setVisibility(View.VISIBLE);
                consulta.startAnimation(fadeIn);
                buscar.setVisibility(View.GONE);
                aceptar.setVisibility(View.GONE);
                consultando = true;
            }

        });
    }

}
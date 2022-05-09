package com.example.proyectogranpatin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class actividades_agregar extends AppCompatActivity {
    EditText curp,actividad,hora,fecha,lugar,duracion;
    String currentUser;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_agregar);
        //currentUser = getIntent().getExtras().getString("correo");
        //EDITEXT
        actividad = findViewById(R.id.et_Actividad);
        curp = findViewById(R.id.et_Curp);
        hora = findViewById(R.id.et_Hora);
        fecha = findViewById(R.id.et_Fecha);
        lugar= findViewById(R.id.et_Lugar);
        duracion = findViewById(R.id.et_Duracion);
        //BUTTON
        Button volver = findViewById(R.id.volver);
        Button registrar = findViewById(R.id.et_Registrar_actividad);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("correo", currentUser);
                Intent intent = (new Intent(actividades_agregar.this,Menu.class));
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarPaciente(curp.getText().toString(), actividad.getText().toString(),hora.getText().toString(),fecha.getText().toString(),lugar.getText().toString(),duracion.getText().toString());
            }
        });


    }
    private void RegistrarPaciente(String curp,String actividad, String hora,String fecha, String lugar, String duracion){
        Map<String, Object> map = new HashMap<>();
        map.put("Actividad", actividad);
        map.put("Hora", hora);
        map.put("Fecha", fecha);
        map.put("Lugar", lugar);
        map.put("Duracion", duracion);
        db.collection("users").document(currentUser).collection(curp).document("Actividades").set(map);
    }
}
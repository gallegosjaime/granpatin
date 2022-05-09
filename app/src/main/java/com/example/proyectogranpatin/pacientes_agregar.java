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

public class pacientes_agregar extends AppCompatActivity {
    EditText nombre, curp, edad, entidad, municipio, tratamiento, alergias;
    String currentUser;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes_agregar);
        //currentUser = getIntent().getExtras().getString("correo");
        //EDITEXT
        nombre = findViewById(R.id.et_Nombre);
        curp = findViewById(R.id.et_Curp);
        edad = findViewById(R.id.et_Edad);
        entidad = findViewById(R.id.et_Entidad);
        municipio = findViewById(R.id.et_Municipio);
        tratamiento = findViewById(R.id.et_Tratamiento);
        alergias = findViewById(R.id.et_Alergias);
        //BUTTON
        Button volver = findViewById(R.id.volver);
        Button registrar = findViewById(R.id.et_Registrar_paciente);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarPaciente(nombre.getText().toString(), curp.getText().toString(), edad.getText().toString(),entidad.getText().toString(),municipio.getText().toString(),tratamiento.getText().toString(),alergias.getText().toString());
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("correo", currentUser);
                Intent intent = (new Intent(pacientes_agregar.this,Menu.class));
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });

    }
    private void RegistrarPaciente(String nombre,String curp, String edad, String  entidad, String municipio, String tratamiento,String alergias){
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre", nombre);
        map.put("Edad", edad);
        map.put("Entidad", entidad);
        map.put("Municipio", municipio);
        map.put("Tratamiento", tratamiento);
        map.put("Alergias", alergias);
        db.collection("users").document(currentUser).collection(curp).document("Pacientes").set(map);
    }
}
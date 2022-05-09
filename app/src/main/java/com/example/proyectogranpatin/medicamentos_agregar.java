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

public class medicamentos_agregar extends AppCompatActivity {
    EditText nombre, curp, cantidad,tipo,frecuencia;
    String currentUser;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos_agregar);
        //currentUser = getIntent().getExtras().getString("correo");
        //EDITEXT
        nombre = findViewById(R.id.et_Nombre);
        curp = findViewById(R.id.et_Curp);
        cantidad = findViewById(R.id.et_Cantidad);
        tipo= findViewById(R.id.et_Tipo);
        frecuencia = findViewById(R.id.et_Frecuencia);
        //BUTTON
        Button registrar = findViewById(R.id.et_Registar_medicamento);
        Button volver = findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("correo", currentUser);
                Intent intent = (new Intent(medicamentos_agregar.this,Menu.class));
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarPaciente(nombre.getText().toString(), curp.getText().toString(), cantidad.getText().toString(),tipo.getText().toString(),frecuencia.getText().toString());
            }
        });
    }
    private void RegistrarPaciente(String nombre,String curp, String cantidad, String  tipo, String frecuencia){
        Map<String, Object> map = new HashMap<>();
        map.put("Medicina", nombre);
        map.put("Cantidad", cantidad);
        map.put("Tipo de medicina", tipo);
        map.put("Frecuencia", frecuencia);
        db.collection("users").document(currentUser).collection(curp).document("Medicamentos").set(map);
    }
}
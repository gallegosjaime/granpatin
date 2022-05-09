package com.example.proyectogranpatin;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.textclassifier.ConversationActions;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SingUp extends AppCompatActivity {
    //Variables para almacenar datos de los fragmentos y validarlos
    String Correo;
    String Nombre;
    String ApellidoP;
    String ApellidoM;
    String Contraseña;
    String ConfirmarContraseña;
    String Cedula;
    String Institucion;
    String Telefono;
    String Especialidad;
    String Edad;
    String Direccion;
    String SegundoFamiliarNombre;
    String SegundoFamiliarTelefono;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sing_up);
        //buttons
        Button siguiente = findViewById(R.id.Registro_siguiente);
        Button anterior = findViewById(R.id.Registro_anterior);
        Button enviar = findViewById(R.id.Registro_finalizar);
        Button volver = findViewById(R.id.Registro_volver);
        //Animations
        Animation fromDown = AnimationUtils.loadAnimation(this,R.anim.anim_enter_from_down);
        Animation toDown = AnimationUtils.loadAnimation(this,R.anim.anim_exit_to_down);
        //LLamar al fragment1
        FragmentManager fm = getSupportFragmentManager();
        fragment_campos fragment = (fragment_campos) fm.findFragmentById(R.id.fragment1);
        //LLamar al fragment2
        fragment_campos2 fragment2 = (fragment_campos2) fm.findFragmentById(R.id.fragment2);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtener datos del primer formulario ubicado en el fragment 1
                Correo = fragment.Correo();
                Nombre = fragment.Nombre();
                ApellidoP = fragment.ApellidoP();
                ApellidoM = fragment.ApellidoM();
                Contraseña = fragment.Contraseña();
                ConfirmarContraseña = fragment.ConfirmarContraseña();
                //Aparecer siguiente formulario
                anterior.startAnimation(fromDown);
                anterior.setEnabled(true);
                siguiente.setVisibility(View.GONE);
                enviar.setVisibility(view.VISIBLE);
                nextFragment(new fragment_campos2());
            }
        });
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anterior.setEnabled(false);
                anterior.startAnimation(toDown);
                enviar.setVisibility(View.GONE);
                siguiente.setVisibility(view.VISIBLE);
                previousFragment(new fragment_campos());
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtener los datos que están en el fragment 2
                if(fragment2.EsEnfermero()){
                    Cedula = fragment2.Cedula();
                    Institucion = fragment2.Institucion();
                    Telefono = fragment2.Telefono();
                    Especialidad = fragment2.Especialidad();
                    CrearUsuario();
                    CrearRegistroEnfermero();
                }
                else{
                    Edad= fragment2.Edad();
                    Direccion = fragment2.Direccion();
                    SegundoFamiliarNombre = fragment2.SegundoFamiliarNombre();
                    SegundoFamiliarTelefono = fragment2.SegundoFamiliarTelefono();
                    CrearUsuario();
                    CrearRegistroFamiliar();
                }
                Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_SHORT).show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingUp.this,MainActivity.class));
                finish();
            }
        });

    }
    private void CrearUsuario(){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(Correo, Contraseña);
    }
    private void CrearRegistroEnfermero(){
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre", Nombre);
        map.put("Apellido Paterno", ApellidoP);
        map.put("Apellido Materno", ApellidoM);
        map.put("Cedula", Cedula);
        map.put("Institucion", Institucion);
        map.put("Telefono", Telefono);
        map.put("Especialidad", Especialidad);
        db.collection("users").document(Correo).set(map);
    }
    private void CrearRegistroFamiliar(){
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre", Nombre);
        map.put("Apellido Paterno", ApellidoP);
        map.put("Apellido Materno", ApellidoM);
        map.put("Edad", Edad);
        map.put("Direccion", Direccion);
        map.put("Familiar alternativo", SegundoFamiliarNombre);
        map.put("Telefono del familiar", SegundoFamiliarTelefono);
        db.collection("users").document(Correo).set(map);
    }
    private void nextFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    private void previousFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations( R.anim.anim_enter_from_left, R.anim.anim_exit_to_right);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}

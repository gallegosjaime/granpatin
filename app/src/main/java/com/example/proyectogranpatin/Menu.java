package com.example.proyectogranpatin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {
    //variables globales
    String botonSeleccionado = "hola";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String currentUser = getIntent().getExtras().getString("correo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //TextView
        TextView titulo = findViewById(R.id.Menu_titulo);
        //buttons
        Button pacientes = findViewById(R.id.Menu_pacientes);
        Button actividades = findViewById(R.id.Menu_actividades);
        Button medicamentos = findViewById(R.id.Menu_medicamentos);
        Button opciones = findViewById(R.id.Menu_opciones);
        Button agregar = findViewById(R.id.Menu_agregar);
        Button consultar = findViewById(R.id.Menu_consultar);
        Button cerrarSesion = findViewById(R.id.Menu_cerrar_sesion);
        //animations
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.anim_fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this,R.anim.anim_fade_out);
        pacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titulo.getVisibility()==View.GONE) QuitarInstruccion();
                if (agregar.getVisibility()==View.GONE) RevertirBotones();
                titulo.startAnimation(fadeOut);
                titulo.setText("Pacientes");
                titulo.startAnimation(fadeIn);
                botonSeleccionado = "pacientes";
            }
        });
        actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titulo.getVisibility()==View.GONE) QuitarInstruccion();
                if (agregar.getVisibility()==View.GONE) RevertirBotones();
                titulo.startAnimation(fadeOut);
                titulo.setText("Actividades");
                titulo.startAnimation(fadeIn);
                botonSeleccionado = "actividades";
            }
        });
        medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titulo.getVisibility()==View.GONE) QuitarInstruccion();
                if (agregar.getVisibility()==View.GONE) RevertirBotones();
                titulo.startAnimation(fadeOut);
                titulo.setText("Medicamentos");
                titulo.startAnimation(fadeIn);
                botonSeleccionado = "medicamentos";
            }
        });
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titulo.getVisibility()==View.GONE) QuitarInstruccion();
                titulo.startAnimation(fadeOut);
                titulo.setText("Opciones");
                titulo.startAnimation(fadeIn);
                botonSeleccionado = "opciones";
                consultar.setVisibility(View.GONE);
                agregar.setVisibility(View.GONE);
                cerrarSesion.setVisibility(View.VISIBLE);
            }
        });
         /*
        consultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(botonSeleccionado.equals("pacientes")){
                    Bundle extras = new Bundle();
                    extras.putString("correo", currentUser);
                    Intent intent = (new Intent(Menu.this,pacientes_consultar.class));
                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();
                }
                if(botonSeleccionado.equals("actividades")){
                    Bundle extras = new Bundle();
                    extras.putString("correo", currentUser);
                    Intent intent = (new Intent(Menu.this,actividades_consultar.class));
                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();
                }
                if(botonSeleccionado.equals("medicamentos")){
                    Bundle extras = new Bundle();
                    extras.putString("correo", currentUser);
                    Intent intent = (new Intent(Menu.this,medicamentos_consultar.class));
                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();
                }
            }


        });

          */
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(botonSeleccionado.equals("pacientes")){
                    //Bundle extras = new Bundle();
                    //extras.putString("correo", currentUser);
                    startActivity(new Intent(Menu.this,pacientes_agregar.class));
                    //Intent intent = (new Intent(Menu.this,pacientes_agregar.class));
                    //intent.putExtras(extras);
                    //startActivity(intent);
                    finish();
                }
                if(botonSeleccionado.equals("actividades")){
                    //Bundle extras = new Bundle();
                    //extras.putString("correo", currentUser);
                    startActivity(new Intent(Menu.this,actividades_agregar.class));
                    //Intent intent = (new Intent(Menu.this,actividades_agregar.class));
                    //intent.putExtras(extras);
                    //startActivity(intent);
                    finish();
                }
                if(botonSeleccionado.equals("medicamentos")){
                    //Bundle extras = new Bundle();
                    //extras.putString("correo", currentUser);
                    startActivity(new Intent(Menu.this,medicamentos_agregar.class));
                    //Intent intent = (new Intent(Menu.this,medicamentos_agregar.class));
                    //intent.putExtras(extras);
                    //startActivity(intent);
                    finish();
                }
            }
        });
        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this,login.class));
                finish();
            }
        });
    }
    public void RevertirBotones(){
        Button agregar = findViewById(R.id.Menu_agregar);
        //Button consultar = findViewById(R.id.Menu_consultar);
        Button cerrarSesion = findViewById(R.id.Menu_cerrar_sesion);
        //consultar.setVisibility(View.VISIBLE);
        agregar.setVisibility(View.VISIBLE);
        cerrarSesion.setVisibility(View.GONE);
    }
    public void QuitarInstruccion(){
        TextView instruccion = findViewById(R.id.Menu_instruccion);
        TextView titulo = findViewById(R.id.Menu_titulo);
        instruccion.setVisibility(View.GONE);
        titulo.setVisibility(View.VISIBLE);
    }
}
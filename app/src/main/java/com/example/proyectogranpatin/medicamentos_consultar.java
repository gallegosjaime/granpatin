package com.example.proyectogranpatin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class medicamentos_consultar extends AppCompatActivity {
    boolean consultando = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos_consultar);
        //Linear layout
        LinearLayout consulta = findViewById(R.id.consultar_medicamento);
        LinearLayout buscar = findViewById(R.id.buscar_pacientes);
        //Animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_fade_in);
        //Button
        Button aceptar = findViewById(R.id.aceptar_busqueda);
        Button volver = findViewById(R.id.volver);
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
                }
                else{
                    startActivity(new Intent(medicamentos_consultar.this,Menu.class));
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
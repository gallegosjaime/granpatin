package com.example.proyectogranpatin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.function.Function;

public class fragment_campos2 extends Fragment {
    static View view;

    //Variables para retornar valores al activity SingUp
    public static String cedula;
    public static boolean EsEnfermero;
    public static String institucion;
    public static String telefono;
    public static String especialidad;
    public static String edad;
    public static String direccion;
    public static String segundoFamiliarNombre;
    public static String segundoFamiliarTelefono;

    //Metodos que son llamados desde el activity SingUp para obtener la informacion de los EditText almacenados en las variables anteriores
    public static boolean EsEnfermero(){
        return EsEnfermero;
    }
    public static String Cedula(){
        return cedula;
    }
    public static String Institucion(){
        return institucion;
    }
    public static String Telefono(){
        return telefono;
    }
    public static String Especialidad(){
        return especialidad;
    }
    public static String Edad(){
        return edad;
    }
    public static String Direccion(){
        return direccion;
    }
    public static String SegundoFamiliarNombre(){
        return segundoFamiliarNombre;
    }
    public static String SegundoFamiliarTelefono(){
        return segundoFamiliarTelefono;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_campos2, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiobox);
        //EditText      Ed=editText
        EditText EdCedula = getView().findViewById(R.id.et_cedula);
        EditText EdInstitucion = getView().findViewById(R.id.et_institucion);
        EditText EdTelefono = getView().findViewById(R.id.et_telefono);
        EditText EdEspecialidad = getView().findViewById(R.id.et_especialidad);
        EditText EdEdad = getView().findViewById(R.id.et_edad);
        EditText EdDireccion = getView().findViewById(R.id.et_direccion);
        EditText EdSegundoFamiliarNombre = getView().findViewById(R.id.et_segundo_contacto_nombre);
        EditText EdSegundoFamiliarTelefono = getView().findViewById(R.id.et_segundo_contacto_telefono);

        //Cuando se introduce texto se guardarán los datos en las variables static para luego retornarlas
        EdCedula.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
               cedula= EdCedula.getText().toString() ;
            }
        });
        EdInstitucion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                institucion= EdInstitucion.getText().toString();
            }
        });
        EdTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                telefono= EdTelefono.getText().toString() ;
            }
        });
        EdEspecialidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                especialidad=EdEspecialidad.getText().toString() ;
            }
        });
        EdEdad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                edad= EdEdad.getText().toString() ;
            }
        });
        EdDireccion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                direccion= EdDireccion.getText().toString() ;
            }
        });
        EdSegundoFamiliarNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                segundoFamiliarNombre= EdSegundoFamiliarNombre.getText().toString() ;
            }
        });
        EdSegundoFamiliarTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                segundoFamiliarTelefono= EdSegundoFamiliarTelefono.getText().toString() ;
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                LinearLayout familiar  = view.findViewById(R.id.campos_familiar);
                LinearLayout enfermero = view.findViewById(R.id.campos_enfermero);
                RadioButton Rbutton = view.findViewById(checkedId);
                String selected = String.valueOf(Rbutton.getText());
                if (selected.equals("Enfermero")){
                    enfermero.setVisibility(View.VISIBLE);
                    familiar.setVisibility(View.GONE);
                    EsEnfermero = true;
                }
                else{
                    familiar.setVisibility(View.VISIBLE);
                    enfermero.setVisibility(View.GONE);
                    EsEnfermero = false;
                }
            }
        });

    }


}
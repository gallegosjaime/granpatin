package com.example.proyectogranpatin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

public class fragment_campos extends Fragment {
    View view;
    public static String correo;
    public static String nombre;
    public static String apellidoP;
    public static String apellidoM;
    public static String contraseña;
    public static String confirmarContraseña;

    //Metodos que son llamados desde el activity SingUp para obtener la informacion de los EditText almacenados en las variables anteriores
    public static String Correo(){
        return correo;
    }
    public static String Nombre(){
        return nombre;
    }
    public static String ApellidoP(){
        return apellidoP;
    }
    public static String ApellidoM(){
        return apellidoM;
    }
    public static String Contraseña(){
        return contraseña;
    }
    public static String ConfirmarContraseña(){
        return confirmarContraseña;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_campos, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiobox);
        //EditText      Ed=editText
        EditText EdCorreo = getView().findViewById(R.id.et_correo);
        EditText EdNombre = getView().findViewById(R.id.et_nombre);
        EditText EdApellidoP = getView().findViewById(R.id.et_apellidoP);
        EditText EdApellidoM = getView().findViewById(R.id.et_apellidoM);
        EditText EdContraseña = getView().findViewById(R.id.et_contraseña);
        EditText EdConfirmarContraseña = getView().findViewById(R.id.et_confirmarContraseña);
        //Cuando se introduce texto se guardarán los datos en las variables static para luego retornarlas
        EdCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                correo= EdCorreo.getText().toString() ;
            }
        });
        EdNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                nombre= EdNombre.getText().toString() ;
            }
        });
        EdApellidoP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                apellidoP= EdApellidoP.getText().toString() ;
            }
        });
        EdApellidoM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
               apellidoM= EdApellidoM.getText().toString() ;
            }
        });
        EdContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                contraseña= EdContraseña.getText().toString() ;
            }
        });
        EdConfirmarContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                confirmarContraseña= EdConfirmarContraseña.getText().toString() ;
            }
        });
    }
}
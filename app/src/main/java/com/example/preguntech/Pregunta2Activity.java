package com.example.preguntech;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pregunta2Activity extends AppCompatActivity {

    private int puntajeAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup grupo = findViewById(R.id.grupoOpciones2);
        Button btnResponder2 = findViewById(R.id.btnResponder2);
        puntajeAnterior = getIntent().getIntExtra("PUNTAJE", 0);
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            finish();
        });

        btnResponder2.setOnClickListener(v -> {
            int seleccion = grupo.getCheckedRadioButtonId();
            int seleccionUsuario = -1;

            if (seleccion == R.id.op4) {
                seleccionUsuario = 0;
            } else if (seleccion == R.id.op5) {
                seleccionUsuario = 1;
            } else if (seleccion == R.id.op6) {
                seleccionUsuario = 2;
            }

            if (seleccionUsuario == -1) {
                Toast.makeText(this, "Seleccioná una opción", Toast.LENGTH_SHORT).show();
                return;
            }
            if (seleccionUsuario == 0) {
                puntajeAnterior++;
            }
            Intent intent = new Intent(Pregunta2Activity.this, Pregunta3Activity.class);
            intent.putExtra("PUNTAJE", puntajeAnterior);
            startActivity(intent);
            finish();
        });

    }
}
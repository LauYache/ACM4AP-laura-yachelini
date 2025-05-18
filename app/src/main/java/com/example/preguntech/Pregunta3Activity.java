package com.example.preguntech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pregunta3Activity extends AppCompatActivity {
    private int puntajeAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            finish();
        });

        puntajeAnterior = getIntent().getIntExtra("PUNTAJE", 0);
        RadioGroup grupo = findViewById(R.id.grupoOpciones3);
        Button btnResponder = findViewById(R.id.btnResponder3);

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seleccion = grupo.getCheckedRadioButtonId();
                int seleccionUsuario = -1;

                if (seleccion == R.id.op10) seleccionUsuario = 0;
                else if (seleccion == R.id.op11) seleccionUsuario = 1;
                else if (seleccion == R.id.op12) seleccionUsuario = 2;

                if (seleccionUsuario == -1) {
                    Toast.makeText(Pregunta3Activity.this, "Seleccioná una opción", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (seleccionUsuario == 0) {
                    puntajeAnterior++;
                }

                Intent intent = new Intent(Pregunta3Activity.this, ResultadoActivity.class);
                intent.putExtra("PUNTAJE_FINAL", puntajeAnterior);
                startActivity(intent);
                finish();
            }
        });
    }
}
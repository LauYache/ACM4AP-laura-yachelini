package com.example.preguntech;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int puntajeFinal = getIntent().getIntExtra("PUNTAJE_FINAL", 0);
        TextView txtResultado = findViewById(R.id.txtResultado);
        txtResultado.setText("Tu puntaje fue: " + puntajeFinal + " de 3");

        Button btnReiniciar = findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(v -> {
            Intent intent = new Intent(ResultadoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        String mensajeFinal;
        if (puntajeFinal == 3) {
            mensajeFinal = "Perfecto, crack";
        } else if (puntajeFinal == 2) {
            mensajeFinal = "Esta mal, pero no tan mal...";
        } else {
            mensajeFinal = "Ups, puede fallar.";
        }

        txtResultado.setText("Tu puntaje fue: " + puntajeFinal + " de 3\n" + mensajeFinal);
    }
}
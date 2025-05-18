package com.example.preguntech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JuegoActivity extends AppCompatActivity {
    private int puntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView saludo = findViewById(R.id.txtSaludo);
        String nombre = getIntent().getStringExtra("NOMBRE_USUARIO");
        saludo.setText("Bienvenido, " + nombre );

        RadioGroup grupo = findViewById(R.id.grupoOpciones);
        Button btnResponder = findViewById(R.id.btnResponder);
        puntaje = 0;

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            finish();
        });

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seleccion = grupo.getCheckedRadioButtonId();
                int seleccionUsuario = -1;
                if (seleccion == R.id.op1) seleccionUsuario = 0;
                else if (seleccion == R.id.op2) seleccionUsuario = 1;
                else if (seleccion == R.id.op3) seleccionUsuario = 2;

                if (seleccionUsuario == -1) {
                    Toast.makeText(JuegoActivity.this, "Seleccioná una opción", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (seleccionUsuario == 0) {
                    puntaje++;
                }

                Intent intent = new Intent(JuegoActivity.this, Pregunta2Activity.class);
                intent.putExtra("PUNTAJE", puntaje);
                startActivity(intent);
                finish();
            }
        });

    }
}
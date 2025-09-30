package com.example.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText peso;
    EditText estatura;
    Button calcular;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    peso=findViewById(R.id.peso);
    estatura=findViewById(R.id.estatura);
    calcular=findViewById(R.id.calcula);
    result=findViewById(R.id.result);

    calcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double kg=Double.parseDouble(peso.getText().toString());
            double mts=Double.parseDouble(estatura.getText().toString());
            //imc = peso / estatura^2
            double imc = kg/Math.pow(mts,2);
            result.setText(String.valueOf(imc));
        }
    });
    }
}
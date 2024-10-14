package com.seuusuario.appcalculoidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDia, editTextMes, editTextAno;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes da interface
        editTextDia = findViewById(R.id.editTextDia);
        editTextMes = findViewById(R.id.editTextMes);
        editTextAno = findViewById(R.id.editTextAno);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurando o evento de clique no botão "Calcular"
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIdade();
            }
        });
    }

    private void calcularIdade() {
        try {
            // Obtendo o dia, mês e ano de nascimento
            int dia = Integer.parseInt(editTextDia.getText().toString());
            int mes = Integer.parseInt(editTextMes.getText().toString());
            int ano = Integer.parseInt(editTextAno.getText().toString());

            // Obtendo a data atual
            LocalDate dataAtual = LocalDate.now();

            // Criando a data de nascimento a partir das entradas do usuário
            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

            // Calculando a diferença (idade) entre a data atual e a data de nascimento
            Period periodo = Period.between(dataNascimento, dataAtual);

            // Exibindo a idade em anos, meses e dias
            textViewResultado.setText(String.format("Idade: %d anos, %d meses, %d dias",
                    periodo.getYears(), periodo.getMonths(), periodo.getDays()));

        } catch (Exception e) {
            textViewResultado.setText("Por favor, insira uma data válida.");
        }
    }
}

package com.example.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");

    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");

    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada(String opcoaSelecionada) {

        ImageView resultado = findViewById(R.id.resultado);
        TextView textoResultado = findViewById(R.id.textResultadado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];


        switch (opcaoApp) {
            case "pedra":
                resultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                resultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                resultado.setImageResource(R.drawable.tesoura);
                break;

        }


        // app ganhador

        if(
                (opcaoApp == "tesoura" && opcoaSelecionada == "papel") ||
                (opcaoApp == "papel" && opcoaSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcoaSelecionada == "tesoura")
        ){
            textoResultado.setText("Você Perdeu!!");

        // Usuario ganha
        }else if(
                (opcoaSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcoaSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcoaSelecionada == "pedra" && opcaoApp == "tesoura")
        ){
            textoResultado.setText("Você Ganhou :)");
            //Empate
        }else{
            textoResultado.setText("Empatamos");

        }

        System.out.println("Item clicado: " + opcoaSelecionada);


    }


}
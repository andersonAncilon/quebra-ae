package topstermidster.quebraae;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class TelaPrincipal extends AppCompatActivity implements Serializable {

    private ArrayList<String> textoClaroArray = new ArrayList<>();
    private ArrayList<String> textoClaroCp = new ArrayList<>();
    private ArrayList<Integer> posicoes = new ArrayList<>();

    private EditText textoClaro ;
    private Button cifra;

    private String cifrado = "";
    private String chave = "";

    private final int initial = 32;
    private final int qtd = 127;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);


        final EditText textoClaro = (EditText) findViewById(R.id.textoClaro);
        Button cifrar = (Button) findViewById(R.id.cifrar);



        cifrar.setOnClickListener(
                view -> {
                    Intent i = new Intent(this.getApplicationContext(), TelaDecriptografar.class);
                    final ArrayList<Integer> key = new ArrayList<>();

                    cifrado = "";
                    criptografar(textoClaro.getText().toString());

                    int r = random();

                    for (int j = 0; j < textoClaroArray.size(); j++) {
                        char caractere = textoClaroArray.get(j).charAt(0);
                        int valor = (char) caractere;
                        key.add(j, valor * r);
                    }

                    key.add(r);
                    textoClaroArray.clear();

                    Log.v("teste", "teste" + r);

                    textoClaroArray.clear();
                    i.putExtra("cifrado",cifrado);
                    i.putExtra("key", key);
                    textoClaro.setText("");
                    startActivity(i);

                });
    }


    //Método para iniciar a criptografia
    public void criptografar(String textoClaro) {
        contagemCaracteres(textoClaro);
    }


    //Método que gera um valor aleatorio entre 1 e 4 para utilizar na chave
    public int random() {
        Random rand = new Random();
        int r = rand.nextInt(3) + 2;

        return r;
    }

    /*Método responsável por fazer o cálculo do valor decimal do caractere
      com o resultado do fatorial, além de realizar um loop para encontrar o novo
      valor do respectivo caractere
     */
    public String somatorio(String fatorial, String decimal) {

        char decimalAscii = decimal.charAt(0);
        int decimalAsciiInteiro = (int) decimalAscii;

        int posicoes = Integer.parseInt(fatorial) + decimalAsciiInteiro;
        int somatorio = 32;

        for(int i = initial; i < posicoes; i++) {
            somatorio++;
            if(somatorio == qtd)
                somatorio = 32;

        }

        return Integer.toString(somatorio);
    }


    /*Método responsável pela contagem dos caracteres repetidos
      assim como armazena em um ArrayList de inteiros as posições das respectivas
      repetições
    */
    public void contagemCaracteres(String textoClaro) {

        int qtd = 0;

        for (int i = 0; i < textoClaro.length(); i++) {
            textoClaroArray.add(String.valueOf(textoClaro.toString().charAt(i)));
            textoClaroCp.add(String.valueOf(textoClaro.toString().charAt(i)));
        }

        for (int i = 0; i <= textoClaroArray.size(); i++) {
            qtd = 2;

            for (int j = i; j < textoClaroCp.size(); j++) {
                if ( textoClaroCp.get(j).equals(textoClaroArray.get(i)) && textoClaroArray.get(i) != " " ) {
                    posicoes.add(j);
                }
            }

            for (int k = 0; k < posicoes.size(); k++ ) {
                    if(posicoes.size() > 0) {
                        textoClaroCp.set(posicoes.get(k),  somatorio(fatorial(qtd), textoClaroCp.get(posicoes.get(k))));
                        //textoClaroArray.set(posicoes.get(k),  textoClaroCp.get(posicoes.get(k)));
                        int charInteiro = Integer.parseInt(textoClaroCp.get(posicoes.get(k)));
                        char caractere = (char) charInteiro;
                        textoClaroCp.set(posicoes.get(k), String.valueOf(caractere));
                        qtd++;
                    }
            }

            posicoes.clear();
        }
        Log.v("contagem","posicoes" + textoClaroCp);

        cifrado = textoClaroCp.toString();
        textoClaroCp.clear();
    }

    //Método para calcular o fatorial
    public String fatorial(int qtd) {
        int fat = 1;

        for( int i = 2; i <= qtd; i++ )
        {
            fat *= i;
        }

        return Integer.toString(fat);
    }
}

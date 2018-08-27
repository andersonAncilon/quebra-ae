package topstermidster.quebraae;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TelaPrincipal extends AppCompatActivity {

    private ArrayList<String> textoClaroArray = new ArrayList<>();
    private ArrayList<String> textoClaroCp = new ArrayList<>();
    private ArrayList<Integer> posicoes = new ArrayList<>();

    private EditText textoClaro ;
    private Button cifra;
    private TextView textoCifrado;
    private String cifrado = "";
    private String chave;

    private final int qtd = 128;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        final EditText textoClaro = (EditText) findViewById(R.id.textoClaro);
        Button cifrar = (Button) findViewById(R.id.cifrar);
        final TextView textoCifrado = (TextView) findViewById(R.id.cifrado);


        cifrar.setOnClickListener(
                view -> {
                    cifrado = "";
                    criptografar(textoClaro.getText().toString());
                    textoCifrado.setText(cifrado);

                });
    }

    public void criptografar(String textoClaro) {
        contagemCaracteres(textoClaro);
    }

    public String somatorio(String fatorial, String decimal) {

        char decimalAscii = decimal.charAt(0);
        int decimalAsciiInteiro = (int) decimalAscii;

        int posicoes = Integer.parseInt(fatorial) + decimalAsciiInteiro;
        int somatorio = 0;

        for(int i = 0; i < posicoes; i++) {

            if(somatorio == qtd)
                somatorio = 0;

            somatorio++;

        }

        return Integer.toString(somatorio);
    }



    public void contagemCaracteres(String textoClaro) {

        int qtd = 0;

        for (int i = 0; i < textoClaro.length(); i++) {
            textoClaroArray.add(String.valueOf(textoClaro.toString().charAt(i)));
            textoClaroCp.add(String.valueOf(textoClaro.toString().charAt(i)));

        }

        for (int i = 0; i <= textoClaroArray.size(); i++) {
            //posicoes.add(i);
            qtd = 2;

            for (int j = i; j < textoClaroCp.size(); j++) {
                if ( textoClaroCp.get(j).equals(textoClaroArray.get(i)) ) {
                    posicoes.add(j);
                }
            }

            for (int k = 0; k < posicoes.size(); k++ ) {
                    if(posicoes.size() > 0) {
                        textoClaroCp.set(posicoes.get(k),  somatorio(fatorial(qtd), textoClaroCp.get(posicoes.get(k))));

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
        //textoCifrado.setText(tex);
    }

    public String fatorial(int qtd) {
        int fat = 1;

        for( int i = 2; i <= qtd; i++ )
        {
            fat *= i;
        }

        return Integer.toString(fat);
    }







}

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

    EditText textoClaro ;
    Button cifra;
    TextView textoCifrado;
    private String cifrado = "";
    private String chave;

    final int qtd = 127;


    public void criptografar(String textoClaro) {

       /* for(int i = 0; i < textoClaro.length(); i++) {
            char caractere = textoClaro.charAt(i);
            int decimal = (int) caractere;

            //Log.v("valor", " decimal" + decimal + " Na posicao: " + i );
            chave += (int) caractere + ";";

            if(decimal != 32)
                decimal = decimal + 3;
            cifrado += (char) decimal;
        }*/
        contagemCaracteres(textoClaro);
    }


    public String contagemCaracteres(String textoClaro) {
        ArrayList<String> textoClaroArray = new ArrayList<>();
        ArrayList<String> textoClaroCp = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();

        for (int i = 0; i < textoClaro.length(); i++) {
            textoClaroArray.add(String.valueOf(textoClaro.toString().charAt(i)));
            textoClaroCp.add(String.valueOf(textoClaro.toString().charAt(i)));
           // Log.v("contagem", "array" + textoClaroArray);
        }

        //textoClaroCp = textoClaroArray;
        //System.arrtextoClaroArray, 0, textoClaroCp, 0, textoClaroArray.size());

        for (int i = 0; i < textoClaroArray.size(); i++) {
            //posicoes.add(i);
            for (int j = i; j < textoClaroCp.size(); j++) {
                if ( textoClaroCp.get(j).equals(textoClaroArray.get(i)) ) {
                    posicoes.add(j);

                    //textoClaroCp.indexOf(textoClaroArray.get(i));
                    //Log.v("contagem","vetor1: " + textoClaroArray.get(i) + "/ vetor2:" + textoClaroCp.get(j));
                }

                for (int k = 0; k < textoClaroCp.size(); k++ ) {
                    if ( textoClaroCp.get(j).equals(textoClaroArray.get(i)) ) {
                        textoClaroCp.set(j, Integer.toString(j + 1) );
                    }
                }
            }
            Log.v("contagem","posicoes" + posicoes);
            posicoes.clear();
        }


        return "";
    }


    public int fatorial(int qtd) {
        int fat = 1;

        for( int i = 2; i <= qtd; i++ )
        {
            fat *= i;
        }

        return fat;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        final EditText textoClaro = (EditText) findViewById(R.id.textoClaro);
        Button cifrar = (Button) findViewById(R.id.cifrar);
        final TextView textoCifrado = (TextView) findViewById(R.id.cifrado);


        cifrar.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        criptografar(textoClaro.getText().toString());
                        textoCifrado.setText(cifrado);
                        cifrado = "";
                    }
                });
    }




}

package topstermidster.quebraae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
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
        Map<Character, Integer> mapaLetras = new HashMap<Character, Integer>();

        char arr[] = textoClaro.toCharArray();

        for( char letra: arr) {
            if (!mapaLetras.containsValue(letra)) {
                mapaLetras.put(letra, 0);
            }

            mapaLetras.put(letra, mapaLetras.get(letra) + 1);
        }

        Iterator<Integer> itr = mapaLetras.values().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


        return "";
    }




    public void fatorial(int qtd) {
        int fat = 1;

        for( int i = 2; i <= qtd; i++ )
        {
            fat *= i;
        }
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

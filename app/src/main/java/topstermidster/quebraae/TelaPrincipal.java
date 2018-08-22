package topstermidster.quebraae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TelaPrincipal extends AppCompatActivity {

    EditText textoClaro ;
    Button cifra;
    TextView textoCifrado;
    private String cifrado = "";
    private String chave;

    public void criptografar(String textoClaro) {

        for(int i = 0; i < textoClaro.length(); i++) {
            char caractere = textoClaro.charAt(i);
            int decimal = (int) caractere;

            Log.v("valor", " decimal" + decimal + " Na posicao: " + i );
            chave += (int) caractere + ";";

            if(decimal != 32)
                decimal = decimal + 3;
            cifrado += (char) decimal;
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

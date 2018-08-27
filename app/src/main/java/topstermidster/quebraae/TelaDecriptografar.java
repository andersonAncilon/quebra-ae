package topstermidster.quebraae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TelaDecriptografar extends AppCompatActivity {

    private TextView criptografado;
    private TextView decriptografado;
    private Button decrip;

    private ArrayList<Integer> key;
    private ArrayList<String> dec;
    private String definKey = "";
    private int r = 0;

    public String stringFormat(String texto) {

        String formatada = texto.substring(1, texto.length() - 1);

        return formatada;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_decriptografar);
        Bundle b = getIntent().getExtras();

        criptografado = (TextView) findViewById(R.id.textoEncriptado);
        decriptografado = (TextView) findViewById(R.id.textoDescriptado);
        decrip = (Button) findViewById(R.id.decriptar);

        decriptografado.setVisibility(View.INVISIBLE);

        dec = new ArrayList<>();

        String crip = b.getString("cifrado");

        criptografado.setText(stringFormat(crip));

        if (b != null) {
            key = b.getIntegerArrayList("key");
        }

        r = key.get(key.size() - 1);
        //Log.v("aqui", "teste" + r);

        for (int i = 0; i < key.size() - 1; i++) {
            int valor = key.get(i) / r;
            char caractere = (char) valor;
            dec.add(Character.toString(caractere));
        }

        decriptografado.setText(dec.toString());

        decrip.setOnClickListener(
                view -> {
                    decriptografado.setVisibility(View.VISIBLE);
                });

    }




}

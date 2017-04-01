package br.usjt.ftce.desmob.clientev1;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText textNome;
    ArrayList<Cliente> lista;
    ClienteRequester requester;
    Intent intent;
    String chave;

    public static final String SERVIDOR = "http://10.0.2.2:8080";
    public static final String APLICACAO = "/arqdesis_poetas";
    public static final String RECURSO = "/cliente";
    public static final String CHAVE = "br.usjt.ftce.dsmob.clientev1.busca";

    public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText)findViewById(R.id.buscar_cliente);

    }

    public void buscarCliente(View view){
        Intent intent =  new Intent(this, ListarClienteActivity.class);
        chave = textNome.getText().toString();
        requester = new ClienteRequester();
        if(requester.isConnected(this)){
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                lista = requester.get(SERVIDOR + APLICACAO + RECURSO, chave);
                runnew Runnable(){

                };
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    })
        }else{
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
        startActivity(intent);
    }
}

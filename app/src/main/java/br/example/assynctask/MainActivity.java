package br.example.assynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView texto = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView)findViewById(R.id.texto);
    }
    public void chamarAsync(View view){
        new TesteAsyncTask(new MeuListener() {
            @Override
            public void onResult(Object resultado) {
                Long res = (Long)resultado;
                Toast.makeText(MainActivity.this, "Resultado: " + res,

                        Toast.LENGTH_LONG).show();

            }
            @Override
            public void onProgress(Object progresso) {
                texto.setText(String.valueOf(progresso));
            }
        }).execute(10);
    }
}
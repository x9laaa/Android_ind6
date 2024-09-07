package cl.bootcamp.ind_6v2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnElegir;
    RadioButton rbpoke1, rbPoke2, rbPoke3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegir = findViewById(R.id.button);
        rbpoke1 = findViewById(R.id.radioButton);
        rbPoke2 = findViewById(R.id.radioButton2);
        rbPoke3 = findViewById(R.id.radioButton3);

        enviarNotify();


    }

    private void enviarNotify() {
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pokemonSeleccionado = "";

                if (rbpoke1.isChecked()) {
                    pokemonSeleccionado = rbpoke1.getText().toString();
                } else if (rbPoke2.isChecked()) {
                    pokemonSeleccionado = rbPoke2.getText().toString();
                } else if (rbPoke3.isChecked()) {
                    pokemonSeleccionado = rbPoke3.getText().toString();
                }

                if (!pokemonSeleccionado.isEmpty()) {
                    Toast.makeText(MainActivity.this, pokemonSeleccionado, Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
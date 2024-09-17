package cl.bootcamp.ind_6v2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnElegir, btnConfirmar, btnCancelar;
    RadioGroup rdGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegir = findViewById(R.id.btnElegir);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);
        rdGroup = findViewById(R.id.rdGroup);

        fondodefault();

        btnElegir.setOnClickListener(v -> {
            rdGroup.setVisibility(View.GONE);
            btnElegir.setVisibility(View.GONE);

            btnConfirmar.setVisibility(View.VISIBLE);
            btnCancelar.setVisibility(View.VISIBLE);
            cambiofondo();
        });

        btnCancelar.setOnClickListener(v -> {
            rdGroup.setVisibility(View.VISIBLE);
            btnElegir.setVisibility(View.VISIBLE);

            btnConfirmar.setVisibility(View.GONE);
            btnCancelar.setVisibility(View.GONE);
            fondodefault();
        });
    }

    public void fondodefault(){
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new DefaultFragment()).commit();
    }

    public void cambiofondo(){
        int selectedId = rdGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.rbpoke1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new CharmanderFragment()).commit();
            btnConfirmar.setBackgroundColor(getColor(R.color.colorAccent));
        } else if (selectedId == R.id.rbpoke2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new BulbasaurFragment()).commit();
            btnConfirmar.setBackgroundColor(getColor(R.color.verde));
        } else if (selectedId == R.id.rbpoke3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new SquirtleFragment()).commit();
            btnConfirmar.setBackgroundColor(getColor(R.color.azul));

        }
    }
}
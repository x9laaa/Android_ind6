package cl.bootcamp.ind_6v2;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import cl.bootcamp.ind_6v2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fondodefault();

        binding.btnElegir.setOnClickListener(v -> {
            binding.rdGroup.setVisibility(View.GONE);
            binding.btnElegir.setVisibility(View.GONE);
            binding.btnConfirmar.setVisibility(View.VISIBLE);
            binding.btnCancelar.setVisibility(View.VISIBLE);
            cambiofondo();
        });

        binding.btnCancelar.setOnClickListener(v -> {
            binding.rdGroup.setVisibility(View.VISIBLE);
            binding.btnElegir.setVisibility(View.VISIBLE);

            binding.btnConfirmar.setVisibility(View.GONE);
            binding.btnCancelar.setVisibility(View.GONE);
            fondodefault();
        });
    }

    public void fondodefault(){
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new DefaultFragment()).commit();
    }

    public void cambiofondo(){
        int selectedId = binding.rdGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.rbpoke1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new CharmanderFragment()).commit();
            binding.btnConfirmar.setBackgroundColor(getColor(R.color.colorAccent));
        } else if (selectedId == R.id.rbpoke2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new BulbasaurFragment()).commit();
            binding.btnConfirmar.setBackgroundColor(getColor(R.color.verde));
        } else if (selectedId == R.id.rbpoke3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new SquirtleFragment()).commit();
            binding.btnConfirmar.setBackgroundColor(getColor(R.color.azul));

        }
    }
}
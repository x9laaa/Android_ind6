package cl.bootcamp.ind_6v2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import java.util.Objects;

import cl.bootcamp.ind_6v2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {


    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cambiarcolorfondo();
        textopokemon();


    }

    public void textopokemon(){
        String pokemon = "Evoluciones de " + getIntent().getStringExtra("pokemon");
        binding.textEvol.setText(pokemon);
    }

    public void cambiarcolorfondo(){
        String pokemon = getIntent().getStringExtra("pokemon");

        if (Objects.equals(pokemon, "Charmander")){
            binding.linearLayoutFondo.setBackground(ContextCompat.getDrawable(this, R.color.colorAccent));
            getSupportFragmentManager().beginTransaction().replace(R.id.containerframe, new CharmanderEvoFragment()).commit();

        } else if (Objects.equals(pokemon, "Bulbasaur")) {
            binding.linearLayoutFondo.setBackground(ContextCompat.getDrawable(this, R.color.verde));
            getSupportFragmentManager().beginTransaction().replace(R.id.containerframe, new BulbasaurEvoFragment()).commit();

        } else if (Objects.equals(pokemon, "Squirtle")) {
            binding.linearLayoutFondo.setBackground(ContextCompat.getDrawable(this, R.color.azul));
            getSupportFragmentManager().beginTransaction().replace(R.id.containerframe, new SquirtleEvoFragment()).commit();
        }
    }
}
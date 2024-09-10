package cl.bootcamp.ind_6v2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    Button btnElegir;
    RadioGroup rbPoke;
    FragmentTransaction transaction;
    Fragment fragmentDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegir = findViewById(R.id.button);
        rbPoke = findViewById(R.id.radioGroup);

        fragmentDefault = new DefaultFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.containerfragment, fragmentDefault).commit();

        enviarNotify();

    }

    private void enviarNotify() {
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selectedRadioButton = findViewById(rbPoke.getCheckedRadioButtonId());
                String pokemon = (String) selectedRadioButton.getText();
                //Toast.makeText(MainActivity.this, pokemon, Toast.LENGTH_LONG).show();
                mostarDialog(pokemon);
                cambiarFragment(pokemon);

            }
        });
    }

    private void cambiarFragment(String pokemon) {
        Fragment fragment;

        switch (pokemon) {
            case "Charmander":
                fragment = new CharmanderFragment();
                break;
            case "Bulbasaur":
                fragment = new BulbasaurFragment();
                break;
            case "Squirtle":
                fragment = new SquirtleFragment();
                break;
            default:
                fragment = new DefaultFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.containerfragment, fragment).commit();

    }

    public void mostarDialog(String pokemon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pokemon, null);
        builder.setView(dialogView);

        TextView namepokemon = dialogView.findViewById(R.id.textView);
        TextView mensajepokemon = dialogView.findViewById(R.id.textdialog);
        Button Button = dialogView.findViewById(R.id.button2);

        String mensaje = "Pokémon Seleccionado es";
        namepokemon.setText(pokemon);
        mensajepokemon.setText(mensaje);
        AlertDialog dialog = builder.create();

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }



}
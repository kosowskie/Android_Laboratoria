package pl.kosowski.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPolicz(View view){
        TextView wynik = (TextView)  findViewById (R.id.wynik);

        Spinner liczba1 = (Spinner) findViewById(R.id.liczba1);
        Spinner liczba2 = (Spinner) findViewById(R.id.liczba2);
        Spinner dzialanie = (Spinner) findViewById(R.id.dzialanie);
        String liczba1Text = String.valueOf(liczba1. getSelectedItem() );
        String liczba2Text = String.valueOf(liczba2. getSelectedItem() );
        String dzialanieText = String.valueOf(dzialanie. getSelectedItem() );
        Float f = new Float("20.75f");
        Float liczba1Float = f.parseFloat(liczba1Text);
        Float liczba2Float = f.parseFloat(liczba2Text);
        Float wynikFloat;
        switch(dzialanieText) {
            case "+":
                wynikFloat = liczba1Float + liczba2Float;
                break;
            case "-":
                wynikFloat = liczba1Float - liczba2Float;
                break;
            case "/":
                if (liczba2Float != 0.0f)  wynikFloat = liczba1Float / liczba2Float;
                else {
                    wynikFloat = 0.0f;
                    Context context = getApplicationContext();
                    CharSequence text = "Nie dziel przez 0!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;
            case "*":
                wynikFloat = liczba1Float * liczba2Float;
                break;
            default:
                wynikFloat = liczba1Float + liczba2Float;
        }

        wynik.setText(wynikFloat.toString());
    }

}
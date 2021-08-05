package be.ehb.demoinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //components ui
    private EditText etEuro, etDollar;
    private Button btnConvert;
    private TextInputLayout layoutEuro;
    private TextInputLayout layoutDollar;
    private CheckBox mCheckBox;
    // eventListener


   /*private boolean checkDollar() {String strDollar=etDollar.getText().toString();
        if(strDollar.length()<=0){
        layoutDollar.setError("Field must be filled in");
        return false;}
        else {
            layoutEuro.setError(null); return true;
        }
    }*/


    private final TextWatcher textWatcherEuro= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // kijken of de invoer juist
           checkEuro();
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkEuro();

        }


        @Override
        public void afterTextChanged(Editable s) {}

        };

    private boolean checkEuro() {
        String strEuro=etEuro.getText().toString();
             if(strEuro.length()<=0){
            layoutEuro.setError("Field must be filled in ");
            return false;     }
                else {
            layoutEuro.setError(null); return true;
        }
};
    private CheckBox checkbox; private final View.OnClickListener convertOnClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if (!checkEuro()) {
                return;
            }
           /*if(!checkDollar()){
                return;
            }*/
            // drukken op button convert
            // Waarde uit euro of dollar halen
            String strEuro=etEuro.getText().toString();
            // zet de waarde om naar double
            // op de klasse en parse zet het om naar een primitief type
            // value of zet om naar een object
            double euro= Double.parseDouble(strEuro);

            // omzetten naar Dollar;

            // op de klasse van de String format daar komt een waarde van een variabele
            double usd= euro * 1.18;


            //proper
            etDollar.setText(String.format(Locale.getDefault(),"%.2f",usd));
            // werkvloer
            // etDollar.setText(""usd);
        }};
// een comppundbutton is een combinatie is een button met stuk tekst- switch met label
    private CompoundButton.OnCheckedChangeListener tosListener= new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            Toast.makeText(getApplication(),"Check",Toast.LENGTH_SHORT).show();
        }
}
};


    @Override
         protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEuro=findViewById(R.id.et_euro);
        etDollar=findViewById(R.id.et_dollar);
        btnConvert=findViewById(R.id.btn_convert);

        btnConvert.setOnClickListener(convertOnClickListener);

        layoutEuro=findViewById(R.id.til_euro);
        layoutDollar=findViewById(R.id.til_dollar);

        etEuro.addTextChangedListener(textWatcherEuro);
        checkbox=findViewById(R.id.ch_bx_turnOfservice);
        checkbox.setOnCheckedChangeListener(tosListener);


    }
}

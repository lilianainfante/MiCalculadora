package com.example.operacionesmatematicas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numero1,numero2;
    TextView etiResul
            ;
    int valor1,valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText) findViewById(R.id.valor1);
        numero2 = (EditText) findViewById(R.id.valor2);
        etiResul = (TextView) findViewById(R.id.etiResultado);

    }

    public void onClick(View view) {

        if (numero1.getText().toString().equals("")) numero1.setText("0");
        if (numero2.getText().toString().equals("")) numero2.setText("0");
        valor1 = Integer.parseInt(numero1.getText().toString());
        valor2 = Integer.parseInt(numero2.getText().toString());

        switch (view.getId()){
            case R.id.btnSuma: sumar();
                break;
            case R.id.btnResta: resta();
                break;
            case R.id.btnMultipli: multiplicar();
                break;
            case R.id.btnDiv: division();
                break;
            case R.id.btnRaiz: raiz();
                break;
            case R.id.btnFactorial: factorial();
                break;

        }
    }

    private void factorial() {

        long factorial = 1;
        if (numero1.getText().toString().equals("")) numero1.setText("0");
        Toast.makeText(getApplicationContext(),"El factorial es del primer campo",Toast.LENGTH_SHORT).show();
        int num = Integer.parseInt(numero1.getText().toString());
        for(int i = 1; i<=num; i++){
            factorial = i * factorial;
        }
        etiResul.setText("El factorial  es: "+factorial);
    }

    private void raiz() {
        Toast.makeText(getApplicationContext(),"La raiz cudrada es del primer campo",Toast.LENGTH_SHORT).show();
        Double operan1, res;
        operan1= Double.parseDouble(numero1.getText().toString());
        res=Math.sqrt(operan1);
        etiResul.setText("El result de la raiz es: "+res);
    }

    private void division() {
        if(valor2>0){
            int div=valor1/valor2;
            etiResul.setText("El result de la divicion es: "+div);
        }else {
            Toast.makeText(this,"Advertencia",Toast.LENGTH_SHORT).show();
            etiResul.setText("El numero 2 debe ser mayor a 0 ");
        }


    }

    private void multiplicar() {
        int multi=valor1*valor2;
        etiResul.setText("El result de la multi es: "+multi);
    }

    private void resta() {
        int resta=valor1-valor2;
        etiResul.setText("El result de la resta es: "+resta);
    }

    private void sumar() {
        int suma=valor1+valor2;
        etiResul.setText("El resul de la suma es: "+suma);
    }
}

package com.danielescobar.sesion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class settingsActivity extends AppCompatActivity {
    EditText eProyecto, ePractica, eAvance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        eProyecto = findViewById(R.id.eProyecto);
        ePractica = findViewById(R.id.ePractica);
        eAvance = findViewById(R.id.eAvances);

        Bundle extras= getIntent().getExtras();
        if (extras!= null) {
            eProyecto.setText(String.valueOf(extras.getInt("proy")));
            ePractica.setText(String.valueOf(extras.getInt("lab")));
            eAvance.setText(String.valueOf(extras.getInt("avance")));
        }
    }

    public void onButtonCliecked(View view) {
        //onBackPressed();
        Intent intent =new Intent();
        intent.putExtra("proy", Integer.parseInt(eProyecto.getText().toString()));
        intent.putExtra("lab", Integer.parseInt(ePractica.getText().toString()));
        intent.putExtra("avance", Integer.parseInt(eAvance.getText().toString()));
        setResult(RESULT_OK,intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
        super.onBackPressed();
    }
}

package br.com.uneb.tebdfaculdademobile.scenes.disciplina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import br.com.uneb.tebdfaculdademobile.R;
import br.com.uneb.tebdfaculdademobile.model.DisciplinaValue;
import br.com.uneb.tebdfaculdademobile.persistence.DisciplinaDAO;

public class DisciplinaActivity extends AppCompatActivity {

    EditText disciplinaEDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        disciplinaEDT = (EditText) findViewById(R.id.disciplinaEDT);
        Button button = (Button) findViewById(R.id.botao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisciplinaDAO dao = new DisciplinaDAO(DisciplinaActivity.this);
                dao.salvar(new DisciplinaValue(
                        new Random().nextLong(),
                        disciplinaEDT.getText().toString()
                ));
                finish();
            }
        });
    }
}

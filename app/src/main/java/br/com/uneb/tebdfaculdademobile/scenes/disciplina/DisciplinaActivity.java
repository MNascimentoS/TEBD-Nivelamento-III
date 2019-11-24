package br.com.uneb.tebdfaculdademobile.scenes.disciplina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    protected DisciplinaValue disciplinaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        disciplinaEDT = (EditText) findViewById(R.id.disciplinaEDT);
        Button button = (Button) findViewById(R.id.botao);
        Intent intent = getIntent();

        disciplinaSelecionada = (DisciplinaValue) intent.getSerializableExtra("disciplinaSelecionada");

        if(disciplinaSelecionada != null){
            button.setText("Alterar");
            disciplinaEDT.setText(disciplinaSelecionada.getDisciplina());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisciplinaDAO dao = new DisciplinaDAO(DisciplinaActivity.this);
                if (disciplinaSelecionada==null) {
                    DisciplinaValue disciplinaValue = new DisciplinaValue();
                    disciplinaValue.setDisciplina(disciplinaEDT.getText().toString());
                    dao.salvar(disciplinaValue);
                } else {
                    disciplinaSelecionada.setDisciplina(disciplinaEDT.getText().toString());
                    dao.alterar(disciplinaSelecionada);
                }
                finish();
            }
        });
    }
}

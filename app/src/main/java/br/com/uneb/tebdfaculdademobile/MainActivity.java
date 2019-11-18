package br.com.uneb.tebdfaculdademobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.uneb.tebdfaculdademobile.model.DisciplinaValue;
import br.com.uneb.tebdfaculdademobile.persistence.DisciplinaDAO;
import br.com.uneb.tebdfaculdademobile.scenes.disciplina.DisciplinaActivity;

public class MainActivity extends AppCompatActivity {

    protected ListView lista;
    protected DisciplinaValue disciplinaValue;
    protected ArrayAdapter<DisciplinaValue> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisciplinaDAO dao = new DisciplinaDAO(this);
        ArrayList<DisciplinaValue> disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());
        dao.close();

        adapter = new ArrayAdapter<DisciplinaValue>(this, android.R.layout.simple_list_item_1, disciplinas);

        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adapter);
        lista.setOnCreateContextMenuListener(this);
        registerForContextMenu(lista);
        initListeners();
    }

    private void initListeners() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Toast.makeText(MainActivity.this, "Clicou " + posicao, Toast.LENGTH_LONG).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, adapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        DisciplinaDAO dao = new DisciplinaDAO(this);
        ArrayList<DisciplinaValue> disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());
        dao.close();
        adapter.clear();
        adapter.addAll(disciplinas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_disciplinas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_new) {
            Intent intent = new Intent(this, DisciplinaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

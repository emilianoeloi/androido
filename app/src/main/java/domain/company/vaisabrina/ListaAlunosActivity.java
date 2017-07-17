package domain.company.vaisabrina;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by android7045 on 17/07/17.
 */

public class ListaAlunosActivity extends Activity {
    private ListView listaAlunos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {"Rhyana", "Gabriela", "Emiliano"};
        this.listaAlunos = (ListView)findViewById(R.id.lista_alunos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListaAlunosActivity.this, "Posicao Selecionada: " + i, Toast.LENGTH_LONG).show();
            }

        });

        listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = listaAlunos.getItemAtPosition(i).toString();

                Toast.makeText(ListaAlunosActivity.this, "Nome Selecionado "+name, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

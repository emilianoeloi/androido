package domain.company.vaisabrina;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by android7045 on 17/07/17.
 */

public class ListaAlunos extends Activity {
    private ListView listaAlunos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {"Rhyana", "Gabriela", "Emiliano"};
        this.listaAlunos = (ListView)findViewById(R.id.lista_alunos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }
}

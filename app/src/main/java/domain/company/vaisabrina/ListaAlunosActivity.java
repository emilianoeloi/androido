package domain.company.vaisabrina;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by android7045 on 17/07/17.
 */

public class ListaAlunosActivity extends AppCompatActivity {
    private ListView listaAlunos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listaAlunos = (ListView)findViewById(R.id.lista_alunos);


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
                return false;
            }
        });

        // Context Menu
        registerForContextMenu(listaAlunos);

        // Float Button
        Button floatButton = (Button)findViewById(R.id.novo_aluno);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_enviar_notas:
                new EnviaAlunosTask(this).execute();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem ligarItem = menu.add("Ligar");
        MenuItem smsItem = menu.add("Enviar SMS");
        MenuItem acharItem = menu.add("Achar no Mapa");
        MenuItem siteItem = menu.add("Navegar no Site");
        MenuItem editarItem = menu.add("Editar");
        MenuItem deleteItem = menu.add("Deletar");

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        int position = info.position;
        final Aluno aluno = (Aluno)listaAlunos.getItemAtPosition(position);

        /// Ligar Item
        Intent intentLigar = new Intent(Intent.ACTION_CALL);
        intentLigar.setData(Uri.parse("tel:"+aluno.getTelefone()));
        ligarItem.setIntent(intentLigar);

        /// SMS Item
        Intent intentSMS = new Intent(Intent.ACTION_VIEW);
        intentSMS.setData(Uri.parse("sms:"+aluno.getTelefone()));
        intentSMS.putExtra("sms_body", "Mensagem");
        smsItem.setIntent(intentSMS);

        /// Site Item
        siteItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intentSite = new Intent(ListaAlunosActivity.this, FamigeradaActivity.class);
                intentSite.putExtra("ALUNO", aluno);
                Log.i("ListaAlunos", aluno.getSite());
                startActivity(intentSite);
                return false;
            }
        });

        /// Achar no Mapa
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        String endereco = aluno.getEndereco();
        intentMapa.setData(Uri.parse("geo:0,0?z=14&q="+Uri.encode(endereco)));
        acharItem.setIntent(intentMapa);


        editarItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                intent.putExtra("ALUNO", aluno);
                startActivity(intent);
                return false;
            }
        });
        deleteItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                new AlertDialog.Builder(ListaAlunosActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Deletar")
                        .setMessage("Deseja mesmo deletar?")
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
                                        dao.delete(aluno);
                                        dao.close();
                                        carregaLista();
                                    }
                                }
                        )
                        .setNegativeButton("Não", null).show();

                return false;
            }
        });
    }

    public void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.getLista();
        dao.close();
        ListaAlunosAdapter adapter = new ListaAlunosAdapter(this, alunos);
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.carregaLista();
    }
}

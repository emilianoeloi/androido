package domain.company.vaisabrina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by emiliano on 7/17/17.
 */

public class FormularioActivity extends AppCompatActivity {
    FormularioHelper helper;
    AlunoDAO dao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btnInserir = (Button)findViewById(R.id.btn_inserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingBar bar  = (RatingBar)findViewById(R.id.aluno_nota);
                Toast.makeText(FormularioActivity.this, "Você clicou no botão. Nota: "+bar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
        /// Helper
        helper = new FormularioHelper(this);
        dao = new AlunoDAO(this);

        Intent intenet = getIntent();
        Aluno aluno = (Aluno)getIntent().getSerializableExtra("ALUNO");
        helper.preencherFormulario(aluno);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.menu_formulario) {
            Aluno aluno = helper.pegaAlunoDoFormulario();
            dao.save(aluno);
            Toast.makeText(FormularioActivity.this, "Confirmar aluno: "+aluno.getNome(), Toast.LENGTH_SHORT).show();
            finish();
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}

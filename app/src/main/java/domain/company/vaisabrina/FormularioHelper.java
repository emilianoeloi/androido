package domain.company.vaisabrina;

import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by emiliano on 7/18/17.
 */

public class FormularioHelper {
    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private RatingBar nota;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        nome = (EditText)activity.findViewById(R.id.aluno_nome);
        telefone = (EditText)activity.findViewById(R.id.aluno_telefone);
        endereco = (EditText)activity.findViewById(R.id.aluno_endereco);
        site = (EditText)activity.findViewById(R.id.aluno_site);
        nota = (RatingBar)activity.findViewById(R.id.aluno_nota);
    }

    public Aluno pegaAlunoDoFormulario() {
        aluno.setNome(nome.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setNota(nota.getRating());
        return aluno;
    }

    public void preencherFormulario(Aluno alunoForUpdate) {
        if (alunoForUpdate == null) {
            this.aluno = new Aluno();
            return;
        }
        nome.setText(alunoForUpdate.getNome());
        telefone.setText(alunoForUpdate.getTelefone());
        endereco.setText(alunoForUpdate.getEndereco());
        site.setText(alunoForUpdate.getSite());
        nota.setRating(alunoForUpdate.getNota());
        this.aluno = alunoForUpdate;
    }
}

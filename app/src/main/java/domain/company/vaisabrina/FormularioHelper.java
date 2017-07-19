package domain.company.vaisabrina;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

/**
 * Created by emiliano on 7/18/17.
 */

public class FormularioHelper {
    private ImageView foto;
    private Button fotoButton;
    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private RatingBar nota;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        foto = (ImageView)activity.findViewById(R.id.aluno_foto);
        fotoButton = (Button)activity.findViewById(R.id.aluno_foto_button);
        nome = (EditText)activity.findViewById(R.id.aluno_nome);
        telefone = (EditText)activity.findViewById(R.id.aluno_telefone);
        endereco = (EditText)activity.findViewById(R.id.aluno_endereco);
        site = (EditText)activity.findViewById(R.id.aluno_site);
        nota = (RatingBar)activity.findViewById(R.id.aluno_nota);
    }

    public Button getFotoButton(){
        return fotoButton;
    }

    public void carregarImagem(String arquivoFoto) {
        Bitmap imagemFoto = BitmapFactory.decodeFile(arquivoFoto);
        Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagemFoto, imagemFoto.getWidth(), 300, true);
        foto.setImageBitmap(imagemReduzida);
        foto.setTag(arquivoFoto);
        foto.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public Aluno pegaAlunoDoFormulario() {
        aluno.setCaminhoFoto(foto.getTag().toString());
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
        carregarImagem(alunoForUpdate.getCaminhoFoto());
        nome.setText(alunoForUpdate.getNome());
        telefone.setText(alunoForUpdate.getTelefone());
        endereco.setText(alunoForUpdate.getEndereco());
        site.setText(alunoForUpdate.getSite());
        nota.setRating(alunoForUpdate.getNota());
        this.aluno = alunoForUpdate;
    }
}

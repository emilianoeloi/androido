package domain.company.vaisabrina;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by emiliano on 7/20/17.
 */

public class EnviaAlunosTask extends AsyncTask<Object, Object, String> {
    Context context;
    ProgressDialog progressDialog;
    public EnviaAlunosTask(Context ctx) {
        context = ctx;
        progressDialog = ProgressDialog.show(context,"Cadastro de Alunos","Aguarde o envio das notas...", false, true);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Object... objects) {
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.getLista();
        dao.close();

        String json = new AlunoConverter().toJson(alunos);

        WebClient wc = new WebClient("https://www.caelum.com.br/mobile");
        String resposta = wc.post(json);
        return resposta;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        Toast.makeText(context, "On Post Execute "+s, Toast.LENGTH_LONG).show();
        final Dialog dialog = new Dialog(context); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_resultado_nota);
        dialog.setTitle("Resultado");
        TextView dialogMedia = (TextView)dialog.findViewById(R.id.dialog_media);
        TextView dialogQuantidade = (TextView)dialog.findViewById(R.id.dialog_quantidade);
        try {
            JSONObject resultado = new JSONObject(s);
            String media = resultado.getString("media");
            String quantidade = resultado.getString("quantidade");
            dialogMedia.setText(media);
            dialogQuantidade.setText(quantidade);
        } catch(JSONException e) {

        }

        dialog.show();

    }
}

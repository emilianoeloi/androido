package domain.company.vaisabrina;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.List;

/**
 * Created by emiliano on 7/20/17.
 */

public class AlunoConverter {
    public String toJson(List<Aluno> alunos) {
        try {
            JSONStringer json = new JSONStringer();
            json.object().key("list").array().object().key("aluno").array();
            for (Aluno aluno : alunos) {
                json.object()
                        .key("id").value(aluno.getId())
                        .key("name").value(aluno.getNome())
                        .key("telefone").value(aluno.getTelefone())
                        .key("endereco").value(aluno.getEndereco())
                        .key("site").value(aluno.getSite())
                        .key("nota").value(aluno.getNota())
                        .key("caminhoFoto").value(aluno.getCaminhoFoto())
                        .key("email").value(aluno.getEmail())
                .endObject();
            }
            return json.endArray().endObject().endArray().endObject().toString();
        } catch(JSONException exception) {
            throw new RuntimeException(exception);
        }
    }
//    public List<Aluno> toObject(String json) {
//        try {
//            List<Aluno> alunos = new Lis;
//            JSONObject object = new JSONObject(json);
//            return alunos;
//        } catch(JSONException exception) {
//            throw new RuntimeException(exception);
//        }
//    }
}

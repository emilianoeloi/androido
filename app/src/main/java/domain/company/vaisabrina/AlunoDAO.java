package domain.company.vaisabrina;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by emiliano on 7/18/17.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    AlunoDAO(Context ctx) {
        super(ctx, "Cadastro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ddl = "CREATE TABLE ALUNO (" +
                "ID INTEGER PRIMARY KEY,"+
                "NOME TEXT,"+
                "TELEFONE TEXT,"+
                "ENDERECO TEXT,"+
                "SITE TEXT,"+
                "NOTA REAL"+
                ")";
        sqLiteDatabase.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("AlunoDAO", "Upgrade. Antiga: "+i+", Nova:"+i1);
    }

    public void adiciona(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("NOME", aluno.getNome());
        values.put("TELEFONE", aluno.getTelefone());
        values.put("ENDERECO", aluno.getEndereco());
        values.put("SITE", aluno.getSite());
        values.put("NOTA", aluno.getNome());

        db.insert("ALUNO", null, values);
    }

}

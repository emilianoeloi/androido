package domain.company.vaisabrina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by emiliano on 7/18/17.
 */

public class AlunoDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "ALUNO";
    private static final String DATABASE = "CADASTRO";
    AlunoDAO(Context ctx) {
        super(ctx, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ddl = "CREATE TABLE "+
                TABELA+
                "("+
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antiga, int nova) {
        String ddl = "DROP TABLE IF EXISTS "+TABELA;
        sqLiteDatabase.execSQL(ddl);
        onCreate(sqLiteDatabase);
    }

    public void adiciona(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("NOME", aluno.getNome());
        values.put("TELEFONE", aluno.getTelefone());
        values.put("ENDERECO", aluno.getEndereco());
        values.put("SITE", aluno.getSite());
        values.put("NOTA", aluno.getNome());

        db.insert(TABELA, null, values);
    }

    public List<Aluno> getLista() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        SQLiteDatabase db = getReadableDatabase();
        String dql = "SELECT ID, NOME, TELEFONE, ENDERECO, SITE, NOTA FROM "+
                TABELA+";";
        Cursor cursor = db.rawQuery(dql, null);

        while(cursor.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(cursor.getColumnIndex("ID")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("TELEFONE")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("ENDERECO")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("SITE")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("NOTA")));
            alunos.add(aluno);
        }

        cursor.close();
        return alunos;
    }

}

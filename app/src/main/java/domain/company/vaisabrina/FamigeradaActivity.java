package domain.company.vaisabrina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

/**
 * Created by emiliano on 7/19/17.
 */

public class FamigeradaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famigerada);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("ALUNO");

        WebView webview = (WebView)findViewById(R.id.famigerada);
        Log.i("Famigerada", aluno.getSite());
        webview.loadUrl(aluno.getSite());
    }
}

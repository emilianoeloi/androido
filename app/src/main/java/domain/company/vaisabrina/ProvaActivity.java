package domain.company.vaisabrina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by emiliano on 7/21/17.
 */

public class ProvaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (isTablet()) {
            transaction
                    .replace(R.id.prova_view, new ListaProvaFragment())
                    .replace(R.id.prova_detalhe, new DetalhesProvaFragment());
        } else {
            transaction.replace(R.id.prova_view, new ListaProvaFragment());
        }

        transaction.commit();

    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }
}

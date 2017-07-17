package domain.company.vaisabrina;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by emiliano on 7/17/17.
 */

public class FormularioActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btnInserir = (Button)findViewById(R.id.btn_inserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingBar bar  = (RatingBar)findViewById(R.id.rating);
                Toast.makeText(FormularioActivity.this, "Você clicou no botão. Nota: "+bar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

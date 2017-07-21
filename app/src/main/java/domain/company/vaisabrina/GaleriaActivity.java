package domain.company.vaisabrina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by emiliano on 7/21/17.
 */

public class GaleriaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galeria);
        ViewPager gallery = (ViewPager) findViewById(R.id.gallery);
        GaleriaAlunoAdapter adapter = new GaleriaAlunoAdapter(new AlunoDAO(this).getLista(), this);
        gallery.setAdapter(adapter);
    }
}

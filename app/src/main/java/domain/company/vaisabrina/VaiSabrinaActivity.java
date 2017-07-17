package domain.company.vaisabrina;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by android7045 on 17/07/17.
 */

public class VaiSabrinaActivity extends Activity {
    int count;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count++;
        Log.i("Ciclo de Vida", "On Create "+count);
        setContentView(R.layout.activity_vai_sabrina);
        final EditText editText = (EditText)findViewById(R.id.entrada);
        final TextView textView = (TextView)findViewById(R.id.saida);
        Button button = (Button)findViewById(R.id.buttonOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                textView.setText(text);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        count++;
        Log.i("Ciclo de Vida", "On Start "+count);
    }

    @Override
    protected void onResume() {
        super.onResume();
        count++;
        Log.i("Ciclo de Vida", "On Resume "+count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        count++;
        Log.i("Ciclo de Vida", "On Restart "+count);
    }

    @Override
    protected void onPause() {
        super.onPause();
        count++;
        Log.i("Ciclo de Vida", "On Pause "+count);
    }

    @Override
    protected void onStop() {
        super.onStop();
        count++;
        Log.i("Ciclo de Vida", "On Stop "+count);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        count++;
        Log.i("Ciclo de Vida", "On Destroy "+count);
    }
}

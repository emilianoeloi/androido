package domain.company.vaisabrina;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by emiliano on 7/19/17.
 */

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos;
    private final Activity activity;

    public ListaAlunosAdapter(Activity activity, List<Aluno> alunos) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        Aluno aluno = alunos.get(i);
        TextView nome = (TextView)view.findViewById(R.id.item_nome);
        TextView telefone = (TextView)view.findViewById(R.id.item_telefone);
        TextView site = (TextView)view.findViewById(R.id.item_site);

        nome.setText(aluno.getNome());
        if (telefone != null) {
            telefone.setText(aluno.getTelefone());
        }
        if (site != null) {
            site.setText(aluno.getSite());
        }

        ImageView foto = (ImageView)view.findViewById(R.id.item_foto);
        Bitmap imagemFoto = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
        Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagemFoto, 50, 50, true);
        foto.setImageBitmap(imagemReduzida);
        foto.setScaleType(ImageView.ScaleType.FIT_XY);

        if(i % 2 == 0) {
            view.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
        } else {
            view.setBackgroundColor(activity.getResources().getColor(R.color.linha_impar));
        }

        return view;
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public int getCount() {
        return alunos.size();
    }
}

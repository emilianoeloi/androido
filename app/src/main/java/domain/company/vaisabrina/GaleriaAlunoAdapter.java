package domain.company.vaisabrina;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by emiliano on 7/21/17.
 */

public class GaleriaAlunoAdapter extends PagerAdapter {
    private List<Aluno> alunos;
    private Activity activity;

    public GaleriaAlunoAdapter(List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.alunos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        ((ViewPager) container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView foto;
        foto = new ImageView(activity);
        Aluno aluno = alunos.get(position);

        if (aluno.getCaminhoFoto() != null) {
            Bitmap image = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
            foto.setImageBitmap(Bitmap.createScaledBitmap(image, 200, 200, true));
        } else {
            foto.setImageResource(R.drawable.ic_no_image);
        }
        ((ViewPager) container).addView(foto, 0);
        return foto;
    }
}

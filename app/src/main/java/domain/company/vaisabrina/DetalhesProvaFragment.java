package domain.company.vaisabrina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by emiliano on 7/21/17.
 */

public class DetalhesProvaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layoutDetalhes = inflater.inflate(R.layout.fragment_detalhes_prova, container, false);
        return layoutDetalhes;
    }
}

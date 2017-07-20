package domain.company.vaisabrina;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by emiliano on 7/20/17.
 */

public class ListaProvaFragment extends Fragment {
    ListView listaViewProvas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layoutProva = inflater.inflate(R.layout.fragment_lista_prova, container, false);
        listaViewProvas = (ListView)layoutProva.findViewById(R.id.lista_provas_listview);

        Prova prova1 = new Prova("1/1/1", "Matemática");
        Prova prova2 = new Prova("31/12/99", "Português");

        List<Prova> provas=Arrays.asList(prova1, prova2);

        listaViewProvas.setAdapter(new ArrayAdapter<Prova>(getActivity(), android.R.layout.simple_expandable_list_item_1));

        return layoutProva;
    }
}

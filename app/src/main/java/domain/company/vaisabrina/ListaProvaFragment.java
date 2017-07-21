package domain.company.vaisabrina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        prova1.setTopicos(Arrays.asList("A", "B", "C"));
        Prova prova2 = new Prova("31/12/99", "Português");
        prova2.setTopicos(Arrays.asList("D", "E", "F"));

        List<Prova> provas=Arrays.asList(prova1, prova2);

        listaViewProvas.setAdapter(new ArrayAdapter<Prova>(getActivity(), android.R.layout.simple_expandable_list_item_1, provas));

        listaViewProvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Prova selecionada = (Prova)adapterView.getItemAtPosition(i);
                ProvaActivity calendarioProva = (ProvaActivity) getActivity();
                calendarioProva.selecionaProva(selecionada);
                Toast.makeText(getActivity(), "Prova selecionada: " + selecionada, Toast.LENGTH_LONG).show();
            }
        });

        return layoutProva;
    }
}

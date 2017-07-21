package domain.company.vaisabrina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by emiliano on 7/21/17.
 */

public class DetalhesProvaFragment extends Fragment {
    private Prova prova;
    private TextView materia;
    private TextView data;
    private ListView topicos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layoutDetalhes = inflater.inflate(R.layout.fragment_detalhes_prova, container, false);
        if (getArguments() != null) {
            prova = (Prova)getArguments().getSerializable("PROVA");
        }
        buscarComponentes(layoutDetalhes);
        pupularCampos(prova);

        return layoutDetalhes;
    }

    public void buscarComponentes(View layout) {
        this.materia = (TextView)layout.findViewById(R.id.detalhe_prova_materia);
        this.data = (TextView)layout.findViewById(R.id.detalhe_prova_data);
        this.topicos = (ListView)layout.findViewById(R.id.detalhe_prova_topicos);
    }

    public void pupularCampos(Prova prova) {
        if (prova != null) {
            this.materia.setText(prova.getMateria());
            this.data.setText(prova.getData());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, prova.getTopicos());
            this.topicos.setAdapter(adapter);
        }
    }
}

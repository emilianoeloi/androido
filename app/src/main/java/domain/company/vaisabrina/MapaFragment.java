package domain.company.vaisabrina;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by emiliano on 7/21/17.
 */

public class MapaFragment extends SupportMapFragment {
    Aluno aluno;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        aluno = (Aluno)intent.getSerializableExtra("ALUNO");
        if (aluno != null) {
            final LatLng ll = new Localizador(getActivity()).getCoordenada(aluno.getEndereco());
            final MarkerOptions marker = new MarkerOptions().title(aluno.getNome()).snippet(aluno.getTelefone()).position(ll);
            getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                   googleMap.addMarker(marker);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 17));
                }
            });
        }
    }
}

package domain.company.vaisabrina;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by emiliano on 7/21/17.
 */

public class Localizador {
    private Geocoder geo;

    public Localizador(Context context) {
        geo = new Geocoder(context);
    }

    public LatLng getCoordenada(String endereco) {
        try {
            List<Address> listaEndereco = geo.getFromLocationName(endereco, 1);
            Address address = listaEndereco.get(0);
            return new LatLng(address.getLatitude(), address.getLongitude());
        }catch (Exception excepetion) {
            return null;
        }
    }
}

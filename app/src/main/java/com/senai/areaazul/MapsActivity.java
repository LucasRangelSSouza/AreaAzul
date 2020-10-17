package com.senai.areaazul;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng estacionamento1 = new LatLng(-16.671845, -49.258964);
        LatLng estacionamento2 = new LatLng(-16.671686, -49.258999);
        LatLng estacionamento3 = new LatLng(-16.671511, -49.259061);
        LatLng estacionamento4 = new LatLng(-16.671344, -49.259099);
        LatLng estacionamento5 = new LatLng(-16.671102, -49.259171);

        LatLng estacionamento6 = new LatLng(-16.671242, -49.259491);
        LatLng estacionamento7 = new LatLng(-16.671417, -49.259437);
        LatLng estacionamento8 = new LatLng(-16.671561, -49.259405);
        LatLng estacionamento9 = new LatLng(-16.671787, -49.259319);
        LatLng estacionamento10 = new LatLng(-16.671869, -49.259309);


        LatLng mylocate = new LatLng(-16.672794, -49.258751);

        BitmapDescriptor vagalivre = BitmapDescriptorFactory.fromResource(R.drawable.parkicon);
        BitmapDescriptor vagaocupada = BitmapDescriptorFactory.fromResource(R.drawable.parkiconred);
        BitmapDescriptor me = BitmapDescriptorFactory.fromResource(R.drawable.mylocate);

        MarkerOptions vaga1 = new MarkerOptions().position(estacionamento1)
                .title("Vaga 1")
                .snippet("Estacionamento 1")
                .icon(vagalivre);

        MarkerOptions vaga2 = new MarkerOptions().position(estacionamento2)
                .title("Vaga 2")
                .snippet("Estacionamento 2")
                .icon(vagalivre);

        MarkerOptions vaga3 = new MarkerOptions().position(estacionamento3)
                .title("Vaga 3")
                .snippet("Estacionamento 3")
                .icon(vagaocupada);

        MarkerOptions vaga4 = new MarkerOptions().position(estacionamento4)
                .title("Vaga 4")
                .snippet("Estacionamento 4")
                .icon(vagalivre);

        MarkerOptions vaga5 = new MarkerOptions().position(estacionamento5)
                .title("Vaga 5")
                .snippet("Estacionamento 5")
                .icon(vagaocupada);

        MarkerOptions mylocal = new MarkerOptions().position(mylocate)
                .title("Minha localização")
                .snippet(" ")
                .icon(me);

        MarkerOptions vaga6 = new MarkerOptions().position(estacionamento6)
                .title("Vaga 6")
                .snippet("Estacionamento 1")
                .icon(vagalivre);

        MarkerOptions vaga7 = new MarkerOptions().position(estacionamento7)
                .title("Vaga 7")
                .snippet("Estacionamento 2")
                .icon(vagalivre);

        MarkerOptions vaga8 = new MarkerOptions().position(estacionamento8)
                .title("Vaga 8")
                .snippet("Estacionamento 3")
                .icon(vagaocupada);

        MarkerOptions vaga9 = new MarkerOptions().position(estacionamento9)
                .title("Vaga 9")
                .snippet("Estacionamento 4")
                .icon(vagalivre);

        MarkerOptions vaga10 = new MarkerOptions().position(estacionamento10)
                .title("Vaga 10")
                .snippet("Estacionamento 5")
                .icon(vagaocupada);




        marker = googleMap.addMarker(vaga1);
        marker = googleMap.addMarker(vaga2);
        marker = googleMap.addMarker(vaga3);
        marker = googleMap.addMarker(vaga4);
        marker = googleMap.addMarker(vaga5);
        marker = googleMap.addMarker(vaga6);
        marker = googleMap.addMarker(vaga7);
        marker = googleMap.addMarker(vaga8);
        marker = googleMap.addMarker(vaga9);
        marker = googleMap.addMarker(vaga10);

        marker = googleMap.addMarker(mylocal);
        /*
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(estacionamento1);
        markerOptions.title("Localização atual");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(icon));
        marker = mMap.addMarker(markerOptions);*/
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(estacionamento1,18.0f));

    }
}

package com.valentina.miscontactos.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.valentina.miscontactos.R;
import com.valentina.miscontactos.adapter.ContactoAdaptador;
import com.valentina.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        rvContactos.setLayoutManager(llm);

        inicializarDatos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarDatos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.paleta_de_hielo,"Valentina Peña", "099627104", "valepena@gmail.com"));
        contactos.add(new Contacto(R.drawable.platano,"Virginia Peña", "099164555", "vivileep@gmail.com"));
        contactos.add(new Contacto(R.drawable.rayo_azul,"Martín Garreta", "094860286", "mgarretal@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta_venenosa,"Ximena Garreta", "099113706", "xgarreta123@gmail.com"));
    }

    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        rvContactos.setAdapter(adaptador);

    }
}

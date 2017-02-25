package com.example.formador.mysearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String[] array = new String[] {
            "ALBERTO",
            "BEA",
            "CARLA",
            "DANI",
            "PACO",
            "ZIZOU"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.fila, array);

        ListView lv = (ListView) findViewById(R.id.listacadena);

        lv.setAdapter(listAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.cajabusqueda);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d(getClass().getCanonicalName(), " CADENA ts = " + s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String texto_introducido) {
                Log.d(getClass().getCanonicalName(), " CADENA tc = " + texto_introducido);
                //TODO filtrar la lista para que salgan sólo los
                //nombres que coinciden con la cadena de búsqueda (texto_introducido)

                String texto_intro_mayusc = texto_introducido.toUpperCase();
                List<String> lista_coincidencias = new ArrayList<String>();
                for (String nombre: array)
                {
                    String nom_mayus = nombre.toUpperCase();
                    if (nombre.contains(texto_intro_mayusc)) {
                        //sé que coincide
                        lista_coincidencias.add(nombre);
                    }
                }

                ListView lv = (ListView) findViewById(R.id.listacadena);

                ListAdapter listAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.fila, lista_coincidencias);


                lv.setAdapter(listAdapter);
                return false;
            }
        });
    }
}

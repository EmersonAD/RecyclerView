package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem
        this.criarFilmes();

        //Adaptador
        Adapter adapter = new Adapter(listaFilmes);

        //Configuração
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Adicionar toque
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Clique longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )

            );


    }

    public void criarFilmes(){

        Filme filme = new Filme("Homem-aranha: Sem volta para casa", "Ficção", "2022");
        this.listaFilmes.add(filme);

        filme = new Filme("Harry Potter e a Pedra Filosofal", "Ficção", "2001");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e a Câmara Secreta", "Ficção", "2002");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e o Prisioneiro de Azkaban", "Ficção", "2004");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e o Cálice de Fogo", "Ficção", "2005");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e a Ordem da Fênix", "Ficção", "2007");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e o Enigma do Príncipe", "Ficção", "2009");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e as Relíquias da Morte: Parte 1", "Ficção", "2010");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e as Relíquias da Morte: Parte 2", "Ficção", "2011");
        listaFilmes.add(filme);

        filme = new Filme("Animais Fantásticos e Onde Habitam", "Ficção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("Animais Fantásticos e os crimes de Grindelwald", "Ficção", "2018");
        listaFilmes.add(filme);

        filme = new Filme("Animais Fantásticos: Os Segredos de Dumbledore", "Ficção", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Harry Potter e a criança amaldiçoada(Livro)", "Ficção", "2016");
        listaFilmes.add(filme);



    }
}
package com.tutorials.hp.lvfilterobjects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    ArrayAdapter<Spacecraft> adapter;
    ListView lv;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEW REFERENCES
        lv= (ListView) findViewById(R.id.lv);
        sv= (SearchView) findViewById(R.id.sv);

        //POPULATE DATA
        fillData();

        //ADAPTER
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,spacecrafts);
        lv.setAdapter(adapter);

        //EVENTS
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //FILTER
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillData()
    {
        Spacecraft s=new Spacecraft("Voyager","Nuclear","Asteroid Belt");
        spacecrafts.add(s);

        s=new Spacecraft("Casini","Anti-Matter","Canis Majos");
        spacecrafts.add(s);

        s=new Spacecraft("Enterprise","Warp Drive","Andromeda");
        spacecrafts.add(s);

        s=new Spacecraft("Pioneer","Solar","Venus");
        spacecrafts.add(s);

        s=new Spacecraft("Rosetter","Warp Drive","Pluto");
        spacecrafts.add(s);
        s=new Spacecraft("Spitzer","Plasma Ions","Andromeda");
        spacecrafts.add(s);
        s=new Spacecraft("Discovery","Plasma Ions","Andromeda");
        spacecrafts.add(s);
        s=new Spacecraft("Atlantis","Plasma Ions","Andromeda");
        spacecrafts.add(s);
        s=new Spacecraft("Columbia","Chemical","Space");
        spacecrafts.add(s);

        s=new Spacecraft("Apollo","Chemical","Space");
        spacecrafts.add(s);
        s=new Spacecraft("Challenger","Warp Drive","Sombrero");
        spacecrafts.add(s);

        s=new Spacecraft("Curiosity","Solar","Mars");
        spacecrafts.add(s);
        s=new Spacecraft("Opportunity","Solar","Mars");
        spacecrafts.add(s);

        s=new Spacecraft("Kepler","Solar","Jupiter");
        spacecrafts.add(s);
    }
}

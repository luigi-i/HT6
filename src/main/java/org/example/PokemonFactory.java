package org.example;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class PokemonFactory {


    //tiene los new para los 3 tipos de map que se piden
    public HashMap<String, Pokemon> hashmapPokemon(){


        HashMap<String, Pokemon> hmPokemon = new HashMap();

        return hmPokemon;
    }

    public TreeMap<String, Pokemon> treeMapPokemon(){

        TreeMap<String, Pokemon> tmPokemon = new TreeMap();

        return tmPokemon;
    }

    public LinkedHashMap<String, Pokemon> linkedHashMapPokemon(){

        LinkedHashMap<String, Pokemon> lhmPokemon = new LinkedHashMap();

        return lhmPokemon;
    }

}

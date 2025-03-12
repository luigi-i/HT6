package org.example;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static org.example.Main.csvfile;

public class MainTest extends TestCase {

    public void testM5() {
        String input = "";
        ArrayList<String> poseedores = new ArrayList<>();
        String listaAtaque = "";
        Map<String, Pokemon>  mapa = new PokemonFactory().hashmapPokemon();
        csvfile(mapa);

        input = "Stance-change";
        for (Pokemon p : mapa.values()){//entre todos los pokemon
            for (String s : p.getAbilities()){//revisa las habilidades de cada uno
                if(s.equals(input) && !poseedores.contains(p)){//si la encuentra y aun no se ha agregado
                    poseedores.add(p.getName());//lo agrega a un Arraylist
                }
            }
        }

        for(String s : poseedores){
            listaAtaque += s ; // agrega a los pokemon a un String para imprirlo mejor
        }
        System.out.println(listaAtaque);

        Assert.assertEquals("Aegislash-shield", listaAtaque);


        listaAtaque = "";
        poseedores.clear(); //limpia las listas y el String para poder usarlos de nuevo

    }

    public void testM2() {
        String input = "";

        System.out.println("Ingrese el input del pokemon");
        input = "Squirtle";
        Map<String, Pokemon>  mapa = new PokemonFactory().hashmapPokemon();
        csvfile(mapa);
        Pokemon pokemon = mapa.get(input);
        if(mapa.containsKey(input)){
            pokemon = mapa.get(input); //si se encuentra al pokemon
            System.out.println(pokemon); //se llama al toString de Pokemon
        }else{
            System.out.println("No existe ese pokemon");
        }


        String expected = "Nombre: Squirtle, Numero: 7, Tipo1:Water, Tipo2: , Clasificacion: Tiny Turtle Pokémon\n" +
                "Height: 0.5, Weight: 9.0, Habilidades: [Torrent,  Rain-dish], Generation: 1, Legendario: no\n";

        Assert.assertEquals(expected, pokemon.toString() );

    }

    }

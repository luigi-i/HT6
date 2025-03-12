package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;


import java.util.*;

public class Main {
    public static void main(String[] args) {


        boolean opcion1 = false;
        boolean opcion2 = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja una opcion entre 1 y 3");
        String est = sc.nextLine();
        Map<String, Pokemon> mapa = null;
        Usuario user = new Usuario();


        while (!opcion1)
        {
            if(est.equals("1")){
                mapa = new PokemonFactory().hashmapPokemon();
                csvfile(mapa);

                opcion1 = true;

            }else if(est.equals("2")){
                mapa = new PokemonFactory().treeMapPokemon();
                csvfile(mapa);

                opcion1 = true;

            }else if(est.equals("3")){
                mapa = new PokemonFactory().linkedHashMapPokemon();
                csvfile(mapa);

                opcion1 = true;

            }else {
                System.out.println("Ingrese una opcion entre 1 o 3");
                est = sc.nextLine();
            }
        }

        String input = "";

        while(opcion2){

            System.out.println("1.Agregar un pokemon a tu coleccion");
            System.out.println("2.Mostrar los datos de un pokemon segun su input");
            System.out.println("3.Mostrar nombre y tipo de los pokemon de tu coleccion");
            System.out.println("4.Mostrar el nombre y tipo de todos los pokemon");
            System.out.println("5.Mostrar el nombre de los pokemon que posean una abilidad especifica");
            System.out.println("6. Salir");
            String opcao = sc.nextLine();
            switch(opcao){
                case "1":

                    System.out.println("Ingrese el input del pokemon a agregar");
                    input = sc.nextLine();

                    if(mapa.containsKey(input)){ //Si se encuentra a ese pokemon
                        user.agregarP(mapa.get(input));//lo agrega a la coleccion
                    }else{
                        System.out.println("No existe ese pokemon");
                    }



                    break;


                case "2":

                    m2(sc, mapa);


                    break;
                case "3":

                    System.out.println("\n");
                    for (Pokemon p : user.getColeccion()){//por cada pokemon en la coleccion del usuario
                        System.out.println(p.getName() + ": " + p.getType1());  //imprime su nombre y tipo
                    }
                    System.out.println("\n");


                    break;

                case "4":


                    m4(mapa);

//                    Map<String, Pokemon> finalMapa = mapa;
//                    Profiler.medirTiempo(() -> m4(finalMapa));
                    //complejidad de operacion #4


                    break;

                case "5":



                    m5(sc, mapa);

                    break;

                case "6":
                    opcion2 = false; //termina el ciclo
                    break;

                default:

                    System.out.println("Ingrese una opcion entre 1 o 6");
            }
        }
    }

    public static void csvfile(Map<String, Pokemon> mapa) {

        try (CSVReader reader = new CSVReader(new FileReader("pokecsv.csv"))) {
            List<String[]> rows = reader.readAll();
            boolean isHeader = true;

            for (String[] row : rows) {
                if (isHeader) { // Saltar la primera fila si es encabezado
                    isHeader = false;
                    continue;
                }

                String name = row[0];
                int number = Integer.parseInt(row[1]);
                String type1 = row[2];
                String type2 = row[3];
                String classification = row[4];
                float height = Float.parseFloat(row[5]);
                float weight = Float.parseFloat(row[6]);
                List<String> abilities = Arrays.asList(row[7].split(","));
                int generation = Integer.parseInt(row[8]);
                boolean legendary = Boolean.parseBoolean(row[9]);
                //Asigna cada columna a la variable que luego se asignara al pokemon creado dinamicamente


                Pokemon pokemon = new Pokemon();
                pokemon.setName(name);
                pokemon.setNumber(number);
                pokemon.setType1(type1);
                pokemon.setType2(type2);
                pokemon.setClassification(classification);
                pokemon.setHeight(height);
                pokemon.setWeight(weight);
                pokemon.setAbilities(abilities);
                pokemon.setGeneration(generation);
                pokemon.setLegendary(legendary); //Asignacion de atributos

                mapa.put(name, pokemon); //agrega al pokemon al mapa

            }
        } catch (IOException | CsvException | NumberFormatException e) {
            e.printStackTrace();
        }

        //Estructura del metodo y manejo de excepciones extraida de: https://infogonzalez.com/2024/11/lectura-y-escritura-de-ficheros-csv-con-java.html


    }


    public static void m5(Scanner sc,Map<String, Pokemon> mapa){
        String input = "";
        ArrayList<String> poseedores = new ArrayList<>();
        String listaAtaque = "";

        boolean verificar5 = false;
        System.out.println("Ingrese la habilidad para buscar a sus poseedores");
        input = sc.nextLine();
        for (Pokemon p : mapa.values()){//entre todos los pokemon
            for (String s : p.getAbilities()){//revisa las habilidades de cada uno
                if(s.equals(input) && !poseedores.contains(p)){//si la encuentra y aun no se ha agregado
                    poseedores.add(p.getName() + "\n");//lo agrega a un Arraylist
                    verificar5 = true;//marcador de que se encontro al menos 1 pokemon
                }
            }
        }
        if(!verificar5){ // si el marcador no se activa se muestra el mensaje de error
            System.out.println("Ataque no encontrada en ningun pokemon");
        }
        for(String s : poseedores){
            listaAtaque += s ; // agrega a los pokemon a un String para imprirlo mejor
        }
        System.out.println(listaAtaque);
        listaAtaque = "";
        poseedores.clear(); //limpia las listas y el String para poder usarlos de nuevo

    }


    public static void m4(Map<String, Pokemon> mapa){
        mapa.values().stream().sorted(Comparator.comparing(Pokemon::getType1)) // Ordena por tipo 1
                .forEach(pokemon ->
                        System.out.println(pokemon.getName() + " - " + pokemon.getType1()));
        System.out.println("\n");
    }

    public static void m2(Scanner sc, Map<String, Pokemon> mapa){
        String input = "";

        System.out.println("Ingrese el input del pokemon");
        input = sc.nextLine();
        if(mapa.containsKey(input)){
            Pokemon pokemon = mapa.get(input); //si se encuentra al pokemon
            System.out.println(pokemon); //se llama al toString de Pokemon
        }else{
            System.out.println("No existe ese pokemon");
        }
    }

}
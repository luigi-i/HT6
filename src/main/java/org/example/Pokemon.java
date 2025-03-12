package org.example;


import java.util.List;

public class Pokemon {

    protected String name;
    protected int number;
    protected String type1;
    protected String type2;
    protected String classification;
    protected float height;
    protected float weight;
    protected List<String> abilities;
    protected int generation;
    protected boolean legendary;

    public Pokemon() {

        //setters y getters
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setType1(String type1){
        this.type1 = type1;
    }
    public void setType2(String type2){
        this.type2 = type2;
    }
    public void setClassification(String classification){
        this.classification = classification;
    }
    public void setHeight(float height){
        this.height = height;
    }
    public void setWeight(float weight){
        this.weight = weight;
    }
    public void setAbilities(List<String> abilities){
        this.abilities = abilities;
    }
    public void setGeneration(int generation){
        this.generation = generation;
    }
    public void setLegendary(boolean legendary){
        this.legendary = legendary;
    }

    public String getType1(){
        return type1;
    }

    public String getName(){
        return name;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() { //toString
        String legendario = null;
        if(legendary){legendario = "si";}
        else {legendario = "no";}

        return "Nombre: " + name + ", Numero: " + number + ", Tipo1:" + type1 + ", Tipo2: " + type2 +
                ", Clasificacion: " + classification + "\nHeight: " + height + ", Weight: " + weight +
                ", Habilidades: " + abilities + ", Generation: " + generation + ", Legendario: " + legendario + "\n";
    }
}

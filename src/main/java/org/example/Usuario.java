package org.example;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Usuario implements Comparator<Pokemon> {

    protected Set<Pokemon> coleccion;

    public Usuario() {
        this.coleccion = new TreeSet<>(this); //
    }

    public boolean agregarP(Pokemon p) {
        return this.coleccion.add(p);
    }

    public Set<Pokemon> getColeccion() {
        return coleccion;
    }


    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        int result = p1.getType1().compareTo(p2.getType1());
        if (result == 0) {
            return p1.getName().compareTo(p2.getName());
        }
        return result;
    }
}

package aaAmphibians;

public abstract class Amphibians {
    public Integer aaPeso;
    public int aaEdad;

    public Amphibians(){}

    public void aasaludar(){
        System.out.println("Hola soy un amphian");
    }

    public void aasaludar(String aaNombre){
        System.out.println("Hola " + aaNombre);
    }

}

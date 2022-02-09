package com.example.exercice8;

public class Voyage {
    private String VilleDepart;
    private String VilleArrivée;
    private String Heure;

    public Voyage(String villeDepart, String villeArrivée, String heure) {
        this.VilleDepart = villeDepart;
        this.VilleArrivée = villeArrivée;
        this.Heure = heure;
    }

    public String getVilleDepart() {
        return VilleDepart;
    }

    public void setVilleDepart(String villeDepart) {
        VilleDepart = villeDepart;
    }

    public String getVilleArrivée() {
        return VilleArrivée;
    }

    public void setVilleArrivée(String villeArrivée) {
        VilleArrivée = villeArrivée;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String heure) {
        Heure = heure;
    }

    @Override
    public String toString() {
        return this.getVilleDepart() + " - " + this.getVilleArrivée() + "    départ à "+ this.getHeure();
    }
}

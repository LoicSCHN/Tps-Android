package com.example.calendrier;

import java.text.DateFormat;
import java.util.Date;

public class Evenement {
    private String titre;
    private String heure;
    private String date;

    public Evenement(String titre, String heure, String date) {
        this.titre = titre;
        this.heure = heure;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "titre='" + titre + '\'' +
                ", heure='" + heure + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

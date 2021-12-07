package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne {

    private int niveau;
    private ArrayList<Licence> licence = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        Licence lic = new Licence(this, numero, delivrance, club);
        licence.add(lic);
    }

    public Licence derniereLicence() {
        Licence l = licence.get(licence.size() - 1);
        return l;
    }

}

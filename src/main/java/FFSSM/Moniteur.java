/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    private ArrayList<Embauche> embauches = new ArrayList<>();

    private final Moniteur employe;

    private final Club employeur;
    public int numeroDiplome;

    public Moniteur(Moniteur employe, Club employeur, int numeroDiplome, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.employe = employe;
        this.employeur = employeur;
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        if(embauches.isEmpty()|| embauches.get(embauches.size()-1).estTerminee()){
             return Optional.empty();
        }else{
       return Optional.ofNullable(embauches.get(embauches.size()-1).getEmployeur());
    }
}
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        embauches.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return embauches;
    }

    public void terminerEmbauche(LocalDate fin) {
        embauches.get(embauches.size() - 1).terminer(fin);
    }

}

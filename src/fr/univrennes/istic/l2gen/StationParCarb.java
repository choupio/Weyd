package fr.univrennes.istic.l2gen;

import java.util.ArrayList;
import java.util.List;

public class StationParCarb {
    @Override
    public String toString() {
        return "Station [id=" + id + ", cp=" + cp + ", pop=" + pop + ", adresse=" + adresse + ", ville=" + ville
                + ", horaires=" + horaires + ", rupture=" + rupture + ", fermeture=" + fermeture + ", prix_maj="
                + prix_maj + ", prix_id=" + prix_id + ", prix_nom=" + prix_nom + ", com_arm_code=" + com_arm_code
                + ", com_arm_name=" + com_arm_name + ", epci_code=" + epci_code + ", epci_name=" + epci_name
                + ", dep_code=" + dep_code + ", dep_name=" + dep_name + ", reg_code=" + reg_code + ", reg_name="
                + reg_name + ", rupture_nom=" + rupture_nom + ", rupture_debut=" + rupture_debut + ", rupture_fin="
                + rupture_fin + ", horaires_automate_24_24=" + horaires_automate_24_24 + ", prix_valeur=" + prix_valeur
                + ", services_service=" + services_service + ", geom=" + geom + "]";
    }

    private String id, cp, pop, adresse, ville, horaires, rupture, fermeture, prix_maj, prix_id, prix_nom, com_arm_code,
            com_arm_name, epci_code, epci_name, dep_code, dep_name, reg_code, reg_name, rupture_nom, rupture_debut,
            rupture_fin, horaires_automate_24_24;
    private double prix_valeur;
    private List<String> services_service;
    private Geom geom;

    // Constructeur par défaut nécessaire pour Jackson
    public StationParCarb() {
        services_service = new ArrayList<>();
        geom = new Geom();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public String getRupture() {
        return rupture;
    }

    public void setRupture(String rupture) {
        this.rupture = rupture;
    }

    public String getFermeture() {
        return fermeture;
    }

    public void setFermeture(String fermeture) {
        this.fermeture = fermeture;
    }

    public String getPrix_maj() {
        return prix_maj;
    }

    public void setPrix_maj(String prix_maj) {
        this.prix_maj = prix_maj;
    }

    public String getPrix_id() {
        return prix_id;
    }

    public void setPrix_id(String prix_id) {
        this.prix_id = prix_id;
    }

    public String getPrix_nom() {
        return prix_nom;
    }

    public void setPrix_nom(String prix_nom) {
        this.prix_nom = prix_nom;
    }

    public String getCom_arm_code() {
        return com_arm_code;
    }

    public void setCom_arm_code(String com_arm_code) {
        this.com_arm_code = com_arm_code;
    }

    public String getCom_arm_name() {
        return com_arm_name;
    }

    public void setCom_arm_name(String com_arm_name) {
        this.com_arm_name = com_arm_name;
    }

    public String getEpci_code() {
        return epci_code;
    }

    public void setEpci_code(String epci_code) {
        this.epci_code = epci_code;
    }

    public String getEpci_name() {
        return epci_name;
    }

    public void setEpci_name(String epci_name) {
        this.epci_name = epci_name;
    }

    public String getDep_code() {
        return dep_code;
    }

    public void setDep_code(String dep_code) {
        this.dep_code = dep_code;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getReg_code() {
        return reg_code;
    }

    public void setReg_code(String reg_code) {
        this.reg_code = reg_code;
    }

    public String getReg_name() {
        return reg_name;
    }

    public void setReg_name(String reg_name) {
        this.reg_name = reg_name;
    }

    public String getRupture_nom() {
        return rupture_nom;
    }

    public void setRupture_nom(String rupture_nom) {
        this.rupture_nom = rupture_nom;
    }

    public String getRupture_debut() {
        return rupture_debut;
    }

    public void setRupture_debut(String rupture_debut) {
        this.rupture_debut = rupture_debut;
    }

    public String getRupture_fin() {
        return rupture_fin;
    }

    public void setRupture_fin(String rupture_fin) {
        this.rupture_fin = rupture_fin;
    }

    public String getHoraires_automate_24_24() {
        return horaires_automate_24_24;
    }

    public void setHoraires_automate_24_24(String horaires_automate_24_24) {
        this.horaires_automate_24_24 = horaires_automate_24_24;
    }

    public double getPrix_valeur() {
        return prix_valeur;
    }

    public void setPrix_valeur(double prix_valeur) {
        this.prix_valeur = prix_valeur;
    }

    public List<String> getServices_service() {
        return services_service;
    }

    public void setServices_service(List<String> services_service) {
        this.services_service = services_service;
    }

    public Geom getGeom() {
        return geom;
    }

    public void setGeom(Geom geom) {
        this.geom = geom;
    }
}

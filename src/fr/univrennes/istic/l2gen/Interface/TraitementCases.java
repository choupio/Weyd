package fr.univrennes.istic.l2gen.Interface;

import java.util.HashMap;

public class TraitementCases {
    private HashMap<String, Boolean> isCheckedServ = Services.getIsCheckedServ();
    private HashMap<String, Boolean> isCheckedDept = Departement.getIsCheckedDept();
    private HashMap<String, Boolean> isCheckedCarb = Carburant.getIsCheckedCarb();
    private HashMap<String, Boolean> isCheckedStat = Statistique.getIsCheckedStat();
    private HashMap<String, Boolean>[] isCheckedDiag = Diag.getIsCheckedDiag();
    private Boolean isCheckedPos = Onglet.getIsSationsAffichees();
    private HashMap<String, Boolean> isCheckedReg = Region.getIsCheckedReg();

    public TraitementCases() {
        // Traitement des cases cochées
        traitementCarburants();
        traitementDepartements();
        traitementPosition();
        traitementRegions();
        traitementServices();
        traitementStatistiques();
    }

    // Traitement des carburants cochées et voir le diag qui va avec
    public void traitementCarburants() {
        // regarder quel carburant est coché et quel est son diagramme
    }

    // Traitement des services cochées
    public void traitementServices() {

    }

    // Traitement des départements cochées
    public void traitementDepartements() {
    }

    // Traitement des statistiques cochées
    public void traitementStatistiques() {
    }

    // Traitement de position coché
    public void traitementPosition() {
    }

    // Traitement des regions cochées
    public void traitementRegions() {
    }
}

package fr.univrennes.istic.l2gen.Interface;

import java.util.HashMap;

public class TraitementCases {
    private HashMap<String, Boolean> isCheckedServ = Services.getIsCheckedServ();
    private HashMap<String, Boolean> isCheckedDept = Departement.getIsCheckedDept();
    private HashMap<String, Boolean> isCheckedCarb = Carburant.getIsCheckedCarb();
    private HashMap<String, Boolean> isCheckedStat = Statistique.getIsCheckedStat();
    private HashMap<String, Boolean> isCheckedDiag = Diag.getIsCheckedDiag();
    private Boolean isCheckedPos = Onglet.getIsSationsAffichees();
    private HashMap<String, Boolean> isCheckedReg = Region.getIsCheckedReg();

    public TraitementCases() {
        // Traitement des cases cochées
        traitementCarburants();
        traitementDepartements();
        traitementDiagrammes();
        traitementPosition();
        traitementRegions();
        traitementServices();
        traitementStatistiques();
    }

    // Traitement des services cochées
    public void traitementServices() {
        
    }

    // Traitement des départements cochées
    public void traitementDepartements() {
    }

    // Traitement des carburants cochées
    public void traitementCarburants() {
    }

    // Traitement des statistiques cochées
    public void traitementStatistiques() {
    }

    // Traitement des diagrammes cochées
    public void traitementDiagrammes() {
    }

    // Traitement de position coché
    public void traitementPosition() {
    }

    // Traitement des regions cochées
    public void traitementRegions() {
    }
}

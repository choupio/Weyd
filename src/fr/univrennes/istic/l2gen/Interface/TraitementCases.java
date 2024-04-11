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
     
    public void isCheckedDept(){
        HashMap<String, Boolean> isCheckedDept = Departement.getIsCheckedDept();
        for (String department : isCheckedDept.keySet()) {
            Boolean isChecked = isCheckedDept.get(department);
            System.out.println("Department: " + department + ", isChecked: " + isChecked);
        }
    }
    public void isCheckedServ(){
        HashMap<String, Boolean> isCheckedServ = Services.getIsCheckedServ();
        for (String services : isCheckedServ.keySet()) {
            Boolean isChecked = isCheckedServ.get(services);
            System.out.println("Services: " + services + ", isChecked: " + isChecked);
        }
    }


}

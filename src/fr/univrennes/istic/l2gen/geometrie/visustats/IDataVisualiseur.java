package fr.univrennes.istic.l2gen.geometrie.visustats;

import fr.univrennes.istic.l2gen.geometrie.IForme;

public interface IDataVisualiseur extends IForme {
    // TODO le contrat/javadoc

    public IDataVisualiseur agencer();

    public IDataVisualiseur ajouterDonnees(String str, double... doubles);

    public IDataVisualiseur legender(String... strings);

    public IDataVisualiseur setOption(String... strings);
}

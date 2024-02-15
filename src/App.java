import fr.univrennes.istic.l2gen.geometrie.Polygone;

public class App {
    public static void main(String[] args) throws Exception {
        Polygone r1 = new Polygone(128, 128, 128, 256, 256, 256, 256, 128);
        r1.colorier("red");
        System.out.println(r1.enSVG());
    }
}

import fr.univrennes.istic.l2gen.geometrie.Rectangle;

public class App {
    public static void main(String[] args) throws Exception {
        Rectangle r1 = new Rectangle(15, 20, 200, 200);
        System.out.println(r1.enSVG());
    }
}

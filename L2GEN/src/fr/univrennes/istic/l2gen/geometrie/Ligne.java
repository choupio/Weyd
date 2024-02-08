package fr.univrennes.istic.l2gen.geometrie;
public class Ligne implements IForme{
    private Point[] ligne;
    public Ligne(double...l){
        ligne=new Point[l.length/2];
        int j=0;
        for(int i=0;i<l.length;i=i+2){
            ligne[j]=new Point(l[i],l[i+1]);
            j++;
        }
    }
    public void ajouterSommet(Point p){
        Point[] temp=ligne;
        ligne=new Point[temp.length+1];
        for(int i=0;i<temp.length;i++){
            ligne[i]=temp[i];
        }
        ligne[ligne.length-1]=p;
    }
    public void ajouterSommet(double x,double y){
        ajouterSommet(new Point(x, y));
    }
    public Point centre(){
        return ligne[ligne.length-1];
    }
    public String description(int identation){
        String result="Ligne";
        String identa="";
        for(int i=0;i<identation;i++){
            identa=identa + " ";
        }
        for(int i=0;i<ligne.length;i++){
            result=result+identa+ligne[i].x()+','+ligne[i].y();
        }
        return result;
    }
    public Double[] getSommets(){
        Double[]result=new Double[ligne.length*2];
        int y =0;
        for(int i=0;i<ligne.length;i++){
            result[y]=ligne[i].x();
            result[y+1]=ligne[i].y();
            y=y+2;
        }
        return result;
    }
    public double hauteur(){
        return ligne[ligne.length-1].y()-ligne[0].y();
    }
    public double largeur(){
        return ligne[ligne.length-1].x()-ligne[0].x();
    }
    public String enSVG(){
        String result="<polyline points=\"";
        result=result+ligne[0].x()+' '+ligne[0].y()+' ';
        for(int i=1;i<ligne.length;i++){
            result=result+ligne[i].y()+' '+ligne[i].y()+' ';
        }
        result=result+"\" fill=\"white\" stroke=\"black\"";
        return result;
    }
}
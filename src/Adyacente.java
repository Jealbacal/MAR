public class Adyacente {
    int destino;
    double peso;

    public Adyacente(int destino,double peso){
        this.destino=destino;
        this.peso=peso;
    }
    public Adyacente(int destino){
        this.destino=destino;
    }

    public String toString(){
        return destino + "("+ peso + ")";
    }
}

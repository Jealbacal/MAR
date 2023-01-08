public class Adyacente {
    int destino;
    int peso;

    public Adyacente(int destino,int peso){
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

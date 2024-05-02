package classes;

public abstract class Paquete {
    private int peso;
    private String destino;

    private int servicioAdicional;

    public Paquete(int peso, String destino, int servicioAdicional) {
        this.peso = peso;
        this.destino = destino;
        this.servicioAdicional = servicioAdicional;
    }
    public Paquete(){
        peso=0;
        destino="";
        servicioAdicional=0;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(int servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    public abstract double calcularCostoAdicional();
    public abstract double calcularTotalPaquete();

    @Override
    public String toString() {
        return "Paquete{" +
                "peso='" + peso + '\'' +
                ", destino='" + destino + '\'' +
                ", servicioAdicional='" + servicioAdicional + '\'' +
                '}';
    }
}
package classes;

import interfaces.icalcularTarifaEnvio;
import interfaces.iservicioAdicional;

public class PaqueteTierra extends Paquete implements iservicioAdicional, icalcularTarifaEnvio {
    private double distancia;
    private String tipoVehiculo;

    public PaqueteTierra(int peso, String destino, int servicioAdicional, double distancia, String tipoVehiculo) {
        super(peso, destino, servicioAdicional);
        this.distancia = distancia;
        this.tipoVehiculo = tipoVehiculo;
    }

    public PaqueteTierra(double distancia, String tipoVehiculo) {
        this.distancia = distancia;
        this.tipoVehiculo = tipoVehiculo;
    }
    public PaqueteTierra()
    {
        distancia=0;
        tipoVehiculo="";
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean sonIguales = false;
        if (obj != null) {

            if (obj instanceof PaqueteTierra) {
                PaqueteTierra aComparar = (PaqueteTierra) obj;
                if (getDistancia() == aComparar.getDistancia() && tipoVehiculo.equals(aComparar.tipoVehiculo) && getDestino().equals(aComparar.getDestino())) {
                    sonIguales = true;
                } else {
                    sonIguales = false;
                }
            }
        }
        return sonIguales;
    }

    @Override
    public String toString() {
        return super.toString()+"PaqueteTierra{" +
                "distancia=" + distancia +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ",precio = '" +calcularTotalPaquete()+'}';
    }

    @Override
    public double calcularCostoSeguro() {

        double precio=calcularTarifa()+1500;

        return precio;
    }

    @Override
    public double calcularCostoEntregaDia() {

        double precio=calcularTarifa()+(calcularTarifa()*0.25);
        return precio;
    }

    @Override
    public int calcularTarifa() {
    int tarifa=getPeso()*25;
    if(tipoVehiculo.equals("camion"))
    {
        tarifa+=tarifa*0.10;
    }
    if(distancia>100)
    {
        double extra=distancia-100;
        tarifa+=tarifa*(extra*0.05);
    }
    return tarifa;
    }

    @Override
    public double calcularCostoAdicional() {
        int tipoServicio=getServicioAdicional();
        double precio=0;
        if (tipoServicio==0)
        {
           precio= calcularCostoSeguro();
        }
        else if(tipoServicio==1)
        {
            precio=calcularCostoEntregaDia();
        }
        return precio;
    }

    @Override
    public double calcularTotalPaquete() {

        double preciototal=0;
        if(getServicioAdicional()==-1)
        {
            preciototal=calcularTarifa();
        }
        else if (getServicioAdicional()==0)
        {
            preciototal=calcularCostoSeguro();
        }
        else if (getServicioAdicional()==1)
        {
            preciototal=calcularCostoEntregaDia();
        }
        return preciototal;

    }

}

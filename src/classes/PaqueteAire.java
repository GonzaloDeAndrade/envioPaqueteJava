package classes;


import interfaces.icalcularTarifaEnvio;
import interfaces.iservicioAdicional;

public class PaqueteAire extends Paquete implements iservicioAdicional, icalcularTarifaEnvio {

    private String aerolinea;
    private String claseEnvio;

    public PaqueteAire(int peso, String destino, int servicioAdicional, String aerolinea, String claseEnvio) {
        super(peso, destino, servicioAdicional);
        this.aerolinea = aerolinea;
        this.claseEnvio = claseEnvio;
    }

    public PaqueteAire(String aerolinea, String claseEnvio) {
        this.aerolinea = aerolinea;
        this.claseEnvio = claseEnvio;
    }
    public  PaqueteAire(){
        aerolinea="";
        claseEnvio="";
    }



    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getClaseEnvio() {
        return claseEnvio;
    }

    public void setClaseEnvio(String claseEnvio) {
        this.claseEnvio = claseEnvio;
    }

    @Override
    public boolean equals(Object obj) {
        boolean sonIguales = false;
        if (obj != null) {

            if (obj instanceof PaqueteAire) {
                PaqueteAire aComparar = (PaqueteAire) obj;
                if (getAerolinea()== aComparar.getAerolinea() && claseEnvio.equals(aComparar.getClaseEnvio())&& getPeso()==aComparar.getPeso()) {
                    sonIguales=true;
                } else {
                    sonIguales = false;
                }
            }
        }
        return sonIguales;
    }

    @Override
    public String toString() {
        return super.toString()+"PaqueteAire{" +
                "aerolinea='" + aerolinea + '\'' +
                ", claseEnvio='" + claseEnvio + '\'' +
                ",precio = '" +calcularTotalPaquete()+'}';
    }

    @Override
    public double calcularCostoSeguro() {


        double precio=calcularTarifa()+2500;

        return precio;
    }

    @Override
    public double calcularCostoEntregaDia() {

        double precio=calcularTarifa()+(calcularTarifa()*0.5);
        return precio;
    }

    @Override
    public int calcularTarifa() {
        int tarifa=getPeso()*30;
        if (getAerolinea().equals("AA"))
        {
            tarifa+=tarifa*0.5;
        }
        if(getClaseEnvio().equals("express"))
        {
            tarifa+=tarifa+1000;
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

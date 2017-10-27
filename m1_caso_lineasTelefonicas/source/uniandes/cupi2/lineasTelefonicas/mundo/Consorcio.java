package uniandes.cupi2.lineasTelefonicas.mundo;

public class Consorcio {
	 //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
        
	private Empresa empresaA;
	private Empresa empresaB;
	private Empresa empresaC;
 
    /**
    * Constructor de la clase Consorcio
    */
    public Consorcio()
    {
    		empresaA = new Empresa();
    		empresaA.inicializar();
    		empresaB = new Empresa();
    		empresaB.inicializar();
    		empresaC = new Empresa();
    		empresaC.inicializar();
    }

    /**
    * Calcula el total de dinero que debe pagar el consorcio por consumo en lineas telefonicas
    * @return cantidad a pagar por consumo telefonico
    */
    public double darTotalFacturaConsorcio ( )
    {
        return empresaA.darTotalCostoLlamadas() + empresaB.darTotalCostoLlamadas() + empresaC.darTotalCostoLlamadas();
    }

    /**
    * Calcula el costo de impuestos que debe pagar el consorcio por concepto de inpuestos telefonicos
    * @return impuestos
    */
    public double darTotalImpuestos()
    {
        double impuestoEmpresaA = (1 * empresaA.darTotalNumeroLlamadas() ) + (0.04 * empresaA.darTotalCostoLlamadas());
        double impuestoEmpresaB = (0.01 * empresaB.darTotalMinutos() ) + ( empresaB.darTotalNumeroLlamadas()* 3);
        double impuestoEmpresaC = empresaC.darTotalCostoLlamadas() * 0.05;
    	
    		return  impuestoEmpresaA + impuestoEmpresaB + impuestoEmpresaC;	   	
    }
}

package arraysOrdenacionBusqueda;

import arrays.LeerTeclado;

public class OrdenacionDptos {

	public static void main(String[] args) {
		String [] dptos={"Informatica", "Contabilidad", "Recursos Humanos", "Administracion", "Marketing", "Ventas", "Produccion", "Logistica"};
		double [] presup={80000, 50000, 40000, 12000, 32000, 42000, 55000, 23000};
		
		
		
		System.out.println("El array de departamentos y presupuestos desordenados es: ");
		
		visualizar(dptos, presup);
		System.out.println();
				
		//ordenamos
		
		ordenar(dptos, presup);
		
		System.out.println("El array de departamentos y presupuestos ordenados por departamento es: ");
		
		visualizar(dptos, presup);
		System.out.println();
				
		System.out.println("Introduce el nombre de un departamento a buscar o Fin para salir");
		String nombre=LeerTeclado.readString();
			
		while (!nombre.equalsIgnoreCase("Fin")){
			buscar(nombre, dptos, presup);
			System.out.println("Introduce el nombre de un departamento a buscar o Fin para salir");
			nombre=LeerTeclado.readString();
		}
		
		System.out.println("Departamento de mayor presupuesto");
		mayorPresupuesto(dptos, presup);
		

	}
	
	public static void visualizar(String[] departamentos, double[] presupuestos){
		
		
		for (int i=0;i<departamentos.length;i++){
			System.out.println(departamentos[i]+" "+presupuestos[i]);
			
		}
			
		System.out.println();
	}
	
	public static void ordenar(String[] departamentos, double [] presupuestos){
		String aux; double aux2;
		
		for (int i=0; i<departamentos.length-1; i++)
			for (int j=i+1; j<departamentos.length; j++)
				if (departamentos[i].compareTo(departamentos[j])>0) //Usar compareTo 
				{			
						aux=departamentos[i];
						departamentos[i]=departamentos[j]; 
						departamentos[j]=aux;
						
						aux2=presupuestos[i];
						presupuestos[i]=presupuestos[j];
						presupuestos[j]=aux2;
				}
	}
	
	public static void buscar(String nombre, String[] departamentos, double[] presupuestos){
		
		int limInferior=0, limSuperior=departamentos.length-1, medio;
		boolean encontrado=false;
		
		do
		{	medio=(int)(limInferior+limSuperior)/2;
			if (departamentos[medio].compareToIgnoreCase(nombre)==0){
				encontrado=true;
				System.out.println("El presupuesto del departamento "+nombre+ " es "+presupuestos[medio]);
				
			}
			else
				if (departamentos[medio].compareToIgnoreCase(nombre)>0)//la búsqueda se restringe a la mitad izquierda
					limSuperior=medio-1; 
				else //idem mitad derecha
					limInferior=medio+1;
		}
		while (!encontrado && limInferior<=limSuperior);
		
		if (!encontrado)
			
			System.out.println("El departamento no se encuentra en la lista");
	}
	
	public static void mayorPresupuesto (String[] departamentos, double[] presupuestos){
		
		double max=Double.MIN_VALUE;
		int iMax=0;
		
		for (int i = 0; i < presupuestos.length; i++) {
			if (presupuestos[i]>max){
				max=presupuestos[i];
				iMax=i;
			}			
		}
		System.out.println("El presupuesto mayor es "+max+" y corresponde al departamento "+departamentos[iMax]);
	}


}
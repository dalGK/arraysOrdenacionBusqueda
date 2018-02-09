package arraysOrdenacionBusqueda;

import arrays.LeerTeclado;

public class OrdenacionEjerc1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arrayNum[];
		int num;
		boolean encontrado=false;
		
		arrayNum=new int[30];
		
		//rellenamos el array de forma aleatoria
		introdArray(arrayNum);
		
		//visualizamos el array 
		System.out.println("El array desordenado es");		
		verArray(arrayNum);
		System.out.println();
		
		System.out.println("Introduce un número entre 1 y 100 para buscarlo en el array desordenado");
		num=LeerTeclado.readInteger();
		
		//búsqueda secuencial con el array  desordenado: se saldrá  cuando lo encuentre o cuando termine el array
		busqSecuencialDesordenado(arrayNum, num);

		//Ordenamos el array
		System.out.println("Ordenamos el array ");
		
		
		arrayNum=ordenarArray(arrayNum);
		verArray(arrayNum);
		System.out.println();
		System.out.println("Buscamos ahora el número en el array ordenado por búsqueda secuencial");
		
		busqSecuencialOrdenado(arrayNum, num);

		//Busqueda binaria (solo es posible en el arrya ordenado)
		System.out.println("Buscamos ahora el número en el array ordenado por búsqueda binaria");
		busqBinaria(arrayNum, num);

	}





	

	


	public static void introdArray(int[] array) {
		for (int i=0; i<array.length; i++){
			array[i]=(int)(Math.random()*100+1);
		}
	}

	public static void verArray(int[] array) {
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	
	public static void busqSecuencialDesordenado(int[] array, int num){
		//búsqueda secuencial con el array  desordenado: se saldrá  cuando lo encuentre o cuando termine el array
		boolean encontrado=false;//si queremos que encuentre todas las posibles ocurrencias no usaremos el boolean
		for (int i=0; i<array.length && encontrado==false; i++){ 			
			if(array[i]==num){
				encontrado=true;
				System.out.println("El número "+num+" está en la posición "+i+" del array");
			}
		}
		if(!encontrado){
			System.out.println("El número no está en el array");
		}
	}
	
	public static void busqSecuencialOrdenado(int[] array, int num) {
		// busqueda secuencial con el array ordenado: se saldrá cuando lo encuentre, cuando deduzca que no está porque
		//encuentre una componente mayor (arrayNum[i]>num) o cuando termine el arrayboolean encontrado;
		boolean encontrado=false;
		//si queremos que encuentre todas las posibles ocurrencias no usaremos el boolean		
		for (int i=0; i<array.length && encontrado==false && array[i]<=num; i++){
			if(array[i]==num){
				encontrado=true;
				System.out.println("El número "+num+" está en la posición "+i+" del array");
			}
		}
		if(!encontrado){
			System.out.println("El número no está en el array");
		}
	}

	public static int[] ordenarArray(int array[]){
			int aux;
			for(int i=array.length-1;i>0;i--){
				for(int j=0;j<i;j++){
					if(array[j]>array[j+1]){
						aux=array[j+1];
						array[j+1]=array[j];
						array[j]=aux;
					}
				}
			}
			return array;
		}
	
	public static void busqBinaria(int[] array, int num) {
		boolean encontrado;
		encontrado=false;
		int limiteInf=0, limiteSup=array.length-1, medio;
		do{
			medio=(limiteInf+limiteSup)/2;
			if(array[medio]==num){
				encontrado=true;
				System.out.println("El número "+num+" está en la posición "+medio+" del array");
			}
			else{
				if(array[medio]>num){
					limiteSup=medio-1;
				}
				else{
					limiteInf=medio+1;
				}
			}
		}while(!encontrado&&limiteInf<=limiteSup);
		if(!encontrado){
			System.out.println("El número no está en el array");
		}
	}

	
	
}

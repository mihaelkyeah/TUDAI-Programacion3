package ejercicio2;
import java.util.List;
import java.util.ArrayList;

public class PrincipalEj2 {
	
	private List<Integer> arreglo;
	
	public PrincipalEj2() {
		arreglo = new ArrayList<>();
	}
	
	public void agregarValor(int valor) {
		arreglo.add(valor);
	}
	
	public boolean encuentraEnArreglo(int numero) {
		return this.seEncuentraEnElArregloDelObjeto(numero, 0);
	}
	
	private boolean seEncuentraEnElArregloDelObjeto(int numero, int pos) {
		if(pos < arreglo.size() && (numero >= arreglo.get(0) || numero <= arreglo.get(arreglo.size()-1))) {
				if(numero > arreglo.get(pos)) {
					System.out.println(arreglo.get(pos));
					return seEncuentraEnElArregloDelObjeto(numero, pos+1);
				}
				else
					return arreglo.get(pos) == numero;
		}
		else
			return false;
	}

	public static void main(String[] args) {
		
		/*
		MySimpleLinkedList<Integer> miListaSimple = new MySimpleLinkedList<Integer>();
		
		miListaSimple.insertFront(1);
		miListaSimple.insertFront(3);
		miListaSimple.insertFront(6);
		miListaSimple.insertFront(2);
		miListaSimple.insertFront(5);
		miListaSimple.insertFront(4);
		
		System.out.println("Encuentra elemento en la lista vinculada");
		System.out.println(miListaSimple.encuentraElemento(5));
		*/
		// :D
		// FELIZ DOMINGO PARA TOODOOOOOS
		
		PrincipalEj2 elementoPrincipalEj2 = new PrincipalEj2();
		 
		elementoPrincipalEj2.agregarValor(1);
		elementoPrincipalEj2.agregarValor(3);
		elementoPrincipalEj2.agregarValor(6);
		
		System.out.println("Encuentra elemento en el arreglo");
		System.out.println(elementoPrincipalEj2.encuentraEnArreglo(2));
		
		// NO ANDA D:
		// ^ era un > :^)

	}

}
package ejercicio1;
import java.util.List;
import java.util.ArrayList;

public class PrincipalEj1 {
	
	private List<Integer> arreglo;
	
	public PrincipalEj1() {
		this.arreglo = new ArrayList<Integer>();
	}
	
	public void agregarValor(int valor) {
		this.arreglo.add(valor);
	}
	
	// Por mí (con ayuda del Búho)
	
	private boolean recorrerElArregloParaVerificarSiEstaOrdenado(List<Integer> arr, int pos) {
		boolean estaOrdenado = true;
		
		if((pos < arr.size()) && (int)(arr.get(pos)) > (int)(arr.get(pos-1)))
				estaOrdenado = recorrerElArregloParaVerificarSiEstaOrdenado(arr,++pos);
			else if (pos == arr.size())
				estaOrdenado = true;
			else
				estaOrdenado = false;
		
		return estaOrdenado;
	}
		
	public boolean estaOrdenado() {
		return this.recorrerElArregloParaVerificarSiEstaOrdenado(this.arreglo, 1);
	}
	
	// Por Facu
	
	public static boolean esAscendente(int[] arr, int i) {
		boolean asc = arr[i] > arr[i - 1];
		if (i > 1 && asc) {
			asc = esAscendente(arr, i - 1);
		}
		return asc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrincipalEj1 objetoConArreglo = new PrincipalEj1();
		
		objetoConArreglo.agregarValor(2);
		objetoConArreglo.agregarValor(5);
		objetoConArreglo.agregarValor(6);
		objetoConArreglo.agregarValor(12);
		objetoConArreglo.agregarValor(18);
		
		System.out.println(objetoConArreglo.estaOrdenado());
		
	}

}

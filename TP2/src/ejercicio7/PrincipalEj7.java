package ejercicio7;
import utils.*;

public class PrincipalEj7 {
	
	public static void main(String[] args) {
		
		int[] valoresIniciales = new int[] {};
		TreeWithNode miArbol = new TreeWithNode(valoresIniciales);

		System.out.println(miArbol.getPathSumList());
		
		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2) );
		System.out.println( miArbol.getFrontier() );

		miArbol.add(23);
		miArbol.add(21);
		miArbol.delete(3);
		miArbol.delete(12);

		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2) );
		System.out.println( miArbol.getFrontier() );

		miArbol.add(65);
		miArbol.delete(21);
		miArbol.delete(8);
		miArbol.add(5);

		miArbol.printPreOrder();
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2) );
		System.out.println( miArbol.getFrontier());
	}

}
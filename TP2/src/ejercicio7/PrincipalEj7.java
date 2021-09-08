package ejercicio7;
import utils.*;

public class PrincipalEj7 {
	
	public static void main(String[] args) {
		
		TreeWithNode myTree1 = new TreeWithNode(new int[] {8, 4, 12, 2, 1, 3, 7, 11, 25, 9});
		
		/*
		
		System.out.println("Árbol inicializado con arreglo");
		System.out.println("Tiene 6?");
		System.out.println(myTree1.hasElem(6));
		System.out.println("Tiene 3?");
		System.out.println(myTree1.hasElem(3));
		
		*/
		
//		System.out.println("Altura del árbol:");
//		System.out.println(myTree1.getHeight());
		
		// TreeWithNode myTree2 = new TreeWithNode(1);
		
		myTree1.printPreOrder();
		System.out.println();
		
		System.out.println("Hojas del árbol:");
		System.out.println(myTree1.getFrontier());
		
		// Anduvo a la primera 8-)
		
		// System.out.println(myTree1.getElemAtLevel(2));
		
		// ANDA :D
		
		// System.out.println(myTree1.getMaxElem());
		
		// ANDA! ^O^
		
		myTree1.delete(4);
		myTree1.printPreOrder();
		System.out.println();
		
	}

}
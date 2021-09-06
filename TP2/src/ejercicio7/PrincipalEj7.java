package ejercicio7;
import utils.*;

public class PrincipalEj7 {
	
	public static void main(String[] args) {
		
		TreeWithNode myTree1 = new TreeWithNode(new int[] {3, 1, 2, 4, 5, 6});
		
		System.out.println("Árbol inicializado con arreglo");
		
		System.out.println("Tiene 6?");
		System.out.println(myTree1.hasElem(6));
		System.out.println("Tiene 3?");
		System.out.println(myTree1.hasElem(3));
		
		System.out.println("Altura del árbol:");
		System.out.println(myTree1.getHeight());
		
		// TreeWithNode myTree2 = new TreeWithNode(1);
		
		myTree1.printPreOrder();
		
	}

}
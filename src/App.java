import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {

        System.out.println("Nombre: Erika Collaguazo");
        ArbolBinario arbol = new ArbolBinario();
        arbol.insert(50);
        arbol.insert(17);
        arbol.insert(76);
        arbol.insert(9);
        arbol.insert(23);
        arbol.insert(54);
        arbol.insert(14);
        arbol.insert(19);

        System.out.println("Peso del arbol = " + arbol.contarNodos());
        System.out.println("Altura es = " + arbol.getHeightRec());

        System.out.println("Arbol InOrder");
        arbol.inOrder();

        System.out.println("Arbol InOrder con alturas");
        arbol.inOrderConAlturas();

        System.out.println("Arbol InOrder con factor de equilibrio");
        arbol.inOrderConBalance();

        boolean estaEquilibrado = arbol.arbolEquilibrado();
        System.out.println("Arbol esta equilibrado = " + (estaEquilibrado ? "TRUE" : "FALSE"));

        if (estaEquilibrado) {
            int nuevoValor = 15;
            arbol.insert(nuevoValor);
            System.out.println("Agregamos valor = " + nuevoValor);

            System.out.println("Arbol InOrder con factor de equilibrio");
            arbol.inOrderConBalance();
        }

        arbol.mostrarNodosDesequilibrados();
    }
}
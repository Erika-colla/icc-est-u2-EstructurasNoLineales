package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        }
        return node;
    }

    public int contarNodos() {
        return contarNodosRec(root);
    }

    private int contarNodosRec(Node node) {
        if (node == null) return 0;
        return 1 + contarNodosRec(node.getLeft()) + contarNodosRec(node.getRight());
    }

    public int getHeightRec() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeightRec(node.getLeft()), getHeightRec(node.getRight()));
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inOrderRec(node.getRight());
        }
    }

    public void inOrderConAlturas() {
        inOrderConAlturasRec(root);
        System.out.println();
    }

    private void inOrderConAlturasRec(Node node) {
        if (node != null) {
            inOrderConAlturasRec(node.getLeft());
            System.out.print(node.getValue() + "(h=" + getHeightRec(node) + "), ");
            inOrderConAlturasRec(node.getRight());
        }
    }

    public void inOrderConBalance() {
        inOrderConBalanceRec(root);
        System.out.println();
    }

    private void inOrderConBalanceRec(Node node) {
        if (node != null) {
            inOrderConBalanceRec(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            System.out.print(node.getValue() + " (bf=" + bf + "), ");
            inOrderConBalanceRec(node.getRight());
        }
    }

    public boolean arbolEquilibrado() {
        return esEquilibrado(root);
    }

    private boolean esEquilibrado(Node node) {
        if (node == null) return true;
        int bf = Math.abs(getHeightRec(node.getLeft()) - getHeightRec(node.getRight()));
        return bf <= 1 && esEquilibrado(node.getLeft()) && esEquilibrado(node.getRight());
    }

    public void mostrarNodosDesequilibrados() {
        System.out.println("Nodos desequilibrados:");
        mostrarNodosDesequilibradosRec(root);
    }

    private void mostrarNodosDesequilibradosRec(Node node) {
        if (node != null) {
            mostrarNodosDesequilibradosRec(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            if (bf <= -2 || bf >= 2) {
                System.out.print(node.getValue() + " (fE = " + bf + ")");
            }
            mostrarNodosDesequilibradosRec(node.getRight());
        }
    }
}
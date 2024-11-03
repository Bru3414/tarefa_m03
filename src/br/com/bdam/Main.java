package br.com.bdam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> obterSubconjuntos(int[] S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        gerarSubconjuntos(S, n, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void gerarSubconjuntos(int[] S, int n, int indice, List<Integer> atual, List<List<Integer>> resultado) {
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        for (int i = indice; i < S.length; i++) {
            atual.add(S[i]);
            gerarSubconjuntos(S, n, i + 1, atual, resultado);
            atual.remove(atual.size() - 1);
        }
    }

    public static List<Integer> calcularTroco(int quantia, int[] moedas) {
        List<Integer> troco = new ArrayList<>();
        Arrays.sort(moedas);

        for (int i = moedas.length - 1; i >= 0; i--) {
            while (quantia >= moedas[i]) {
                quantia -= moedas[i];
                troco.add(moedas[i]);
            }
        }

        return troco;
    }

    public static void main(String[] args) {
        int[] S1 = {1, 2, 3};
        int n1 = 2;
        System.out.println("Subconjuntos de " + n1 + " elementos de S1: " + obterSubconjuntos(S1, n1));

        int[] S2 = {1, 2, 3, 4};
        int n2 = 1;
        System.out.println("Subconjuntos de " + n2 + " elementos de S2: " + obterSubconjuntos(S2, n2));

        int[] S3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int n3 = 3;
        System.out.println("Subconjuntos de " + n3 + " elementos de S2: " + obterSubconjuntos(S3, n3));

        int quantia = 18;
        int[] moedas = {5, 2, 1};

        List<Integer> troco = calcularTroco(quantia, moedas);
        System.out.println("Moedas usadas para dar o troco de " + quantia + ": " + troco);
        System.out.println("Número total de moedas: " + troco.size());

        int quantia2 = 39;
        int[] moedas2 = {8, 3, 1};

        List<Integer> troco2 = calcularTroco(quantia2, moedas2);
        System.out.println("Moedas usadas para dar o troco de " + quantia2 + ": " + troco2);
        System.out.println("Número total de moedas: " + troco2.size());
    }
}

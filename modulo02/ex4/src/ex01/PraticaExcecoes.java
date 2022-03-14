package ex01;

public class PraticaExcecoes {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

//        exercicioA(a, b);

        exercicioB(a, b);

        System.out.println("Programa finalizado");
    }

    private static void exercicioB(int a, int b) {
        try {
            int result = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Não pode ser dividido por zero");
        }
    }

    private static void exercicioA(int a, int b) {
        try {
            int result = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Ocorreu um erro");
        }
    }
}

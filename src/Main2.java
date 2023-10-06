import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cantidad total de trabajo (N): ");
        int N = scanner.nextInt();
        System.out.print("Introduce el número de hilos (M): ");
        int M = scanner.nextInt();

        int blockSize = N / M;

        Thread[] threads = new Thread[M];

        for (int i = 0; i < M; i++) {
            final int start = i * blockSize;
            final int end = (i == M - 1) ? N : (i + 1) * blockSize;
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    int cuadrado = j * j;
                    System.out.println("Hilo " + Thread.currentThread().getId() + ": Trabajo " + j + " - Cuadrado: " + cuadrado);
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}

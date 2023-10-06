import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Introduce la cantidad total de trabajo (N): ");
            int N = scanner.nextInt();
            System.out.print("Introduce el número de hilos (M): ");
            int M = scanner.nextInt();

            Thread[] threads = new Thread[M];


            for (int i = 0; i < M; i++) {
                final int threadId = i;

                threads[i] = new Thread(() -> {
                    for (int j = threadId; j < N; j += M) {
                        int cuadrado = j * j;
                        System.out.println("Hilo " + threadId + ": Trabajo " + j + " - Cuadrado: " + cuadrado);
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
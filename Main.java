import Atividade1.*;
import Atividade2.*;
import Atividade3.*;
import Atividade4.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println();
            System.out.println("Escolha uma atividade: 1, 2, 3, 4, 5, 6 ou 0 para sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    Atividade1();
                    break;

                case 2:
                    Atividade2();
                    break;

                case 3:
                    Atividade3();
                    break;

                case 4:
                    Atividade4();
                    break;
            }
        } while(escolha != 0);
    }

    public static void Atividade1(){
        //Threads
        Thread thread = new Thread(new ClasseRunnable());

        //Inicia a thread
        thread.start();

        try{
            //Espera a thread terminar
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Atividade2(){
        //Threads
        Thread pares = new Thread(new NumerosPares(54));
        Thread impares = new Thread(new NumerosImpares(54));

        //Inicia todas as threads
        pares.start();
        impares.start();

        try{
            //Aguarda todas terminarem
            pares.join();
            impares.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Atividade3(){
        //Variável de controle
        Controle controle = new Controle();

        //Threads
        Thread threadPares = new Thread(new NumerosParesWait(54, controle));
        Thread threadImpares = new Thread(new NumerosImparesWait(54, controle));

        //Inicia todas as threads
        threadPares.start();
        threadImpares.start();

        try {
            //Aguarda todas terminarem
            threadPares.join();
            threadImpares.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Atividade4(){
        //Contador
        Contador contador = new Contador();

        //Threads
        Thread thread1 = new Thread(new Incrementador(contador, 1));
        Thread thread2 = new Thread(new Incrementador(contador, 2));
        Thread thread3 = new Thread(new Incrementador(contador, 3));
        Thread thread4 = new Thread(new Incrementador(contador, 4));
        Thread thread5 = new Thread(new Incrementador(contador, 5));

        //Inicia todas as threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            //Espera todas as threads terminarem a execução
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

            //Imprime o valor total no contador(tem que ser 500000)
            System.out.println("Valor total no contador: " + contador.getValor());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

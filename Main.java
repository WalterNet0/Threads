import Atividade1.ClasseRunnable;
import Atividade2.NumerosImpares;
import Atividade2.NumerosPares;
import Atividade3.Controle;
import Atividade3.NumerosImparesWait;
import Atividade3.NumerosParesWait;

public class Main {
    public static void main(String[] args) {
        ClasseRunnable runnable = new ClasseRunnable();
        Controle controle = new Controle();

        NumerosPares par = new NumerosPares(54);
        NumerosImpares impar = new NumerosImpares(77);

        NumerosParesWait parWait = new NumerosParesWait(54, controle);
        NumerosImparesWait imparWait = new NumerosImparesWait(54, controle);

        Thread threadPares = new Thread(parWait);
        Thread threadImpares = new Thread(imparWait);

        threadPares.start();
        threadImpares.start();

        try{
            threadPares.join();
            threadImpares.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

package comunicador.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado extends Thread {

    private BufferedReader teclado;

    public Teclado() {
        teclado = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String mensagem = "";
        try {
            while (true) {
                System.out.print(Servidor.getPrompt());
                mensagem = teclado.readLine();
                if (mensagem != null) {
                    if (mensagem.trim().equals("/sair")) {
                        break;
                    } else {
                        Servidor.comunicar(mensagem);
                    }
                }
            }
            Servidor.sair();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

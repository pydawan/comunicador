package comunicador.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) {
        Socket conexao = null;
        try {
            conexao = new Socket("localhost", 8000);
            System.out.println("\nConectando-se ao Comunicador Server.\n");
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(
                    conexao.getInputStream()
                )
            );
            String mensagem;
            while (true) {
                mensagem = entrada.readLine();
                if (mensagem != null) {
                    System.out.println(mensagem);
                } else {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
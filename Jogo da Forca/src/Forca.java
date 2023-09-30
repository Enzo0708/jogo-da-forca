import javax.swing.*;
import java.util.Random;

public class Forca {
    String palavra;
    String palavraEscondida;
    int tentativasRestantes;
    static final int MAX_TENTATIVAS = 6;
    static final String[] PALAVRAS = {
            "cachorro", "elefante", "girafa", "leao", "tigre",
            "macaco", "gato", "peixe", "papagaio", "hamster",
            "rato", "cobra", "lagarto", "jacare", "panda",
            "golfinho", "avestruz", "camelo", "iguana", "foca",
            "puma", "zebra", "morcego", "rinoceronte", "polvo",
            "arara", "salamandra", "pombo", "coruja", "tartaruga",
            "esquilo", "ornitorrinco", "peixinho", "pinguim", "boi",
            "cavalo", "touro", "baleia", "veado", "lobo",
            "pantera", "raposa", "sabia", "tucano", "suricate"};

    public Forca() {
        Random random = new Random();
        int indicePalavra = random.nextInt(PALAVRAS.length);
        this.palavra = PALAVRAS[indicePalavra].toLowerCase();
        this.palavraEscondida = geraUnderscores(palavra.length());
        this.tentativasRestantes = MAX_TENTATIVAS;
    }

    public void jogar() {
        while (tentativasRestantes > 0) {
            String tentativa = JOptionPane.showInputDialog(
                    "Palavra: " + palavraEscondida + "\n" +
                            "Tentativas Restantes: " + tentativasRestantes + "\n" +
                            "Informe uma letra: "
            ).toLowerCase();

            if (tentativa.length() != 1 || !Character.isLetter(tentativa.charAt(0))) {
                JOptionPane.showMessageDialog(null, "Por favor, informe uma única letra válida.");
                continue;
            }

            if (palavra.contains(tentativa)) {
                atualizarPalavraEscondida(tentativa);
            } else {
                tentativasRestantes--;
            }

            if (palavraEscondida.equals(palavra)) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você acertou a palavra: " + palavra);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Suas tentativas acabaram. A palavra era: " + palavra);
    }

    private void atualizarPalavraEscondida(String letra) {
        StringBuilder novaPalavraEscondida = new StringBuilder(palavraEscondida);
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra.charAt(0)) {
                novaPalavraEscondida.setCharAt(i, letra.charAt(0));
            }
        }
        palavraEscondida = novaPalavraEscondida.toString();
    }

    private String geraUnderscores(int tamanho) {
        StringBuilder underscores = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            underscores.append("_");
        }
        return underscores.toString();
    }
}

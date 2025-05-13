package Personagem;

import java.util.ArrayList;

public class Personagem {
	private String nome;
	private ArrayList<Boolean> tomouCafe;
    private ArrayList<Boolean> escolhaAmbiental;

    public Personagem() {
        tomouCafe = new ArrayList<>();
        escolhaAmbiental = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            tomouCafe.add(false);
            escolhaAmbiental.add(false);
        }
    }

    public void tomarCafe(int dia) {
        tomouCafe.set(dia, true);
    }

    public boolean tomouCafe(int dia) {
        return tomouCafe.get(dia);
    }

    public void setEscolhaAmbiental(int dia) {
        escolhaAmbiental.set(dia, true);
    }

    public boolean getEscolhaAmbiental(int dia) {
        return escolhaAmbiental.get(dia);
    }

    public int getPontuacaoAmbiental() {
        int score = 0;
        for (int i = 1; i <= 2; i++) {
            if (getEscolhaAmbiental(i)) score++;
        }
        return score;
    }

    public int getPontuacaoSaude() {
        int score = 0;
        for (int i = 1; i <= 2; i++) {
            if (tomouCafe.get(i)) score++;
        }
        return score;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}


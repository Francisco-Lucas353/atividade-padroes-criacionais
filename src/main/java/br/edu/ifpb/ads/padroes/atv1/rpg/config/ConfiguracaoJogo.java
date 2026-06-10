package br.edu.ifpb.ads.padroes.atv1.rpg.config;

public class ConfiguracaoJogo {

    private static ConfiguracaoJogo instancia;
    private int nivelDificuldade;

    // Construtor privado impede a criação externa com "new"
    private ConfiguracaoJogo() {
        this.nivelDificuldade = 1;
    }

    public static ConfiguracaoJogo getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoJogo();
        }
        return instancia;
    }

    public int getNivelDificuldade() { return nivelDificuldade; }
    public void setNivelDificuldade(int nivel) { this.nivelDificuldade = nivel; }
}
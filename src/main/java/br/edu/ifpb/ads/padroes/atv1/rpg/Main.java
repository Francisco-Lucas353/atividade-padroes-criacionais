package br.edu.ifpb.ads.padroes.atv1.rpg;

import br.edu.ifpb.ads.padroes.atv1.rpg.config.ConfiguracaoJogo;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO O JOGO ===");

        // 1. Testando o singleton
        ConfiguracaoJogo config1 = ConfiguracaoJogo.getInstancia();
        config1.setNivelDificuldade(3); // Alterando para o modo difícil

        ConfiguracaoJogo config2 = ConfiguracaoJogo.getInstancia();
        System.out.println("Dificuldade atual (Singleton): " + config2.getNivelDificuldade());
        System.out.println("Mesma instância em memória? " + (config1 == config2));
        System.out.println();

        // 2. Testando FACTORY METHOD + ABSTRACT FACTORY + BUILDER
        System.out.println("=== CRIANDO PERSONAGENS ===");

        CriadorPersonagemBase criadorGuerreiro = new CriadorGuerreiro();
        Personagem humanoGuerreiro = criadorGuerreiro.fabricar("Aragorn", "Humano");
        System.out.println(humanoGuerreiro);

        CriadorPersonagemBase criadorMago = new CriadorMago();
        Personagem elfoMago = criadorMago.fabricar("Frieren", "Elfo");
        System.out.println(elfoMago);

        CriadorPersonagemBase criadorArqueiro = new CriadorArqueiro();
        Personagem orcArqueiro = criadorArqueiro.fabricar("Orcoso", "Orc");
        System.out.println(orcArqueiro);
        System.out.println();

        // 3. Testando o PROTOTYPE
        System.out.println("=== TESTANDO CLONE ===");

        Personagem heroiLendario = humanoGuerreiro.clone();
        heroiLendario.setNome(humanoGuerreiro.getNome() + " o Lendário");
        heroiLendario.setForca(99);
        heroiLendario.setArma(new Arma("Excalibur", 50, "Espada Sagrada"));

        System.out.println("Original: " + humanoGuerreiro);
        System.out.println("Clonado e Modificado: " + heroiLendario);
    }
}
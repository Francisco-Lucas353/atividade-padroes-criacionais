package br.edu.ifpb.ads.padroes.atv1.rpg;

import java.util.Arrays;

public class Personagem implements Cloneable {

    private String nome;
    private String raca;
    private String classe;
    private int forca;
    private int inteligencia;
    private int agilidade;
    private int vida;
    private int mana;
    private Arma arma;
    private Armadura armadura;
    private String[] habilidades;

    // O construtor é privado para obrigar o uso do Builder
    private Personagem(Builder builder) {
        this.nome = builder.nome;
        this.raca = builder.raca;
        this.classe = builder.classe;
        this.forca = builder.forca;
        this.inteligencia = builder.inteligencia;
        this.agilidade = builder.agilidade;
        this.vida = builder.vida;
        this.mana = builder.mana;
        this.arma = builder.arma;
        this.armadura = builder.armadura;
        this.habilidades = builder.habilidades;
    }

    // --- Getters ---
    public String getNome() { return nome; }
    public String getRaca() { return raca; }
    public String getClasse() { return classe; }
    public int getForca() { return forca; }
    public int getInteligencia() { return inteligencia; }
    public int getAgilidade() { return agilidade; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Arma getArma() { return arma; }
    public Armadura getArmadura() { return armadura; }
    public String[] getHabilidades() { return habilidades; }

    // --- Setters para modificações pontuais (úteis para o Prototype) ---
    public void setNome(String nome) { this.nome = nome; }
    public void setForca(int forca) { this.forca = forca; }
    // Adicione outros setters se o jogo exigir modificação de status após a criação
// --- Setters adicionais para suportar o Padrão Prototype ---

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }


    // --- Implementação do Padrão Prototype ---
    @Override
    public Personagem clone() {
        try {
            // Cria uma cópia superficial (shallow copy).
            // Como String é imutável e tipos primitivos são copiados por valor, é o suficiente aqui.
            // Nota: Para cópia profunda (deep copy) de arrays/objetos, seria necessário cloná-los individualmente.
            Personagem clonado = (Personagem) super.clone();
            if (this.habilidades != null) {
                clonado.habilidades = this.habilidades.clone();
            }
            return clonado;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o personagem", e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s %s (F:%d, I:%d, A:%d, V:%d, M:%d) | Arma: %s | Armadura: %s | Habilidades: %s",
                nome, raca, classe, forca, inteligencia, agilidade, vida, mana,
                (arma != null ? arma.getNome() : "Nenhuma"),
                (armadura != null ? armadura.getNome() : "Nenhuma"),
                (habilidades != null ? Arrays.toString(habilidades) : "[]"));
    }

    // ==========================================
    // INNER CLASS: BUILDER
    // ==========================================
    public static class Builder {

        // Atributos espelham os da classe principal
        private String nome;
        private String raca;
        private String classe;
        private int forca;
        private int inteligencia;
        private int agilidade;
        private int vida;
        private int mana;
        private Arma arma;
        private Armadura armadura;
        private String[] habilidades;

        // Métodos fluentes que retornam a própria instância do Builder (this)

        public Builder comIdentidade(String nome, String raca, String classe) {
            this.nome = nome;
            this.raca = raca;
            this.classe = classe;
            return this;
        }

        public Builder comAtributos(int forca, int inteligencia, int agilidade, int vida, int mana) {
            this.forca = forca;
            this.inteligencia = inteligencia;
            this.agilidade = agilidade;
            this.vida = vida;
            this.mana = mana;
            return this;
        }

        public Builder equipadoCom(Arma arma, Armadura armadura) {
            this.arma = arma;
            this.armadura = armadura;
            return this;
        }

        public Builder comHabilidades(String... habilidades) {
            this.habilidades = habilidades;
            return this;
        }

        // Método final que efetivamente gera o objeto alvo
        public Personagem build() {
            // Validações opcionais podem ser inseridas aqui antes de criar o objeto
            if (this.nome == null || this.raca == null || this.classe == null) {
                throw new IllegalStateException("O personagem deve ter identidade (nome, raça e classe) definida.");
            }

            return new Personagem(this);
        }
    }
}
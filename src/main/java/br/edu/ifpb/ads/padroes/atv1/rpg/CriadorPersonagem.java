package br.edu.ifpb.ads.padroes.atv1.rpg;

public class CriadorPersonagem {

    public static Personagem criarPersonagem(String nome, String raca, String classe) {

        Personagem.Builder builder = new Personagem.Builder().comIdentidade(nome, raca, classe);
        boolean combinacaoValida = true;

        if (raca.equals("Humano")) {
            if (classe.equals("Guerreiro")) {
                builder.comAtributos(15, 8, 10, 120, 30)
                        .equipadoCom(new Arma("Espada de Ferro", 25, "Espada"),
                                new Armadura("Armadura de Placas", 20, "Pesada"))
                        .comHabilidades("Investida", "Bloqueio");

            } else if (classe.equals("Mago")) {
                builder.comAtributos(6, 18, 8, 80, 150)
                        .equipadoCom(new Arma("Cajado Mágico", 15, "Cajado"),
                                new Armadura("Vestes Mágicas", 8, "Leve"))
                        .comHabilidades("Bola de Fogo", "Cura");

            } else if (classe.equals("Arqueiro")) {
                builder.comAtributos(10, 12, 16, 100, 70)
                        .equipadoCom(new Arma("Arco Élfico", 20, "Arco"),
                                new Armadura("Armadura de Couro", 12, "Média"))
                        .comHabilidades("Tiro Certeiro", "Chuva de Flechas");
            } else { combinacaoValida = false; }

        } else if (raca.equals("Elfo")) {
            if (classe.equals("Guerreiro")) {
                builder.comAtributos(12, 14, 16, 100, 60)
                        .equipadoCom(new Arma("Lâmina Élfica", 22, "Espada"),
                                new Armadura("Cota de Malha Élfica", 15, "Média"))
                        .comHabilidades("Dança das Lâminas", "Agilidade Élfica");

            } else if (classe.equals("Mago")) {
                builder.comAtributos(4, 20, 14, 70, 180)
                        .equipadoCom(new Arma("Cajado da Natureza", 18, "Cajado"),
                                new Armadura("Mantos Élficos", 10, "Leve"))
                        .comHabilidades("Magia da Natureza", "Teleporte");

            } else if (classe.equals("Arqueiro")) {
                builder.comAtributos(8, 16, 20, 90, 100)
                        .equipadoCom(new Arma("Arco Longo Élfico", 28, "Arco"),
                                new Armadura("Armadura de Couro Élfico", 14, "Média"))
                        .comHabilidades("Tiro Múltiplo", "Camuflagem");
            } else { combinacaoValida = false; }

        } else if (raca.equals("Orc")) {
            if (classe.equals("Guerreiro")) {
                builder.comAtributos(20, 6, 8, 150, 20)
                        .equipadoCom(new Arma("Machado de Guerra", 30, "Machado"),
                                new Armadura("Armadura Brutal", 25, "Pesada"))
                        .comHabilidades("Fúria", "Pancada Devastadora");

            } else if (classe.equals("Mago")) {
                builder.comAtributos(10, 14, 6, 100, 120)
                        .equipadoCom(new Arma("Cajado Tribal", 12, "Cajado"),
                                new Armadura("Vestes Xamânicas", 6, "Leve"))
                        .comHabilidades("Magia Sombria", "Invocação");

            } else if (classe.equals("Arqueiro")) {
                builder.comAtributos(14, 8, 12, 120, 40)
                        .equipadoCom(new Arma("Arco de Osso", 24, "Arco"),
                                new Armadura("Couro de Besta", 16, "Média"))
                        .comHabilidades("Tiro Brutal", "Intimidação");
            } else { combinacaoValida = false; }

        } else {
            combinacaoValida = false;
        }

        if (!combinacaoValida) {
            System.out.println("Combinação inválida: " + raca + " " + classe);
            return null;
        }

        return builder.build();
    }

    public static Personagem criarPersonagemEspecial(String nome, String raca, String classe) {
        // Aproveita o método acima para obter o modelo base correto
        Personagem base = criarPersonagem(nome, raca, classe);
        if (base == null) return null;

        if (raca.equals("Humano") && classe.equals("Guerreiro")) {

            // Clona o personagem existente
            Personagem lendario = base.clone();

            lendario.setNome(nome + " o Lendário");
            lendario.setForca(18);
            lendario.setVida(140);
            lendario.setArma(new Arma("Excalibur", 35, "Espada"));
            lendario.setArmadura(new Armadura("Armadura do Rei", 30, "Pesada"));
            lendario.setHabilidades(new String[]{"Investida", "Bloqueio", "Liderança"});

            return lendario;
        }

        return base;
    }
}
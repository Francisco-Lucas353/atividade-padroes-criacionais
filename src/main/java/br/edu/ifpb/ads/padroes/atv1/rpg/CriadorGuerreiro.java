package br.edu.ifpb.ads.padroes.atv1.rpg;

public class CriadorGuerreiro extends CriadorPersonagemBase {

    @Override
    protected String getNomeDaClasse() {
        return "Guerreiro";
    }

    @Override
    protected void configurarAtributos(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comAtributos(15, 8, 10, 120, 30);
        else if (raca.equals("Elfo")) builder.comAtributos(12, 14, 16, 100, 60);
        else if (raca.equals("Orc")) builder.comAtributos(20, 6, 8, 150, 20);
    }

    @Override
    protected void configurarHabilidades(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comHabilidades("Investida", "Bloqueio");
        else if (raca.equals("Elfo")) builder.comHabilidades("Dança das Lâminas", "Agilidade Élfica");
        else if (raca.equals("Orc")) builder.comHabilidades("Fúria", "Pancada Devastadora");
    }

    @Override
    protected void equipar(Personagem.Builder builder, FabricaEquipamentos fabrica) {
        builder.equipadoCom(fabrica.criarArmaGuerreiro(), fabrica.criarArmaduraGuerreiro());
    }
}
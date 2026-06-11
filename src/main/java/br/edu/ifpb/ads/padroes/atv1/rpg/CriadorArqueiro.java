package br.edu.ifpb.ads.padroes.atv1.rpg;

public class CriadorArqueiro extends CriadorPersonagemBase {

    @Override
    protected String getNomeDaClasse() {
        return "Arqueiro";
    }

    @Override
    protected void configurarAtributos(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comAtributos(10, 12, 16, 100, 70);
        else if (raca.equals("Elfo")) builder.comAtributos(8, 16, 20, 90, 100);
        else if (raca.equals("Orc")) builder.comAtributos(14, 8, 12, 120, 40);
    }

    @Override
    protected void configurarHabilidades(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comHabilidades("Tiro Certeiro", "Chuva de Flechas");
        else if (raca.equals("Elfo")) builder.comHabilidades("Tiro Múltiplo", "Camuflagem");
        else if (raca.equals("Orc")) builder.comHabilidades("Tiro Brutal", "Intimidação");
    }

    @Override
    protected void equipar(Personagem.Builder builder, FabricaEquipamentos fabrica) {
        builder.equipadoCom(fabrica.criarArmaArqueiro(), fabrica.criarArmaduraArqueiro());
    }
}
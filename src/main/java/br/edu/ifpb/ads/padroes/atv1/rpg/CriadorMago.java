package br.edu.ifpb.ads.padroes.atv1.rpg;

public class CriadorMago extends CriadorPersonagemBase {

    @Override
    protected String getNomeDaClasse() {
        return "Mago";
    }

    @Override
    protected void configurarAtributos(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comAtributos(6, 18, 8, 80, 150);
        else if (raca.equals("Elfo")) builder.comAtributos(4, 20, 14, 70, 180);
        else if (raca.equals("Orc")) builder.comAtributos(10, 14, 6, 100, 120);
    }

    @Override
    protected void configurarHabilidades(Personagem.Builder builder, String raca) {
        if (raca.equals("Humano")) builder.comHabilidades("Bola de Fogo", "Cura");
        else if (raca.equals("Elfo")) builder.comHabilidades("Magia da Natureza", "Teleporte");
        else if (raca.equals("Orc")) builder.comHabilidades("Magia Sombria", "Invocação");
    }

    @Override
    protected void equipar(Personagem.Builder builder, FabricaEquipamentos fabrica) {
        builder.equipadoCom(fabrica.criarArmaMago(), fabrica.criarArmaduraMago());
    }
}
package br.edu.ifpb.ads.padroes.atv1.rpg;

public abstract class CriadorPersonagemBase {

    // Método principal que orquestra os padrões Builder e Abstract Factory
    public Personagem fabricar(String nome, String raca) {

        Personagem.Builder builder = new Personagem.Builder()
                .comIdentidade(nome, raca, getNomeDaClasse());

        configurarAtributos(builder, raca);
        configurarHabilidades(builder, raca);

        FabricaEquipamentos fabricaDeItens = obterFabricaDaRaca(raca);
        equipar(builder, fabricaDeItens);

        return builder.build();
    }

    protected abstract String getNomeDaClasse();
    protected abstract void configurarAtributos(Personagem.Builder builder, String raca);
    protected abstract void configurarHabilidades(Personagem.Builder builder, String raca);
    protected abstract void equipar(Personagem.Builder builder, FabricaEquipamentos fabrica);

    private FabricaEquipamentos obterFabricaDaRaca(String raca) {
        if (raca.equals("Humano")) {
            return new FabricaEquipamentoHumano();
        } else if (raca.equals("Elfo")) {
            return new FabricaEquipamentoElfo();
        } else if (raca.equals("Orc")) {
            return new FabricaEquipamentoOrc();
        } else {
            throw new IllegalArgumentException("Raça inválida ou desconhecida: " + raca);
        }
    }
}
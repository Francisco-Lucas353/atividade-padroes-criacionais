package br.edu.ifpb.ads.padroes.atv1.rpg;

public class FabricaEquipamentoHumano implements FabricaEquipamentos {

    @Override
    public Arma criarArmaGuerreiro() {
        return new Arma("Espada de Ferro", 25, "Espada");
    }

    @Override
    public Armadura criarArmaduraGuerreiro() {
        return new Armadura("Armadura de Placas", 20, "Pesada");
    }

    @Override
    public Arma criarArmaMago() {
        return new Arma("Cajado Mágico", 15, "Cajado");
    }

    @Override
    public Armadura criarArmaduraMago() {
        return new Armadura("Vestes Mágicas", 8, "Leve");
    }

    @Override
    public Arma criarArmaArqueiro() {
        return new Arma("Arco Élfico", 20, "Arco");
    }

    @Override
    public Armadura criarArmaduraArqueiro() {
        return new Armadura("Armadura de Couro", 12, "Média");
    }
}
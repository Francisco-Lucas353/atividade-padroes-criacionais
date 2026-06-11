package br.edu.ifpb.ads.padroes.atv1.rpg;

public interface FabricaEquipamentos {

    // Equipamentos para Guerreiros
    Arma criarArmaGuerreiro();
    Armadura criarArmaduraGuerreiro();

    // Equipamentos para Magos
    Arma criarArmaMago();
    Armadura criarArmaduraMago();

    // Equipamentos para Arqueiros
    Arma criarArmaArqueiro();
    Armadura criarArmaduraArqueiro();

}
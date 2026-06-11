package br.edu.ifpb.ads.padroes.atv2.pagamentos.service;

import br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway.PagamentoGateway;
import com.google.inject.Inject;

public class PagamentoService {

    private final PagamentoGateway gateway;

    // A injeção de dependência acontece aqui no construtor
    @Inject
    public PagamentoService(PagamentoGateway gateway) {
        this.gateway = gateway;
    }

    public void pagar(double valor) {
        System.out.println("Iniciando processo de checkout no E-commerce...");
        this.gateway.processarPagamento(valor);
        System.out.println("Checkout finalizado.\n");
    }
}
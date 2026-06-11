package br.edu.ifpb.ads.padroes.atv2.pagamentos.config;

import com.google.inject.AbstractModule;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway.PayPalGateway;

public class PayPalModule extends AbstractModule {
    @Override
    protected void configure() {
        // Vincula a interface PagamentoGateway à implementação específica do PayPal
        bind(PagamentoGateway.class).to(PayPalGateway.class);
    }
}
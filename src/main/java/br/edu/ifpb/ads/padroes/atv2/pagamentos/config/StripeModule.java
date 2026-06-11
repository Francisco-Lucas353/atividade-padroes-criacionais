package br.edu.ifpb.ads.padroes.atv2.pagamentos.config;

import com.google.inject.AbstractModule;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway.StripeGateway;

public class StripeModule extends AbstractModule {
    @Override
    protected void configure() {
        // Vincula a interface PagamentoGateway à implementação específica do Stripe
        bind(PagamentoGateway.class).to(StripeGateway.class);
    }
}
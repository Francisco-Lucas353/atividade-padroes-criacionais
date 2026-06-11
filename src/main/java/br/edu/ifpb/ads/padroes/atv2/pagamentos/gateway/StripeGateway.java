package br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway;

public class StripeGateway implements PagamentoGateway {
    @Override
    public void processarPagamento(double valor) {
        // Simula a chamada HTTP para a API do Stripe
        System.out.println("[Stripe SDK Mock] Gerando token de transação no Stripe...");
        System.out.println("[Stripe SDK Mock] Transação de R$ " + valor + " confirmada!");
    }
}
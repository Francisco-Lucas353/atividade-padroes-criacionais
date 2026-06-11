package br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway;

public class PayPalGateway implements PagamentoGateway {
    @Override
    public void processarPagamento(double valor) {
        // Simula a chamada HTTP para a API do PayPal
        System.out.println("[PayPal SDK Mock] Conectando aos servidores do PayPal...");
        System.out.println("[PayPal SDK Mock] Pagamento de R$ " + valor + " aprovado com sucesso!");
    }
}

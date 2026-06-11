package br.edu.ifpb.ads.padroes.atv2.pagamentos.gateway;

public class PagSeguroGateway implements PagamentoGateway {
    @Override
    public void processarPagamento(double valor) {
        // Simula a chamada HTTP para a API do PagSeguro
        System.out.println("[PagSeguro SDK Mock] Redirecionando checkout transparente...");
        System.out.println("[PagSeguro SDK Mock] Pagamento de R$ " + valor + " processado via UOL!");
    }
}
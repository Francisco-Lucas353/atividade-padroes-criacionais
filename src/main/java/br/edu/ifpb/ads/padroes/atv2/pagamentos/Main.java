package br.edu.ifpb.ads.padroes.atv2.pagamentos;

import br.edu.ifpb.ads.padroes.atv2.pagamentos.service.PagamentoService;
import com.google.inject.Guice;
import com.google.inject.Injector;

// REQUISITO PARA CORREÇÃO: Importar os módulos que estão no pacote 'config'
import br.edu.ifpb.ads.padroes.atv2.pagamentos.config.PayPalModule;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.config.StripeModule;
import br.edu.ifpb.ads.padroes.atv2.pagamentos.config.PagSeguroModule;


public class Main {
    public static void main(String[] args) {

        System.out.println("--- COMPRA 1 (Via PayPal) ---");
        // O Guice utiliza o módulo importado para saber qual gateway injetar
        Injector injetorPayPal = Guice.createInjector(new PayPalModule());
        PagamentoService servicoPayPal = injetorPayPal.getInstance(PagamentoService.class);
        servicoPayPal.pagar(150.50);


        System.out.println("--- COMPRA 2 (Via Stripe) ---");
        // O Guice utiliza o módulo do Stripe
        Injector injetorStripe = Guice.createInjector(new StripeModule());
        PagamentoService servicoStripe = injetorStripe.getInstance(PagamentoService.class);
        servicoStripe.pagar(340.00);


        System.out.println("--- COMPRA 3 (Via PagSeguro) ---");
        // Adicionando também o exemplo do PagSeguro que criamos
        Injector injetorPagSeguro = Guice.createInjector(new PagSeguroModule());
        PagamentoService servicoPagSeguro = injetorPagSeguro.getInstance(PagamentoService.class);
        servicoPagSeguro.pagar(99.90);
    }
}
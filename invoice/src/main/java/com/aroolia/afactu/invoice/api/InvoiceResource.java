package com.aroolia.afactu.invoice.api;//package com.aroolia.afactu.api;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        out.println("La méthode displayInvoice a été invoquée");

        final WebClient webClient = webClientBuilder.baseUrl("http://customer-service").build();

        Invoice invoice = invoiceService.getInvoiceByNumber(number);

         //final Customer customer = restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(), Customer.class) ;
         //final Address address = restTemplate.getForObject("http://customer-service/address/"+customer.getAddress().getId(), Address.class) ;

        final Customer customer = webClient.get().uri("http://customer-service/customer/"+invoice.getIdCustomer())
                .retrieve()
                .bodyToMono(Customer.class)
                .block();


        final Address address = webClient.get().uri("http://customer-service/address/"+customer.getAddress().getId())
                .retrieve()
                .bodyToMono(Address.class)
                .block();

         customer.setAddress(address);
         invoice.setCustomer(customer);

         return invoice;
    }

    @GetMapping
    public ParallelFlux<Invoice> list() {
        out.println("La méthode display all invoice a été invoquée");

        List<Mono<Invoice>> invoiceMonos = new ArrayList<>();

        final WebClient webClient = webClientBuilder.baseUrl("http://customer-service").build();

        Iterable<Invoice> invoices = invoiceService.getInvoiceList();

        invoices.forEach(invoice -> {

            invoiceMonos.add(webClient.get()
                    .uri("/customer/"+invoice.getIdCustomer())
                    .retrieve()
                    .bodyToMono(Customer.class)
                    .map(customer -> {
                        invoice.setCustomer(customer);
                        return invoice;
                    }));
        /*invoice.setCustomer(restTemplate.getForObject("/customer/"+invoice.getIdCustomer(), Customer.class) );*/

        } );

        final Flux<Invoice> invoiceFlux = Flux.concat(invoiceMonos);

        return invoiceFlux.parallel().runOn(Schedulers.boundedElastic());
    }
}
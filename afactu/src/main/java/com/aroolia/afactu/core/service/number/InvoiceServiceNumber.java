package com.aroolia.afactu.core.service.number;


import com.aroolia.afactu.core.entity.invoice.Invoice;

//import com.aroolia.afactu.core.repository.CustomerRepositoryInterface;
import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private InvoiceRepositoryInterface invoiceRepository;

    /*@Autowired
    private CustomerRepositoryInterface customerRepository;*/

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {

        return invoiceRepository.findAll();
    }

    @Autowired
    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice){
        //customerRepository.save(invoice.getCustomer());

        return invoiceRepository.save(invoice);
    }



    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}
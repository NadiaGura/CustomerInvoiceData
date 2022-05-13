package company.objects;

import java.util.Date;
import java.util.List;

public class Invoice {

  /*  private int id;
    private Customer customer;
    private Date date;

    public Invoice() {

    }

    public Invoice(int id, Customer customer, Date date) {
        this.id = id;
        this.customer = customer;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }







}*/


    private int id; // get all invoice data (items list and total amount)
    private int customersid;
    private String invoiceDate; //how to add date?


    public Invoice(int id, int customersid, String invoiceDate) {

        this.id = id;
        this.customersid = customersid;
        this.invoiceDate = invoiceDate;
    }

    public Invoice() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomersId() {
        return customersid;
    }

    public void setCustomersId(int customersid) {
        this.customersid = customersid;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

  /*  private int id;
    private static Customer customer = new Customer();
    private static Date invoiceDate;
    private static List<InvoiceLine> invoiceLines;

    public Invoice(int id, Customer customer, Date invoiceDate, List<InvoiceLine>invoiceLines) {
        this.id = id;
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.invoiceLines = invoiceLines;

    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getCustomerName(){
        return customer.getName();
    }

    public int getCustomerId(){
        return customer.getId();
    }


    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }*/
}

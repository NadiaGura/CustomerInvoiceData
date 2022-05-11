package company.objects;

import java.util.Date;

public class Invoice {
  //  Date date = new Date();

    private int id; // get all invoice data (items list and total amount)
    private int customersid;
    private String invoiceDate; //how to add date?


    public Invoice(int id, int customersid, String invoiceDate) {

        this.id = id;
        this.customersid = customersid;
        this.invoiceDate = invoiceDate;
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
}

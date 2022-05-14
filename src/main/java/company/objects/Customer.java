package company.objects;
import java.util.Arrays;

public class Customer {

    private int id;
    private String name;


    public Customer() {

    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method to get all invoices for one customer
    private Invoice[] invoices;

    public Customer(int id, String name, Invoice[] invoices) {
        this.id = id;
        this.name = name;
        this.invoices = invoices;
    }



    public String getInvoices() {
        String invoiceList = " ";
        for (int i = 0; i < invoices.length; i++) {
            if (i == invoices.length - 1) {
                invoiceList += invoices[i].getCustomersId();
                break;

            } else invoiceList += invoices[i].getCustomersId() + ", ";

        } return invoiceList;


    }
}

package br.com.megalaser.hinelabel.getprinter;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RODRIGO.CASTRO on 07/08/2017.
 * This class get printers installed from system
 */
public class GetPrintersFromSystem {

    private List printers;

    /**
     * Constructor
     */
    public GetPrintersFromSystem() {
        getPrintersFromSystem();
    }

    /**
     *
     * @return printers
     */
    public List getPrinters() {
        return printers;
    }

    /**
     * Get Printers Text
     */
    public void getPrintersFromSystem() {
        printers = new ArrayList<String>();

        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        for (PrintService printer : printServices) {
            printers.add(printer.getName());
        }
    }

}

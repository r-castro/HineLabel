package br.com.megalaser.hinelabel.printerconfig;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RODRIGO.CASTRO on 07/08/2017.
 * Class test.
 */
public class PrinterConfigArgoxTest {

    public static void main(String[] args) {
        PrinterConfigArgox printerConfigArgox = new PrinterConfigArgox();

        printerConfigArgox.setPurchaseOrderMegalaser("0001A");
        printerConfigArgox.setQuantityLabelPrint(10);
        printerConfigArgox.setItemCode("AAAABBBBBB12");
        printerConfigArgox.setDate("03/05/2015");
        System.out.println(printerConfigArgox.toString());

        try {
            FileOutputStream file = new FileOutputStream("\\\\ml-desk-109\\Argox");
            PrintWriter out = new PrintWriter(file);
            out.println(printerConfigArgox.toString());
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

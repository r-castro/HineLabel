package br.com.megalaser.hinelabel.getprinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RODRIGO.CASTRO on 07/08/2017.
 */
public class GetPrintersFromSystemTest {

    public static void main(String[] args) {
        GetPrintersFromSystem getPrintersFromSystem = new GetPrintersFromSystem();
        List<String> test = new ArrayList<String>(getPrintersFromSystem.getPrinters());

        for (String print : test) {
            System.out.println(print);
        }
    }
}

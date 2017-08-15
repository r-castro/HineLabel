package br.com.megalaser.hinelabel.printerconfig;

/**
 * Created by RODRIGO.CASTRO on 07/08/2017.
 * Class data printers
 */
public class PrinterConfigArgox {

    private final char STX = '\u0002';
    private String purchaseOrderMegalaser;
    private String itemCode;
    private String date;
    private int quantityLabelPrint;


    public String getPurchaseOrderMegalaser() {
        return purchaseOrderMegalaser;
    }

    public void setPurchaseOrderMegalaser(String purchaseOrderMegalaser) {
        this.purchaseOrderMegalaser = purchaseOrderMegalaser;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantityLabelPrint() {
        return quantityLabelPrint;
    }

    public void setQuantityLabelPrint(int quantityLabelPrint) {
        this.quantityLabelPrint = quantityLabelPrint;
    }

    @Override
    public String toString() {

        StringBuilder text = new StringBuilder();

        text.append(STX + "C0000\n");
        text.append(STX + "KI503\n");
        text.append(STX + "f340\n");
        text.append(STX + "O0220\n");
        text.append(STX + "KI7\n");
        text.append(STX + "V0\n");
        text.append(STX + "e\n");
        text.append(STX + "L\n");
        text.append("H16\n");
        text.append("PA\n");
        text.append("A2\n");
        text.append("D11\n");
        text.append("491100300100030PV.     : ").append(getPurchaseOrderMegalaser().trim()).append("\n");
        text.append("491100300100050ITEM. : ").append(getItemCode().trim()).append("\n");
        text.append("491100300100070DATA.: ").append(getDate().trim()).append("\n");
        text.append("Q").append(getQuantityLabelPrint()).append("\n");
        text.append("E\n");

        return text.toString();
    }
}

//file name: SU2023_Project_Neduelan
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SU2023_ProductSU_Neduelan {
	 private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
	    static final int SIZE_COUNT = 3;

	    private String saleDay;
	    private int[] units;
	    private float[] prices;
	    private static int transactionNum = 0;

	    public SU2023_ProductSU_Neduelan() {
	        units = new int[SIZE_COUNT];
	        prices = new float[SIZE_COUNT];
	        saleDay = "";
	    }

	    public SU2023_ProductSU_Neduelan(String saleDay, int[] units, float[] prices) {
	        this.saleDay = saleDay;
	        this.units = units;
	        this.prices = prices;
	    }

	    public String getStrTransaction() {
	        return "Transaction: #" + transactionNum;
	    }

	    public String toFile() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Transaction: #").append(transactionNum).append(System.lineSeparator());
	        sb.append("Sale Day: ").append(saleDay).append(System.lineSeparator());
	        for (int i = 0; i < SIZE_COUNT; i++) {
	            sb.append("Size ").append(i + 1).append(": ").append(units[i]).append(" units @ $")
	                    .append(DECIMAL_FORMAT.format(prices[i])).append(" each").append(System.lineSeparator());
	        }
	        sb.append("Subtotal: $").append(DECIMAL_FORMAT.format(calculateSubtotal())).append(System.lineSeparator());
	        sb.append("Tax: $").append(DECIMAL_FORMAT.format(calculateTax())).append(System.lineSeparator());
	        sb.append("Total: $").append(DECIMAL_FORMAT.format(calculateTotal())).append(System.lineSeparator());
	        sb.append("------------------------------------").append(System.lineSeparator());
	        return sb.toString();
	    }

	    public void writeToFile() {
	        String fileName = "sales_report.txt";
	        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
	            writer.println(toFile());
	        } catch (IOException e) {
	            System.out.println("An error occurred while writing to the file: " + e.getMessage());
	        }
	    }

	    public void printSaleReceipt() {
	        System.out.println("Sale Day: " + saleDay);
	        for (int i = 0; i < SIZE_COUNT; i++) {
	            System.out.println("Size " + (i + 1) + ": " + units[i] + " units @ $" + DECIMAL_FORMAT.format(prices[i]) +
	                    " each");
	        }
	        System.out.println("Subtotal: $" + DECIMAL_FORMAT.format(calculateSubtotal()));
	        System.out.println("Tax: $" + DECIMAL_FORMAT.format(calculateTax()));
	        System.out.println("Total: $" + DECIMAL_FORMAT.format(calculateTotal()));
	        System.out.println("------------------------------------");
	    }

	    public void printDayReport() {
	        System.out.println(toFile());
	    }

	    public void compareTwoSaleDays(SU2023_ProductSU_Neduelan saleDay2) {
	        System.out.println("Comparing Sale Days:");
	        System.out.println("Sale Day 1: " + saleDay);
	        System.out.println("Sale Day 2: " + saleDay2.saleDay);
	        System.out.println("Difference: ");
	        int[] difference = calculateDifference(saleDay2);
	        for (int i = 0; i < SIZE_COUNT; i++) {
	            System.out.println("Size " + (i + 1) + ": " + difference[i] + " units");
	        }
	    }

	    private float calculateSubtotal() {
	        float subtotal = 0;
	        for (int i = 0; i < SIZE_COUNT; i++) {
	            subtotal += units[i] * prices[i];
	        }
	        return subtotal;
	    }

	    private float calculateTax() {
	        float taxRate = 0.07f;
	        return calculateSubtotal() * taxRate;
	    }

	    private float calculateTotal() {
	        return calculateSubtotal() + calculateTax();
	    }

	    private int[] calculateDifference(SU2023_ProductSU_Neduelan saleDay2) {
	        int[] difference = new int[SIZE_COUNT];
	        for (int i = 0; i < SIZE_COUNT; i++) {
	            difference[i] = units[i] - saleDay2.units[i];
	        }
	        return difference;
	    }

	    public void setSaleDay(String saleDay) {
	        this.saleDay = saleDay;
	    }

	    public void setUnits(int[] units) {
	        this.units = units;
	    }

	    public void setPrices(float[] prices) {
	        this.prices = prices;
	    }

	    public static void incrementTransactionNum() {
	        transactionNum++;
	    }
}

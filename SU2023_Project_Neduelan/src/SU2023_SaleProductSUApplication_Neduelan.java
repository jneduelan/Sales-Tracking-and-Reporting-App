//file name: SU2023_Project_Neduelan
import java.util.Scanner;


public class SU2023_SaleProductSUApplication_Neduelan {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        SU2023_ProductSU_Neduelan productSU = new SU2023_ProductSU_Neduelan();

	        //prompt user to enter sale day
	        System.out.print("Enter the sale day: ");
	        String saleDay = scanner.nextLine();
	        productSU.setSaleDay(saleDay);

	        //prompt user to enter units and prices for each size
	        int[] units = new int[SU2023_ProductSU_Neduelan.SIZE_COUNT];
	        float[] prices = new float[SU2023_ProductSU_Neduelan.SIZE_COUNT];

	        for (int i = 0; i < SU2023_ProductSU_Neduelan.SIZE_COUNT; i++) {
	            System.out.print("Enter units sold for Size " + (i + 1) + ": ");
	            units[i] = scanner.nextInt();
	            System.out.print("Enter price for Size " + (i + 1) + ": $");
	            prices[i] = scanner.nextFloat();
	            scanner.nextLine(); //consume the newline character
	        }

	        productSU.setUnits(units);
	        productSU.setPrices(prices);
	        SU2023_ProductSU_Neduelan.incrementTransactionNum();

	        //call the methods to display the sale receipt, print day report, and write to file
	        productSU.printSaleReceipt();
	        productSU.printDayReport();
	        productSU.writeToFile();

	        //prompt user to compare two sale days
	        System.out.println("Compare Two Sale Days:");
	        compareTwoDaysReport(productSU, scanner);

	        scanner.close();
	    }

	    public static void compareTwoDaysReport(SU2023_ProductSU_Neduelan productSU, Scanner scanner) {
	        System.out.print("Enter the first sale day: ");
	        String firstSaleDay = scanner.nextLine();
	        SU2023_ProductSU_Neduelan firstProductSU = new SU2023_ProductSU_Neduelan();
	        firstProductSU.setSaleDay(firstSaleDay);

	        System.out.print("Enter the second sale day: ");
	        String secondSaleDay = scanner.nextLine();
	        SU2023_ProductSU_Neduelan secondProductSU = new SU2023_ProductSU_Neduelan();
	        secondProductSU.setSaleDay(secondSaleDay);

	        System.out.println();
	        System.out.println("Sale Report for " + firstSaleDay + ":");
	        firstProductSU.printDayReport();

	        System.out.println("Sale Report for " + secondSaleDay + ":");
	        secondProductSU.printDayReport();

	        productSU.compareTwoSaleDays(secondProductSU);
	    }
	}

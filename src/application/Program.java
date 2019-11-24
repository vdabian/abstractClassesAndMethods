package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main (String[]args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.print("Please, type the number of taxpayers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if (resp == 'i') {
				System.out.print("Health expeditures: ");
				Double healthExpeditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpeditures));
			} else if (resp == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}	
		}
		
		System.out.println("");
		System.out.println("TAXES PAID:");
		double total = 0;
		for (TaxPayer tp : list) {

			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			
			total += tp.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $"+ total);
		
	
		sc.close();
	}
}

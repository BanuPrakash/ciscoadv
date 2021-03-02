package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.cisco.prj.entity.Product;

public class StreamExample {

	public static void main(String[] args) {
		
		IntStream.range(1, 25).filter(elem -> elem%2 == 0).forEach(elem -> System.out.println(elem));
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		
//		Predicate<Product> predicate =  p -> p.getCategory().equals("mobile");
		// filter accepts Predicate
		// forEach accepts Consumer
		products.stream()
			.filter(p -> p.getCategory().equals("computer"))
			.forEach(p -> System.out.println(p));
		
		
		System.out.println("*******");
		
		Stream<Product> stream = products.stream()
		.filter(p -> p.getCategory().equals("mobile"));
		
		stream.forEach(System.out::println); // Method reference
		
		System.out.println("**********");
		
		List<Product> computers = products.stream()
		.filter(p -> p.getCategory().equals("computer"))
		.collect(Collectors.toList());
		
		System.out.println("********");
		
		List<String> names = products.parallelStream()
		.filter(p -> p.getCategory().equals("computer"))
		.map(p -> p.getName())
		.collect(Collectors.toList());
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("*******");
		
		DoubleSummaryStatistics data =  
				products.stream().collect(Collectors.summarizingDouble(p -> p.getPrice()));
		System.out.println("Max " + data.getMax());
		System.out.println("Min " + data.getMin());
		System.out.println(("Avg " + data.getAverage()));
		
		
		
	}

}

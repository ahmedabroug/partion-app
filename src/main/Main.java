package main;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.Collection;


public class Main {

	public static void main(String[] args) {
		
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

		System.out.println(Partition.ofSize(numbers, 3));
		System.out.println(Partition.ofSize(numbers, 2));
		
		
		// second method using Java 8.
		final List<Integer> secondNumbers = Arrays.asList(1,2,3,4,5,6,7);
		final int chunkSize = 3;
		final AtomicInteger counter = new AtomicInteger();
		final Collection<List<Integer>> result = secondNumbers.stream()
			    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
			    .values();

			System.out.println(result);

	}

}

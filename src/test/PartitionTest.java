package test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import main.Partition;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class PartitionTest {

    @Test
    public void whenThis_thenThat() {
    	final AtomicInteger counter = new AtomicInteger();
    	final int chunkSize = 3;
    	final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
    	
    	final Collection<List<Integer>> result = Partition.ofSize(numbers, 3);
    	
		final Collection<List<Integer>> expectedResult = numbers.stream()
			    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
			    .values();
		assertThat(result.size(), equalTo(expectedResult.size()));
		assertThat(result.toString(), equalTo(expectedResult.toString()));
    }
 
}

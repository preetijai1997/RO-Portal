import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Stream {
	
	@Test
	public void stream(){
		
		
		List<Integer> li=Arrays.asList(3,2,1,2,1,2,3,1,5,6,7);
		
		List<Integer> l1=li.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(l1.get(2));
	}

}

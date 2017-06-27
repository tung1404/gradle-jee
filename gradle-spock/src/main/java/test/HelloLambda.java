package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloLambda {
	
	public HelloLambda(String word) {
		this.word = word;
	}
	
	private String word;
	
	public String getWord() {
		return word;
	}
	
	public void printWord() {
		System.out.println(word);
	}
	
	interface HelloService {
		String hello(String firstname, String lastname) throws Exception;
	}

	public static void main(String[] args) {
		final AtomicInteger i = new AtomicInteger(0);
		HelloService helloService = (String firstname, String lastname) -> {
			i.getAndAdd(1);
			String hello = "Hello, " + i.get() + " " + firstname + " " + lastname;
			return hello;
		};
		try {
			System.out.println(helloService.hello("firstname", "lastname"));
			System.out.println(helloService.hello("firstname", "lastname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Callable<HelloLambda> caller = () -> {
			HelloLambda m = new HelloLambda("");
			return m;
		};
		try {
			caller.call().printWord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Callable<Integer> intCaller = () -> 2;
		try {
			System.out.println(intCaller.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HelloLambda h1 = new HelloLambda("12");
		HelloLambda h2 = new HelloLambda("1234");
		List<HelloLambda> list = new ArrayList<HelloLambda>();
		list.add(h1);
		list.add(h2);
		list.add(h1);
		
		Collections.sort(list, 
				(x, y) -> x.getWord().compareTo(y.getWord()));
		list.forEach(item -> item.printWord());
	}
}

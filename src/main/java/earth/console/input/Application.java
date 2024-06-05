package earth.console.input;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println(hello(args));

    	try (Scanner scanner = new Scanner(System.in)) {
    		String option = option("Continue? (Y/n)", "c", "continue", "yes", "y", "Y", "n", "N");

    		System.out.println("Selected: " + option);

    		/*
            for(boolean quit = false; !quit; ) {
	        	System.out.print("Hello>");
	
	        	String next = scanner.nextLine();
	
	        	switch (next.toLowerCase()) {
	        		case "q", "quit", "x", "exit" -> quit = true;
	        		default -> System.out.println(hello(next));
	        	}
            }
            */
    	}
    }

    static String option(String prompt, String defaultOption, String... otherOptions) {
    	Set<String> options = setOf(defaultOption, otherOptions);

    	try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
	        	System.out.print(prompt);

	        	String next = scanner.nextLine();

	        	if (next.isEmpty()) {
	        		return defaultOption;
	        	}

	        	for (String option : options) {
	        		if (option.equals(next)) {
	        			return option;
	        		}
	        	}

	        	System.err.println("Invalid input: " + next + " Please enter one of these: " + String.join(" ", options));
            }
    	}
    }
    
    static String hello(String... args) {
    	return "Hello, " + (0==args.length ? "World" : String.join(", ", args)) + "!";
    }

    static <T> Set<T> setOf(T defaultOption, T... otherOptions) {
    	var options = new TreeSet<T>();

    	options.add(defaultOption);

    	for (var option : otherOptions) {
    		options.add(option);
    	}

    	return options;
    }

}

import java.util.Scanner;

public class Week1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entries = sc.nextInt();
		Person people[] = new Person[entries];
		for (int i = 0; i < entries; i++)
			people[i] = new Person(sc.next(), sc.nextLong());
		
		String mostCompatible[] = new String[2];
		String leastCompatible[] = new String[2];
		long min = 33;
		long max = -1;
		
		for (int i = 0; i < entries - 1; i++) {
			for (int j = i + 1; j < entries; j++) {
				long differences = people[i].bitsInCommon(people[j]);
				if (differences < min) {
					min = differences;
					mostCompatible[0] = people[i].name;
					mostCompatible[1] = people[j].name;					
				}
				if (differences > max) {
					max = differences;
					leastCompatible[0] = people[i].name;
					leastCompatible[1] = people[j].name;	
				}
			}
		}
		
		System.out.println(mostCompatible[0] + " " + mostCompatible[1]);
		System.out.println(leastCompatible[0] + " " + leastCompatible[1]);
	}
}

class Person {
	String name;
	long value;
	
	Person(String name, long value) {
		this.name = name;
		this.value = value;
	}
	
	public String toString() {
		return name + " " + value;
	}
	
	long bitsInCommon(Person p) {
		int setBits = 0;
		for (long difference = value ^ p.value; difference != 0; difference >>= 1)
			setBits += difference & 1;
		return setBits;	
	}
}


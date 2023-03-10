package com.skilldistillery.titanic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TitanicPresentation2 {
	public static ArrayList<Passenger> passengers;

	public static void main(String[] args) {

		// load csv data
		TitanicUtils.init();
		passengers = TitanicUtils.passengers;

		// so why lambdas?
		// we already have all the tools we need to work with data structures, right?
		// alright, smarty pants... here's your assignment then.
		// the ArrayList "passengers" now contains 1,309 entries representing the names
		// and some possibly important data about all of the recorded passengers who
		// were
		// on board the RMS Titanic at the time of her sinking in 1912.

		// Your job? Write code to find the following information and use lambdas

		// Each passenger has the following methods:
		// public int getCabin() -cabin class 1, 2, or 3
		// public boolean didSurvive() -true or false
		// public String getFirstName()
		// public String getLastName()
		// public String getSex() -"male" or "female"
		// public double getAge() -sometimes fractional. 999 if unknown
		// public int getSiblingsOrSpouses() -number of siblings or spouse(s?) they were
		// travelling with
		// public int getParentsOrChildren() -number of parents or children they were
		// travelling with
		// public String getTicketNumber() -a String showing their ticket number (combo
		// of numbers and letters)
		// public String getEmbarked() -the port they boarded from: "Southampton",
		// "Cherbourg", or "Queenstown"

//		for (Passenger passenger : passengers) {
//			System.out.println(passenger);
//		}

		// First, implement the three methods at the bottom of this class:
		// Passenger getFirstMatch(ArrayList<Passenger> passengers, Predicate<Passenger>
		// tester)
		// List<Passenger> getMatchList(ArrayList<Passenger> passengers,
		// Predicate<Passenger> tester)
		// double getSurvivalRate(ArrayList<Passenger> passengers, Predicate<Passenger>
		// tester)

		// Then use these methods to analyze the data.

		// Let's start with some easy ones!
		// 1) find out whether a "Miss. Alice Cleaver" survived the accident.

		Passenger alice = getFirstMatch(passengers,
				p -> p.getFirstName().equals("Miss. Alice") && p.getLastName().equals("Carver"));

		System.out.print("Miss Alice Cleaver");
		if (alice == null) {
			System.out.println(" was not aboard.");
		} else {
			System.out.print(" did");
			if (!alice.didSurvive()) {
				System.out.println(" not");
			}
			System.out.print(" survive.");
		}
		// 2) there were six 52-year-olds on board, however, only one embarked from
		// Cherbourg. What was his or her
		// name? Did he or she survive?

		Passenger cherbourgRider = getFirstMatch(passengers,
				p -> p.getEmbarked().equals("Cherbourg") && p.getAge() == 52);
		System.out.println();
		System.out.println("Cherbourg: " + cherbourgRider);

		// 3) find the number of adult men, adult women, and minor children in the
		// passenger list and print to console.
		List<Passenger> women = getMatchList(passengers,
				p -> p.getSex().equals("female") && (p.getAge() >= 18 && p.getAge() < 999.0));

		List<Passenger> women1 = passengers.stream()
				.filter(p -> p.getSex().equals("female") && (p.getAge() >= 18 && p.getAge() < 999.0))
				.collect(Collectors.toList());

		List<Passenger> men = getMatchList(passengers,
				p -> p.getSex().equals("male") && (p.getAge() >= 18 && p.getAge() < 999.0));
		List<Passenger> children = getMatchList(passengers, p -> p.getAge() < 18);
		List<Passenger> childs = passengers.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
		System.out.println(childs.size());

		System.out.println(women1.size());
		System.out.println(men.size());
		System.out.println(children.size());

		// 4) Who was the youngest survivor? Who was the oldest casualty? (remember age
		// is a double and unknown ages are 999)

		List<Passenger> casualties = getMatchList(passengers, p -> !p.didSurvive() && p.getAge() < 999.0);
		List<Passenger> survivors = getMatchList(passengers, p -> p.didSurvive() && p.getAge() < 1.0);

		List<Passenger> deceased = passengers.stream().filter(p -> !p.didSurvive() && p.getAge() < 999.0)
				.collect(Collectors.toList());

		casualties.sort((p1, p2) -> (int) (p1.getAge() - p2.getAge()));

		System.out.println("Oldest casualty: " + casualties.get(casualties.size() - 1));

		survivors.sort((p1, p2) -> {
			if (p1.getAge() > p2.getAge()) {
				return 1;
			} else if (p1.getAge() < p2.getAge()) {
				return -1;
			} else {
				return 0;
			}
		});
		System.out.println("Youngest survivor: " + survivors.get(0));

		// Do you still think you can get away without lambdas by writing methods
		// and/or inner classes? Then try the next batch!

		// 5) Calculate the overall survival odds for all passengers, as well as
		// for each of the following demographics:

		double survivalOdds = getSurvivalRate(passengers, p -> !p.getFirstName().isEmpty());
		System.out.println("Overall survival odds: " + survivalOdds + "%");

		// a) All adult women
		double adultWomenRate = getSurvivalRate(passengers,
				p -> p.getSex().equals("female") && p.getAge() > 17 && p.getAge() < 999);

		System.out.println("Surival rate for women " + adultWomenRate + "%");

		// b) All adult men
		double maleRate = getSurvivalRate(passengers,
				p -> p.getSex().equals("male") && p.getAge() > 17 && p.getAge() < 999);
		System.out.println("Surival rate for men " + maleRate + "%");

		// c) All minor children

		double childRate = getSurvivalRate(passengers, p -> p.getAge() < 18);
		System.out.println("Surival rate for men " + childRate + "%");

		// d) All first class
		double firstClass = getSurvivalRate(passengers, p -> p.getCabinClass() == 1);
		System.out.println("Surival rate for firstClass " + firstClass + "%");
		// e) All second class

		double second = getSurvivalRate(passengers, p -> p.getCabinClass() == 2);
		System.out.println("Surival rate for second class " + second + "%");
		// f) All third class
		// g) Minor female children in first class with 2 or more of any relative

		double minorFemaleWith2Relative = getSurvivalRate(passengers, p -> p.getSex().equals("female")
				&& p.getAge() < 18 && p.getSiblingsOrSpouses() + p.getParentsOrChildren() >= 2);
		System.out.println("Surival rate for minor females with two relatives " + minorFemaleWith2Relative + "%");

		System.out.printf("Rich girls with family: %.1f%%\n",
				getSurvivalRate(passengers, p -> p.getCabinClass() == 1 && p.getSex().equals("female")
						&& p.getAge() < 18 && p.getSiblingsOrSpouses() + p.getParentsOrChildren() >= 2));
		// h) Adult men in third class with no relatives
		// i) Anyone who embarked from Southampton and whose fare was over 10 pounds
		// j) Anyone whose ticket number included the substring "13"
		double ticket13 = getSurvivalRate(passengers, p -> p.getTicketNumber().contains("13"));
		System.out.println("Surival rate for people with a ticket 13 " + ticket13 + "%");

		System.out.printf("Surival rate for people with a ticket 13: %.1f%%\n",
				getSurvivalRate(passengers, p -> p.getTicketNumber().contains("13")));
		// k) Anyone with the word "sink" in their name (case insensitive)

		double sink = getSurvivalRate(passengers,
				p -> p.getFirstName().toLowerCase().contains("sink") || p.getLastName().toLowerCase().contains("sink"));
		System.out.println("Surival rate for people with 'sink' in their name " + sink + "%");

	}

//	public static int makePercent(double x) {
//		return (int) (x * 100);
//	}

	public static Passenger getFirstMatch(ArrayList<Passenger> passengers, Predicate<Passenger> tester) {
		Passenger matched = null;
		for (Passenger passenger : passengers) {
			if (tester.test(passenger)) {
				matched = passenger;
				break;
			}
		}
		return matched;
	}

	public static List<Passenger> getMatchList(ArrayList<Passenger> passengers, Predicate<Passenger> tester) {
		List<Passenger> matchedList = new ArrayList<>();
		for (Passenger passenger : passengers) {
			if (tester.test(passenger)) {
				matchedList.add(passenger);
			}
		}
		return matchedList;
	}

	public static double getSurvivalRate(ArrayList<Passenger> passengers, Predicate<Passenger> tester) {
		double count = 0.0;
		double total = 0.0;
		for (Passenger passenger : passengers) {
			if (tester.test(passenger)) {
				total++;
				if (passenger.didSurvive()) {
					count++;
				}
			}
		}
		return 100.0 * count / total;
	}
}

package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
//		System.out.println("Good Bye!");
	}

	private void test() {
		Film film = db.findFilmById(1);
		Actor actor = db.findActorById(1);
		List<Actor> test = db.findActorsByFilmId(1);
		System.out.println(film);
		System.out.println(actor);
		System.out.println(test.size());
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Please Select and option");
		System.out.println("1. Look up a film by ID");
		System.out.println("2. Look up a film by Key word");
		System.out.println("3. Exit");
		int check = 0;
		int choice = 0;
		try {
			check = input.nextInt();
			boolean loop = true;
			while (loop) {
				switch (check) {
				case 1:
					System.out.println("Please enter the ID of the film youd like to display");
					int id = input.nextInt();
					Film film = db.findFilmById(id);
					input.nextLine();
					if (film != null) {
						film.display();
						System.out.println("Would you like to view additional detail about the film?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						choice = input.nextInt();
						displayAllDetails(choice, film);
					} else {
						System.out.println("no film found matching the film ID: " + id);
						System.out.println();
					}
					break;
				case 2:
					System.out.println("Please enter the Key word you would like to use");
					input.nextLine();
					String keyword = input.nextLine();
					List<Film> list = db.findFilmByKeyWord(keyword);
					if (list.size() != 0) {
						for (Film film2 : list) {
							film2.display();
						}
						System.out.println("Would you like to view additional detail about the films?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						choice = input.nextInt();
						displayAllDetails(choice, list);
					} else {
						System.out.println("no films found containing " + keyword);
						System.out.println();
					}
					break;
				case 3:
					loop = false;
					break;
				default:
					System.out.println("please enter a valid option");
					System.out.println();
					loop = false;
					break;
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid option");
			System.out.println();
		} finally {
			if (check != 3) {
				launch();
			}
			else {
				System.out.println("Good Bye!");
			}
		}
	}

	public void displayAllDetails(int choice, Film film) {

		switch (choice) {
		case 1:
			System.out.println(film);
			;
			break;
		}
	}

	public void displayAllDetails(int choice, List<Film> list) {

		switch (choice) {
		case 1:
			for (Film film : list) {
				System.out.println(film);
			}
			break;

		}
	}

}

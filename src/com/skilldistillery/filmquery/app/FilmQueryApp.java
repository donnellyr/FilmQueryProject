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
		System.out.println("Good Bye!");
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
		System.out.println("Please Select and option");
		System.out.println("1. Look up a film by ID");
		System.out.println("2. Look up a film by Key word");
		System.out.println("3. Exit");

		startUserInterface(input);
    input.close();
	}

	private void startUserInterface(Scanner input) {
		int check = 3;
		try {
			check = input.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid option");
			launch();
		}
		boolean loop = true;
		while (loop) {
			switch (check) {
			case 1:
				System.out.println("Please enter the ID of the film youd like to display");
				Film film = db.findFilmById(input.nextInt());
				input.nextLine();
				if (film != null) {
					film.display();
				} else {
					System.out.println("please enter a valid film ID");
				}
				launch();
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
				} else {
					System.out.println("no films found containing " + keyword);
				}
				launch();
				break;
			case 3:
				loop = false;
				check =0;
				break;
			default:
				System.out.println("please enter a valid option");
				loop = false;
    		launch();
				break;
			}
			break;
		}
	}

}

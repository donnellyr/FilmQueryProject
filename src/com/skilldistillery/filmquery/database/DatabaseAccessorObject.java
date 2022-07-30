package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		String user = "student";
		String pass = "student";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		Film film = null;
		String sql = "SELECT * FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String releaseYear = rs.getString("release_year");
				int languageID = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				List<Actor> actorList = findActorsByFilmId(filmId);
				String language = rs.getString("name");


				film = new Film(id, title, description, releaseYear, languageID, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures, actorList, language);
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
		String pass = "student";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				actor = new Actor(id, firstName, lastName);
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorList = new ArrayList<Actor>();
		String user = "student";
		String pass = "student";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		Actor actor = null;
		String sql = "SELECT a.first_name, a.last_name FROM actor a JOIN film_actor f ON a.id = f.actor_id JOIN film fm ON f.film_id = fm.id WHERE f.film_id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
//		  int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				actor = new Actor(firstName, lastName);
				actorList.add(actor);
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;
	}
	public List<Film> findFilmByKeyWord(String key) {
		key = "%" + key + "%";
		String user = "student";
		String pass = "student";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		List<Film> filmList = new ArrayList<>();
		Film film = null;
		String sql = "SELECT * FROM film f JOIN language l ON f.language_id = l.id WHERE title LIKE ? OR description LIKE ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String releaseYear = rs.getString("release_year");
				int languageID = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				List<Actor> actorList = new ArrayList<Actor>(findActorsByFilmId(id));
				String language = rs.getString("name");


				film = new Film(id, title, description, releaseYear, languageID, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures, actorList, language);
				filmList.add(film);
				
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
		
	}
}

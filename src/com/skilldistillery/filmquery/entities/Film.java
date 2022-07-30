package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
private int id;
private String title;
private String description;
private String releaseYear;
private int languageID;
private int rentalDuration;
private double rentalRate;
private int length;
private double replacementCost;
private String rating;
private String specialFeatures;
private List<Actor> actorList;
private String language;
public Film(int id, String title, String description, String releaseYear, int languageID, int rentalDuration,
		double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
		List<Actor> actorList, String language) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.releaseYear = releaseYear;
	this.languageID = languageID;
	this.rentalDuration = rentalDuration;
	this.rentalRate = rentalRate;
	this.length = length;
	this.replacementCost = replacementCost;
	this.rating = rating;
	this.specialFeatures = specialFeatures;
	this.actorList = actorList;
	this.language = language;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public Film() {
	
}
public Film(int id, String title, String description, String releaseYear, int languageID, int rentalDuration,
		double rentalRate, int length, double replacementCost, String rating, String specialFeatures, List<Actor> actorList) {
	this.id = id;
	this.title = title;
	this.description = description;
	this.releaseYear = releaseYear;
	this.languageID = languageID;
	this.rentalDuration = rentalDuration;
	this.rentalRate = rentalRate;
	this.length = length;
	this.replacementCost = replacementCost;
	this.rating = rating;
	this.specialFeatures = specialFeatures;
	this.actorList = actorList;
}
public void display() {
	System.out.println("Title: " + title + " Released: " + releaseYear + " Rating: " + rating + " Language: " + language);
	System.out.println("Description: " + description);
	System.out.print("Cast: ");
	for (Actor actor : actorList) {
		actor.display();
	}
	System.out.println();
	System.out.println();
}
@Override
public String toString() {
	return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
			+ ", languageID=" + languageID + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
			+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
			+ ", specialFeatures=" + specialFeatures + ", actorList=" + actorList + ", language=" + language + "] \n";
}
@Override
public int hashCode() {
	return Objects.hash(actorList, description, id, language, languageID, length, rating, releaseYear, rentalDuration,
			rentalRate, replacementCost, specialFeatures, title);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Film other = (Film) obj;
	return Objects.equals(actorList, other.actorList) && Objects.equals(description, other.description)
			&& id == other.id && Objects.equals(language, other.language) && languageID == other.languageID
			&& length == other.length && Objects.equals(rating, other.rating)
			&& Objects.equals(releaseYear, other.releaseYear) && rentalDuration == other.rentalDuration
			&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
			&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
			&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getReleaseYear() {
	return releaseYear;
}
public void setReleaseYear(String releaseYear) {
	this.releaseYear = releaseYear;
}
public int getLanguageID() {
	return languageID;
}
public void setLanguageID(int languageID) {
	this.languageID = languageID;
}
public int getRentalDuration() {
	return rentalDuration;
}
public void setRentalDuration(int rentalDuration) {
	this.rentalDuration = rentalDuration;
}
public double getRentalRate() {
	return rentalRate;
}
public void setRentalRate(double rentalRate) {
	this.rentalRate = rentalRate;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public double getReplacementCost() {
	return replacementCost;
}
public void setReplacementCost(double replacementCost) {
	this.replacementCost = replacementCost;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getSpecialFeatures() {
	return specialFeatures;
}
public void setSpecialFeatures(String specialFeatures) {
	this.specialFeatures = specialFeatures;
}
public List<Actor> getActorList() {
	return actorList;
}
public void setActorList(List<Actor> actorList) {
	this.actorList = actorList;
}
}

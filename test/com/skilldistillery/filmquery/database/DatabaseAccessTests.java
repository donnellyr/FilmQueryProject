package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }
  
  @Test
  void test_getFilmById_returns_film_with_id() {
    Film f = db.findFilmById(1);
    assertNotNull(f);
    assertEquals("ACADEMY DINOSAUR", f.getTitle());
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  @Test
  void test_getFilmByKeyWord_returns_films_with_key_word() {
	  List<Film> f = db.findFilmByKeyWord("whale");
	  assertNotEquals(0, f.size());
	  assertEquals("VAMPIRE WHALE", f.get(0).getTitle());
	  assertEquals("WHALE BIKINI", f.get(1).getTitle());
  }
  @Test
  void test_getFilmByKeyWord_with_invalid_key_word_returns_empty_film_list() {
	  List<Film> f = db.findFilmByKeyWord("help");
	  assertEquals(0, f.size());
  
}
}

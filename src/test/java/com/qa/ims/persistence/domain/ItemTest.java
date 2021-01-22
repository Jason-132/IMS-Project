package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Items game;
	private Items test_game;

	@Before
	public void setUp() {
		game = new Items(1L, "Zelda", 22.99);
		test_game = new Items(1L, "Zelda", 22.99); 
	}

	@Test 
	public void settersTest() { 
		assertNotNull(game.getItem_id()); 
		assertNotNull(game.getItem_name());
		assertNotNull(game.getPrice());

		game.setItem_id(null);
		assertNull(game.getItem_id()); 
		game.setItem_name(null);
		assertNull(game.getItem_name());
		game.setPrice(null);
		assertNull(game.getPrice());

	}

	@Test
	public void equalsWithNull() {
		assertNotEquals(game, null);
	}

	@Test
	public void equalsWithDifferentObject() {
		assertNotEquals(game, (new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, game.getItem_id(), 0);
		assertEquals("Zelda", game.getItem_name());
		assertEquals(22.99, game.getPrice(), 0);
	}

	@Test
	public void checkEquality() {
		assertEquals(game, (game));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertEquals(game, test_game);
	}

	@Test
	public void itemTitleNullButOtherTileNotNull() {
		game.setItem_name(null);
		assertNotEquals(game, test_game);
	}

	@Test
	public void itemTitlesNotEqual() {
		test_game.setItem_name("Minecraft");
		;
		assertNotEquals(game, test_game);
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullTitle() {
		game.setItem_name(null);
		test_game.setItem_name(null);
		assertEquals(game, test_game);
	}

	@Test
	public void nullId() {
		game.setItem_id(null);
		assertNotEquals(game, test_game);
	}

	@Test
	public void nullIdOnBoth() {
		game.setItem_id(null);
		test_game.setItem_id(null);
		assertEquals(game, test_game);
	}

	@Test
	public void otherIdDifferent() {
		test_game.setItem_id(2L);
		assertNotEquals(game, test_game);
	}

	@Test
	public void nullPrice() {
		game.setPrice(null);
		assertNotEquals(game, test_game);
	}

	@Test
	public void nullPriceOnBoth() {
		game.setPrice(null);
		test_game.setPrice(null);
		assertEquals(game, test_game);
	}

	@Test
	public void otherPriceDifferent() {
		test_game.setPrice(1099.0);
		assertNotEquals(game, test_game);
	}

	@Test
	public void constructorWithoutId() {
		Items item = new Items("Zelda", 22.99);
		assertNull(item.getItem_id());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(game.hashCode(), test_game.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Items item = new Items(null, null);
		Items test_game = new Items(null, null);
		assertEquals(item.hashCode(), test_game.hashCode());
	}

}

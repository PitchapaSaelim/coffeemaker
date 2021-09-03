/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 *
 * Permission has been explicitly granted to the University of Minnesota
 * Software Engineering Center to use and distribute this source for
 * educational purposes, including delivering online education through
 * Coursera or other entities.
 *
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including
 * fitness for purpose.
 *
 *
 * Modifications
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

//import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 *
 * @author Pitchapa SAE-LIM 6210546421
 */
public class CoffeeMakerTest {

    /**
     * The object under test.
     */
    private CoffeeMaker coffeeMaker;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;

    /**
     * Initializes some recipes to test with and the {@link CoffeeMaker}
     * object we wish to test.
     *
     * @throws RecipeException if there was an error parsing the ingredient
     *                         amount when setting up the recipe.
     */
    @Before
    public void setUp() throws RecipeException {
        coffeeMaker = new CoffeeMaker();

        //Set up for r1
        recipe1 = new Recipe();
        recipe1.setName("Coffee");
        recipe1.setAmtChocolate("0");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("50");

        //Set up for r2
        recipe2 = new Recipe();
        recipe2.setName("Mocha");
        recipe2.setAmtChocolate("20");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("75");

        //Set up for r3
        recipe3 = new Recipe();
        recipe3.setName("Latte");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtCoffee("3");
        recipe3.setAmtMilk("3");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("100");

        //Set up for r4
        recipe4 = new Recipe();
        recipe4.setName("Hot Chocolate");
        recipe4.setAmtChocolate("4");
        recipe4.setAmtCoffee("0");
        recipe4.setAmtMilk("1");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("65");
    }


    /**
     * Given a coffee maker with the default inventory
     * When we add inventory with well-formed quantities
     * Then we do not get an exception trying to read the inventory quantities.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("4", "7", "0", "9");
    }

    /**
     * Given a coffee maker with the default inventory
     * When we add inventory with malformed quantities (i.e., a negative
     * quantity and a non-numeric string)
     * Then we get an inventory exception
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddInventoryException() throws InventoryException {
        coffeeMaker.addInventory("4", "-1", "asdf", "3");
    }

    /**
     * Given a coffee maker with one valid recipe
     * When we make coffee, selecting the valid recipe and paying more than
     * the coffee costs
     * Then we get the correct change back.
     */
    @Test
    public void testMakeCoffee() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));
    }

    // Add a Recipe

    /**
     * Test Case ID: 1
     * Given a coffee maker with valid recipes
     * When we add the recipe,
     * Then we get the information of the recipe.
     */
    @Test
    public void testRecipeCanAdded() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertTrue(coffeeMaker.addRecipe(recipe2));
        assertTrue(coffeeMaker.addRecipe(recipe3));
    }

    /**
     * Test Case ID: 2
     * Given a coffee maker with three valid recipes
     * When we add three recipes already,
     * Then we can't add more than three recipes.
     */
    @Test
    public void testOnlyThreeRecipesCanAdded() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        assertFalse(coffeeMaker.addRecipe(recipe4));
    }

    /**
     * Test Case ID: 3
     * Given a coffee maker with one valid recipe
     * When we set the name of the recipe,
     * Then we can't enter a duplicate name with an existing one.
     */
    @Test
    public void testMustHaveUniqueNameInRecipe() {
        coffeeMaker.addRecipe(recipe1);
        Recipe exampleRecipe = new Recipe();
        exampleRecipe.setName("Coffee");
        assertFalse(coffeeMaker.addRecipe(exampleRecipe));
    }

    /**
     * Test Case ID: 4
     * Given a recipe with the price
     * When we set the price to the recipe with the string,
     * Then we can't set the price with the string.
     *
     * @throws RecipeException if there was an error parsing the price to a positive integer.
     */
    @Test(expected = RecipeException.class)
    public void testPriceMustBeInteger() throws RecipeException {
        recipe1.setPrice("Fifty");
        recipe2.setPrice("SeventyFive");
        recipe3.setPrice("OneHundred");
        recipe4.setPrice("SixtyFive");
    }

    // Delete a Recipe

    /**
     * Test Case ID: 5
     * Given a coffee maker with valid recipes
     * When we delete the recipe with the index of that recipe,
     * Then we get the name of the recipe that we deleted.
     */
    @Test
    public void testRecipesCanDeleted() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        assertEquals("Coffee", coffeeMaker.deleteRecipe(0));
        assertEquals("Mocha", coffeeMaker.deleteRecipe(1));
        assertEquals("Latte", coffeeMaker.deleteRecipe(2));
    }

    /**
     * Test Case ID: 6
     * Given a coffee maker with one valid recipe
     * When we delete the recipe with the wrong index of that recipe, it cannot be deleted
     * Then we get null.
     */
    @Test
    public void testReturnNullWhenRecipesCannotDeleted() {
        coffeeMaker.addRecipe(recipe1);
        assertNull("Coffee", coffeeMaker.deleteRecipe(-1));
    }

    // Edit a Recipe

    /**
     * Test Case ID: 7
     * Given a coffee maker with valid recipes
     * When we edit the recipe with the index of that recipe, and create new recipe to store new information instead
     * Then we get the name of the recipe that we edited.
     *
     * @throws RecipeException if there was an error parsing new recipe.
     */
    @Test
    public void testRecipeCanEdited() throws RecipeException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        Recipe newRecipe1 = new Recipe();
        newRecipe1.setAmtChocolate("10");
        newRecipe1.setAmtCoffee("32");
        newRecipe1.setAmtMilk("1");
        newRecipe1.setAmtSugar("12");
        newRecipe1.setPrice("1000");
        Recipe newRecipe2 = new Recipe();
        newRecipe2.setAmtChocolate("5");
        newRecipe2.setAmtCoffee("0");
        newRecipe2.setPrice("50");
        Recipe newRecipe3 = new Recipe();
        newRecipe3.setAmtChocolate("1");
        newRecipe3.setAmtCoffee("1");
        newRecipe3.setAmtMilk("1");
        assertEquals("Coffee", coffeeMaker.editRecipe(0, newRecipe1));
        assertEquals("Mocha", coffeeMaker.editRecipe(1, newRecipe2));
        assertEquals("Latte", coffeeMaker.editRecipe(2, newRecipe3));
    }

    /**
     * Test Case ID: 8
     * Given a coffee maker with one valid recipe
     * When we edit the recipe with the index of that recipe, and create new recipe to store new information instead
     * Then we can't change the name of the recipe.
     *
     * @throws RecipeException if there was an error parsing new recipe.
     */
    @Test
    public void testAfterEditedNameCannotBeChanged() throws RecipeException {
        coffeeMaker.addRecipe(recipe1);
        Recipe newRecipe1 = new Recipe();
        newRecipe1.setName("Water");
        coffeeMaker.editRecipe(0, newRecipe1);
        assertEquals("Coffee", coffeeMaker.getRecipes()[0].getName());
    }

    // Add Inventory

    /**
     * Test Case ID: 9
     * Given a coffee maker with the amount of coffee
     * When we add the amount of coffee to the inventory,
     * Then we can add amount of coffee.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testAmtCoffeeCanAddedInInventory() throws InventoryException {
        coffeeMaker.addInventory("10", "0", "0", "0");
    }

    /**
     * Test Case ID: 10
     * Given a coffee maker with the amount of milk
     * When we add the amount of milk to the inventory,
     * Then we can add amount of milk.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testAmtMilkCanAddedInInventory() throws InventoryException {
        coffeeMaker.addInventory("0", "10", "0", "0");
    }

    /**
     * Test Case ID: 11
     * Given a coffee maker with the amount of sugar
     * When we add the amount of sugar to the inventory,
     * Then we can add amount of sugar.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testAmtSugarCanAddedInInventory() throws InventoryException {
        coffeeMaker.addInventory("0", "0", "10", "0");
    }

    /**
     * Test Case ID: 12
     * Given a coffee maker with the amount of chocolate
     * When we add the amount of chocolate to the inventory,
     * Then we can add amount of chocolate.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testAmtChocolateCanAddedInInventory() throws InventoryException {
        coffeeMaker.addInventory("0", "0", "0", "10");
    }

    /**
     * Test Case ID: 13
     * Given a coffee maker with the amount of ingredients
     * When we add the amount of ingredients with negative integer to the inventory,
     * Then we can't add amount of ingredients.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAmtCanOnlyAddedWithPositiveIntegerInInventory() throws InventoryException {
        coffeeMaker.addInventory("-10", "-10", "-30", "-90");
    }

    // Check Inventory

    /**
     * Test Case ID: 14
     * Given a coffee maker with the amount of ingredients
     * When we add the amount of ingredients to the inventory,
     * Then we get updated amount of ingredients.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testInventoryCanChecked() throws InventoryException {
        coffeeMaker.addInventory("10", "20", "0", "40");
        String detailsInventory = "Coffee: 25\nMilk: 35\nSugar: 15\nChocolate: 55\n";
        assertEquals(detailsInventory, coffeeMaker.checkInventory());
    }

    // Purchase Beverage

    /**
     * Test Case ID: 15
     * Given a coffee maker with valid recipes
     * When we purchase, the amount we pay will be calculated against the price
     * Then we get correct change and ingredients are reduced to make coffee according to the selected recipe.
     */
    @Test
    public void testBeverageCanPurchased() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe3);
        assertEquals(10, coffeeMaker.makeCoffee(0, 60));
        assertNotEquals(0, coffeeMaker.makeCoffee(1, 200));
    }

    /**
     * Test Case ID: 16
     * Given a coffee maker with valid recipes
     * When we make coffee with the selected recipe,
     * Then we get the details of the inventory with ingredients are reduced from being used to make coffee.
     */
    @Test
    public void testInventoryUpdatedWhenPurchased() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.makeCoffee(2, 160);
        String detailsInventory = "Coffee: 12\nMilk: 12\nSugar: 14\nChocolate: 15\n";
        assertEquals(detailsInventory, coffeeMaker.checkInventory());
    }

    /**
     * Test Case ID: 17
     * Given a coffee maker with valid recipes
     * When we make coffee, but the ingredients are not enough,
     * Then we get the change equal to the money we paid.
     */
    @Test
    public void testMakeCoffeeWhenIngredientsNotEnough() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        assertEquals(75, coffeeMaker.makeCoffee(1, 75));
    }

    /**
     * Test Case ID: 18
     * Given a coffee maker with valid recipes
     * When we make coffee, but the recipe that we selected is not in the system,
     * Then we get the change equal to the money we paid.
     */
    @Test
    public void testMakeCoffeeWhenRecipeIsNull() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        assertEquals(100, coffeeMaker.makeCoffee(2, 100));
    }

    /**
     * Test Case ID: 19
     * Given a coffee maker with valid recipes
     * When we make coffee with not enough money for the price,
     * Then we get the change equal to the money we paid.
     */
    @Test
    public void testPurchasedBeverageWithNotEnoughMoney() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        assertEquals(40, coffeeMaker.makeCoffee(0, 40));
    }
}

package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for Inventory class.
 *
 * @author Pitchapa SAE-LIM 6210546421
 */
public class InventoryTest {

    /**
     * The object under test.
     */
    private Inventory inventory;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    /**
     * Initializes some recipes to test with and the {@link Inventory}
     * object we wish to test.
     *
     * @throws RecipeException if there was an error parsing the ingredient
     *                         amount when setting up the recipe.
     */
    @Before
    public void setUp() throws RecipeException {

        inventory = new Inventory();

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
        recipe3.setName("Hot Chocolate");
        recipe3.setAmtChocolate("4");
        recipe3.setAmtCoffee("0");
        recipe3.setAmtMilk("1");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("65");
    }

    /**
     * Test Case ID: 20
     * Given an inventory with a valid amount of chocolate
     * When we set the amount of the chocolate with positive integer,
     * Then we get the amount of the chocolate.
     */
    @Test
    public void testSetChocolateWithPositiveInteger() {
        inventory.setChocolate(9);
        assertEquals(9, inventory.getChocolate());
    }

    /**
     * Test Case ID: 21
     * Given an inventory with a valid amount of chocolate
     * When we set the amount of the chocolate with negative number,
     * Then we can't set the amount of chocolate and get the default of amount of chocolate.
     */
    @Test
    public void testSetChocolateWithNegativeInteger() {
        inventory.setChocolate(-9);
        assertEquals(15, inventory.getChocolate());
    }

    /**
     * Test Case ID: 22
     * Given an inventory with a valid amount of chocolate
     * When we add the amount of the chocolate with positive number,
     * Then we can add the amount of chocolate with positive number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testCanAddChocolateWithPositiveInteger() throws InventoryException {
        inventory.addChocolate("15");
    }

    /**
     * Test Case ID: 23
     * Given an inventory with a valid amount of chocolate
     * When we add the amount of the chocolate with the string,
     * Then we can't add the amount of chocolate with the string.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testAddChocolateMustBeInteger() throws InventoryException {
        inventory.addChocolate("fifteen");
    }

    /**
     * Test Case ID: 24
     * Given an inventory with a valid amount of chocolate
     * When we add the amount of the chocolate with negative number,
     * Then we can't add the amount of chocolate with negative number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testCannotAddChocolateWithNegativeInteger() throws InventoryException {
        inventory.addChocolate("-15");
    }

    /**
     * Test Case ID: 25
     * Given an inventory with a valid amount of sugar
     * When we set the amount of the sugar with positive integer,
     * Then we get the amount of the sugar.
     */
    @Test
    public void testSetSugarWithPositiveInteger() {
        inventory.setSugar(9);
        assertEquals(9, inventory.getSugar());
    }

    /**
     * Test Case ID: 26
     * Given an inventory with a valid amount of sugar
     * When we set the amount of the sugar with negative number,
     * Then we can't set the amount of sugar and get the default of amount of sugar.
     */
    @Test
    public void testSetSugarWithNegativeInteger() {
        inventory.setSugar(-9);
        assertEquals(15, inventory.getSugar());
    }

    /**
     * Test Case ID: 27
     * Given an inventory with a valid amount of sugar
     * When we add the amount of the sugar with positive number,
     * Then we can add the amount of sugar with positive number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testCanAddSugarWithPositiveInteger() throws InventoryException {
        inventory.addSugar("15");
    }

    /**
     * Test Case ID: 28
     * Given an inventory with a valid amount of sugar
     * When we add the amount of the sugar with the string,
     * Then we can't add the amount of sugar with the string.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testAddSugarMustBeInteger() throws InventoryException {
        inventory.addSugar("fifteen");
    }

    /**
     * Test Case ID: 29
     * Given an inventory with a valid amount of sugar
     * When we add the amount of the sugar with negative number,
     * Then we can't add the amount of sugar with negative number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testCannotAddSugarWithNegativeInteger() throws InventoryException {
        inventory.addSugar("-15");
    }

    /**
     * Test Case ID: 30
     * Given an inventory with a valid amount of coffee
     * When we set the amount of the coffee with positive integer,
     * Then we get the amount of the coffee.
     */
    @Test
    public void testSetCoffeeWithPositiveInteger() {
        inventory.setCoffee(9);
        assertEquals(9, inventory.getCoffee());
    }

    /**
     * Test Case ID: 31
     * Given an inventory with a valid amount of coffee
     * When we set the amount of the coffee with negative number,
     * Then we can't set the amount of coffee and get the default of amount of coffee.
     */
    @Test
    public void testSetCoffeeWithNegativeInteger() {
        inventory.setCoffee(-9);
        assertEquals(15, inventory.getCoffee());
    }

    /**
     * Test Case ID: 32
     * Given an inventory with a valid amount of coffee
     * When we add the amount of the coffee with positive number,
     * Then we can add the amount of coffee with positive number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testCanAddCoffeeWithPositiveInteger() throws InventoryException {
        inventory.addCoffee("15");
    }

    /**
     * Test Case ID: 33
     * Given an inventory with a valid amount of coffee
     * When we add the amount of the coffee with the string,
     * Then we can't add the amount of coffee with the string.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testAddCoffeeMustBeInteger() throws InventoryException {
        inventory.addCoffee("fifteen");
    }

    /**
     * Test Case ID: 34
     * Given an inventory with a valid amount of coffee
     * When we add the amount of the coffee with negative number,
     * Then we can't add the amount of coffee with negative number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testCannotAddCoffeeWithNegativeInteger() throws InventoryException {
        inventory.addCoffee("-15");
    }

    /**
     * Test Case ID: 35
     * Given an inventory with a valid amount of milk
     * When we set the amount of the milk with positive integer,
     * Then we get the amount of the milk.
     */
    @Test
    public void testSetMilkWithPositiveInteger() {
        inventory.setMilk(9);
        assertEquals(9, inventory.getMilk());
    }

    /**
     * Test Case ID: 36
     * Given an inventory with a valid amount of milk
     * When we set the amount of the milk with negative number,
     * Then we can't set the amount of milk and get the default of amount of milk.
     */
    @Test
    public void testSetMilkWithNegativeInteger() {
        inventory.setMilk(-9);
        assertEquals(15, inventory.getMilk());
    }

    /**
     * Test Case ID: 37
     * Given an inventory with a valid amount of milk
     * When we add the amount of the milk with positive number,
     * Then we can add the amount of milk with positive number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test
    public void testCanAddMilkWithPositiveInteger() throws InventoryException {
        inventory.addMilk("15");
    }

    /**
     * Test Case ID: 38
     * Given an inventory with a valid amount of milk
     * When we add the amount of the milk with the string,
     * Then we can't add the amount of milk with the string.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testAddMilkMustBeInteger() throws InventoryException {
        inventory.addMilk("fifteen");
    }

    /**
     * Test Case ID: 39
     * Given an inventory with a valid amount of milk
     * When we add the amount of the milk with negative number,
     * Then we can't add the amount of milk with negative number.
     *
     * @throws InventoryException if there was an error that inventory cannot add.
     */
    @Test (expected = InventoryException.class)
    public void testCannotAddMilkWithNegativeInteger() throws InventoryException {
        inventory.addMilk("-15");
    }

    /**
     * Test Case ID: 40
     * Given an inventory with a valid amount of coffee
     * When we set the amount of the coffee, and we select the recipe that uses the amount of coffee more than we set
     * Then we can't make a coffee because the ingredient wasn't enough.
     */
    @Test
    public void testCoffeeIsNotEnough() {
        inventory.setCoffee(1);
        assertFalse(inventory.enoughIngredients(recipe1));
    }

    /**
     * Test Case ID: 41
     * Given an inventory with a valid amount of sugar
     * When we set the amount of the sugar, and we select the recipe that uses the amount of sugar more than we set
     * Then we can't make a sugar because the ingredient wasn't enough.
     */
    @Test
    public void testSugarIsNotEnough() {
        inventory.setSugar(0);
        assertFalse(inventory.enoughIngredients(recipe2));
    }

    /**
     * Test Case ID: 42
     * Given an inventory with a valid amount of chocolate
     * When we set the amount of the chocolate, and we select the recipe that uses the amount of chocolate more than we set
     * Then we can't make a chocolate because the ingredient wasn't enough.
     */
    @Test
    public void testChocolateIsNotEnough() {
        inventory.setChocolate(15);
        assertFalse(inventory.enoughIngredients(recipe2));
    }

    /**
     * Test Case ID: 43
     * Given an inventory with a valid amount of milk
     * When we set the amount of the milk, and we select the recipe that uses the amount of milk more than we set
     * Then we can't make a milk because the ingredient wasn't enough.
     */
    @Test
    public void testMilkIsNotEnough() {
        inventory.setMilk(0);
        assertFalse(inventory.enoughIngredients(recipe3));
    }
}

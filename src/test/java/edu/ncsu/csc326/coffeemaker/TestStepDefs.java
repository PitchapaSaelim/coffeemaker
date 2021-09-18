package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

/**
 * Step definitions for Cucumber Test.
 *
 * @author Pitchapa SAE-LIM 6210546421
 */
public class TestStepDefs {

    /**
     * The object under test.
     */
    private CoffeeMaker coffeeMaker;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;

    // Boolean is used to check the status of adding a recipe.
    private boolean recipeCanAdded = false;

    @Given("A coffee maker with a valid recipe")
    public void aCoffeeMakerWithAValidRecipe() throws RecipeException {
        coffeeMaker = new CoffeeMaker();

        //Set up for r1
        recipe1 = new Recipe();
        recipe1.setName("Coffee");
        recipe1.setAmtChocolate("0");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("50");
    }

    @When("I add a recipe")
    public void iAddARecipe() {
        recipeCanAdded = coffeeMaker.addRecipe(recipe1);
    }

    @Then("A recipe can be added")
    public void aRecipeCanBeAdded() {
        assertTrue(recipeCanAdded);
    }

    @Given("A coffee maker with valid recipes")
    public void aCoffeeMakerWithValidRecipes() throws RecipeException {
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

    @When("I add more than three recipes")
    public void iAddMoreThanThreeRecipes() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        recipeCanAdded = coffeeMaker.addRecipe(recipe4);
    }

    @Then("Cannot add more than three recipes")
    public void cannotAddMoreThanThreeRecipes() {
        assertFalse(recipeCanAdded);
    }

    @When("I add a recipe with duplicate name")
    public void iAddARecipeWithDuplicateName() {
        coffeeMaker.addRecipe(recipe1);
        Recipe exampleRecipe = new Recipe();
        exampleRecipe.setName("Coffee");
        recipeCanAdded = coffeeMaker.addRecipe(exampleRecipe);
    }

    @Then("Cannot enter a duplicate name with an existing one")
    public void cannotEnterADuplicateNameWithAnExistingOne() {
        assertFalse(recipeCanAdded);
    }
}

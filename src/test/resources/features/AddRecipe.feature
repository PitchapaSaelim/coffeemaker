Feature: Only three recipes may be added to the CoffeeMaker. A recipe consists of a name, price,
  units of coffee, units of milk, units of sugar, and units of chocolate. Each recipe name must
  be unique in the recipe list. Price must be handled as an integer. A status message is
  printed to specify if the recipe was successfully added or not. Upon completion, the
  CoffeeMaker is returned to the waiting state.

  Scenario: Add a recipe
    Given A coffee maker with a valid recipe
    When I add a recipe
    Then A recipe can be added

  Scenario: Only three recipes can be added
    Given A coffee maker with valid recipes
    When I add more than three recipes
    Then Cannot add more than three recipes

  Scenario: The recipe must have a unique name
    Given A coffee maker with a valid recipe
    When I add a recipe with duplicate name
    Then Cannot enter a duplicate name with an existing one
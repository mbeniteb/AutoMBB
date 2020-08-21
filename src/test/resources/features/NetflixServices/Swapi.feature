@swapi
Feature: Api de starwars para el uso multiplataforma

  @scenario1sw
  Scenario: Usuario obtiene la lista de personaje
    Given el api esta operativo
    When obtiene la lista de personajes
    And valido que el nombre del elemento 3 de tipo "height" es "202"
    Then valido que la respuesta final obtenida es 200
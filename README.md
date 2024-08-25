# Ecosystem Simulation Project

## Project Overview

### Purpose
This project is developed as part of the Object-Oriented Programming course. The goal is to simulate an ecosystem where various animal and plant species coexist. The simulation replicates real-world behaviors such as reproduction, predation, and aging.

### Context
The project is implemented in Java and was developed using IntelliJ IDEA on macOS. The ecosystem is modeled using classes, abstract classes, interfaces, and enumerations to simulate interactions between species.

## Organization and Structure

### Main Classes
- **Ecosystem:** The core class managing the entire ecosystem, including all living organisms.
- **Organism:** The base class for all living entities in the ecosystem, containing common attributes like `id` and `ecosystem`.
- **Plant and Subclasses:** Represents plant entities in the ecosystem with subclasses such as `Vegetable`, `Herb`, and `Tree`.
- **Animal and Subclasses:** Represents animal entities, subdivided into `Mammal`, `Bird`, and `Reptile` classes.
- **Egg:** Represents eggs laid by oviparous animals, storing parent characteristics for inheritance.

### Key Functionalities
- **Reproduction:** Different modes of reproduction are modeled using interfaces and implemented concretely in `Viviparous` and `Oviparous` classes.
- **Dietary Habits:** The dietary habits are represented by interfaces and concrete classes such as `Herbivore`, `Carnivore`, `Scavenger`, `Legumivore`, and `Ovivore`.
- **Lifecycle Management:** The simulation tracks aging, hunger, and reproduction cycles, leading to dynamic changes in the ecosystem.

## Usage

### Running the Simulation
To run the simulation, execute the `Main` class. The simulation will initialize a temperate forest ecosystem populated with a random number of animals and plants, and run for a random number of days with a visible progression.

### Configuration
- **Initial Setup:** The ecosystem is populated with 5-8 instances of each species, including `Asparagus`, `Deer`, `Birch`, `Crow`, `Lettuce`, `Wolf`, `Mint`, `Bear`, `Rhubarb`, and `Turtle`.
- **Simulation Loop:** Each day in the simulation represents a cycle where plants and animals may reproduce, age, and interact. The simulation pauses for 10 seconds between each cycle for observation.

## Tests

### Test Cases
The project includes various test cases to validate the functionality:
- `testDeerReproduce()`: Tests reproduction of a deer.
- `testBearEat()`: Validates that a bear can consume other animals and plants.
- `testEggHatch()`: Ensures eggs hatch correctly after fertilization.
- `testPlantGrow()`: Simulates a day in the life of a plant.


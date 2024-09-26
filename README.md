# Hungry Animal Game - Group E

## Concepts
### Abstract Classes & Polymorphism
We demonstrate the concept of abstract classes in the class `Food` as shown below.
```mermaid
flowchart TD
	n1["Food"]
	n1 --- n2(["Apple"])
	n1 --- n3(["Banana"])
```
The `Food` class is abstract, meaning we will never instantiate it directly. 
Instead, we create instances of its subclasses, such as `Apple` or `Banana`. 
The `Food` class represents anything the Elephant can eat, and each food item can each have a unique value indicating how many points it awards to the player.

### Overrides
```mermaid
flowchart TD
	n1["Food"]
	n1 --- n2(["Apple"])
	n1 --- n3(["Banana"])
	subgraph n1["Food"]
		n4["move()"]
	end
	subgraph n2["Apple"]
		n5["move()"]
	end
	subgraph n3["Banana"]
		n6["move()"]
	end
```

In the `Food` class, we define an abstract method `move()`, which is overridden by its subclasses `Apple` and `Banana`. This allows each type of food to have a unique movement speed.

### Interfaces
The interface `Moveable` says the implemented classes (`Elephant` and `Food`) must define certain behaviour, in this case, a `move()` method. This is helpful as we can be certain that any class that implements `Moveable` can be moved in the same way.

[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=16138150&assignment_repo_type=AssignmentRepo)

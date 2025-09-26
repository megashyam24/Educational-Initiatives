# Educational-Initiatives Placement

Exercise 1: Design Patterns

This exercise demonstrates implementations of behavioral, creational, and structural design patterns using Java. Each pattern has a separate folder containing the code, a README explaining the concept, and screenshots showing program output.

Observer Pattern (Behavioral): Implements a publish-subscribe system where User objects subscribe to topics like News, Sports, and Entertainment. When the publisher sends a message, all subscribers are notified automatically, demonstrating a one-to-many relationship. Inspired by event notification concepts from my Computer Networks project.

Strategy Pattern (Behavioral): A DocumentEditor supports multiple editing strategies such as UpperCase, LowerCase, and Reverse. Algorithms are encapsulated as strategies and can be switched at runtime, allowing flexible behavior without changing the main logic.

Singleton Pattern (Creational): PrinterManager ensures that only one instance exists to manage all print jobs. This controls access to a shared global resource and prevents inconsistencies.

Factory Pattern (Creational): PlaylistFactory creates playlists like Workout, Relax, Party, or Focus based on user input. The creation logic is hidden from the main program, promoting loose coupling and easier maintenance.

Decorator Pattern (Structural): An Avatar is built by dynamically adding features such as Hat, Glasses, Beard, and Costume. This demonstrates flexible object composition without modifying the base class.

Adapter Pattern (Structural): CardAdapter allows MemoryCard objects to connect to a USBPort. This shows how objects with incompatible interfaces can work together seamlessly.

Exercise 2: Satellite Command System

Simulates controlling a satellite in orbit with commands like Rotate, Activate/Deactivate Solar Panels, and Collect Data.

Uses Command Pattern to encapsulate each action and allow Undo functionality.

Implements Observer Pattern to notify status updates whenever satellite state changes.

Follows OOP principles and SOLID design practices to maintain clean, modular, and scalable code.

The console-based program allows sequential command execution and shows live state updates.

Key Features

Pure console/terminal-based applications to focus on logic and code quality.

Demonstrates OOP concepts, behavioral/structural/creational design patterns, and SOLID principles.

Each project has a separate README explaining the design, implementation, and how patterns are applied.

Screenshots included to showcase outputs and functionality.

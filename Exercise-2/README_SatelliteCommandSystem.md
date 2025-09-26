This console-based simulator showcases OOP, behavioral design patterns, and clean coding practices. The Satellite class handles orientation, solar panel status, and data collection, using encapsulation to ensure controlled and safe access to its internal state.

The Observer Pattern is applied via the Observer interface and Status class, notifying all registered observers automatically whenever the satellite’s state changes. This ensures efficient real-time updates without repeatedly checking the satellite, demonstrating a clear one-to-many dependency.

The Command Pattern encapsulates operations like Rotate, ActivatePanels, DeactivatePanels, and CollectData into separate command objects. Using a stack in UndoCommand, the system allows easy rollback, decouples actions from the main program, and adds flexibility for undoable operations.

Users interact through a console interface to rotate the satellite, toggle panels, collect data, check status, or undo commands. Input validation ensures incorrect commands or invalid directions are handled gracefully, enhancing robustness and usability.

SOLID principles guide the design: each class has a single responsibility, the system is open for extension but closed for modification, and encapsulation safeguards internal state. This makes the code maintainable, scalable, and easy to extend with new commands or features.

Error handling uses try-catch blocks. Rotation commands validate directions (North, South, East, West), and data collection is restricted when panels are off, preventing program crashes and ensuring safe operations.

By integrating Observer and Command patterns with OOP and SOLID principles, the simulator efficiently manages state, notifications, and undoable actions. It provides a practical, interactive, and extendable satellite control system, mirroring real-world aerospace management concepts. Refer to the screenshots to see the program output and how commands are executed dynamically.
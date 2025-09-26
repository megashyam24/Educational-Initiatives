The Decorator Pattern allows adding new features to an object dynamically without changing its original code. I understood it as “wrapping” an object to extend its behavior at runtime.

For my implementation, I used an avatar customization example. The BaseAvatar is the original object, and decorators like Hat, Glasses, Beard, and Costume wrap the avatar to add features while keeping previous ones intact.

The program lets the user choose features one by one. Each selected feature wraps the current avatar, building a final avatar with all applied features. Calling avatar.show() then displays the base avatar along with all added features.

This project helped me see how structural patterns let us extend functionality without modifying existing classes.
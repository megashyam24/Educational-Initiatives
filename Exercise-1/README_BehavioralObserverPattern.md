The Observer Pattern allows one object to automatically notify many others when its state changes. I saw its usefulness in apps like news feeds or chat notifications, where updates happen without manual checking.

I implemented it using a publish-subscribe model. The Pub class acts as the publisher for topics like Sports, News, or Entertainment, while User objects subscribe to the topics they want.

This idea came from a previous Computer Networks project on data flow and event-driven notifications, which helped me visualize the system.

The program collects users and their preferred topics, then notifies subscribers instantly when a message is published. This shows a clear one-to-many relationship and handles multiple topics efficiently.

Check the screenshots for the output to see how the same text can be edited in different ways using different strategies.
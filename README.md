# Snake Game in JavaFX

This project is a classic **Snake Game** developed in JavaFX. The game allows players to control a snake that grows in length as it consumes food items, with the goal of avoiding collisions with the snake's own body or the edges of the screen.

## Features

- **Classic Snake Gameplay**: The snake moves across the grid, eating food to grow while avoiding collisions.
- **Grid System**: The game uses two grids — one for the background and one for the player.
- **Timeline Animation**: Movement is managed using a JavaFX `Timeline` to ensure smooth and consistent animation.
- **Adjustable Speed**: The snake's speed can be adjusted based on the player's progress.

## Installation

### Requirements

- **Java 11 or higher**
- **Gradle**
- **JavaFX SDK**

### Clone the repository

```bash
git clone https://github.com/BenjaminC62/SnakeGameJavaFX.git
```

### Build the project

Navigate to the project directory and run the following command to build the project:

```bash
./gradlew build
```

### Run the game

To run the game, use:

```bash
./gradlew run
```

### Controls

    - Arrow Keys: Move the snake up, down, left, or right.
    - ESC: Pause the game.

### Structure

    - Main class: SnakeGame.java
    - Game logic: The game logic is implemented using JavaFX's Timeline and event handlers for snake movement.
    - Grid System: The background and snake are displayed using a two-layer grid system.

### Changelog
#### Version 1.0.0 (June 21, 2024)

    - Added the Timeline to manage snake movement.
    - Introduced the dual-grid system (one for the background, one for the snake).
    - Fixed issues with the SceneBuilder configuration to display the snake correctly.

### Contribution

Feel free to fork the repository and submit pull requests if you'd like to contribute.

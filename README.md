# 🎮 Top-Down Game Prototype
A simple top-down Java game acting as a sandbox to explore and practice core 2D game-development fundamentals. Walk around, collect items, test movement and collision logic.

## 🛠️ Technology
- `Java`
- `Graphics2D`
- `Notepad`
- `Aseprite`

## 🚀 Features
- **Tile-based world navigation** - move around a world built from tiles
- **Collision detection** - prevents walking through walls, trees, water or outside map boundaries
- **Viewport/camera system** - only part of the map renders at a time, simulating a camera view tied to the player’s current position
- **Collectable items** - interactable objects like keys and chests for pickup and interaction
- **Sandbox environment for experimentation** - no end goal, enemies or purpose: this project’s main purpose is for learning and experimentation.

## 🧠 The Process
I built this project to get a hands-on understanding of what goes on behind 2D games, more specifically, the overworld. Engine-based projects abstract away the core mechanics (rendering, input handling, collision, camera logic). I wanted to skip those abstractions and code everything myself, to understand the fundamentals.

This project stands apart from engine-dependent games because it forces a deep dive into the basics: rendering loops, manual input handling, collision logic, viewport rendering and item interaction. I started with the foundation of drawing the tiles, character and objects with Aseprite. For the code, I could focus on the program listening for keyboard input and making a movable player since the character was already decided. Over time, I added collision detection, camera viewport logic, tile-based world layout and item pickups. 

Since I am not using a game-engine there is no drag and drop or map editor to create the world with the tiles. As an alternative, I tagged each tile with a number ID and, using Notepad, create the world by writing a 2-dimensional grid where each cell holds the ID of the tile to draw there. When the game runs, it reads the grid and draws the tiles accordingly

## 📦 Running the Project
1. Clone the repository
2. Navigate into the project directory
3. Compile Java source files
4. Run main class

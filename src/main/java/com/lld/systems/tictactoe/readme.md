# TicTacToe Game

A command-line implementation of the classic Tic Tac Toe game in Java. Two players take turns placing their symbols (O and X) on a 3×3 board, with the first player to get three in a row (horizontally, vertically, or diagonally) winning the game.

## Project Structure

The implementation consists of four main classes:

- **`Game`**: Manages game flow, player turns, and game state
- **`Board`**: Handles the game board, move validation, and win condition checking
- **`Player`**: Represents a player with a name and symbol
- **`SYMBOL`**: Enum defining player symbols (X and O)

## How to Play

### Starting the Game

```java
Game game = new Game(3, "Sushil", "Divyani");
game.startGame();
```

### Game Flow

1. The board is displayed before each turn
2. The current player is prompted to enter their move as row and column indices (0-2)
3. Players alternate turns after each valid move
4. The game ends when:
   - A player gets three symbols in a row/column/diagonal (wins)
   - All 9 squares are filled with no winner (draw)

### Input Format

Enter two integers separated by a newline:
- **Row**: 0-2 (top to bottom)
- **Column**: 0-2 (left to right)

## Class Reference

### Game

Orchestrates the game loop, manages players, and determines win conditions.

**Constructor:**
- `Game(int size, String player1Name, String player2Name)`: Initializes a new game with specified player names

**Key Methods:**
- `startGame()`: Initiates the game loop

**Attributes:**
- `board`: The game board
- `player1`: First player (symbol O)
- `player2`: Second player (symbol X)
- `currentPlayer`: Tracks whose turn it is
- `moveCount`: Counts total moves made

### Board

Maintains the game state and validates moves.

**Constructor:**
- `Board(int size)`: Creates a new board of specified size

**Key Methods:**
- `move(row, col, SYMBOL symbol)`: Places a symbol on the board; returns `false` if position is invalid
- `checkWinner(row, col)`: Checks if the last move resulted in a win
- `printBoard()`: Displays the current board state in formatted grid

**Win Conditions Checked:**
- **Horizontal**: All three symbols in a row match
- **Vertical**: All three symbols in a column match
- **Main Diagonal (↘)**: All positions from top-left to bottom-right match
- **Anti-Diagonal (↙)**: All positions from top-right to bottom-left match

### Player

Simple data holder for player information.

**Attributes:**
- `name`: Player's name
- `symbol`: Player's symbol (X or O)

### SYMBOL Enum

Defines the two possible player symbols.

**Enum Constants:**
- `X`: Represents player 2 (character 'X')
- `O`: Represents player 1 (character 'O')

**Methods:**
- `getValue()`: Returns the character value of the symbol

## Example Game Output

```
 . | . | .
---+---+---
 . | . | .
---+---+---
 . | . | .

Sushil: Where would you like to place?
1 1
 . | . | .
---+---+---
 . | O | .
---+---+---
 . | . | .

Divyani: Where would you like to place?
1 0
 . | . | .
---+---+---
 X | O | .
---+---+---
 . | . | .

Sushil: Where would you like to place?
0 1
 . | O | .
---+---+---
 X | O | .
---+---+---
 . | . | .

Divyani: Where would you like to place?
0 0
 X | O | .
---+---+---
 X | O | .
---+---+---
 . | . | .

Sushil: Where would you like to place?
2 1
 X | O | .
---+---+---
 X | O | .
---+---+---
 . | O | .
The Winner is Sushil
Game Over
```

## Dependencies

- **Lombok**: Used for `@Getter`, `@Setter`, and `@AllArgsConstructor` annotations
- **Java 8+**

## Known Limitations & Potential Improvements

1. **Board size is hardcoded** — Currently fixed at 3×3; could be parameterized for larger boards
2. **Limited input validation** — Doesn't handle non-integer inputs; would benefit from exception handling
3. **Scanner resource** — Not explicitly closed; should use try-with-resources for better resource management
4. **Move validation timing** — Invalid moves don't consume player turns; could be adjusted based on game rules
5. **No move history** — Cannot undo moves or replay the game
6. **No persistence** — Game state is not saved; could add save/load functionality
7. **Hardcoded player order** — Player 1 always starts; could be randomized

## Running the Game

Compile and run the `TicTacToe` class:

```bash
javac TicTacToe.java
java TicTacToe
```

Or if using Maven:

```bash
mvn clean compile exec:java -Dexec.mainClass="com.lld.systems.tictactoe.TicTacToe"
```

## License

This is a learning project for Low-Level Design practice.

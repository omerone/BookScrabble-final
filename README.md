# Book Scrabble Game

Book Scrabble is a word game that challenges players to form words using letter tiles.
In this version of the game, all the words must be related to books, authors, or literary themes.

## Table of Contents
- [Overview](Overview.md)
- [Features](Features.md)
- [Usage](Usage.md)

## Overview
A Desktop application named Book Scrabble Game permits users to establish an account, either create or participate in a game, and engage in online gameplay against other players. The game is played on a board with a grid of letter tiles, where players alternate in placing tiles to create words. The score is determined by the words' length and complexity, in addition to any bonus tiles used.

Moreover, the game comprises of a lexicon of literary terms and expressions, enabling players to effortlessly discover ideas for their upcoming moves.

## Collaborators
* [Omer Maoz](https://github.com/Omerone)
* [Tomer Mizrahi](https://github.com/TomerMiz10)
* [Ori Joseph](https://github.com/josephori)
* [Nitzan Toledo](https://github.com/nitzanto)

## Video links
 * Demo video - will be added
 * Project presentation video - will be added

## Gantt

![image](https://github.com/omerone/BookScrabble-final/blob/b5e6c3d29453609e9c80ef96503630f3cc3388cd/src%20files/Gantt.jpg)


## Features
* Create an account and log in to the game.
* Join or start a new game with other players.
* Play against other players in real-time.
* View the game board and the words played by other players.
* Use the dictionary to find book-related words and phrases.
* Score points based on the length and complexity of the words played.
* Earn bonus points for using certain tiles or for forming certain types of words.


## Usage
To play the Book Scrabble Game, follow these steps:
1. Launch the game and select either Host or Guest mode.
2. If you choose Host mode, you can play with up to 4 players, with at least 1 player being local (the game host). The remaining players can be local or remote players who join the game through an online connection.
3. If you choose Guest mode, you can play against the other players.

## Game instructions

### Definitions:
#### Tile:
* A small board containing a letter (in English) and its value in the game - the amount of points the letter is worth.
* In the following diagram you can see how much each letter is worth in the game:
<img src="https://user-images.githubusercontent.com/118439273/229486188-1f5ab09f-8f78-4e12-b2d1-8aea60616c7c.png" width="360" height="180" />

#### Bag:
* A bag containing 98 tiles 
* Allows you to randomize tiles
* The number of tiles in the bag for each letter at the beginning of the game:
<img src="https://user-images.githubusercontent.com/118439273/229486334-5985074d-ffa1-4366-bc21-8acfd1d4445d.png" width="1080" height="120" />

#### Board:
* 15 x 15 2D board
* The board has some bonus slots:
o The central square (marked with a star) doubles the value of the word written on it
o Squares that double the value of the letter on them (light blue)
o Squares that triple the value of the letter on them (blue)
o Squares that double the value of the entire word (yellow)
o Squares that triple the value of the entire word (red)
* The bonus slots are distributed as in the following diagram:
<img src="https://user-images.githubusercontent.com/118439273/229484247-4854a0a0-7e4f-4f2d-9e87-60fadd52d077.png" width="520" height="520" />



### Rules:
1. Players will draw a letter tile randomly from the bag.
2. The order of players will be determined based on the order of the letters drawn, ranging from the smallest to the largest. If an empty tile is drawn, it will be returned to the bag and another one will be drawn instead.
3. All tiles will be returned to the bag.
4. Each player will randomly draw seven tiles.
5. The first player (who drew the smallest letter in the drawing) must compose a legal word that goes through the central slot (the star) on the board. Only he will receive a double score for it. Then he will draw tiles from the bag to have a full set of seven tiles again.
6. In turn, each player will construct a legal word from the tiles they have. Each word must intersect with an existing word on the board, similar to a crossword puzzle. After forming the word, the player will replenish their hand by drawing seven tiles from the bag. The player's score will accumulate based on all words created on the board following the placement of the tiles:
- Tiles placed on double or triple letter squares will have their value doubled or tripled, respectively.
- The word will receive the sum of its tile value.
- This amount will be multiplied by two or three for each tile that is placed on a double word or triple word square, respectively. For instance, it is possible to multiply by 4 or 9 if the word encompasses two double word or triple word squares.
- The aforementioned calculation is valid for each new word created on the board following the turn.
7. A player who is unable to form a legal word will skip their turn.
8. The game will conclude after N rounds."

### User Story:
- As an end-user, I want to understand the rules of Book Scrabble so that I can play the game effectively and enjoyably.
User Stories for each feature/functionality:
- As a player, I want to randomly draw a tile from the bag to determine my order in the game, so that the game is fair and unpredictable.
- As a player, I want the order of players to be determined by the order of the letters drawn (from smallest to largest), so that the game is fair and unpredictable.
- As a player, I want to return any empty tile drawn back to the bag and draw another one, so that the game remains fair and consistent.
- As a player, I want to randomly draw 7 tiles to start the game, so that I can start forming words on the board.
- As the first player, I want to form a legal word that passes through the central slot (the star) on the board, so that I can score double points for it.
- As a player, I want to complete from the bag after forming a word, so that I always have 7 tiles in my possession.
- As a player, I want to assemble a legal word from the tiles in my possession, resting on one of the tiles on the board, so that I can score points and add new words to the board.
- As a player, I want to add 7 tiles from the bag after forming a word, so that I can continue forming new words on the board.
- As a player, I want my score to be accumulated according to all the words created on the board following the placement of the tiles, so that I can keep track of my score.
- As a player, I want the value of tiles placed on double or triple letter squares to be doubled or tripled respectively, so that I can score more points.
- As a player, I want the value of words to be doubled or tripled for each word multiplication or tripling slot that is one of the tiles superimposed on it, so that I can score more points.
- As a player, I want to be able to multiply my score by 4 or 9 if the word took two double word or triple word slots respectively, so that I can score even more points.
- As a player, I want the above calculation to be true for every new word created on the board following the placement in the queue, so that I can keep track of my score.
- As a player, I want to give up my turn if I cannot form a legal word, so that the game can continue.
- As a player, I want the game to end after N rounds, so that there is a clear ending to the game.
- As a player, I want a legal word to meet all of the following conditions: be written from left to right or from top to bottom (and not in any other way), appear in one of the books chosen for the game, lean on one of the existing tiles on the board, and not produce other illegal words on the board, so that the game remains fair and consistent.


A legal word must meet all of the following conditions:
<<<<<<< HEAD
* Written from left to right or from top to bottom (and not in any other way)
* A word that appears in one of the books chosen for the game
* Leans on one of the existing tiles on the board
* Does not produce other illegal words on the board
=======
* Written from left to right or from top to bottom (and not in any other way).
* A word that appears in one of the books chosen for the game.
* Leans on one of the existing tiles on the board.
* Does not produce other illegal words on the board.
>>>>>>> 9cf6fbe29af424865435f74459a0266a4d49e6c4


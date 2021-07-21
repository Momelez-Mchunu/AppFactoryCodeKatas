## Conway's Game of Life

## Description: 
A command line based Java implementation of Conway's Game of Life

## Table of Contents: 
	1. Installation
	2. Usage
	3. Rules of the Game.

## Installation: 
	1. Download the zip version of the repository.
	2. Alternatively, clone the repository using the following line:gh repo clone Momelez-Mchunu/AppFactoryCodeKatas;
		
## Usage: 
        1. Compile App.java on the cloned repository
    	2. Either run it on your IDE after compilatation
    	3. Or run it on the command line with - java App someInt1 someInt2
    	4. Where someInt1 & someInt2 respectively represent rows and columns of the grid
	 

## Rules of the Game:
    Dead cells are denoted by a dot(.) and living cells by a zero(0)
	For a Living cell (0):
	1. Each cell with one or no neighbour dies.
	2. Each cell with four or more neighbours dies.
	3. Each cell with two or three neighbours survives.

	For an Dead cell (.):
	1. Each cell with three neighbours becomes populated.
	

import java.io.IOException;
import java.util.Scanner;

class Main {
    static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    static Ship checkCarrier1;
    static Ship checkBattleship1;
    static Ship checkSubmarine1;
    static Ship checkCruiser1;
    static Ship checkDestroyer1;

    static Ship checkCarrier2;
    static Ship checkBattleship2;
    static Ship checkSubmarine2;
    static Ship checkCruiser2;
    static Ship checkDestroyer2;

    static Game game1 = new Game();
    static Game game2 = new Game();


    public static void main(String[] args) {

        // check status of ship ALIVE OR DEAD
        boolean flagCarrier1 = false;
        boolean flagBattleship1 = false;
        boolean flagSubmarine1 = false;
        boolean flagCruiser1 = false;
        boolean flagDestroyer1 = false;

        boolean flagCarrier2 = false;
        boolean flagBattleship2 = false;
        boolean flagSubmarine2 = false;
        boolean flagCruiser2 = false;
        boolean flagDestroyer2 = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, place your ships on the game field");

        game1.printField();

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");

        while (true) {
            String[] carrierCoords = scanner.nextLine().toUpperCase().split(" ");
            String carrierStartPoint = carrierCoords[0];
            String carrierEndPoint = carrierCoords[1];
            Ship shipCarrier = new Ship(new Vector(carrierStartPoint), new Vector(carrierEndPoint));
            checkCarrier1 = shipCarrier;
            if (shipCarrier.checkDiagonal(shipCarrier)) continue;
            if (shipCarrier.getLength(shipCarrier) == 5) {
                game1.placeShip(shipCarrier);
                game1.printField();
                break;
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
            }
        }


        System.out.println("Enter the coordinates of the Battleship (4 cells):");

        while (true) {
            String[] battleshipCoords = scanner.nextLine().toUpperCase().split(" ");
            String battleshipStartPoint = battleshipCoords[0];
            String battleshipEndPoint = battleshipCoords[1];
            if (letters[Vector.LetterToInt(battleshipStartPoint.charAt(0))] > letters[Vector.LetterToInt(battleshipEndPoint.charAt(0))]) {
                String tmp = battleshipStartPoint;
                battleshipStartPoint = battleshipStartPoint.replace(battleshipStartPoint.charAt(0), battleshipEndPoint.charAt(0));
                battleshipEndPoint = battleshipEndPoint.replace(battleshipEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipBattleship = new Ship(new Vector(battleshipStartPoint), new Vector(battleshipEndPoint));
            checkBattleship1 = shipBattleship;
            if (shipBattleship.checkDiagonal(shipBattleship)) continue;
            if (shipBattleship.getLength(shipBattleship) == 4 && game1.ableToPlace(shipBattleship)) {
                game1.placeShip(shipBattleship);
                game1.printField();
                break;

            } else if (!game1.ableToPlace(shipBattleship)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
            }
        }
        System.out.println("Enter the coordinates of the Submarine (3 cells):");

        while (true) {
            String[] submarineCoords = scanner.nextLine().toUpperCase().split(" ");
            String submarineStartPoint = submarineCoords[0];
            String submarineEndPoint = submarineCoords[1];
            if (submarineStartPoint.length() == 3) {
                String tmp = submarineEndPoint;
                submarineEndPoint = submarineStartPoint;
                submarineStartPoint = tmp;
            }
            if (letters[Vector.LetterToInt(submarineStartPoint.charAt(0))] > letters[Vector.LetterToInt(submarineEndPoint.charAt(0))]) {
                String tmp = submarineStartPoint;
                submarineStartPoint = submarineStartPoint.replace(submarineStartPoint.charAt(0), submarineEndPoint.charAt(0));
                submarineEndPoint = submarineEndPoint.replace(submarineEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipSubmarine = new Ship(new Vector(submarineStartPoint), new Vector(submarineEndPoint));
            checkSubmarine1 = shipSubmarine;
            if (shipSubmarine.checkDiagonal(shipSubmarine)) continue;
            if (shipSubmarine.getLength(shipSubmarine) == 3 && game1.ableToPlace(shipSubmarine)) {
                game1.placeShip(shipSubmarine);
                game1.printField();
                break;

            } else if (!game1.ableToPlace(shipSubmarine)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
            }
        }

        System.out.println("Enter the coordinates of the Cruiser (3 cells):");

        while (true) {
            String[] cruiserCoords = scanner.nextLine().toUpperCase().split(" ");
            String cruiserStartPoint = cruiserCoords[0];
            String cruiserEndPoint = cruiserCoords[1];
            if (cruiserStartPoint.length() == 3) {
                String tmp = cruiserEndPoint;
                cruiserEndPoint = cruiserStartPoint;
                cruiserStartPoint = tmp;
            }
            if (letters[Vector.LetterToInt(cruiserStartPoint.charAt(0))] > letters[Vector.LetterToInt(cruiserEndPoint.charAt(0))]) {
                String tmp = cruiserStartPoint;
                cruiserStartPoint = cruiserStartPoint.replace(cruiserStartPoint.charAt(0), cruiserEndPoint.charAt(0));
                cruiserEndPoint = cruiserEndPoint.replace(cruiserEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipCruiser = new Ship(new Vector(cruiserStartPoint), new Vector(cruiserEndPoint));
            checkCruiser1 = shipCruiser;
            if (shipCruiser.checkDiagonal(shipCruiser)) continue;
            if (shipCruiser.getLength(shipCruiser) == 3 && game1.ableToPlace(shipCruiser)) {
                game1.placeShip(shipCruiser);
                game1.printField();
                break;
            } else if (!game1.ableToPlace(shipCruiser)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
            }
        }

        System.out.println("Enter the coordinates of the Destroyer (2 cells):");

        while (true) {


            String[] destroyerCoords = scanner.nextLine().toUpperCase().split(" ");
            String destroyerStartPoint = destroyerCoords[0];
            String destroyerEndPoint = destroyerCoords[1];
            if (letters[Vector.LetterToInt(destroyerStartPoint.charAt(0))] > letters[Vector.LetterToInt(destroyerEndPoint.charAt(0))]) {
                String tmp = destroyerStartPoint;
                destroyerStartPoint = destroyerStartPoint.replace(destroyerStartPoint.charAt(0), destroyerEndPoint.charAt(0));
                destroyerEndPoint = destroyerEndPoint.replace(destroyerEndPoint.charAt(0), tmp.charAt(0));
            }

            Ship shipDestroyer = new Destroyer(new Vector(destroyerStartPoint), new Vector(destroyerEndPoint));
            checkDestroyer1 = shipDestroyer;
            if (shipDestroyer.checkDiagonal(shipDestroyer)) continue;
            if (shipDestroyer.getLength(shipDestroyer) == 2 && game1.ableToPlace(shipDestroyer)) {
                game1.placeShip(shipDestroyer);
                game1.printField();
                break;
            } else if (!game1.ableToPlace(shipDestroyer)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");

            }
        }

        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field");

        game2.printField();

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");

        while (true) {
            String[] carrierCoords = scanner.nextLine().toUpperCase().split(" ");
            String carrierStartPoint = carrierCoords[0];
            String carrierEndPoint = carrierCoords[1];
            Ship shipCarrier = new Ship(new Vector(carrierStartPoint), new Vector(carrierEndPoint));
            checkCarrier2 = shipCarrier;
            if (shipCarrier.checkDiagonal(shipCarrier)) continue;
            if (shipCarrier.getLength(shipCarrier) == 5) {
                game2.placeShip(shipCarrier);
                game2.printField();
                break;
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
            }
        }


        System.out.println("Enter the coordinates of the Battleship (4 cells):");

        while (true) {
            String[] battleshipCoords = scanner.nextLine().toUpperCase().split(" ");
            String battleshipStartPoint = battleshipCoords[0];
            String battleshipEndPoint = battleshipCoords[1];
            if (letters[Vector.LetterToInt(battleshipStartPoint.charAt(0))] > letters[Vector.LetterToInt(battleshipEndPoint.charAt(0))]) {
                String tmp = battleshipStartPoint;
                battleshipStartPoint = battleshipStartPoint.replace(battleshipStartPoint.charAt(0), battleshipEndPoint.charAt(0));
                battleshipEndPoint = battleshipEndPoint.replace(battleshipEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipBattleship = new Ship(new Vector(battleshipStartPoint), new Vector(battleshipEndPoint));
            checkBattleship2 = shipBattleship;
            if (shipBattleship.checkDiagonal(shipBattleship)) continue;
            if (shipBattleship.getLength(shipBattleship) == 4 && game2.ableToPlace(shipBattleship)) {
                game2.placeShip(shipBattleship);
                game2.printField();
                break;

            } else if (!game2.ableToPlace(shipBattleship)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
            }
        }
        System.out.println("Enter the coordinates of the Submarine (3 cells):");

        while (true) {
            String[] submarineCoords = scanner.nextLine().toUpperCase().split(" ");
            String submarineStartPoint = submarineCoords[0];
            String submarineEndPoint = submarineCoords[1];
            if (submarineStartPoint.length() == 3) {
                String tmp = submarineEndPoint;
                submarineEndPoint = submarineStartPoint;
                submarineStartPoint = tmp;
            }
            if (letters[Vector.LetterToInt(submarineStartPoint.charAt(0))] > letters[Vector.LetterToInt(submarineEndPoint.charAt(0))]) {
                String tmp = submarineStartPoint;
                submarineStartPoint = submarineStartPoint.replace(submarineStartPoint.charAt(0), submarineEndPoint.charAt(0));
                submarineEndPoint = submarineEndPoint.replace(submarineEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipSubmarine = new Ship(new Vector(submarineStartPoint), new Vector(submarineEndPoint));
            checkSubmarine2 = shipSubmarine;
            if (shipSubmarine.checkDiagonal(shipSubmarine)) continue;
            if (shipSubmarine.getLength(shipSubmarine) == 3 && game2.ableToPlace(shipSubmarine)) {
                game2.placeShip(shipSubmarine);
                game2.printField();
                break;

            } else if (!game2.ableToPlace(shipSubmarine)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
            }
        }

        System.out.println("Enter the coordinates of the Cruiser (3 cells):");

        while (true) {
            String[] cruiserCoords = scanner.nextLine().toUpperCase().split(" ");
            String cruiserStartPoint = cruiserCoords[0];
            String cruiserEndPoint = cruiserCoords[1];
            if (cruiserStartPoint.length() == 3) {
                String tmp = cruiserEndPoint;
                cruiserEndPoint = cruiserStartPoint;
                cruiserStartPoint = tmp;
            }
            if (letters[Vector.LetterToInt(cruiserStartPoint.charAt(0))] > letters[Vector.LetterToInt(cruiserEndPoint.charAt(0))]) {
                String tmp = cruiserStartPoint;
                cruiserStartPoint = cruiserStartPoint.replace(cruiserStartPoint.charAt(0), cruiserEndPoint.charAt(0));
                cruiserEndPoint = cruiserEndPoint.replace(cruiserEndPoint.charAt(0), tmp.charAt(0));
            }
            Ship shipCruiser = new Ship(new Vector(cruiserStartPoint), new Vector(cruiserEndPoint));
            checkCruiser2 = shipCruiser;
            if (shipCruiser.checkDiagonal(shipCruiser)) continue;
            if (shipCruiser.getLength(shipCruiser) == 3 && game2.ableToPlace(shipCruiser)) {
                game2.placeShip(shipCruiser);
                game2.printField();
                break;
            } else if (!game2.ableToPlace(shipCruiser)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
            }
        }

        System.out.println("Enter the coordinates of the Destroyer (2 cells):");

        while (true) {


            String[] destroyerCoords = scanner.nextLine().toUpperCase().split(" ");
            String destroyerStartPoint = destroyerCoords[0];
            String destroyerEndPoint = destroyerCoords[1];
            if (letters[Vector.LetterToInt(destroyerStartPoint.charAt(0))] > letters[Vector.LetterToInt(destroyerEndPoint.charAt(0))]) {
                String tmp = destroyerStartPoint;
                destroyerStartPoint = destroyerStartPoint.replace(destroyerStartPoint.charAt(0), destroyerEndPoint.charAt(0));
                destroyerEndPoint = destroyerEndPoint.replace(destroyerEndPoint.charAt(0), tmp.charAt(0));
            }

            Ship shipDestroyer = new Destroyer(new Vector(destroyerStartPoint), new Vector(destroyerEndPoint));
            checkDestroyer2 = shipDestroyer;
            if (shipDestroyer.checkDiagonal(shipDestroyer)) continue;
            if (shipDestroyer.getLength(shipDestroyer) == 2 && game2.ableToPlace(shipDestroyer)) {
                game2.placeShip(shipDestroyer);
                game2.printField();
                break;
            } else if (!game2.ableToPlace(shipDestroyer)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");

            }
        }


        promptEnterKey();

        mark:
        while (true) {
            while (true) {
                try {
                    game2.printFog();
                    System.out.println("---------------------");
                    game1.printField();
                    System.out.println("Player 1, it's your turn:");
                    String firstVZRIV = scanner.next().toUpperCase();
                    Vector vzriv = new Vector(firstVZRIV);
                    game2.Explosion(vzriv);
                    if (game2.fogOfWar[vzriv.getX()][vzriv.getY()] == '~' || game2.fogOfWar[vzriv.getX()][vzriv.getY()] == 'M') {

                        System.out.println("You missed!");
                        promptEnterKey();
                        break;
                    } else if (!checkCarrier2.checkShipHP(checkCarrier2, game2) && !flagCarrier2) {
                        flagCarrier2 = true;

                        if (flagBattleship2 && flagSubmarine2 && flagCruiser2 && flagDestroyer2) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkBattleship2.checkShipHP(checkBattleship2, game2) && !flagBattleship2) {
                        flagBattleship2 = true;

                        if (flagCarrier2 && flagSubmarine2 && flagCruiser2 && flagDestroyer2) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkSubmarine2.checkShipHP(checkSubmarine2, game2) && !flagSubmarine2) {
                        flagSubmarine2 = true;

                        if (flagCarrier2 && flagBattleship2 && flagCruiser2 && flagDestroyer2) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkCruiser2.checkShipHP(checkCruiser2, game2) && !flagCruiser2) {
                        flagCruiser2 = true;

                        if (flagCarrier2 && flagBattleship2 && flagSubmarine2 && flagDestroyer2) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkDestroyer2.checkShipHP(checkDestroyer2, game2) && !flagDestroyer2) {
                        flagDestroyer2 = true;

                        if (flagCarrier2 && flagBattleship2 && flagSubmarine2 && flagCruiser2) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else {
                        System.out.println("You hit a ship!");
                        promptEnterKey();
                        break;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            }

            while (true) {
                try {
                    game1.printFog();
                    System.out.println("---------------------");
                    game2.printField();
                    System.out.println("Player 2, it's your turn:");
                    String firstVZRIV = scanner.next().toUpperCase();
                    Vector vzriv = new Vector(firstVZRIV);
                    game1.Explosion(vzriv);
                    if (game1.fogOfWar[vzriv.getX()][vzriv.getY()] == '~' || game1.fogOfWar[vzriv.getX()][vzriv.getY()] == 'M') {
                        System.out.println("You missed!");
                        promptEnterKey();
                        break;
                    } else if (!checkCarrier1.checkShipHP(checkCarrier1, game1) && !flagCarrier1) {
                        flagCarrier1 = true;

                        if (flagBattleship1 && flagSubmarine1 && flagCruiser1 && flagDestroyer1) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkBattleship1.checkShipHP(checkBattleship1, game1) && !flagBattleship1) {
                        flagBattleship1 = true;

                        if (flagCarrier1 && flagSubmarine1 && flagCruiser1 && flagDestroyer1) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkSubmarine1.checkShipHP(checkSubmarine1, game1) && !flagSubmarine1) {
                        flagSubmarine1 = true;

                        if (flagCarrier1 && flagBattleship1 && flagCruiser1 && flagDestroyer1) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkCruiser1.checkShipHP(checkCruiser1, game1) && !flagCruiser1) {
                        flagCruiser1 = true;

                        if (flagCarrier1 && flagBattleship1 && flagSubmarine1 && flagDestroyer1) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else if (!checkDestroyer1.checkShipHP(checkDestroyer1, game1) && !flagDestroyer1) {
                        flagDestroyer1 = true;

                        if (flagCarrier1 && flagBattleship1 && flagSubmarine1 && flagCruiser1) {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break mark;
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                            break;
                        }
                    } else {
                        System.out.println("You hit a ship!");
                        promptEnterKey();
                        break;
                    }


                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            }
            if (!game1.checkFieldHP() || !game2.checkFieldHP()) {
                break;
            }
        }
    }
    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





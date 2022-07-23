
public class Game {

    char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    private void CreateField() {
        for (int i = 0; i < fieldOfWar.length; i++) {
            for (int j = 0; j < fieldOfWar.length; j++) {
                fieldOfWar[i][j] = '~';
            }
        }
    }

    private void CreateFog() {
        for (int i = 0; i < fogOfWar.length; i++) {
            for (int j = 0; j < fogOfWar.length; j++) {
                fogOfWar[i][j] = '~';
            }
        }
    }

    final char[][] fieldOfWar = new char[10][10];

    final char[][] fogOfWar = new char[10][10];

    Game() {
        CreateField();
        CreateFog();
    }

    public void printField() {
        System.out.print("  ");
        for (int number = 1; number <= 10; number++) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int i = 0; i < fieldOfWar.length; i++) {
            System.out.print(letters[i] + " ");
            for (int j = 0; j < fieldOfWar.length; j++) {
                System.out.print(fieldOfWar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printFog() {
        System.out.print("  ");
        for (int number = 1; number <= 10; number++) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int i = 0; i < fogOfWar.length; i++) {
            System.out.print(letters[i] + " ");
            for (int j = 0; j < fogOfWar.length; j++) {
                System.out.print(fogOfWar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void placeShip(Ship ship) {
        if (this.ableToPlace(ship)) {
            if (ship.getOrientation().equals("horizontal")) {
                for (int i = Math.min(ship.startPoint.getY(), ship.endPoint.getY()); i <= Math.max(ship.startPoint.getY(), ship.endPoint.getY()); i++) {
                    if (fieldOfWar[ship.startPoint.getX()][i] != '0') fieldOfWar[ship.startPoint.getX()][i] = 'O';
                }
            } else if (ship.getOrientation().equals("vertical")) {
                for (int i = Math.min(ship.startPoint.getX(), ship.endPoint.getX()); i <= Math.max(ship.startPoint.getX(), ship.endPoint.getX()); i++) {
                    if (fieldOfWar[i][ship.startPoint.getY()] != 'O') fieldOfWar[i][ship.startPoint.getY()] = 'O';
                }
            }
        } else System.out.println("Error! Wrong ship location! Try again:");
    }

    public boolean ableToPlace(Ship ship) {
        for (Vector vector : ship.shipCoords()) {
            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                for (int yOffset = -1; yOffset <= 1; yOffset++) {
                    try {
                        if (fieldOfWar[vector.getX() + xOffset][vector.getY() + yOffset] == 'O') {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
        return true;
    }

    protected void Explosion(Vector coords) {
        if (fieldOfWar[coords.getX()][coords.getY()] == 'O') {
            fieldOfWar[coords.getX()][coords.getY()] = 'X';
            fogOfWar[coords.getX()][coords.getY()] = 'X';

        } else if (fieldOfWar[coords.getX()][coords.getY()] == '~') {
            fieldOfWar[coords.getX()][coords.getY()] = 'M';
            fogOfWar[coords.getX()][coords.getY()] = 'M';

        }
    }

    protected boolean checkFieldHP() {
        for (char[] row : fieldOfWar) {
            for (char column : row) {
                if (column == 'O') return true;
            }
        }
        return false;
    }

    /*public boolean ableToPlace(Ship ship) {
        for (Vector vector : ship.shipCoords()) {
            try {
                if (fieldOfWar[vector.getX() + 1][vector.getY()] == 'O') return false;
                else if (fieldOfWar[vector.getX()][vector.getY() + 1] == 'O') return false;
                else if (fieldOfWar[vector.getX()][vector.getY() - 1] == 'O') return false;
                else if (fieldOfWar[vector.getX() - 1][vector.getY()] == 'O') return false;

            } catch (ArrayIndexOutOfBoundsException ignored) {
            }


        }
        return true;
    } */
}
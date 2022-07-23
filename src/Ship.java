
public class Ship {
    Vector startPoint;
    Vector endPoint;

    int length;


    Ship(Vector startPoint, Vector endPoint, int length) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.length = length;
    }

    Ship(Vector startPoint, Vector endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        if (this.getOrientation().equals("horizontal")) {
            this.length = Math.abs(endPoint.getY() - startPoint.getY() + 1);
        } else if (this.getOrientation().equals("vertical")) {
            this.length = Math.abs(endPoint.getX() - startPoint.getX() + 1);
        }
    }

    public String getOrientation() {
        if (startPoint.getX() == endPoint.getX()) {
            return "horizontal";
        } else if (startPoint.getY() == endPoint.getY()) {
            return "vertical";
        }
        return "error";
    }

    public Vector[] shipCoords() {

        Vector[] coords = new Vector[this.length];

        coords[0] = startPoint;
        coords[coords.length - 1] = endPoint;
        if (getOrientation().equals("horizontal")) {
            if (startPoint.getY() < endPoint.getY()) {
                for (int i = 1; i < coords.length - 1; i++) {
                    coords[i] = new Vector(startPoint.getX(), coords[i - 1].getY() + 1);
                }
            } else if (startPoint.getY() > endPoint.getY()) {
                for (int i = 1; i < coords.length - 1; i++) {
                    coords[i] = new Vector(startPoint.getX(), coords[i - 1].getY() - 1);
                }
            }
        } else if (getOrientation().equals("vertical")) {
            if (startPoint.getX() < endPoint.getX()) {
                for (int i = 1; i < coords.length - 1; i++) {
                    coords[i] = new Vector(coords[i - 1].getX() + 1, startPoint.getY());
                }
            } else if (startPoint.getX() > endPoint.getX()) {
                for (int i = 1; i < coords.length - 1; i++) {
                    coords[i] = new Vector(coords[i - 1].getX() - 1, startPoint.getY());
                }
            }
        }
        return coords;
    }

    public int getLength(Ship ship) {
        if (ship.getOrientation().equals("horizontal"))
            return Math.abs(ship.startPoint.getY() - ship.endPoint.getY()) + 1;
        else if (ship.getOrientation().equals("vertical"))
            return Math.abs(ship.startPoint.getX() - ship.endPoint.getX()) + 1;
        return -1;
    }

    protected boolean checkDiagonal(Ship ship) {
        if (ship.getOrientation().equals("error")) {
            System.out.println("Error! Wrong ship location! Try again:");
            return true;
        }
        return false;
    }

    protected boolean checkShipHP(Ship ship, Game game) {
        for (Vector coords : ship.shipCoords()) {
            if (game.fieldOfWar[coords.getX()][coords.getY()] == 'O') return true;
        }
        return false;
    }
}

class Destroyer extends Ship {

    Destroyer(Vector startPoint, Vector endPoint) {
        super(startPoint, endPoint);
        length = 2;
    }
}

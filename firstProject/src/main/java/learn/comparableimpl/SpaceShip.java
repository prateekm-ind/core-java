package learn.comparableimpl;

public class SpaceShip implements Comparable<SpaceShip> {

    private String name;
    private Integer maxSpeed;

    public SpaceShip(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(SpaceShip o) {
        int i = this.name.compareTo(o.name);
        int j = this.maxSpeed.compareTo(o.maxSpeed);

        if (i > 1 && j > 1) {
            return 1;
        } else if (i > 1) {
            if (j == 0) {
                return 1;
            }
            return -1;
        } else if (i == 0 && j > 1) {
            return 1;
        } else if (i == 0) {
            if (j == 0) {
                return 0;
            }
            return -1;
        } else {
            return 0;
        }
    }
}

package mx.edu.greengates.ane.computerscienceiastudymanagement.model;

import java.io.Serializable;

public class Reward implements Serializable {

    private String description;

    public Reward(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "description='" + description + '\'' +
                '}';
    }
}

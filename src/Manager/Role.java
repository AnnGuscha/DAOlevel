package manager;

import java.util.Arrays;

/**
 * Created by Anna on 12/22/2015.
 */
public enum Role {
    ANONYMOUS(0){public String toString(){return "Anonymous";}},
    ADMIN(1){public String toString(){return "Administrator";}},
    PROFESSOR(2){public String toString(){return "Professor";}},
    STUDENT(3){public String toString(){return "Student";}};

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public static Role getRole(int value)
    {
        return Arrays.asList(Role.values()).stream().filter(role-> role.getValue()==value ).findFirst().get();
    }

    public int getValue() {
        return value;
    }

    public abstract String  toString();
}
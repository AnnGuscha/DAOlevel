package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class IdEntity implements java.io.Serializable {

    private int id;

    public IdEntity() {
    }

    public IdEntity(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString()
    {
        return String.valueOf(getId());
    }
}


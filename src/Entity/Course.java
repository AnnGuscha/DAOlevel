package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Course implements java.io.Serializable {
        int id;
        int professorId;
        String description;

        public Course(int id, int professorId, String description)
        {
            this.id=id;
            this.professorId=professorId;
            this.description=description;
        }

        public int getId()
        {
            return id;
        }

        public int getProfessorId()
        {
            return professorId;
        }

        public String getDescription()
        {
            return description;
        }
    }



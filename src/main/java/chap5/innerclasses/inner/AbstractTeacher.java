package chap5.innerclasses.inner;

/**
 * Created by Stas on 31/03/2015.
 */
public abstract class AbstractTeacher {

    private int id;
    public AbstractTeacher(int id) {
        this.id = id;
    }
    /* методы */
    public abstract boolean excludeStudent(String name);
}

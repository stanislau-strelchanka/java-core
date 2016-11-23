package chap5.innerclasses.inner;

import java.util.HashSet;

/**
 * Created by Stas on 31/03/2015.
 */
public class Teacher extends AbstractTeacher{

    public Teacher(int id) {
        super(id);
    }
    /* методы */
    @Override
    public boolean excludeStudent(String name) {
        return false;
    }
}

package chap5.innerclasses.inner;

/**
 * Created by Stas on 31/03/2015.
 */
public class TeacherDemo {

    public static void main(String[] args) {

        TeacherLogic tl = new TeacherLogic();
        tl.excludeProcess(777, "Олейников");
        tl.excludeProcess(6, "Олейников");
    }
}

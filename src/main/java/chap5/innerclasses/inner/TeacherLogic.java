package chap5.innerclasses.inner;

/**
 * Created by Stas on 31/03/2015.
 */
public class TeacherLogic {

    public void excludeProcess(int rectorId, String nameStudent) {
        AbstractTeacher teacher = TeacherCreator.createTeacher(rectorId);
        System.out.println("Студент: " + nameStudent
                + " отчислен:" + teacher.excludeStudent(nameStudent));
    }

}

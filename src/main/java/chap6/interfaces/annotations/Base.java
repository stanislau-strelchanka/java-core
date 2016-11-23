package chap6.interfaces.annotations;

/**
 * Created by Stas on 01/04/2015.
 */
@BaseAction (
        level = 2,
        sqlRequest = "SELECT * FROM phonebook"
)
public class Base {
    public void doAction() {
        Class<Base> f = Base.class;
        BaseAction a = (BaseAction)f.getAnnotation(BaseAction.class);
        System.out.println(a.level());
        System.out.println(a.sqlRequest());
    }
}


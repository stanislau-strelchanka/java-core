package chap6.interfaces.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Stas on 01/04/2015.
 */

@Target(ElementType.TYPE)
public @interface BaseAction {

    //can be basetypes, enum, class, array of this
    int level();
    String sqlRequest();
}

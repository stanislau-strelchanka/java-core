package chap14.xml.sax;

/**
 * Created by Stas on 20/02/2015.
 */
public enum StudentEnum {

    STUDENTS("students"),
    LOGIN("login"),
    FACULTY("faculty"),
    STUDENT("student"),
    NAME("name"),
    TELEPHONE("telephone"),
    COUNTRY("country"),
    CITY("city"),
    STREET("street"),
    ADDRESS("address");

    private String value;
    private StudentEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

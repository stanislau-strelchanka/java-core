package chap3.classesobjects.classloader.dbloader;

/**
 * Created by kevinj.
 */
public class Quote implements IQuote  {
    @Override
    public String getQuote() {
        return "A rolling stone gathers no moss";
    }
}

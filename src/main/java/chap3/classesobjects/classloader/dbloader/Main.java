package chap3.classesobjects.classloader.dbloader;

//need to put binaries in db first
public class Main {
    public static void main(String[] args) throws Exception {
        SqlServerClassLoader cl = new SqlServerClassLoader("jdbc:sqlserver://localhost\\SQLExpress;databaseName=classloading;integratedSecurity=true");
        Class clazz = cl.findClass("hap3.classesobjects.classloader.dbloader.Quote");
        IQuote quote = (IQuote) clazz.newInstance();
        System.out.println(quote.getQuote());
    }
}

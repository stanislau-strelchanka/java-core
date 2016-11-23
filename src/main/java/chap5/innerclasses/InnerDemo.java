package chap5.innerclasses;

/**
 * Created by Stas on 13/01/2015.
 */
public class InnerDemo {

    public interface IShip {

        public interface IEngine{

        }

        public void mehtod();
    }

    public class Ship {

        public class Engine{

        }
    }


    public static void main(String[] args, Ship obj) {

        //Ship.Engine engine = new Ship().new Engine(); object refference needed
        Ship.Engine engine = obj.new Engine();
        IShip.IEngine iEngine = new IShip.IEngine(){   //in interface becomes static by default
        };
    }
}

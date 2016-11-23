package chap3.classesobjects.override;

import org.omg.CORBA.portable.ApplicationException;

public class Exceptions {


    public class A {

        public void methodA() throws Exception {

        }

        public void methodB() {

        }
    }

    public class B extends A {

        public void methodA()
                throws ApplicationException // can be any exception or no exception at all
        {

        }

        public void methodB()
        // throws Exception
        {

        }
    }
}


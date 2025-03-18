import java.sql.Connection;

//Eager Intialization
//static value is preloaded into memory
public class SingletonDesignpattern {
    
    private static SingletonDesignpattern instance = new SingletonDesignpattern();
    
    private SingletonDesignpattern(){
      
    }
    
    public static SingletonDesignpattern getInstance(){    
        return instance;
    }
}

//Lazy intialization
//check if this null; then create a object
//if two thread comes in parllel & get null by two thread & created two different Object.

public class SingletonDesignpattern{

    private static SingletonDesignpattern instance;

    private SingletonDesignpattern(){
        
    }

    public static SingletonDesignpattern getConnection(){
        if (instance == null){
            instance = new SingletonDesignpattern();
         }
        return instance;
    }

}

//Synchronaization 
//it use by one thread,then another thread isaccesed ,it was good
//But it performence is low .because synchronized internally locking mechanism work
public class SingletonDesignpattern{

    private static SingletonDesignpattern instance;

    private SingletonDesignpattern(){

    }
    synchronized public static SingletonDesignpattern getInstance(){
        if (instance == null){
            instance = new SingletonDesignpattern();
         }
        return instance;
    }
}

//DoubleCheck Locking 
//it aslo using locking so performence is down
//volatile use dirctely use in main memory 

//memory > cache -> Core 
public class SingletonDesignpattern{
    private static volatile SingletonDesignpattern instance;


    private SingletonDesignpattern{}{

    }

    public static SingletonDesignpattern getInstance(){
        if (instance == null){
            synchronized(SingletonDesignpattern.class){
                if(instance == null){
                    instance = new SingletonDesignpattern();
                }   
            }
            return instance;
        }
    }
}

//Billpug Solutiona
//nested class not loaded in memory 
public class Designpattern{

    private Designpattern(){

    }
    private static class SingletonDesignpattern {
        private static final SingletonDesignpattern INSTANCE_OBJECT = new SingletonDesignpattern();
    }

    public static SingletonDesignpattern getInstace(){
        return SingletonDesignpattern.INSTANCE_OBJECT;
    }
}


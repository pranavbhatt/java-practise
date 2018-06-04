package com.pranav.javagrok.desigpatterns;

//Eager Initialized
public class Singleton {
	 
    // Private static instance is created at the time of class loading
    private static Singleton instance = new Singleton();
 
    // Constructor made private so that no new instance can be created
    private Singleton() {
 
    }
 
    // Static method to return the instance to the client
    public static Singleton getInstance() {
        return instance;
    }
}

class StaticBlockSingleton {
	 
    private static StaticBlockSingleton instance;
 
    private StaticBlockSingleton() {
 
    }
 
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating instance");
        }
    }
 
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

/**
 * Note: Not thread safe
 * @author pbhatt
 *
 */
class LazzyInitializedSingleton {
	 
    private static LazzyInitializedSingleton instance;
 
    private LazzyInitializedSingleton() {
 
    }
 
    // Lazy initialization is done the first time client requests the instance
    public static LazzyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazzyInitializedSingleton();
        }
        return instance;
    }
}

class DoubleCheckedLockingSingleton {
	 
    /**
     * this field should be volatile to avoid half baked object creation
     * Allocating a memory to the object
     * execute the code inside constructor 
     * Assigning memory reference to the field
     * 
     * Some of the JIT compilers which reorders step 2 and step 3 result in Half baked objects 
     * 
     * volatile gurantees happen before relationship, prevents memory writes from being re-ordered
     */
    private static volatile DoubleCheckedLockingSingleton instance;   
 
    private DoubleCheckedLockingSingleton() 
    {
       // 10000 lines of initialization code
    }
 
    public static DoubleCheckedLockingSingleton getInstance() 
    {
        if (instance == null) 
        {
            synchronized (DoubleCheckedLockingSingleton.class) 
            {
                if (instance == null) 
                {
                    instance = new DoubleCheckedLockingSingleton();
                    System.out.println("Instance Created");
                }
            }
 
        }
        return instance;
    }
 
}

class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
 
    private ThreadSafeSingleton() {
    }
 
    // Thread T2, T3, T4 are waiting for T1 to release the lock
    public static synchronized ThreadSafeSingleton getInstance() {
        // Thread T1 has taken the lock
        if (instance == null) {
            instance = new ThreadSafeSingleton();  // Critical section
        }
        return instance;
    }
}

class BillPughSingleton {
	 
    private BillPughSingleton(){}
     
    //static inner class - inner classes are not loaded until they are referenced.
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    //global access point
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

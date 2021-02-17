package com.wzx.sword;

/**
 * @author wzx
 */
public class No1Singleton {

  /**
   * 锁保证线程安全的懒汉式
   */
  public static class Singleton1{
    volatile private static Singleton1 instance = null;

    private Singleton1(){}

    public static Singleton1 getInstance(){
      if (null == instance) {
        synchronized (Singleton1.class) {
          if (null == instance) {
            instance = new Singleton1();
            return instance;
          }
        }
      }
      return instance;
    }
  }

  /**
   * 饿汉式
   */
  public static class Singleton2{
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
      return INSTANCE;
    }
  }

  /**
   * 内部类保证线程安全的懒汉式
   */
  public static class Singleton3{

    private Singleton3(){}

    public static Singleton3 getInstance(){
      return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
      public static final Singleton3 INSTANCE = new Singleton3();
    }
  }

}

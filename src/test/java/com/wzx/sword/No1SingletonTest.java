package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No1SingletonTest {

  @Test
  public void Singleton1Test() {
    No1Singleton.Singleton1 instance1 = No1Singleton.Singleton1.getInstance();
    No1Singleton.Singleton1 instance2 = No1Singleton.Singleton1.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  public void Singleton2Test() {
    No1Singleton.Singleton2 instance1 = No1Singleton.Singleton2.getInstance();
    No1Singleton.Singleton2 instance2 = No1Singleton.Singleton2.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  public void Singleton3Test() {
    No1Singleton.Singleton3 instance1 = No1Singleton.Singleton3.getInstance();
    No1Singleton.Singleton3 instance2 = No1Singleton.Singleton3.getInstance();
    assertSame(instance1, instance2);
  }
}
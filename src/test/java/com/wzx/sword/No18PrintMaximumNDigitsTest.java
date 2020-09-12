package com.wzx.sword;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class No18PrintMaximumNDigitsTest {

  private static ByteArrayOutputStream stream = null;

  @BeforeClass
  public static void setUp() {
    stream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stream));
  }

  @AfterClass
  public static void afterClass() throws IOException {
    stream.close();
  }

  @Test
  public void print1ToMaxOfNDigits1() {
    No18PrintMaximumNDigits.print1ToMaxOfNDigits1(2);
    String[] strings2 = stream.toString().split("\n");
    for (int i = 0; i < 99; i++) {
      assertEquals((i + 1) + "", strings2[i]);
    }
  }

  @Test
  public void print1ToMaxOfNDigits2() {
    No18PrintMaximumNDigits.print1ToMaxOfNDigits2(2);
    String[] strings2 = stream.toString().split("\n");
    for (int i = 0; i < 99; i++) {
      assertEquals((i + 1) + "", strings2[i]);
    }
  }
}
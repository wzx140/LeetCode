package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No855ExamRoomTest {

  @Test
  public void examRoom() {
    No855ExamRoom.ExamRoom examRoom = new No855ExamRoom.ExamRoom(10);
    assertEquals(0, examRoom.seat());
    assertEquals(9, examRoom.seat());
    assertEquals(4, examRoom.seat());
    assertEquals(2, examRoom.seat());
    examRoom.leave(4);
    assertEquals(5, examRoom.seat());
  }
}
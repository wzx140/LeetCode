package com.wzx.leetcode;

import com.wzx.leetcode.No341FlattenNestedListIterator.NestedInteger;
import com.wzx.leetcode.No341FlattenNestedListIterator.NestedIntegerImpl;
import com.wzx.leetcode.No341FlattenNestedListIterator.NestedIterator;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

public class No341FlattenNestedListIteratorTest {

  private final List<NestedInteger> nestedIntegers1 = Arrays.asList(
          new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1))),
          new NestedIntegerImpl(2),
          new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1)))
  );

  private final List<Integer> res1 = Arrays.asList(1, 1, 2, 1, 1);

  private final List<NestedInteger> nestedIntegers2 = Arrays.asList(
          new NestedIntegerImpl(1),
          new NestedIntegerImpl(Arrays.asList(
                  new NestedIntegerImpl(4),
                  new NestedIntegerImpl(Collections.singletonList(new NestedIntegerImpl(6)))
          ))
  );

  private final List<Integer> res2 = Arrays.asList(1, 4, 6);

  @Test
  public void nestedIterator() {
    int characteristics = Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;

    NestedIterator iterator1 = new NestedIterator(nestedIntegers1);
    List<Integer> ret1 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator1, characteristics), false)
            .collect(Collectors.toList());
    assertEquals(res1, ret1);
    NestedIterator iterator2 = new NestedIterator(nestedIntegers2);
    List<Integer> ret2 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator2, characteristics), false)
            .collect(Collectors.toList());
    assertEquals(res2, ret2);
  }
}
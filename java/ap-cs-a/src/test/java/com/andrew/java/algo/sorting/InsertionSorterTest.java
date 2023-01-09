package com.andrew.java.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.andrew.java.algo.array.DebugDuck;

class InsertionSorterTest {

    List<DebugDuck> ducks = new ArrayList<>(
            Arrays.asList(new DebugDuck("d3", 3), new DebugDuck("d2", 2), new DebugDuck("d1", 1),
                    new DebugDuck("d4", 4)));
    List<DebugDuck> sortedDucks = new ArrayList<>(
            Arrays.asList(new DebugDuck("d1", 1), new DebugDuck("d2", 2), new DebugDuck("d3", 3),
                    new DebugDuck("d4", 4)));

    List<Student> students = new ArrayList<>(Arrays.asList(new Student(123, "joe"), new Student(400, "john"),
            new Student(-600, "bob"), new Student(0, "steve"), new Student(0, "no")));

    List<KindergartenStudent> kinderStudents = new ArrayList<>(
            Arrays.asList(new KindergartenStudent(123, "joe", 5), new KindergartenStudent(400, "john", 3),
                    new KindergartenStudent(-600, "bob", 1), new KindergartenStudent(0, "steve", 2),
                    new KindergartenStudent(0, "no", -1)));

    @Test
    void testSort() {
        List<DebugDuck> newSortedDucks = InsertionSorter.sort(ducks);
        newSortedDucks.stream().forEach(System.out::print);

        Assertions.assertEquals(sortedDucks, newSortedDucks);
    }

    @Test
    void testInsertionSortV1() {
        List<Student> sortResult = InsertionSorterV1.insertionSort(students);

        Assertions.assertEquals(Arrays.asList(new Student(-600, "bob"), new Student(0, "steve"),
                new Student(0, "no"),
                new Student(123, "joe"), new Student(400, "john")),
                sortResult);

        sortResult.stream().forEach(System.out::println);
    }

    @Test
    void testInsertionSortV2() {
        List<KindergartenStudent> sortedKinder = InsertionSorterV2.insertionSort(kinderStudents);
        Assertions.assertEquals(
                Arrays.asList(new KindergartenStudent(0, "no", -1), new KindergartenStudent(-600, "bob", 1),
                        new KindergartenStudent(0, "steve", 2), new KindergartenStudent(400, "john", 3),
                        new KindergartenStudent(123, "joe", 5)),
                sortedKinder);
        System.out.println();
        sortedKinder.stream().forEach(System.out::println);
    }

}

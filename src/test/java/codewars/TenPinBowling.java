package codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TenPinBowling {

    @Test
    public void BasicTests() {
        // assertEquals("expected", "actual");
        System.out.println("Maybe this bowler should put bumpers on...\n ");
        assertEquals(0, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 00 00"));
        assertEquals(10, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ 00"));
        assertEquals(16, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ 30"));
        assertEquals(30, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ X0"));
        assertEquals(40, TenPinBowling.bowling_score("00 00 00 00 00 00 00 0/ 0/ X0"));
        assertEquals(43, TenPinBowling.bowling_score("00 00 00 00 00 00 00 0/ 3/ X0"));
        assertEquals(44, TenPinBowling.bowling_score("00 00 00 00 00 00 00 0/ 3/ X1"));
        assertEquals(54, TenPinBowling.bowling_score("00 00 00 00 00 00 00 0/ 3/ XX1"));
        assertEquals(74, TenPinBowling.bowling_score("00 00 00 00 00 00 X 0/ 3/ XX1"));
        assertEquals(94, TenPinBowling.bowling_score("00 00 00 00 00 X X 0/ 3/ XX1"));
        assertEquals(104, TenPinBowling.bowling_score("0/ 00 00 00 00 X X 0/ 3/ XX1"));
        assertEquals(124, TenPinBowling.bowling_score("0/ X 00 00 00 X X 0/ 3/ XX1"));
        assertEquals(144, TenPinBowling.bowling_score("0/ X 0/ 00 00 X X 0/ 3/ XX1"));

        assertEquals(30, TenPinBowling.bowling_score("0/ 0/ 0/ 00 00 00 00 00 00 00"));
        assertEquals(50, TenPinBowling.bowling_score("0/ X X 00 00 00 00 00 00 00"));
        assertEquals(43, TenPinBowling.bowling_score("1/ 2/ 3/ 40 00 00 00 00 00 00"));
        assertEquals(57, TenPinBowling.bowling_score("1/ 2/ 3/ 40 00 00 00 00 0/ 20"));
        assertEquals(31, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ X1"));
        assertEquals(10, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ 00"));
        assertEquals(32, TenPinBowling.bowling_score("00 00 00 00 00 00 00 X 0/ 10"));

        assertEquals(104, TenPinBowling.bowling_score("X X X 8/ 80 00 00 00 00 00"));
        assertEquals(145, TenPinBowling.bowling_score("X X X X X 72 00 00 00 00"));
        assertEquals(20, TenPinBowling.bowling_score("7/ 42 00 00 00 00 00 00 00 00"));

        assertEquals(10, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 0/ 00"));
        assertEquals(12, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 X 01"));
        assertEquals(30, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 X 0/"));

        assertEquals(101, TenPinBowling.bowling_score("90 3/ 80 90 3/ 80 10 3/ 60 80"));


        assertEquals(100, TenPinBowling.bowling_score("0/ 0/ 0/ 0/ 0/ 0/ 0/ 0/ 0/ 0/"));
        assertEquals(14, TenPinBowling.bowling_score("00 00 00 00 00 00 00 00 1/ 20"));
        assertEquals(83, TenPinBowling.bowling_score("00 00 X 1/ 1/ X 0/ 10 00 00"));
        assertEquals(40, TenPinBowling.bowling_score("12 34 5/ X 00 00 00 00 00 00"));

        assertEquals(133, TenPinBowling.bowling_score("63 52 8/ 06 X X 3/ 7/ 8/ 53"));
        assertEquals(171, TenPinBowling.bowling_score("X X 9/ 80 X X 90 8/ 7/ 44"));
        assertEquals(40, TenPinBowling.bowling_score("0 0 0 0 0 0 0 0 X 0/X"));
        assertEquals(11, TenPinBowling.bowling_score("2/ 01 0 0 0 0 0 0 0 00"));
        assertEquals(37, TenPinBowling.bowling_score("0 01 0 0 0 0 0 0 0/ 8/8"));


//        System.out.println("Woah! Perfect game!");
        assertEquals(300, TenPinBowling.bowling_score("X X X X X X X X X XXX"));
    }

    public static int bowling_score(String frames) {
        String end = frames.substring(frames.lastIndexOf(" ")).replace("X", "Y");
        if ('/' == end.charAt(2)) {
            int firstShot = Character.getNumericValue(end.charAt(1));
            end = end.replace("/", firstShot == 0 ? "Y" : String.valueOf(10 - firstShot));
        }
        String newFrames = frames.substring(0, frames.lastIndexOf(" ")) + end;

        List < Integer > values = Stream.of(newFrames.replace(" ", "").split("")).mapToInt(w -> {
            if ("X".equals(w)) return new Integer(-2);
            else if ("Y".equals(w)) return new Integer(10);
            else if ("/".equals(w)) return new Integer(-1);
            else return new Integer(w);
        }).boxed().collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i<values.size() - 2; i++){
            int next1 = values.get(i+1) == -2 ? 10 : values.get(i+1);
            int next2 = values.get(i+2) == -2 ? 10 : values.get(i+2) == -1 ? 10 - values.get(i+1) : values.get(i+2);
            if (values.get(i) == -2) values.set(i, 10 + next1 + next2);
            else if (values.get(i) == -1) values.set(i, 10 - values.get(i-1) + next1);
        }
        return values.stream().mapToInt(Integer::intValue).sum();
    }
}

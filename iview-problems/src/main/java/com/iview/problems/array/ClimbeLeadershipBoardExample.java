package com.iview.problems.array;


import java.util.Arrays;
import java.util.Collections;

public class ClimbeLeadershipBoardExample {

    public static void main(String[] args) {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] aliceGameScores = {5, 25, 50, 120};

//        String inputString = "295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4";
//        int[] scores = getIntArray(inputString);
//        String playerScoreString = "5 5 6 14 19 20 23 25 29 29 30 30 32 37 38 38 38 41 41 44 45 45 47 59 59 62 63 65 67 69 70 72 72 76 79 82 83 90 91 92 93 98 98 100 100 102 103 105 106 107 109 112 115 118 118 121 122 122 123 125 125 125 127 128 131 131 133 134 139 140 141 143 144 144 144 144 147 150 152 155 156 160 164 164 165 165 166 168 169 170 171 172 173 174 174 180 184 187 187 188 194 197 197 197 198 201 202 202 207 208 211 212 212 214 217 219 219 220 220 223 225 227 228 229 229 233 235 235 236 242 242 245 246 252 253 253 257 257 260 261 266 266 268 269 271 271 275 276 281 282 283 284 285 287 289 289 295 296 298 300 300 301 304 306 308 309 310 316 318 318 324 326 329 329 329 330 330 332 337 337 341 341 349 351 351 354 356 357 366 369 377 379 380 382 391 391 394 396 396 400";
//        int[] aliceGameScores = getIntArray(playerScoreString);
        printArray(climbingLeaderboard(scores, aliceGameScores));

    }

    public static void printArray(int[] array) {
        System.out.print("{ ");
        int count = 0;
        for(int i: array) {
            System.out.print(i);
            if(count != array.length - 1) {
                System.out.print(", ");
                count++;
            }
        }
        System.out.println(" }");
    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] aliceGameScores) {
        int[] alicePositions = new int[aliceGameScores.length];
        Node head = buildScoreBoard(scores);
        head = appendPlayerScore(head, aliceGameScores, alicePositions, "Alice");

        //aliceScores = getPlayerScores(head, aliceScores, "Alice");
//        Integer[] bigArray = toObject(alicePositions);
//        Arrays.sort(bigArray, Collections.reverseOrder());
//        return toPrimitive(bigArray);
        return alicePositions;

    }

    public static Integer[] toObject(int[] intArray) {

        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = Integer.valueOf(intArray[i]);
        }
        return result;
    }

    public static int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }

    static int[] getPlayerScores(Node head, int[] aliceScores, String playerName) {

        Node tempNode = head;

        int index = 0;
        while (tempNode != null) {
            if (tempNode.name.equals(playerName)) {
                aliceScores[index] = tempNode.rank;
                index = index + 1;
            }
            tempNode = tempNode.next;
        }


        return aliceScores;
    }


    static Node updateRankOfAllNodes(Node currentNode) {

        Node tempNode = currentNode;
        while (tempNode != null) {
            tempNode.rank = tempNode.rank + 1;
            tempNode = tempNode.next;
        }
        return currentNode;
    }

    static Node appendPlayerScore(Node head, int[] scores, int[] playerPosition, String name) {
        Node tempNode = head;
        int count = 0;
        for (int i : scores) {
            tempNode = head;

            Node node = new Node();
            node.score = i;
            node.name = name;

            Node prevNode = tempNode;

            while (tempNode != null) {

                if (i < tempNode.score) {
                    if(tempNode.next == null) {
                        node.rank = tempNode.rank + 1;
                        //Insert node after tempNode;
                        node.next = tempNode.next;
                        tempNode.next = node;
                        playerPosition[count] = node.rank;
                        count++;
                        break;
                    }

                    prevNode = tempNode;
                    tempNode = tempNode.next;

                } else if (i == tempNode.score) {
                    node.rank = tempNode.rank;
                    //Insert node after tempNode;
                    node.next = tempNode.next;
                    tempNode.next = node;
                    playerPosition[count] = node.rank;
                    count++;
                    break;

                } else {

                    node.rank = tempNode.rank;
                    tempNode = updateRankOfAllNodes(tempNode);

                    if(prevNode == tempNode) {
                        //Insert node before tempNode;
                        prevNode = node;
                        node.next = tempNode;
                        head = prevNode;
                    } else {
                        //Insert node after tempNode;
                        prevNode.next = node;
                        node.next = tempNode;
                    }
                    playerPosition[count] = node.rank;
                    count++;
                    break;
                }
            }
        }

        return head;
    }

    static Node buildScoreBoard(int[] scores) {
        Node head = null;
        Node prevNode = null;
        int currentRank = 1;

        for (int i : scores) {
            if (head == null) {
                head = new Node();
                head.score = i;
                head.rank = currentRank;
                prevNode = head;
            } else {

                Node node = new Node();
                node.score = i;
                if (node.score != prevNode.score) {
                    currentRank = currentRank + 1;
                }
                node.rank = currentRank;
                prevNode.next = node;
                prevNode = node;
            }
        }

        return head;
    }

    static int[] getIntArray(String str) {
        String[] strArray = str.split(" ");

        //Arrays.stream(strArray).mapToInt(num -> Integer.parseInt(num));
        int[] arr = new int[strArray.length];

        for(int i = 0; i< strArray.length; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        return arr;
    }


}

class Node {
    public String name = "test";
    public int score = 0;
    public int rank = 0;
    public Node next = null;
}

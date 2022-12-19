package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.*;

public class MySolution {

    public static Direction solve(Board board) {
        Direction direction = bfs(board.getApples().get(0), board);
        if (direction == Direction.STOP) {
            List<Point> list = board.getSnake();
            direction = bfs(list.get(list.size() - 1), board);
        }
        return direction;
    }

    public static Direction bfs(Point dest, Board board) {
        Map<Point, Point> map = new HashMap<>();
        Queue<Point> q = new LinkedList<Point>();
        Set<Point> visited = new HashSet<>();
        visited.addAll(board.getBarriers());
        q.add(board.getHead());
        visited.remove(dest);
        while (!q.isEmpty()) {
            Point c = q.remove();
            if (c.equals(dest)) {
                while (!map.get(c).equals(board.getHead())) {
                    c = map.get(c);
                }
                return Utils.getDirection(c, board.getHead());
            }
            for (Point p : Utils.getNeighbours(c)) {
                if (!visited.contains(p)) {
                    visited.add(p);
                    map.put(p, c);
                    q.add(p);
                }
            }
        }
        return Direction.STOP;
    }
}

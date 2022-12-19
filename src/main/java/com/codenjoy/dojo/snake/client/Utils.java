package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Point> getNeighbours(Point p) {
        List<Point> points = new ArrayList<Point>() {{
            add(new PointImpl(p.getX(), p.getY() + 1));
            add(new PointImpl(p.getX(), p.getY() - 1));
            add(new PointImpl(p.getX() + 1, p.getY()));
            add(new PointImpl(p.getX() - 1, p.getY()));
        }};
        return points;
    }

    public static Direction getDirection(Point a, Point b) {
        if (b.getX() > a.getX()) return Direction.LEFT;
        if (b.getX() < a.getX()) return Direction.RIGHT;
        if (b.getY() > a.getY()) return Direction.DOWN;
        if (b.getY() < a.getY()) return Direction.UP;
        return Direction.STOP;
    }
}

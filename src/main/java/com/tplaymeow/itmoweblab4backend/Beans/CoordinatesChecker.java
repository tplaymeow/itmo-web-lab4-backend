package com.tplaymeow.itmoweblab4backend.Beans;

import com.tplaymeow.itmoweblab4backend.Models.Coordinates;

import javax.ejb.Stateless;

@Stateless
public class CoordinatesChecker {
    public Boolean check(Coordinates coordinates) {
        double normalizedX = Math.abs(coordinates.getX());
        double normalizedY = Math.abs(coordinates.getY());
        double r = coordinates.getR();

        if (coordinates.getX() >= 0 && coordinates.getY() >= 0) {
            if (normalizedX <= r && normalizedY <= r) {
                return true;
            }
        }

        if (coordinates.getX() >= 0 && coordinates.getY() <= 0) {
            if (normalizedX + normalizedY <= r / 2) {
                return true;
            }
        }

        if (coordinates.getX() <= 0 && coordinates.getY() >= 0) {
            if (Math.pow(normalizedX, 2) + Math.pow(normalizedY, 2) <= Math.pow(r / 2, 2)) {
                return true;
            }
        }

        return false;
    }
}

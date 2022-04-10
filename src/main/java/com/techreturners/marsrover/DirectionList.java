package com.techreturners.marsrover;

public enum DirectionList {
        NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

        private final String value;

        DirectionList(String value) {
                this.value = value;
        }

        public String getValue() {
                return value;
        }
}

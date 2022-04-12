package com.techreturners.marsrover;

public enum DirectionList {
        NORTH("N"),
        EAST("E"),
        SOUTH("S"),
        WEST("W");

        private String value;

        DirectionList(String value) {
                this.value = value;
        }

        public String getValue() {
                return value;
        }

        public static String getNameByCode(String value){

                for(DirectionList e : DirectionList.values()){
                        if(e.value.equals(value)){
                                return e.name();
                        }
                }
                return null;
        }
}

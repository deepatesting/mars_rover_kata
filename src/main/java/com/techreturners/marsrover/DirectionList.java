package com.techreturners.marsrover;

public enum DirectionList {
        NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

        private String value;

        DirectionList(String value) {
                this.value = value;
        }

        public String getValue() {
                return value;
        }

        public static String getNameByCode(String value){
                System.out.println(value);
                for(DirectionList e : DirectionList.values()){
                        if(e.value.equals(value)){
                                System.out.println(e.name());
                                return e.name();
                        }

                }
                return null;
        }
}

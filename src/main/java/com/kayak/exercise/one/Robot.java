package com.kayak.exercise.one;

public class Robot {

    private Position position;
    private String command;
    private GridDirection gridDirection;

    public Robot(){
        this.position = new Position();
        this.gridDirection = GridDirection.UP;
    }

    public Position getPosition() {
        return position;
    }

    public GridDirection getGridDirection() {
        return gridDirection;
    }

    public void setCommand(String command) {
        if(!this.isCommandValid(command)) throw new IllegalArgumentException();
        this.command = command;
    }

    public void move(){
        for(int i=0;i<command.length();i++){
            char direction = command.charAt(i);
            switch (direction){
                case 'L': this.turnLeft();
                    break;
                case 'R': this.turnRight();
                    break;
                case 'F': this.goForward();
                    break;
                default: break;
            }
        }
    }

    public String getFinalPosition(){
        return this.position.toString();
    }

    private void turnLeft(){
        switch (this.gridDirection){
            case UP: this.gridDirection = GridDirection.LEFT;
                break;
            case DOWN: this.gridDirection = GridDirection.RIGHT;
                break;
            case LEFT: this.gridDirection = GridDirection.DOWN;
                break;
            case RIGHT: this.gridDirection = GridDirection.UP;
                break;
            default: break;
        }
    }

    private void turnRight(){
        switch (this.gridDirection){
            case UP: this.gridDirection = GridDirection.RIGHT;
                break;
            case DOWN:  this.gridDirection = GridDirection.LEFT;
                break;
            case LEFT: this.gridDirection = GridDirection.UP;
                break;
            case RIGHT: this.gridDirection = GridDirection.DOWN;
                break;
            default: break;
        }
    }

    private void goForward(){
        switch (this.gridDirection){
            case UP: this.position.setY(this.position.getY() + 1);
                break;
            case DOWN: this.position.setY(this.position.getY() - 1);
                break;
            case LEFT: this.position.setX(this.position.getX() - 1);
                break;
            case RIGHT: this.position.setX(this.position.getX() + 1);
                break;
            default: break;
        }
    }

    public boolean isCommandValid(String command){
        boolean valid = true;
        if(null == command || command.trim().length() <= 0)  valid = false;
        for(int i=0;i<command.length();i++){
            char direction = command.charAt(i);
            if(direction != 'L' && direction != 'R' && direction != 'F') valid = false;
        }
        return valid;
    }

}

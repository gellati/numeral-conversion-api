package org.conversionapplication.model;

import java.io.Serializable;

/**
 * POJO class to contain the post request information
 */

public class PostDto implements Serializable{
    private String source;
    private String target;
    private String number;

    public PostDto(){}

    public PostDto(String source, String target, String number){
        this.source = source;
        this.target = target;
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}

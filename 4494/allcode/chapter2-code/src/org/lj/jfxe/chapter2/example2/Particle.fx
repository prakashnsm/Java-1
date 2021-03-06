/*
 * Particle.fx
 *
 * Created on Jul 3, 2009, 2:16:28 PM
 */

package org.lj.jfxe.chapter2.example2;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.util.Math;

/**
 * @author lucasjordan
 */

//provices random numbers for direction of particle
var random = new java.util.Random();
public class Particle extends Circle{
    public-init var initialSteps:Integer;//number of steps until removed
    public-init var speed:Number;//pixels per step

    var deltaX;//change in x location per step
    var deltaY;//change in y location per step

    init{
        //radius = 5;
        fill = Color.RED;


        //radom direction in radians
        var theta = random.nextFloat()*2.0*Math.PI;


        deltaX = Math.cos(theta)*speed;
        deltaY = Math.sin(theta)*speed;
    }

    package function doStep(){

        //remove particle if particle has expired
        if (--initialSteps == 0){
            delete this from (parent as Group).content;
        }

        //advance particle's location
        translateX += deltaX;
        translateY += deltaY;
    }
}

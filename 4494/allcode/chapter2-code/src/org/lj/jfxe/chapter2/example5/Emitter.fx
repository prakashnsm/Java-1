/*
 * Emitter.fx
 *
 * Created on Jul 3, 2009, 2:14:24 PM
 */

package org.lj.jfxe.chapter2.example5;

import javafx.scene.Group;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.effect.ColorAdjust;

/**
 * @author lucasjordan
 */
 var random = new java.util.Random();

public class Emitter extends Group{

    public var particleScale = 1.0;
    public var particleSpeed = 1.0;
    public var particleDuration = 100;
    public var particleOpacity = 0.5;
    public var particleFadeout = true;
    public var particleHue = 0.0;
    public var particleHueVariation = 0.0;

    public var frequency  = .05s on replace {
        emitTimeline.playFromStart();
    }

    //specifies when a new particle should be added to the scene
    var emitTimeline = Timeline{
        repeatCount: Timeline.INDEFINITE;
        keyFrames: KeyFrame{
                    time: bind frequency ;
                    action: emit
                   }
    }
    //animates the particles.
    var animator = Timeline{
        repeatCount: Timeline.INDEFINITE;
        keyFrames: KeyFrame{
            time: 1.0/30.0*1s
            action:function(){
                for (p in content){
                    (p as Particle).doStep();
                }
            }
        }
    }

    init{
        //start emitting
        emitTimeline.play();
        animator.play();
    }

    //called when a new particle should be added.
    function emit():Void{
        insert Particle{
            scaleX: particleScale;
            scaleY: particleScale;
            startingOpacity: particleOpacity;
            speed: particleSpeed;
            initialSteps: particleDuration;
            
            fadeout: particleFadeout;
            effect: ColorAdjust{
                    hue: normalizeHue(particleHue + randomFromNegToPos(particleHueVariation));
                }
        } into content;
    }

 public function normalizeHue(value:Number):Number{
        var result = value;
        while
        (
        result > 1.0){
            result -= 1.0;
        }
        while
        (
        result < - 1.0){
            result += 1.0;
        }
        return result;
    }

    public function randomFromNegToPos(max:Number):Number{
        if (max == 0.0){
            return 0.0;
        }
        var result = max - random.nextFloat()*max*2;
        return result;
    }

}

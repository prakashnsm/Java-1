/*
 * SlideReplace.fx
 *
 * Created on Jul 15, 2009, 6:35:59 PM
 */

package com.lj.jfxe.chapter5.transitions;

import javafx.scene.Node;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.util.Sequences;
import javafx.animation.Interpolator;
import javafx.scene.shape.Rectangle;

/**
 * @author lucasjordan
 */

public function doReplace(nodeToReplace:Node,replacementNode:Node,inter:Interpolator,doAfter:function()):Void{
    var parent:Group = (nodeToReplace.parent as Group);

    var index = Sequences.indexOf(parent.content, nodeToReplace);
    
    var startingX = nodeToReplace.translateX;
    var startingY = nodeToReplace.translateY;
    var minX = nodeToReplace.boundsInLocal.minX;
    var minY = nodeToReplace.boundsInLocal.minY;
    var totalWidth = nodeToReplace.boundsInLocal.width;
    var totalHeight = nodeToReplace.boundsInLocal.height;

    replacementNode.translateY = -minY;
    replacementNode.translateX = -replacementNode.boundsInLocal.width;

    
    var clip = Rectangle{
        width: totalWidth;
        height: totalHeight;
    }

    delete nodeToReplace from parent.content;
    
    var group = Group{
        translateX: startingX + minX;
        translateY: startingY + minY;
        content: [nodeToReplace,replacementNode]
        clip: clip
    }

    nodeToReplace.translateX = -minX;
    nodeToReplace.translateY = -minY;

    insert group before parent.content[index];


    var t = Timeline{
        keyFrames: [
                KeyFrame{
                    time: 1s
                    values: [
                        group.translateX => startingX + totalWidth tween inter,
                        clip.translateX => -totalWidth tween inter
                        ]
                    action: function(){
                        delete group.content;
                        replacementNode.translateX = startingX;
                        replacementNode.translateY = startingY;
                        insert replacementNode before parent.content[index];
                    }

                },
                KeyFrame{
                    time: 1s + 1ms
                    action: doAfter
                }

            ]
    }
    t.play();
}

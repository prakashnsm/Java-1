/*
 * Generated by JavaFX Production Suite NetBeans plugin.
 * GameAssetsUI.fx
 *
 * Created on Fri Nov 06 18:29:20 EST 2009
 */
package org.lj.jfxe.chapter11;

import java.lang.*;
import javafx.scene.Node;
import javafx.fxd.FXDNode;

public class GameAssetsUI extends FXDNode {
	
	override public var url = "{__DIR__}GameAssets.fxz";
	
	public-read protected var aboutButton: Node;
	public-read protected var aboutPanel: Node;
	public-read protected var backButton: Node;
	public-read protected var backFromPlayButton: Node;
	public-read protected var backPanel1: Node;
	public-read protected var backPanel2: Node;
	public-read protected var backPanel3: Node;
	public-read protected var backPanel4: Node;
	public-read protected var backPanel5: Node;
	public-read protected var backPanel6: Node;
	public-read protected var backPanelGroup1: Node;
	public-read protected var backPanelGroup2: Node;
	public-read protected var backPanelGroup3: Node;
	public-read protected var backWall: Node;
	public-read protected var barrel: Node;
	public-read protected var bonusBalloon: Node;
	public-read protected var cannon: Node;
	public-read protected var curtainGroup: Node;
	public-read protected var curtainLeft: Node;
	public-read protected var curtainRight: Node;
	public-read protected var endButtons: Node;
	public-read protected var firework0: Node;
	public-read protected var firework1: Node;
	public-read protected var firework10: Node;
	public-read protected var firework11: Node;
	public-read protected var firework2: Node;
	public-read protected var firework4: Node;
	public-read protected var firework5: Node;
	public-read protected var firework6: Node;
	public-read protected var firework7: Node;
	public-read protected var firework8: Node;
	public-read protected var firework9: Node;
	public-read protected var fireworkGroup: Node;
	public-read protected var floor: Node;
	public-read protected var flyingClown: Node;
	public-read protected var gameOverText: Node;
	public-read protected var ladder: Node;
	public-read protected var net: Node;
	public-read protected var peg0: Node;
	public-read protected var peg1: Node;
	public-read protected var peg2: Node;
	public-read protected var peg3: Node;
	public-read protected var peg4: Node;
	public-read protected var pegGroup: Node;
	public-read protected var playAgainButton: Node;
	public-read protected var powerGroup: Node;
	public-read protected var powerLevel: Node;
	public-read protected var score: Node;
	public-read protected var startButton: Node;
	public-read protected var startButtons: Node;
	public-read protected var startGameInstructions: Node;
	public-read protected var status: Node;
	public-read protected var title: Node;
	public-read protected var waitingClown0: Node;
	public-read protected var waitingClown1: Node;
	public-read protected var waitingClown2: Node;
	public-read protected var waitingClown3: Node;
	public-read protected var waitingClown4: Node;
	public-read protected var waitingClownGroup: Node;
	public-read protected var waterBucket: Node;
	
	override protected function contentLoaded() : Void {
		aboutButton=getNode("aboutButton");
		aboutPanel=getNode("aboutPanel");
		backButton=getNode("backButton");
		backFromPlayButton=getNode("backFromPlayButton");
		backPanel1=getNode("backPanel1");
		backPanel2=getNode("backPanel2");
		backPanel3=getNode("backPanel3");
		backPanel4=getNode("backPanel4");
		backPanel5=getNode("backPanel5");
		backPanel6=getNode("backPanel6");
		backPanelGroup1=getNode("backPanelGroup1");
		backPanelGroup2=getNode("backPanelGroup2");
		backPanelGroup3=getNode("backPanelGroup3");
		backWall=getNode("backWall");
		barrel=getNode("barrel");
		bonusBalloon=getNode("bonusBalloon");
		cannon=getNode("cannon");
		curtainGroup=getNode("curtainGroup");
		curtainLeft=getNode("curtainLeft");
		curtainRight=getNode("curtainRight");
		endButtons=getNode("endButtons");
		firework0=getNode("firework0");
		firework1=getNode("firework1");
		firework10=getNode("firework10");
		firework11=getNode("firework11");
		firework2=getNode("firework2");
		firework4=getNode("firework4");
		firework5=getNode("firework5");
		firework6=getNode("firework6");
		firework7=getNode("firework7");
		firework8=getNode("firework8");
		firework9=getNode("firework9");
		fireworkGroup=getNode("fireworkGroup");
		floor=getNode("floor");
		flyingClown=getNode("flyingClown");
		gameOverText=getNode("gameOverText");
		ladder=getNode("ladder");
		net=getNode("net");
		peg0=getNode("peg0");
		peg1=getNode("peg1");
		peg2=getNode("peg2");
		peg3=getNode("peg3");
		peg4=getNode("peg4");
		pegGroup=getNode("pegGroup");
		playAgainButton=getNode("playAgainButton");
		powerGroup=getNode("powerGroup");
		powerLevel=getNode("powerLevel");
		score=getNode("score");
		startButton=getNode("startButton");
		startButtons=getNode("startButtons");
		startGameInstructions=getNode("startGameInstructions");
		status=getNode("status");
		title=getNode("title");
		waitingClown0=getNode("waitingClown0");
		waitingClown1=getNode("waitingClown1");
		waitingClown2=getNode("waitingClown2");
		waitingClown3=getNode("waitingClown3");
		waitingClown4=getNode("waitingClown4");
		waitingClownGroup=getNode("waitingClownGroup");
		waterBucket=getNode("waterBucket");
	}
	
	/**
	 * Check if some element with given id exists and write 
	 * a warning if the element could not be found.
	 * The whole method can be removed if such warning is not required.
	 */
	protected override function getObject( id:String) : Object {
		var obj = super.getObject(id);
		if ( obj == null) {
			System.err.println("WARNING: Element with id {id} not found in {url}");
		}
		return obj;
	}
}


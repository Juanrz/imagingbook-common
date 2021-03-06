/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 *  image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2016 Wilhelm Burger, Mark J. Burge. All rights reserved. 
 * Visit http://imagingbook.com for additional details.
 *******************************************************************************/

package imagingbook.pub.regions;

import ij.process.ByteProcessor;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary region labeler based on a breadth-first flood filling
 * algorithm. 
 * 
 * @author WB
 * @version 2016-11-08
 */
public class BreadthFirstLabeling extends RegionLabeling {
	
	/**
	 * Creates a new region labeling.
	 * 
	 * @param ip the binary input image with 0 values for background pixels and values &gt; 0
	 * for foreground pixels.
	 */
	public BreadthFirstLabeling(ByteProcessor ip) {
		super(ip);
	}
	
	@Override
	void applyLabeling() {
		resetLabel();
		for (int v = 0; v < height; v++) {
			for (int u = 0; u < width; u++) {
				if (getLabel(u, v) == FOREGROUND) {
					// start a new region
					int label = getNextLabel();
					floodFill(u, v, label);
				}
			}
		}
	}

	private void floodFill(int u, int v, int label) {
		Queue<Point> Q = new LinkedList<Point>();	//queue contains pixel coordinates
		Q.add(new Point(u, v));
		while (!Q.isEmpty()) {
			Point p = Q.remove();	// get the next point to process
			int x = p.x;
			int y = p.y;
			if ((x >= 0) && (x < width) && (y >= 0) && (y < height)
					&& getLabel(x, y) == FOREGROUND) {
				setLabel(x, y, label);
				Q.add(new Point(x+1, y));
				Q.add(new Point(x, y+1));
				Q.add(new Point(x, y-1));
				Q.add(new Point(x-1, y));
			}
		}
	}

}

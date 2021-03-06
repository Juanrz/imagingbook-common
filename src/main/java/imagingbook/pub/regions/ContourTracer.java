/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 *  image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2016 Wilhelm Burger, Mark J. Burge. All rights reserved. 
 * Visit http://imagingbook.com for additional details.
 *******************************************************************************/
package imagingbook.pub.regions;

import java.util.List;


/**
 * This interface defines the functionality of region segmenters
 * that perform contour extraction.
 */
public interface ContourTracer {
	
	/**
	 * Retrieves all inner contours of the associated region labeling.
	 * @return the list of inner contours.
	 */
	public List<Contour> getInnerContours();
	
	/**
	 * Retrieves all inner contours of the associated region labeling.
	 * @param sort set true to sort contours by (descending) length.
	 * @return the list of inner contours.
	 */
	public List<Contour> getInnerContours(boolean sort);
	
	/**
	 * Retrieves all outer contours of the associated region labeling.
	 * @return the list of outer contours.
	 */
	public List<Contour> getOuterContours();
	
	/**
	 * Retrieves all outer contours of the associated region labeling.
	 * @param sort set true to sort contours by (descending) length.
	 * @return the list of outer contours.
	 */
	public List<Contour> getOuterContours(boolean sort);
	
}

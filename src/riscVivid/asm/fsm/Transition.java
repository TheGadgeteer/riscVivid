/*******************************************************************************
 * riscVivid - A RISC-V processor simulator.
 * Copyright (C) 2013-2016 The riscVivid project, University of Augsburg, Germany
 * <https://github.com/unia-sik/riscVivid>
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program, see <LICENSE>. If not, see
 * <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package riscVivid.asm.fsm;

/**
 * This class represents a transition in a finite state machine. Transitions are
 * allowed if comparisionObject and passed Object equals
 * 
 */
public class Transition {
	private State destination;
	private Object comparisionObject;

	public Transition(State destination, Object comparisionObject) {
		this.destination = destination;
		this.comparisionObject = comparisionObject;
	}

	/**
	 * 
	 * @return destination
	 */
	public State getDestiantion() {
		return destination;
	}

	/**
	 * 
	 * @return comparisionObject
	 */
	public Object getComparisionObject() {
		return comparisionObject;
	}

	/**
	 * 
	 * @param o
	 *            Object that is compared with comparisionObject
	 * @return destination if o equals comparisionObject null otherwise
	 */
	public State doTransition(Object o) {
		if (comparisionObject.equals(o))
			return destination;
		else
			return null;
	}
}

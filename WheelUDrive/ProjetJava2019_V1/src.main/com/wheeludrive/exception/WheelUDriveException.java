package com.wheeludrive.exception;

public class WheelUDriveException extends Exception{

	/**
	 * 
	 */
	private static final String DEBUT_ERROR = "Erreur captée par wheeludrive: ";
	private static final long serialVersionUID = 1L;
	
	public WheelUDriveException(String exception) {

		super(DEBUT_ERROR + exception);
	}

	public WheelUDriveException(String exception, Throwable cause) {
		super(DEBUT_ERROR + exception, cause);
	}

}

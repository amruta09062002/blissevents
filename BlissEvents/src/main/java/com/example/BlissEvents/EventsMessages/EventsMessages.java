package com.example.BlissEvents.EventsMessages;

public class EventsMessages {
	
	private EventsMessages() {
		
	}
	
	public static String errorMessage() {
		return "Unexpected error occured...!!";
	}
	
	public static String insertMessage() {
		//System.out.println("Event added successfully...!!");
		return "Event added successfully...!!";
	}
	
	public static String notInsertMessage() {
		return "Event not added...!!!";
	}
	
	public static void idNotFound() {
		System.out.println("Id not Found...");
	}
	
	public static void EventNotFound() {
		System.out.println("Event not Found...");
	}
	
	public static String EvenDatetNotFound() {
		return "Event date not Found...";
	}

	public static String deleteIdMessage() {
		return "Event deleted successfully...";
	}

	public static String NotDeleteIdMessage() {
		return  "Event not deleted...";
	}

	public static String updatedMessage() {
		return  "Event updated...";
	}

	public static String notUpdatedMessage() {
		return "Event not updated...";
	}

	public static String displayMessage() {
		return "Event displayed successfully...";
	}

	public static String notDisplayMessage() {
		return "Event not displayed successfully...";
	}
}

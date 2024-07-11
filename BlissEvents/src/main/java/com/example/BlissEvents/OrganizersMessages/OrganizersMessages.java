package com.example.BlissEvents.OrganizersMessages;

public class OrganizersMessages {
	
	private OrganizersMessages() {
		
	}
	
	public static void errorMessage() {
		System.out.println("Unexpected error occurred:");
	}
	
	public static String insertMessage() {
		return "Organizer added successfully.";
	}
	
	public static String notInsertMessage() {
		return "Failed to add Organizer.";
	}
	
	public static String deleteOrganizer() {
		return "Organizer deleted successfully.";
	}
	
	public static String OrganizerNotDeleted() {
		return "Organizer is not deleted.";
	}
	
	public static String nullValue() {
		return "Null cannot be accepted.";
	}
	
	public static String updateOrganizer() {
		return "Organizer updated successfully.";
	}
	
	public static String OrganizerNotupdated() {
		return "Organizer is not updated.";
	}

}

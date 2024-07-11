package com.example.BlissEvents.AttendeesMessages;

public class AttendeesMessages {
	
	private AttendeesMessages() {
	}
	
	public static void errorMessage() {
		System.out.println("Unexpected error occurred:");
	}
	
	public static String insertMessage() {
		return "Attendee added successfully.";
	}
	
	public static String notInsertMessage() {
		return "Failed to add attendee.";
	}
	
	public static String deleteAttendee() {
		return "Attendee deleted successfully.";
	}
	
	public static String AttendeeNotDeleted() {
		return "Attendee is not deleted.";
	}
	
	public static String nullValue() {
		return "Null cannot be accepted.";
	}
	
	public static String updateAttendee() {
		return "Attendee updated successfully.";
	}
	
	public static String AttendeeNotupdated() {
		return "Attendee is not updated.";
	}
}

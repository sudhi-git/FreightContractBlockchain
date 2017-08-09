package com.sudhi.samples.freightcontract.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notes {
	@JsonProperty("NoteUUID")
	private String noteUUID;
	@JsonProperty("NoteType")
	private String noteType;
	@JsonProperty("Language")
	private String lang;
	@JsonProperty("Description")
	private String description;
	public String getNoteUUID() {
		return noteUUID;
	}
	public void setNoteUUID(String noteUUID) {
		if(noteUUID == null || noteUUID.equals("")){
			this.noteUUID = UUID.randomUUID().toString();
		}else{
			this.noteUUID = noteUUID;
		}
		
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}

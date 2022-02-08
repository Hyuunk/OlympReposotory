package fr.hyu.olymp.party;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Party {
	
	private String chief;
	private ArrayList<String> members = new ArrayList<String>();
		
	public Party(Player chief, String member) {
		this.chief = chief.getName();
		this.members.add(member);
	}
		
	public void disband() {
		
	}

	public String getChiefParty() {
		return chief;
	}

	public void setChiefParty(String chiefParty) {
		this.chief = chiefParty;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

}
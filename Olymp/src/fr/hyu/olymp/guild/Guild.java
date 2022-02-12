package fr.hyu.olymp.guild;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Guild{
	
	private String owner;
	private ArrayList<String> members = new ArrayList<String>();
		
	public Guild(Player owner, String member) {
		this.owner = owner.getName();
		this.members.add(member);
	}
		
	public void disband() {
		
	}

	public String getChiefParty() {
		return owner;
	}

	public void setChiefParty(String chiefParty) {
		this.owner = chiefParty;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

}
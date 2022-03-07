package fr.hyu.olympperms.players;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.hyu.olymp.Main;
import fr.hyu.olympperms.players.PlayerRankProfile.Rank;
import fr.hyu.olympplayers.gui.GuiManager;
import fr.hyu.olympplayers.gui.GuiManager.InventoryTypeList;


public class PlayerProfile {

	// Definition des variables joueurs utilis�
	private String name;
	private UUID uuid;
	private Rank rank;
	private int level;
	private int experiencesPoints;
	private int pointsAvailables;
	private int gold;
	private int karma;
	private int vitalityNative;
	private int defenceNative;
	private int strengthNative;
	private int dexterityNative;
	private int enduranceOnLeave;
	private int enduranceCapacityNative;
	private int intelligenceNative;
	private int faithNative;
	private int manaOnLeave;
	private int manaCapacityNative;
	private int agilityNative;
	private List<Inventory> inventoryArrayList;
	private HashMap<InventoryTypeList, Inventory> inventoryHashMapTypeListInv;
		


	// private UUID faction;

	public PlayerProfile(Player player) {

		this.uuid = player.getUniqueId();
		initFile();		
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		this.rank = Rank.valueOf(config.getString("rank").toUpperCase());
		this.inventoryArrayList = initInventories(player);
		this.inventoryHashMapTypeListInv = initHashMap();
		this.level = config.getInt("level.level");
		this.experiencesPoints = config.getInt("level.experiencsPoints");
		this.pointsAvailables = config.getInt("level.pointsAvailables");
		this.gold = config.getInt("gold");
		this.karma = config.getInt("stats.karmaPoint");
		this.vitalityNative = config.getInt("stats.vitalityNative");
		this.defenceNative = config.getInt("stats.defenceNative");
		this.strengthNative = config.getInt("stats.strengthNative");
		this.dexterityNative = config.getInt("stats.dexterityNative");
		this.enduranceOnLeave = config.getInt("stats.enduranceOnLeave");
		this.enduranceCapacityNative = config.getInt("stats.enduranceNative");
		this.intelligenceNative = config.getInt("stats.intelligenceNative");
		this.faithNative = config.getInt("stats.faithNative");
		this.manaOnLeave = config.getInt("stats.manaOnLeave");
		this.manaCapacityNative = config.getInt("stats.manaCapacityNative");
		this.agilityNative = config.getInt("stats.agilityNative");
		
			
	}
	
	public HashMap<InventoryTypeList, Inventory> initHashMap() {
	
		HashMap<InventoryTypeList, Inventory> hashMapInv = new HashMap<InventoryTypeList, Inventory>();
		
		for (int i = 0; i < inventoryArrayList.size() ; i++) {
			Inventory inv = inventoryArrayList.get(i);
			hashMapInv.put(GuiManager.getInventoryType(inv), inv);

		}
		
		return hashMapInv;
	}

	private List<Inventory> initInventories(Player player) {
		
		List<Inventory> inventoryArrayList = new ArrayList<Inventory>();
		
		for (InventoryTypeList inventory : InventoryTypeList.values()) {
		inventoryArrayList.add(inventory.createInventory(player));
		}
		
		return inventoryArrayList;
	}
	
	private void initFile() {

		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		if (!file.exists()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			config.set("rank", "default");
			config.set("level.level", 0);
			config.set("level.experiencesPoints", 0);
			config.set("level.pointsAvailables", 0);
			config.set("gold", 0);
			config.set("stats.karmaPoint", 0);
			config.set("stats.vitalityNative", 0);
			config.set("stats.defenceNative", 0);
			config.set("stats.strengthNative", 0);
			config.set("stats.dexterityNative", 0);
			config.set("stats.enduranceOnLeave", 100);
			config.set("stats.enduranceNative", 100);
			config.set("stats.intelligenceNative", 0);
			config.set("stats.faithNative", 0);
			config.set("stats.manaOnLeave", 100);
			config.set("stats.manaCapacityNative", 100);
			config.set("stats.agilityNative", 0);

			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// Constructeur des variables joueurs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("rank", rank);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Inventory> getInventories() {		
		return inventoryArrayList;
	}
	
	public void setInventories(Inventory inventory) {
		
		List<Inventory> inventoryArrayList = this.inventoryArrayList;
				
		inventoryArrayList.add(inventory);
		
		this.inventoryArrayList = inventoryArrayList;
	}
	
	public HashMap<InventoryTypeList, Inventory> getHashMapInventoryTypeToInventory() {
		return inventoryHashMapTypeListInv;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("level.level", level);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getExperiencesPoints() {
		return experiencesPoints;
	}

	public void setExperiencesPoints(int experiencesPoints) {
		this.experiencesPoints = experiencesPoints;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("level.experiencesPoints", experiencesPoints);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPointsAvailables() {
		return pointsAvailables;
	}
	
	public void setPointsAvailables(int pointsAvailables) {
		this.pointsAvailables = pointsAvailables;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("level.pointsAvailables", pointsAvailables);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("gold", gold);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.karmaPoint", karma);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// -----------------------------------------------------------------------------------------------------//
	//                                                                                                      //
	//                                          STATS PLAYER                                                //
	//                                                                                                      //
	// -----------------------------------------------------------------------------------------------------//

	public int getVitalityNative() {
		return vitalityNative;
	}

	public void setVitalityNative(int vitalityNative) {
		this.vitalityNative = vitalityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.vitalityNative", vitalityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getDefenceNative() {
		return defenceNative;
	}

	public void setDefenceNative(int defenceNative) {
		this.defenceNative = defenceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.defenceNative", defenceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getStrengthNative() {
		return strengthNative;
	}

	public void setStrengthNative(int strengthNative) {
		this.strengthNative = strengthNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.strengthNative", strengthNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getDexterityNative() {
		return dexterityNative;
	}
	
	public void setDexterityNative(int dexterityNative) {
		this.dexterityNative = dexterityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.dexterityNative", dexterityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getEnduranceOnLeave() {
		return enduranceOnLeave;
	}

	public void setEnduranceOnLeave(int enduranceOnLeave) {
		this.enduranceOnLeave = enduranceOnLeave;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.enduranceOnLeave", enduranceOnLeave);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getEnduranceNative() {
		return enduranceCapacityNative;
	}

	public void setEnduranceNative(int enduranceNative) {
		this.enduranceCapacityNative = enduranceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.enduranceNative", enduranceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getIntelligenceNative() {
		return intelligenceNative;
	}

	public void setIntelligenceNative(int intelligenceNative) {
		this.intelligenceNative = intelligenceNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.intelligenceNative", intelligenceNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getFaithNative() {
		return faithNative;
	}
	
	public void setFaithNative(int faithNative) {
		this.faithNative = faithNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.faithNative", faithNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getManaOnLeave() {
		return manaOnLeave;
	}

	public void setManaOnLeave(int mana) {
		this.manaOnLeave = mana;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.manaOnLeave", manaOnLeave);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getManaCapacityNative() {
		return manaCapacityNative;
	}

	public void setManaCapacityNative(int manaCapacityNative) {
		this.manaCapacityNative = manaCapacityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.manaCapacityNative", manaCapacityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getAgilityNative() {
		return agilityNative;
	}

	public void setAgilityNative(int agilityNative) {
		this.agilityNative = agilityNative;
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/players/" + uuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stats.agilityNative", agilityNative);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getStat(Player player, Stat stat) {

		switch (stat.getName().toUpperCase()) {
		case "LEVEL":
			return PlayerProfileManager.profiles.get(player).getLevel();
		case "EXPERIENCEPOINTS":
			return PlayerProfileManager.profiles.get(player).getExperiencesPoints();
		case "POINTSAVAILABLES":
			return PlayerProfileManager.profiles.get(player).getPointsAvailables();
		case "GOLD":
			return PlayerProfileManager.profiles.get(player).getGold();
		case "KARMA":
			return PlayerProfileManager.profiles.get(player).getKarma();
		case "VITALITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getVitalityNative();
		case "DEFENCENATIVE":
			return PlayerProfileManager.profiles.get(player).getDefenceNative();
		case "STRENGTHNATIVE":
			return PlayerProfileManager.profiles.get(player).getStrengthNative();
		case "DEXTIRITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getDexterityNative();
		case "ENDURANCENATIVE":
			return PlayerProfileManager.profiles.get(player).getEnduranceNative();
		case "INTELLIGENCENATIVE":
			return PlayerProfileManager.profiles.get(player).getIntelligenceNative();
		case "FAITHNATIVE":
			return PlayerProfileManager.profiles.get(player).getFaithNative();
		case "MANAONLEAVE":
			return PlayerProfileManager.profiles.get(player).getManaOnLeave();
		case "MANACAPACITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getManaCapacityNative();
		case "AGILITYNATIVE":
			return PlayerProfileManager.profiles.get(player).getAgilityNative();
		default:
			System.out.println("[OLYMPPERMS] getStat not defined");
			break;
		}
		
		return -0;
	}

	public static void setStat(Player player, Stat stat, int toSet) {

		switch (stat.getName().toUpperCase()) {
		case "LEVEL":
			PlayerProfileManager.profiles.get(player).setLevel(toSet); break;
		case "EXPERIENCEPOINTS":
			PlayerProfileManager.profiles.get(player).setExperiencesPoints(toSet); break;
		case "POINTSAVAILABLES":
			PlayerProfileManager.profiles.get(player).setPointsAvailables(toSet); break;
		case "GOLD":
			PlayerProfileManager.profiles.get(player).setGold(toSet); break;
		case "KARMA":
			PlayerProfileManager.profiles.get(player).setKarma(toSet); break;
		case "VITALITYNATIVE":
			PlayerProfileManager.profiles.get(player).setVitalityNative(toSet); break;
		case "DEFENCENATIVE":
			PlayerProfileManager.profiles.get(player).setDefenceNative(toSet); break;
		case "STRENGTHNATIVE":
			PlayerProfileManager.profiles.get(player).setStrengthNative(toSet); break;
		case "DEXTIRITYNATIVE":
			PlayerProfileManager.profiles.get(player).setDexterityNative(toSet); break;
		case "ENDURANCENATIVE":
			PlayerProfileManager.profiles.get(player).setEnduranceNative(toSet); break;
		case "INTELLIGENCENATIVE":
			PlayerProfileManager.profiles.get(player).setIntelligenceNative(toSet); break;
		case "FAITHNATIVE":
			PlayerProfileManager.profiles.get(player).setFaithNative(toSet); break;
		case "MANAONLEAVE":
			PlayerProfileManager.profiles.get(player).setManaOnLeave(toSet); break;
		case "MANACAPACITYNATIVE":
			PlayerProfileManager.profiles.get(player).setManaCapacityNative(toSet); break;
		case "AGILITYNATIVE":
			PlayerProfileManager.profiles.get(player).setAgilityNative(toSet); break;
		default:
			System.out.println("[OLYMPPERMS] setStat not defined");
			break;
		}

	}
	
	public static void addStat(Player player, Stat stat, int toAdd) {

		switch (stat.getName().toUpperCase()) {
		case "LEVEL":
			PlayerProfileManager.profiles.get(player).setLevel(PlayerProfileManager.profiles.get(player).getLevel() + toAdd); break;
		case "EXPERIENCEPOINTS":
			PlayerProfileManager.profiles.get(player).setExperiencesPoints(PlayerProfileManager.profiles.get(player).getExperiencesPoints() + toAdd); break;
		case "POINTSAVAILABLES":
			PlayerProfileManager.profiles.get(player).setPointsAvailables(PlayerProfileManager.profiles.get(player).getPointsAvailables() + toAdd); break;
		case "GOLD":
			PlayerProfileManager.profiles.get(player).setGold(PlayerProfileManager.profiles.get(player).getGold() + toAdd); break;
		case "KARMA":
			PlayerProfileManager.profiles.get(player).setKarma(PlayerProfileManager.profiles.get(player).getKarma() + toAdd); break;
		case "VITALITYNATIVE":
			PlayerProfileManager.profiles.get(player).setVitalityNative(PlayerProfileManager.profiles.get(player).getVitalityNative() + toAdd); break;
		case "DEFENCENATIVE":
			PlayerProfileManager.profiles.get(player).setDefenceNative(PlayerProfileManager.profiles.get(player).getDefenceNative() + toAdd); break;
		case "STRENGTHNATIVE":
			PlayerProfileManager.profiles.get(player).setStrengthNative(PlayerProfileManager.profiles.get(player).getStrengthNative() + toAdd); break;
		case "DEXTIRITYNATIVE":
			PlayerProfileManager.profiles.get(player).setDexterityNative(PlayerProfileManager.profiles.get(player).getDexterityNative() + toAdd); break;
		case "ENDURANCENATIVE":
			PlayerProfileManager.profiles.get(player).setEnduranceNative(PlayerProfileManager.profiles.get(player).getEnduranceNative() + toAdd); break;
		case "INTELLIGENCENATIVE":
			PlayerProfileManager.profiles.get(player).setIntelligenceNative(PlayerProfileManager.profiles.get(player).getIntelligenceNative() + toAdd); break;
		case "FAITHNATIVE":
			PlayerProfileManager.profiles.get(player).setFaithNative(PlayerProfileManager.profiles.get(player).getFaithNative() + toAdd); break;
		case "MANAONLEAVE":
			PlayerProfileManager.profiles.get(player).setManaOnLeave(PlayerProfileManager.profiles.get(player).getManaOnLeave() + toAdd); break;
		case "MANACAPACITYNATIVE":
			PlayerProfileManager.profiles.get(player).setManaCapacityNative(PlayerProfileManager.profiles.get(player).getManaCapacityNative() + toAdd); break;
		case "AGILITYNATIVE":
			PlayerProfileManager.profiles.get(player).setAgilityNative(PlayerProfileManager.profiles.get(player).getAgilityNative() + toAdd); break;
		default:
			System.out.println("[OLYMPPERMS] setStat not defined");
			break;
		}

	}
	
	public enum Stat {

		LEVEL("level"),
		EXPERIENCEPOINTS("experiencePoints"),
		POINTSAVAILABLES("pointsAvailables"),
		GOLD("gold"),
		KARMA("karma"),
		VITALITYNATIVE("vitalityNative"),
		DEFENCENATIVE("defenceNative"),
		STRENGTHNATIVE("strengthNative"),
		DEXTIRITYNATIVE("dextirityNative"),
		ENDURENCENATIVE("enduranceNative"),
		INTELLIGENCENATIVE("intelligenceNative"),
		FAITHNATIVE("faithNative"),
		MANAONLEAVE("manaOnLeave"),
		MANACAPACITYNATIVE("manaCapacityNative"),
		AGILITYNATIVE("agilityNative");

		private String name;		
		
		private Stat(String name) {
		 this.name = name;
		}	

		public String getName( ) {
			return name;
		}	
		
		
	 }	
	
	public static boolean isStat(String statToVerify) {
		for (Stat stat : Stat.values()) {	
			
			if (stat.toString().equalsIgnoreCase(statToVerify)) {			
			return true;		
			}
		}
		return false;		
	}
	

}
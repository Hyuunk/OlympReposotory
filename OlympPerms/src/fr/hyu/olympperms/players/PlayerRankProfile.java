package fr.hyu.olympperms.players;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.hyu.olymp.Main;

public class PlayerRankProfile {

	private static HashMap<Rank, List<String>> permissions = new HashMap<Rank, List<String>>();

	public static void initRank() {

		File filePermissions = new File(Main.INSTANCE.getDataFolder(), "OlympPerms/permissions/permissions.yml");
		FileConfiguration configPermissions = YamlConfiguration.loadConfiguration(filePermissions);

		if (!filePermissions.exists()) {
			configPermissions.set("rank.gerant.permissions", "olymp.*");
			configPermissions.set("rank.responsable.permissions", "null");
			configPermissions.set("rank.developpeur.permissions", "null");
			configPermissions.set("rank.moderateur.permissions", "null");
			configPermissions.set("rank.builder.permissions", "null");
			configPermissions.set("rank.helper.permissions", "null");
			configPermissions.set("rank.default.permissions", "null");

			try {
				configPermissions.save(filePermissions);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Rank rank : Rank.values()) {

			permissions.put(rank,
					configPermissions.getStringList("rank." + rank.toString().toLowerCase() + ".permissions"));
		}
	}

	public static boolean hasPermission(Player player, String permission) {

		if (permission.indexOf("olymp.") != -1) {
			if (permissions.get(PlayerProfileManager.profiles.get(player).getRank()).contains("olymp.*")) {
				return true;
			} else {
				return permissions.get(PlayerProfileManager.profiles.get(player).getRank()).contains(permission);
			}
		} else {
			return permissions.get(PlayerProfileManager.profiles.get(player).getRank()).contains(permission);
		}
	}

	public static List<String> getPermissions(Player player) {

		return permissions.get(PlayerProfileManager.profiles.get(player).getRank());
	}

	public enum Rank {

		GERANT(), RESPONSABLE(), DEVELOPPEUR(), MODERATEUR(), BUILDER(), HELPER(), DEFAULT()

	}

}
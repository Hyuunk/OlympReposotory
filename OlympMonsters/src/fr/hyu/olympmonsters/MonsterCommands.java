package fr.hyu.olympmonsters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.EnumUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.hyu.olymp.chat.ChatManager;
import fr.hyu.olympmonsters.files.MonsterFile;
import fr.hyu.olympmonsters.files.MonsterFinishFile;
import fr.hyu.olympperms.players.PlayerRankProfile;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import fr.hyu.olymp.Main;

public class MonsterCommands implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			// PERMISSION
			if (PlayerRankProfile.hasPermission(player, "olymp.monster")) {

				//CHECK IF ARGS AND IF ENUM CONTAINS ARGS
				if (args.length > 0 && EnumUtils.isValidEnum(MonsterCommandsName.class, args[0].toUpperCase())) {
									
				//ARGS[0] CHECK
				switch (args[0].toUpperCase()) {
				
				case "HELP":
					String newLine = System.getProperty("line.separator");
					player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + ChatColor.GRAY.toString() + "Voici la liste des commandes " + ChatColor.BLUE + ChatColor.BOLD + "Monster" + ChatColor.GRAY + " :"
					+ newLine + ChatColor.BLUE + "/monster list" + ChatColor.GRAY + " pour voir la liste des montres."
					+ newLine + ChatColor.BLUE + "/monster info" + ChatColor.GRAY + " pour voir les informations d'un monstre."
					+ newLine + ChatColor.BLUE + "/monster create" + ChatColor.GRAY + " pour créer un nouveau monstre." 
					+ newLine + ChatColor.BLUE + "/monster delete" + ChatColor.GRAY + " pour supprimer un monstre existant."
					+ newLine + ChatColor.BLUE + "/monster finish" + ChatColor.GRAY + " pour nettoyer le fichier d'un monstre des informations inutiles.");
					break;
					
				
					
				case "CREATE":
					
					if (args.length == 2 | args.length == 3) {
						String newMonster = args[1];
						
						if (args.length == 3) {												
							String entityType = args[2];
							
							if (isEntity(entityType)) {

								File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monstersWIP/" + newMonster + ".yml");
								if (!file.exists()) {
							
									MonsterFile.createMonsterFile(newMonster, entityType);
									
							player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage() + "Monster " + ChatColor.BLUE
									+ newMonster + "'s" + ChatColor.GRAY + " file has been created.");
							break;
								} else {
							player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Monster " + ChatColor.BLUE
									+ newMonster + "'s" + ChatColor.GRAY + " file already exist.");
							break;
								}
								
							} else {
								player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Argument's Error. Try /monster create <name>" + ChatColor.RED + " <entityType>");
								break;														
							}							
					} else {							
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Argument's Error. Try /monster create <name>" + ChatColor.RED + " <entityType>");
						break;							
					}												
					 	} else {
					player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
							+ "Argument's Error. Try /monster create <name> <entityType>.");
					 break;
					}
					
					
				case "FINISH":
					
					if (args.length == 2) {
						
						String monster = args[1];
						
						File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monstersWIP/" + monster + ".yml");
						if (file.exists()) {
							
							if (MonsterFinishFile.monsterFinish(file, monster)) {
								
								player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage() + "Monster " + ChatColor.BLUE
										+ monster + "'s" + ChatColor.GRAY + " file has been finished.");
								break;
							} else {
								player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Monster " + ChatColor.RED
										+ monster + "'s" + ChatColor.GRAY + " has suffered an error during process.");	
								break;
								}							
														
						} else {
							player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Argument's Error. Try /monster finish" + ChatColor.RED + " <name>" );
							break;
						}						
					} else {
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Argument's Error. Try /monster finish <name>");
						break;
					}
					
				case "SUMMON":
					
					break;
				case "DELETE":
					
					if (args.length == 2) {
						String nameMonster = args[1];
						File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monstersWIP/" + nameMonster + ".yml");
						
						if (file.exists()) { 
														
							TextComponent text = new TextComponent(ChatColor.RED.toString() + "Click to delete" );
							text.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/monster forcedelete " + args[1])) ;
							ComponentBuilder textBuilder = new ComponentBuilder("");
							textBuilder.append(ChatManager.MessageType.OLYMPCLASSIC.getMessage());
							textBuilder.append(text);
							textBuilder.append(ChatColor.GRAY + " file of monster " + ChatColor.RED + nameMonster + ChatColor.GRAY + ".");
							player.spigot().sendMessage(textBuilder.create());
							
							break;
						} else {
							player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Monster " + ChatColor.RED
									+ nameMonster + "'s" + ChatColor.GRAY + " file doesn't exist.");
							break;
						}
						
					} else {
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
								+ "Argument's Error. Try /monster delete <name>.");
						break;
					}								

				case "FORCEDELETE":
					
					if (args.length == 2) {
						String nameMonster = args[1];
						File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monstersWIP/" + nameMonster + ".yml");
						
						if (file.exists()) { 

							file.delete();
							player.sendMessage(ChatManager.MessageType.OLYMPRIGHT.getMessage() + "Monster " + ChatColor.RED
									+ nameMonster + "'s" + ChatColor.GRAY + " file has been deleted");
							break;
						} else {
							player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage() + "Monster " + ChatColor.RED
									+ nameMonster + "'s" + ChatColor.GRAY + " file doesn't exist.");
							break;
						}
						
					} else {
						player.sendMessage(ChatManager.MessageType.OLYMPERROR.getMessage()
								+ "Argument's Error. Try /monster delete <name>.");
						break;
					}	
					
				}						
				} else {
					player.sendMessage(ChatManager.MessageType.OLYMPCLASSIC.getMessage() + "Add an argument. Try /monster help.");
					return false;
				}
	
				
			} else {
				player.sendMessage(ChatManager.MessageType.UNKNOWCOMMAND.getMessage());
				return false;
			}
		
			
		}
		return false;
	}

	
//CHECK IF 
public enum MonsterCommandsName {
		
		HELP("help"),
		CREATE("create"),
		FINISH("finish"),
		SUMMON("summon"),
		DELETE("delete"),
		FORCEDELETE("forcedelete");
	
	
		private String name;		
		
		private MonsterCommandsName(String name) {
		 this.name = name;
		}	

		public String getName() {
			return name;
		}
	}


//CHECK IF ENTITYTYPE
public boolean isEntity(String entityType) {	
	@SuppressWarnings("unused")
	EntityType type = null;
	
	try {
		
		type = EntityType.valueOf(entityType.toUpperCase());
		try {
			
		notValidateEntityType.valueOf(entityType.toUpperCase());
			return false;		
		
		} catch (IllegalArgumentException e) {
			
			return true;
		}
			
		
			
	} catch (IllegalArgumentException e) {
	return false;
	}	
}

private enum notValidateEntityType {
	
	ARROW(EntityType.ARROW),
	BOAT(EntityType.BOAT),
	COMPLEX_PART(EntityType.COMPLEX_PART),
	DRAGON_FIREBALL(EntityType.DRAGON_FIREBALL),
	EGG(EntityType.EGG),
	ENDER_PEARL(EntityType.ENDER_PEARL),
	ENDER_SIGNAL(EntityType.ENDER_SIGNAL),
	EVOKER_FANGS(EntityType.EVOKER_FANGS),
	EXPERIENCE_ORB(EntityType.EXPERIENCE_ORB),
	FIREBALL(EntityType.FIREBALL),
	FIREWORK(EntityType.FIREWORK),
	FISHING_HOOK(EntityType.FISHING_HOOK),
	ITEM_FRAME(EntityType.ITEM_FRAME),
	LEASH_HITCH(EntityType.LEASH_HITCH),
	LIGHTNING(EntityType.LIGHTNING),
	LINGERING_POTION(EntityType.LINGERING_POTION),
	LLAMA_SPIT(EntityType.LLAMA_SPIT),
	MINECART(EntityType.MINECART),
	MINECART_CHEST(EntityType.MINECART_CHEST),
	MINECART_COMMAND(EntityType.MINECART_COMMAND),
	MINECART_FURNACE(EntityType.MINECART_FURNACE),
	MINECART_HOPPER(EntityType.MINECART_HOPPER),
	MINECART_MOB_SPAWNER(EntityType.MINECART_MOB_SPAWNER),
	MINECART_TNT(EntityType.MINECART_TNT),
	PAINTING(EntityType.PAINTING),
	PLAYER(EntityType.PLAYER),
	PRIMED_TNT(EntityType.PRIMED_TNT),
	SHULKER_BULLET(EntityType.SHULKER_BULLET),
	SMALL_FIREBALL(EntityType.SMALL_FIREBALL),
	SNOWBALL(EntityType.SNOWBALL),
	SPECTRAL_ARROW(EntityType.SPECTRAL_ARROW),
	SPLASH_POTION(EntityType.SPLASH_POTION),
	THROWN_EXP_BOTTLE(EntityType.THROWN_EXP_BOTTLE),
	UNKNOWN(EntityType.UNKNOWN),
	WEATHER(EntityType.WEATHER),
	WITHER_SKULL(EntityType.WITHER_SKULL);
	
	private EntityType entitytype;

	private notValidateEntityType(EntityType entitytype) {
		this.entitytype = entitytype;
	}
	
	@SuppressWarnings("unused")
	public EntityType getNotValidateEntityType() {
		return entitytype;
	}
	
	
	
}
}
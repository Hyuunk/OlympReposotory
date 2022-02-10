package fr.hyu.olympmonsters.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.entity.Parrot.Variant;
import org.bukkit.entity.Villager.Profession;

import fr.hyu.olymp.Main;

public class MonsterFile {

	public static void createMonsterFile(String newMonster, String entityType) {				
		init(newMonster, entityType);		
	}	
	
	@SuppressWarnings("incomplete-switch")
	private static void init(String newMonster, String entityType) {
		
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monstersWIP/" + newMonster + ".yml");
		if (!file.exists()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			config.set("monsterName", newMonster);	
			config.set("entityInfos.name", EntityType.valueOf(entityType.toUpperCase()).name());	
			//ADD INFORMATION ABOUT ENTITY ex (zombie -> isvillager)
			switch (EntityType.valueOf(entityType.toUpperCase())) {		
			
			case AREA_EFFECT_CLOUD:
				
				config.set("entityInfos.addCustomEffect", "wip ask dev to add it if necessary");
				config.set("entityInfos.setBasePotionData", "to fill");
				config.set("entityInfos.setColor", "Color.WHITE");
				config.set("entityInfos.setDuration", 0);
				config.set("entityInfos.setDurationOnUse", 0);
				config.set("entityInfos.setParticle", "Particle.SMOKE_LARGE");
				config.set("entityInfos.setRadius", 0);
				config.set("entityInfos.setRadiusOnUse", 0);
				config.set("entityInfos.setRadiusPerTick", 0);
				config.set("entityInfos.setReapplicationDelay", 0);
				config.set("entityInfos.setSource", "to fill");
				config.set("entityInfos.setWaitTime", 0);
				break;
				
			case ARMOR_STAND:
				
				config.set("entityInfos.setMarker", false);
				config.set("entityInfos.setSmall", false);
				config.set("entityInfos.setVisible", false);
				//config.set("entityInfos.removeEquipementLock", ); a faire permet de lock les items de l'amor stand				
				config.set("entityInfos.setArms", false);
				config.set("entityInfos.setBasePlate", false);								
				break;
				
			case BAT:
				
				config.set("entityInfos.setAwake", false);				
				break;
				
			case BLAZE:
								
				break;
				
			case CAVE_SPIDER:
				
				break;
				
			case CHICKEN:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);	
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);

				break;			
				
			case COW:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				break;
				
			case CREEPER:
				
				config.set("entityInfos.setExplosionRadius", 0);
				config.set("entityInfos.setFuseTicks", 0);
				config.set("entityInfos.setMaxFuseTicks", 0);
				config.set("entityInfos.setPowered", false);
				break;
				
			case DONKEY:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				break;

			case DROPPED_ITEM:
				
				break;

			case ELDER_GUARDIAN:
				
				break;
				
			case ENDERMAN:
				
				config.set("entityInfos.setCarriedBlock", "to fill");
				config.set("entityInfos.setCarriedMaterial", "to fill");
				break;
				
			case ENDERMITE:
				
				break;
				
			case ENDER_CRYSTAL:
				
				config.set("entityInfos.setBeamTarget", "to fill");
				config.set("entityInfos.setShowingBottom", false);
				break;
				
			case ENDER_DRAGON:
				
				break;
				
			case EVOKER:
				
				break;

			case FALLING_BLOCK:
				
				config.set("entityInfos.setDropItem", false);
				config.set("entityInfos.setHurtEntities", false);
				break;

			case GHAST:
				
				break;
				
			case GIANT:
				
				break;
								
			case GUARDIAN:
				
				config.set("entityInfos.setLaser", true);
				break;
				
			case HORSE:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setHorseColor", "Horse.Color.WHITE");
				config.set("entityInfos.setHorsesStyle", "Horse.Style.NONE");
				break;
				
			case HUSK:	
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setConversionTime", 0);
				break;
				
			case ILLUSIONER:
				
				break;
				
			case IRON_GOLEM:
				config.set("entityInfos.setPlayerCreated", false);
				break;
				
			case LLAMA:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setLlameColor", "Llama.Color.CREAMY");
				config.set("entityInfos.setStrength", 0);
				break;

			case MAGMA_CUBE:
				
				config.set("entityInfos.setSize", 0);
				break;

			case MULE:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setCarryingChest", false);
				break;
				
			case MUSHROOM_COW:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setMuhsroomCowVariant", "RED");
				break;
				
			case OCELOT:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setCatType", "Type.WILD_OCELOT");
				config.set("entityInfos.setTrusting", false);
				break;

			case PARROT:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setParrotVariant", "Variant.GREEN");
				break;
				
			case PIG:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setSaddle", false);
				break;
				
			case PIG_ZOMBIE:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAnger", 0);
				config.set("entityInfos.setAngry", false);				
				break;				
				
			case POLAR_BEAR:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				break;

			case RABBIT:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setRabbitType", "Rabbit.Type.GOLD");
				break;
				
			case SHEEP:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setSheared", false);
				config.set("entityInfos.setColor", "Color.WHITE");
				break;
				
			case SHULKER:
				
				config.set("entityInfos.setAttachedFace", "BlockFace.NORTH");
				config.set("entityInfos.setPeek", 0);
				break;				

			case SILVERFISH:
				
				break;
				
			case SKELETON:
				
				break;
				
			case SKELETON_HORSE:
				
				break;
				
			case SLIME:
				
				config.set("entityInfos.setSize", 0);
				break;

			case SNOWMAN:
				
				config.set("entityInfos.setDerp", false);
				break;

			case SPIDER:
								
				break;

			case SQUID:
				
				break;
				
			case STRAY:
				
				break;

			case VEX:
				
				config.set("entityInfos.setCharging", false);
				break;
				
			case VILLAGER:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setProfession", "Profession.LIBRARIAN");
				config.set("entityInfos.setVillagerExperience", 0);
				config.set("entityInfos.setVillagerLevel", 0);
				break;
				
			case VINDICATOR:
				
				break;

			case WITCH:
				
				break;
				
			case WITHER:
				
				break;
				
			case WITHER_SKELETON:
				
				break;

			case WOLF:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setAgeLock", true);
				config.set("entityInfos.setBreed", false);
				config.set("entityInfos.setAngry", false);
				config.set("entityInfos.setCollarColor", "to fill");
				break;
				
			case ZOMBIE:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				break;
				
			case ZOMBIE_HORSE:
				
				break;
				
			case ZOMBIE_VILLAGER:
				
				config.set("entityInfos.setAge", 0);
				config.set("entityInfos.setAdult", true);
				config.set("entityInfos.setBaby", false);
				config.set("entityInfos.setVillagerLevel", 0);
				break;
				
			}
			
			config.set("description", "to fill");		
			config.set("stats.level", 0);
			config.set("stats.vitalityNative", 0);
			config.set("stats.defenceNative", 0);
			config.set("stats.strengthNative", 0);
			config.set("stats.enduranceNative", 0);
			config.set("stats.intelligenceNative", 0);
			config.set("stats.manaCapacityNative", 100);
			config.set("spells.utilisables", "to fill");
			config.set("equippedItems.mainhand", "to fill");
			config.set("equippedItems.offhand", "to fill");
			config.set("equippedItems.head", "to fill");
			config.set("equippedItems.chest", "to fill");
			config.set("equippedItems.legs", "to fill");
			config.set("equippedItems.feet", "to fill");
			config.set("droppables.golds", 0);
			config.set("droppables.experiences", 0);
			config.set("droppables.items", "to fill");

			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}

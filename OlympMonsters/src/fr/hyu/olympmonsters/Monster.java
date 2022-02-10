package fr.hyu.olympmonsters;

import java.io.File;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Parrot.Variant;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionData;
import org.bukkit.projectiles.ProjectileSource;

import fr.hyu.olymp.Main;


public class Monster {

	//BASICS
	private String name;
	private EntityType entityType;
	
	//ENTITYINFOS
	private int setAge = 0;
	private boolean setAdult = true;
	private boolean setBaby = false;
	private boolean AgeLock = true;
	private boolean setBreed = false;
	//private boolean addCustomEffect = false;
	private PotionData setBasePotionData;
	private Color setColor = Color.WHITE;
	private int setDuration = 0;
	private int setDurationOnUse = 0;
	private Particle setParticle = Particle.SMOKE_LARGE;
	private float setRadius = 0;
	private float setRadiusOnUse = 0;
	private float setRadiusPerTick = 0;
	private int SetReapplicationDelay = 0;
	private ProjectileSource setSource = null;
	private int setWaitTime = 0;
	private boolean setMarker = false;
	private boolean setSmall = false;
	private boolean setVisible = false;
	private boolean setArms = false;
	private boolean setBasePlate = false;
	private boolean setAwake = false;
	private int setExplosionRadius = 0;
	private int setFuseTicks = 0;
	private int setMaxFuseTicks = 0;
	private boolean setPowered = false;
	private String setCarriedBlock = "to fill"; // utilisé getAsString je crois 
	private String setCarriedMaterial = "to fill"; // la meme chose que block je crois  getmaterial 
	private Location setBeamTarget;
	private boolean setShowingBottom = false;
	private boolean setDropItem = false;
	private boolean setHurtEntities = false;
	private boolean setLaser = true;
	private Horse.Color setHorseColor = Horse.Color.WHITE;
	private Horse.Style setHorseStyle = Horse.Style.NONE;
	private int setConversionTime = 0;
	private boolean setPlayerCreated = false;
	private Llama.Color setLlameColor = Llama.Color.CREAMY;
	private int setStrength = 0;
	private boolean setCarryingChest = false;
	private String setMuhsroomCowVariant = "RED";
	private Ocelot.Type setCatType = Type.WILD_OCELOT;
	private boolean setTrusting = false;
	private Parrot.Variant setParrotVariant = Variant.GREEN;
	private boolean setSaddle = false;
	private int setAnger = 0;
	private boolean setAngry = false;
	private Rabbit.Type setRabbitType = Rabbit.Type.GOLD;
	private boolean setSheared = false;
	private BlockFace setAttachedFace = BlockFace.NORTH;
	private float setPeek = 0;
	private int setSize = 0;
	private boolean setCharging = false;
	private Villager.Profession setProfession = Profession.LIBRARIAN;
	private int setVillagerExperience = 0;
	private int setVillagerLevel = 0;
	private Color setCollarColor = Color.WHITE;
	

	//STATS
	private int level;
	private int vitalityNative;
	private int defenceNative;
	private int strengthNative;
	private int enduranceNative;
	private int intelligenceNative;
	private int manaCapacityNative;
	
	//EQUIPPEDITEMS
	private String mainhand;
	private String offhand;
	private String head;
	private String chest;
	private String legs;
	private String feet;
	
	//DROPS
	private int droppableGolds;
	private int droppableExperiences;
	private List<String> droppableItems;
	
	public Monster(String name) {
		
		File file = new File(Main.INSTANCE.getDataFolder(), "OlympMonsters/monsters/" + name + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		this.name = name;
		//this.entityType = 
	}
	
	//GETTERS
	public String getName() {
		return name;
	}
	public EntityType getEntityType() {
		return entityType;
	}
	public int getSetAge() {
		return setAge;
	}
	public boolean isSetAdult() {
		return setAdult;
	}
	public boolean isSetBaby() {
		return setBaby;
	}
	public boolean isAgeLock() {
		return AgeLock;
	}
	public boolean isSetBreed() {
		return setBreed;
	}
	public PotionData getSetBasePotionData() {
		return setBasePotionData;
	}
	public Color getSetColor() {
		return setColor;
	}
	public int getSetDuration() {
		return setDuration;
	}
	public int getSetDurationOnUse() {
		return setDurationOnUse;
	}
	public Particle getSetParticle() {
		return setParticle;
	}
	public float getSetRadius() {
		return setRadius;
	}
	public float getSetRadiusOnUse() {
		return setRadiusOnUse;
	}
	public float getSetRadiusPerTick() {
		return setRadiusPerTick;
	}
	public int getSetReapplicationDelay() {
		return SetReapplicationDelay;
	}
	public ProjectileSource getSetSource() {
		return setSource;
	}
	public int getSetWaitTime() {
		return setWaitTime;
	}
	public boolean isSetMarker() {
		return setMarker;
	}
	public boolean isSetSmall() {
		return setSmall;
	}
	public boolean isSetVisible() {
		return setVisible;
	}
	public boolean isSetArms() {
		return setArms;
	}
	public boolean isSetBasePlate() {
		return setBasePlate;
	}
	public boolean isSetAwake() {
		return setAwake;
	}
	public int getSetExplosionRadius() {
		return setExplosionRadius;
	}
	public int getSetFuseTicks() {
		return setFuseTicks;
	}
	public int getSetMaxFuseTicks() {
		return setMaxFuseTicks;
	}
	public boolean isSetPowered() {
		return setPowered;
	}
	public String getSetCarriedBlock() {
		return setCarriedBlock;
	}
	public String getSetCarriedMaterial() {
		return setCarriedMaterial;
	}
	public Location getSetBeamTarget() {
		return setBeamTarget;
	}
	public boolean isSetShowingBottom() {
		return setShowingBottom;
	}
	public boolean isSetDropItem() {
		return setDropItem;
	}
	public boolean isSetHurtEntities() {
		return setHurtEntities;
	}
	public boolean isSetLaser() {
		return setLaser;
	}
	public Horse.Color getSetHorseColor() {
		return setHorseColor;
	}
	public Horse.Style getSetHorseStyle() {
		return setHorseStyle;
	}
	public int getSetConversionTime() {
		return setConversionTime;
	}
	public boolean isSetPlayerCreated() {
		return setPlayerCreated;
	}
	public Llama.Color getSetLlameColor() {
		return setLlameColor;
	}
	public int getSetStrength() {
		return setStrength;
	}
	public boolean isSetCarryingChest() {
		return setCarryingChest;
	}
	public String getSetMuhsroomCowVariant() {
		return setMuhsroomCowVariant;
	}
	public Ocelot.Type getSetCatType() {
		return setCatType;
	}
	public boolean isSetTrusting() {
		return setTrusting;
	}
	public Parrot.Variant getSetParrotVariant() {
		return setParrotVariant;
	}
	public boolean isSetSaddle() {
		return setSaddle;
	}
	public int getSetAnger() {
		return setAnger;
	}
	public boolean isSetAngry() {
		return setAngry;
	}
	public Rabbit.Type getSetRabbitType() {
		return setRabbitType;
	}
	public boolean isSetSheared() {
		return setSheared;
	}
	public BlockFace getSetAttachedFace() {
		return setAttachedFace;
	}
	public float getSetPeek() {
		return setPeek;
	}
	public int getSetSize() {
		return setSize;
	}
	public boolean isSetCharging() {
		return setCharging;
	}
	public Villager.Profession getSetProfession() {
		return setProfession;
	}
	public int getSetVillagerExperience() {
		return setVillagerExperience;
	}
	public int getSetVillagerLevel() {
		return setVillagerLevel;
	}
	public Color getSetCollarColor() {
		return setCollarColor;
	}
	public int getLevel() {
		return level;
	}
	public int getVitalityNative() {
		return vitalityNative;
	}
	public int getDefenceNative() {
		return defenceNative;
	}
	public int getStrengthNative() {
		return strengthNative;
	}
	public int getEnduranceNative() {
		return enduranceNative;
	}
	public int getIntelligenceNative() {
		return intelligenceNative;
	}
	public int getManaCapacityNative() {
		return manaCapacityNative;
	}
	public String getMainhand() {
		return mainhand;
	}
	public String getOffhand() {
		return offhand;
	}
	public String getHead() {
		return head;
	}
	public String getChest() {
		return chest;
	}
	public String getLegs() {
		return legs;
	}
	public String getFeet() {
		return feet;
	}
	public int getDroppableGolds() {
		return droppableGolds;
	}
	public int getDroppableExperiences() {
		return droppableExperiences;
	}
	public List<String> getDroppableItems() {
		return droppableItems;
	}
}

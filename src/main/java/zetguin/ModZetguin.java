package zetguin;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import zetguin.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = ModZetguin.ID, name = "Zetguin", version = ModZetguin.VERSION)
public class ModZetguin {
	
	public static final String ID = "Zetguin";
	public static final String VERSION = "1.1";
	public static final String MODEL_DIR = "zetguin:textures/model/";
	public static final String CLIENT_PROXY_CLASS = "zetguin.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "zetguin.proxy.CommonProxy";
	
	// penguin stuff
	public static int idMobPenguin;
	//public static HashMap<Integer, TFEntityEggInfo> entityEggs = new LinkedHashMap<Integer, TFEntityEggInfo>();
	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Instance(ID)
	public static ModZetguin instance;
	
	public ModZetguin() {
		ModZetguin.instance = this;
		
	}
	
    @EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
    	
    	idMobPenguin = 191;
    	proxy.registerRenders();

	}
    
    @EventHandler
	public void load(FMLInitializationEvent evt) {
    	// twilightforest.entity.passive.EntityTFPenguin.class, "Glacier Penguin", idMobPenguin, 0x12151b, 0xf9edd2
    	
		// CREATUREs
    	//EntityRegistry.registerGlobalEntityID(zetguin.EntityTFPenguin.class, "Zetguin", idMobPenguin);
    	EntityRegistry.registerModEntity(zetguin.EntityTFPenguin.class, "Zetguin", idMobPenguin, ModZetguin.instance, 80, 3, true);

    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 3, 8, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(12));
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 3, 5, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(13));
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 4, 10, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(10));
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(11));
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 4, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(30));
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 4, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(31));

    	//LanguageRegistry.instance().addStringLocalization("entity.Zetguin.name", "en_US", "Penguin!");

    	/*
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 191), 
				Blocks.snow,
				Items.egg);
    	*/
    	
    	
    
    }
	
	/**
	 * Post init
	 */
    @EventHandler
	public void postInit(FMLPostInitializationEvent evt) 
	{

	}

}

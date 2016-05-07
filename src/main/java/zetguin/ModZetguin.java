package zetguin;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import zetguin.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModZetguin.ID, name = "Zetguin", version = ModZetguin.VERSION)
public class ModZetguin {
	
	public static final String ID = "Zetguin";
	public static final String VERSION = "0.2";
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
  

	}
    
    @EventHandler
	public void load(FMLInitializationEvent evt) {
    	// twilightforest.entity.passive.EntityTFPenguin.class, "Glacier Penguin", idMobPenguin, 0x12151b, 0xf9edd2
    	
		// creatures
    	EntityRegistry.registerGlobalEntityID(zetguin.EntityTFPenguin.class, "Zetguin", idMobPenguin);
    	EntityRegistry.registerModEntity(zetguin.EntityTFPenguin.class, "Zetguin", idMobPenguin, ModZetguin.instance, 80, 3, true);
    	
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 3, 8, EnumCreatureType.creature, BiomeGenBase.icePlains);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 3, 5, EnumCreatureType.creature, BiomeGenBase.iceMountains);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 4, 10, EnumCreatureType.creature, BiomeGenBase.frozenOcean);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 8, 2, 4, EnumCreatureType.creature, BiomeGenBase.frozenRiver);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 4, 2, 4, EnumCreatureType.creature, BiomeGenBase.taigaHills);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 4, 2, 4, EnumCreatureType.creature, BiomeGenBase.coldTaiga);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 4, 2, 4, EnumCreatureType.creature, BiomeGenBase.coldTaigaHills);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 7, 2, 4, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
    	EntityRegistry.addSpawn(zetguin.EntityTFPenguin.class, 7, 2, 4, EnumCreatureType.creature, BiomeGenBase.megaTaigaHills);

    	LanguageRegistry.instance().addStringLocalization("entity.Zetguin.name", "en_US", "Penguin!");

    	/*
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 191), 
				Blocks.snow,
				Items.egg);
    	*/
    	
    	proxy.registerRenders();
    
    }
	
	/**
	 * Post init
	 */
    @EventHandler
	public void postInit(FMLPostInitializationEvent evt) 
	{

	}

}

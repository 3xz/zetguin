package zetguin.proxy;

import zetguin.ModelTFPenguin;
import zetguin.RenderTFBird;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() 
	{
		RenderingRegistry.registerEntityRenderingHandler(zetguin.EntityTFPenguin.class, new RenderTFBird(new ModelTFPenguin(), 1.0F, "penguin.png"));
	}
}

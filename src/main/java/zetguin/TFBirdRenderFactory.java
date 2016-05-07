package zetguin;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TFBirdRenderFactory implements IRenderFactory<EntityTFBird> {
	
	@Override
	public Render<? super EntityTFBird> createRenderFor(RenderManager manager) {
		return new RenderTFBird(manager);
	}

}

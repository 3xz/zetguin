package zetguin.proxy;

import zetguin.EntityTFPenguin;
import zetguin.ModelTFPenguin;
import zetguin.RenderTFBird;
import zetguin.TFBirdRenderFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() 
	{
		//RenderingRegistry.registerEntityRenderingHandler(zetguin.EntityTFPenguin.class, new RenderTFBird(Minecraft.getMinecraft().getRenderManager(), new ModelTFPenguin(), 1.0F, "penguin.png"));
		//registaerEntityRenderer(zetguin.EntityTFPenguin.class, RenderTFBird.class);
		RenderingRegistry.registerEntityRenderingHandler(zetguin.EntityTFPenguin.class, new TFBirdRenderFactory());

	}


	private static <E extends Entity> void registerEntityRenderer(Class<E> entityClass, Class<? extends Render<E>> renderClass)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<E>(renderClass));
    }
    
    private static class EntityRenderFactory<E extends Entity> implements IRenderFactory<E>
    {
        private Class<? extends Render<E>> renderClass;

        private EntityRenderFactory(Class<? extends Render<E>> renderClass)
        {
            this.renderClass = renderClass;
        }

        @Override
        public Render<E> createRenderFor(RenderManager manager) 
        {
            Render<E> renderer = null;

            try 
            {
                renderer = renderClass.getConstructor(RenderManager.class).newInstance(manager);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            return renderer;
        }
    }
}

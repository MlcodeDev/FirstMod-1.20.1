package net.mlcode.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mlcode.tutorialmod.Block.ModBlocks;
import net.mlcode.tutorialmod.Item.ModFoods;
import org.slf4j.Logger;
import net.mlcode.tutorialmod.Item.ModItems;

@Mod(TutorialMod.MOD_ID)

public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK);

            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.NETHER_SAPPHIRE_ORE);
            event.accept(ModBlocks.END_STONE_SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

            event.accept(ModItems.METAL_DETECTOR);
            event.accept(ModBlocks.SOUND_BLOCK);

            event.accept(ModItems.STRAWBERRY);
            event.accept(ModBlocks.SOUND_BLOCK);
            event.accept(ModItems.PINE_CONE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}

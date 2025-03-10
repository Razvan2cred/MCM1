package net.razvan.un_gunoi_de_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.razvan.un_gunoi_de_mod.ModCreativeModeTabs;
import net.razvan.un_gunoi_de_mod.block.ModBlocks;
import net.razvan.un_gunoi_de_mod.item.Moditems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnModGunoias.MOD_ID)
public class UnModGunoias {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "un_gunoi_de_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

   public UnModGunoias(FMLJavaModLoadingContext context) {
       IEventBus modEventBus = context.getModEventBus();

       ModCreativeModeTabs.register(modEventBus);

       ModBlocks.register(modEventBus);
       Moditems.register(modEventBus); // Ensure this is here before using the item!

       modEventBus.addListener(this::commonSetup);
       modEventBus.addListener(this::addCreative);

       MinecraftForge.EVENT_BUS.register(this);
   }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
            if (Moditems.RAZVANITE.isPresent()) {
                event.accept(Moditems.RAZVANITE.get());
                event.accept(Moditems.RAW_RAZVANITE.get());
                event.accept(Moditems.RAZVANITE_SWORD.get());
                event.accept(Moditems.RAZVANITE_DETECTOR.get());
                event.accept(ModBlocks.RAZVANITE_BLOCK.get());
            }
   }
   /*
   private void addCreative(BuildCreativeModeTabContentsEvent event) {
    // Use the BLOCK ITEM, not the block itself
    event.accept(Moditems.ITEMS.getEntries().stream()
        .filter(item -> item.getId().getPath().equals("razvanite_block"))
        .findFirst()
        .orElseThrow()
        .get()
    );
}
    */



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

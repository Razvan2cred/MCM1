package net.razvan.un_gunoi_de_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razvan.un_gunoi_de_mod.UnModGunoias;

/*public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UnModGunoias.MOD_ID);

    public static final RegistryObject<Item> RAZVANITE = ITEMS.register("razvanite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}*/
public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UnModGunoias.MOD_ID); // Ensure MOD_ID matches your main class

    public static final RegistryObject<Item> RAZVANITE = ITEMS.register("razvanite",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(UnModGunoias.MOD_ID + ":razvanite")))
            ));
                public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
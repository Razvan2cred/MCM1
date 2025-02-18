package net.razvan.un_gunoi_de_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razvan.un_gunoi_de_mod.UnModGunoias;
import net.razvan.un_gunoi_de_mod.item.custom.RazvaniteItem;

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
    public static final RegistryObject<Item> RAW_RAZVANITE = ITEMS.register("raw_razvanite",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(UnModGunoias.MOD_ID + ":raw_razvanite")))
            ));
    public static final RegistryObject<Item> RAZVANITE_SWORD = ITEMS.register("razvanite_sword",
            () -> new SwordItem(ToolMaterial.NETHERITE, 14,-2.4f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(UnModGunoias.MOD_ID + ":razvanite_sword")))
            ));
    public static final RegistryObject<Item> RAZVANITE_DETECTOR = ITEMS.register("razvanite_detector",
            () -> new RazvaniteItem(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(UnModGunoias.MOD_ID + ":razvanite_detector")))
            ));
                public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
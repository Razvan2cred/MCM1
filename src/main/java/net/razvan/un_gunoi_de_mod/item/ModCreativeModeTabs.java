package net.razvan.un_gunoi_de_mod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.razvan.un_gunoi_de_mod.item.Moditems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnModGunoias.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GUNOI_TAB = CREATIVE_MODE_TABS.register("gunoi_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.RAZVANITE.get()))
                    .title(Component.translatable("creativetab.gunoi_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.RAZVANITE.get());
                        pOutput.accept(Moditems.RAW_RAZVANITE.get());
                        pOutput.accept(Moditems.RAZVANITE_SWORD.get());

                        pOutput.accept(Items.DANDELION);
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
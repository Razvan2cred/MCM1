package net.razvan.un_gunoi_de_mod.item.custom;

import net.minecraft.client.renderer.item.properties.numeric.Damage;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class RazvaniteItem extends Item {

    public RazvaniteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                player.hurt(player.damageSources().generic(), 2.0f);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.getCommandSenderWorld().playSound(null, player.blockPosition(),SoundEvents.CAT_PURREOW, SoundSource.PLAYERS,1.0f,1.0f);
        ///Component.literal("Found "+ I18n.get(block.getDescriptionId())+"at"+
        ///"("+blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.ANCIENT_DEBRIS) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
}

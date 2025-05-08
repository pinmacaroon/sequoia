/**
 * Copyright (c) 2025 pin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * https://pinmacaroon.github.io/mit.txt
 */
package com.github.pinmacaroon.sequoia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

/**
 * conditional falling block, based on {@link net.minecraft.block.FallingBlock}
 */
public class ConditionalFallingBlock extends FallingBlock {
    private final TagKey<Block> hanger_blocks;
    private final boolean damages;
    private final boolean breaks;

    /**
     * constructor
     *
     * @param settings block settings
     * @param hangblock {@link net.minecraft.registry.tag.TagKey<net.minecraft.block.Block>} that keeps {@link ConditionalFallingBlock} hanging
     * @param damages should the block bonk entities under it
     * @param breaks should the block fall apart when landing after a big fall
     */
    public ConditionalFallingBlock(Settings settings, TagKey<Block> hangblock, boolean damages, boolean breaks) {
        super(settings);
        this.hanger_blocks = hangblock;
        this.damages = damages;
        this.breaks = breaks;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (
                canFallThrough(world.getBlockState(pos.down())) && pos.getY()
                        >= world.getBottomY() && !world.getBlockState(pos.up()).isIn(hanger_blocks)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
        }
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if(fallingBlockEntity.timeFalling >= 13 && world.getBlockState(pos).isIn(hanger_blocks) && breaks){
            world.breakBlock(pos, false);
            dropStack(world, pos, new ItemStack(ModBlocks.SEQUOIA_SAPLING, world.random.nextInt(2)));
            world.playSound(null, pos, SoundEvents.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            if(world.random.nextInt(6) >= 5){
                SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
                if (silverfishEntity != null) {
                    silverfishEntity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
                    world.spawnEntity(silverfishEntity);
                    silverfishEntity.playSpawnEffects();
                }
            }
        }
    }

    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        if(damages) entity.setHurtEntities(2f, 4);
    }
}

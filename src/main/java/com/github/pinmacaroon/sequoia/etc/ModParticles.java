package com.github.pinmacaroon.sequoia.etc;

import com.github.pinmacaroon.sequoia.Sequoia;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static DefaultParticleType BI_HEART = register("bi_heart", FabricParticleTypes.simple());

    public static DefaultParticleType register(String id, DefaultParticleType particle){
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Sequoia.MOD_ID, id), particle);
    }
    public static void registerModParticles() {
        Sequoia.LOGGER.info("registering particles for " + Sequoia.MOD_ID);
    }
}

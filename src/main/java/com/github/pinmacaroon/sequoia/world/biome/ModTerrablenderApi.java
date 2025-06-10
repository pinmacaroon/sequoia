package com.github.pinmacaroon.sequoia.world.biome;

import com.github.pinmacaroon.sequoia.Sequoia;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderApi implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(Sequoia.MOD_ID, "overworld"), RegionType.OVERWORLD, 3));
    }
}

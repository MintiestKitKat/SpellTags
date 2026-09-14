package com.mintiestkitkat.kkspelltags.component;

import com.mintiestkitkat.kkspelltags.SpellTagsMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.DataComponents.createDataComponents(Registries.DATA_COMPONENT_TYPE, SpellTagsMod.MODID);

    public static final DeferredHolder<DataComponentType<?>,DataComponentType<Spelltag>> SPELL = register("spell", builder -> builder.persistent(Spelltag.CODEC));


    private static <T> DeferredHolder<DataComponentType<?>,DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>>builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, ()-> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}

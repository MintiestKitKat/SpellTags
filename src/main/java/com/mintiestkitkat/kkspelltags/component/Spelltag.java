package com.mintiestkitkat.kkspelltags.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.awt.*;
import java.util.function.Consumer;

public record Spelltag(String spellTagName) implements TooltipProvider {
    public static final Spelltag DEFAULT = new Spelltag("empty");
    public static final Codec<Spelltag> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("spellTagName").forGetter(Spelltag::spellTagName)
            ).apply(instance, Spelltag::new)
        );

    public static final StreamCodec<? super RegistryFriendlyByteBuf, Spelltag> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, Spelltag::spellTagName,
            Spelltag::new
    );

    public static Spelltag setSpellTagName(String name) {
        return new Spelltag(name);
    }

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        consumer.accept(Component.translatable("tooltip.kkspelltags.spelltag").append(":  "+spellTagName));
    }
}

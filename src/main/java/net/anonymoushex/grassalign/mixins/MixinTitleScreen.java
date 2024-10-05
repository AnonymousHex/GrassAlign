package net.anonymoushex.grassalign.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen
{
    @Inject(method="render", at=@At("TAIL"), cancellable = true)
    public void renderText(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_, CallbackInfo ci)
    {
        Minecraft.getInstance().font.draw(p_96562_, "GrassAlign Loaded", 2, 2, 0xFFFFFF);
    }
}

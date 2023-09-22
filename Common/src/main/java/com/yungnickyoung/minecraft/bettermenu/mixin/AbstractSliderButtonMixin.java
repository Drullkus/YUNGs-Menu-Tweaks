package com.yungnickyoung.minecraft.bettermenu.mixin;

import com.yungnickyoung.minecraft.bettermenu.BetterMenuCommon;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractSliderButton.class)
public abstract class AbstractSliderButtonMixin extends AbstractWidget {

    @Shadow protected abstract void setValue(double $$0);

    @Shadow protected double value;

    public AbstractSliderButtonMixin(int $$0, int $$1, int $$2, int $$3, Component $$4) {
        super($$0, $$1, $$2, $$3, $$4);
    }

    /**
     * Allows scroll wheel to affect sliders.
     */
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollAmount) {
        if (BetterMenuCommon.CONFIG.enableMouseScrollOnSliders) {
            if (scrollAmount > 0.0) {
                this.setValue(this.value + 0.01);
            } else if (scrollAmount < 0.0) {
                this.setValue(this.value - 0.01);
            }

            return true;
        }

        return false;
    }
}

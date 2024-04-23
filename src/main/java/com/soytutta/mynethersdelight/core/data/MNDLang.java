//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soytutta.mynethersdelight.core.data;

import java.util.HashSet;
import java.util.Set;

import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.soytutta.mynethersdelight.common.registry.MNDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class MNDLang extends LanguageProvider {
    public MNDLang(DataGenerator generatorIn) {
        super(generatorIn, "mynethersdelight", "en_us");
    }

    protected void addTranslations() {
        Set<RegistryObject<Block>> blocks = new HashSet(MNDBlocks.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet(MNDItems.ITEMS.getEntries());
        blocks.remove(MNDBlocks.WALL_POWDERY_TORCH);
        blocks.remove(MNDBlocks.POWDERY_WALL_SIGN);
        blocks.forEach((b) -> {
            String name = ((Block)b.get()).getDescriptionId().replaceFirst("block.mynethersdelight.", "");
            name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
            this.add(((Block)b.get()).getDescriptionId(), name);
        });
        items.removeIf((i) -> {
            return i.get() instanceof BlockItem;
        });
        items.forEach((i) -> {
            String name = ((Item)i.get()).getDescriptionId().replaceFirst("item.mynethersdelight.", "");
            name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("Of", "of");
            name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("And", "and");
            name = toTitleCase(this.correctBlockItemName(name), "_").replaceAll("With", "with");
            this.add(((Item)i.get()).getDescriptionId(), name);
        });
        this.add("itemGroup.mynethersdelight", "My Nether's Delight");
        this.add("effect.mynethersdelight.g_pungent", "Pungent");
        this.add("effect.mynethersdelight.b_pungent", "Pungent");
        this.add("mynethersdelight.jei.forgoting", "Forgoting");
        this.add("mynethersdelight.jei.forgoting.nether", "Will only forget in the nether");
        this.add("mynethersdelight.jei.forgoting.accelerators", "Sped up by adjacent activators (see below)");
        this.add("mynethersdelight.jei.forgoting.light", "Sped up by adjacent flames (see below)");
        this.add("mynethersdelight.jei.forgoting.fluid", "Sped up by adjacent lava");
        this.add("mynethersdelight.block.feast.use_knife", "You need a Knife to cut this.");
        this.add("farmersdelight.tooltip.strider_egg", "Nourished by 1 Harmful Effect");
        this.add("farmersdelight.tooltip.hot_cream", "Burning Effects");
        this.add("farmersdelight.tooltip.strider_feed.when_feeding", "When fed to a Strider");
    }

    public String getName() {
        return "Lang Entries";
    }

    public static String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        String[] var4 = stringArray;
        int var5 = stringArray.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }

        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }

    public String correctBlockItemName(String name) {
        if (!name.endsWith("_bricks") && name.contains("bricks")) {
            name = name.replaceFirst("bricks", "brick");
        }

        if ((name.contains("_fence") || name.contains("_button")) && name.contains("planks")) {
            name = name.replaceFirst("_planks", "");
        }

        return name;
    }
}
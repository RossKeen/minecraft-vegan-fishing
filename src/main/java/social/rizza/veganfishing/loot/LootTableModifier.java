package social.rizza.veganfishing.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LootTableModifier {

    private static final Logger logger = LoggerFactory.getLogger("random-fishing");

    private static final Set<Identifier> fishingLootTableIds = Set.of(
            Identifier.fromNamespaceAndPath("minecraft", "gameplay/fishing/fish")
    );

    public static void modifyLootTable() {
        LootTableEvents.REPLACE.register((key, original, source, registries) -> {
            if (!fishingLootTableIds.contains(key.identifier())) {
                return null;
            }

            LootPool.Builder lootPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .conditionally(LootItemRandomChanceCondition.randomChance(1f).build());

            lootPool.add(LootItem.lootTableItem(Items.KELP)
                    .setWeight(60)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));

            lootPool.add(LootItem.lootTableItem(Items.CLAY_BALL)
                    .setWeight(25)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 5f))));

            lootPool.add(LootItem.lootTableItem(Items.SEA_PICKLE)
                    .setWeight(13)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));

            lootPool.add(LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                    .setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f))));

            lootPool.add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)
                    .setWeight(1)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f))));


            LootTable.Builder tableBuilder = LootTable.lootTable();
            tableBuilder.pool(lootPool.build());

            return tableBuilder.build();
        });
    }
}

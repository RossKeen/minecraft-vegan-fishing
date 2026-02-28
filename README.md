# Vegan Fishing 🎣🌿

A Fabric mod for Minecraft Java 1.21.1 that replaces the fish loot table with plant-based and ocean-themed alternatives, allowing players to enjoy the relaxing fishing minigame without harming any virtual wildlife.

## Features

- Replaces the fish loot category entirely with plant-based and ocean-themed alternatives
- Preserves the original weight distribution so fishing still feels balanced
- Junk and treasure drops are unchanged
- Luck of the Sea enchantment continues to work as normal
- Compatible with standard Fabric installations (see Compatibility below)

## Fish Loot Table Changes

The vanilla fish category (85% base chance of occurring) is replaced with the following:

| Item | Weight | Base Chance | LotS 1 | LotS 2 | LotS 3 |
|------|--------|-------------|--------|--------|--------|
| Kelp (×1) | 60 | ~51.0% | ~50.9% | ~50.8% | ~50.7% |
| Clay Ball (×2–5) | 25 | ~21.3% | ~21.2% | ~21.2% | ~21.1% |
| Sea Pickle (×1) | 13 | ~11.1% | ~11.0% | ~11.0% | ~11.0% |
| Prismarine Shard (×1–2) | 1 | ~0.85% | ~0.85% | ~0.85% | ~0.85% |
| Prismarine Crystals (×1–2) | 1 | ~0.85% | ~0.85% | ~0.85% | ~0.85% |

The overall 85%/10%/5% split between fish/junk/treasure and the effect of Luck of the Sea on those proportions is preserved exactly as in vanilla (see https://minecraft.wiki/w/Fishing).

### Why these items?

- **Kelp** — the most natural thing to pull up from the water. Can be smelted into dried kelp for an early-game food source, mirroring how you'd want to cook cod before eating it anyway.
- **Clay Ball** — dredged up from the riverbed or lakebed. Not glamorous, but useful.
- **Sea Pickle** — rarer than the others, reflecting its real scarcity (only found naturally in warm ocean biomes). Perhaps this one drifted from warmer waters. Useful as an underwater light source, and can only be farmed on coral blocks, so fishing is a meaningful alternative source.
- **Prismarine Shard / Prismarine Crystal** — the rarest catches, split equally between the two types. With enough patience you could theoretically accumulate enough to craft a sea lantern without ever visiting an ocean monument — though at roughly 0.85% each you'd need to fish a *lot*. The ocean monument remains the far more practical source.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.1
2. Install the [Fabric API](https://modrinth.com/mod/fabric-api)
3. Drop the mod `.jar` into your `mods` folder

## Compatibility

This mod replaces the `minecraft:gameplay/fishing/fish` loot table. It should be compatible with most other mods unless they also modify this specific table.

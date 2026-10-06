# BlockClub Server

BlockClub is a guild-driven Minecraft server project built around persistent player plots, rotating Frontier campaigns, guild contribution, progression, and cross-platform Java/Bedrock play.

## Current stack

- Paper 1.21.x
- PlotSquared
- Multiverse-Core
- WorldGuard
- LuckPerms
- Geyser + Floodgate
- ItemsAdder
- Denizen
- Custom BlockClub plugins

## Core gameplay loop

Join → choose a guild → claim a natural-terrain plot → gather/build → contribute to your guild → enter the Frontier → compete during the campaign → earn progression and rewards → return for the next cycle.

## Guilds

- Hearthbound
- Ironsworn
- Starweavers

## Repository layout

```
docs/       Design and technical documentation
denizen/    BlockClub Denizen scripts
plugins/    Source/config documentation for custom BlockClub plugins
configs/    Sanitized example configuration files only
```

## Important

This repository should not contain server credentials, private keys, secrets, player data, live world folders, logs, caches, or unreviewed production configuration.

See [ROADMAP.md](ROADMAP.md) for current development priorities.

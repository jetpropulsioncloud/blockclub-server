# Phase 1 — Player Safety & Stabilization

Status: **IN PROGRESS**. This is a test plan, **not a sign-off**. Nothing has been deployed to production.

## Findings

- **Plot sanitation**: In the inspected local `BlockClubPlotWorldRules-1.3.1-ChunkSafety-TEST.jar`, PlotSquared post-clear/delete cleanup scanned every intersecting chunk in full. Neighboring homes that share a chunk could lose decorative ores/amethyst. A separate test-only v1.3.2 patch now restricts this work to exact plot X/Z boundaries and batches block checks.
- **Version provenance**: The GitHub `BlockClubPlotWorldRules-1.3.1.jar` differs from the conversation's 1.3.1 ChunkSafety test build. **Do not install the new patch on production until the active version is identified and compared.**
- **Frontier**: The GitHub `BlockClubGuildFrontier-4.6.4.jar` uses larger bundled defaults. The proposed 1000×1000 profile is not confirmed live. A campaign reset is destructive and must only be tested in a disposable copy with full backups.
- **Trade**: Static guards exist, but double-buy, disconnect and restart atomicity still need integration testing.
- **Permissions**: WorldGuard, PlotSquared, BlockClubWorldGuard, Frontier, EssentialsX teleports and LuckPerms must be tested together, including Java/Bedrock.
- **Public binaries**: The public repository contains third-party JAR files, including filenames marked Premium/Pro. Review licenses and move unapproved distributables to private artifact storage through a separate, reviewed cleanup.

## Tests to complete before launch

| Gate | Pass condition | Status |
|---|---|---|
| Plot restarts | Placed ore, amethyst and builds survive restart and chunk load | Pending on Paper |
| Plot clear/delete | No changes outside exact plot boundaries, including shared chunks | Mock passed; Paper pending |
| Fresh chunks | Natural ores and generated resources sanitized as intended | Pending on Paper |
| Frontier reset | 10 full cycles, safe evacuation, inventories retained, valid three-camp placement | Pending |
| Trade integrity | No duplicated or missing items from concurrent buys, cancellation, disconnect or restart | Pending |
| Protection | Other plots, guild camps and regions cannot be edited or bypassed | Pending |
| Crossplay | Java and Bedrock can complete onboarding, trade, claims, teleport safely | Pending |
| Restore drill | World, PlotSquared DB, plugin data and configs restore together | Pending |

## Safe test order

1. Copy production to a disposable Paper test server; keep plugin versions and worlds aligned.
2. Back up the entire plot world, PlotSquared database, guild and market data, and configs; verify rollback.
3. Test plot clear/delete and chunk reload with side-by-side plots.
4. Test double purchases, disconnects and restarts while trading.
5. Test permissions and teleport behavior as default player, guild member and operator; include Bedrock.
6. Test Frontier generation/reset with three schematics and the compact-border profile on multiple seeds.
7. Review server logs and TPS/MSPT; only then promote verified builds.

## Dependency checkpoints

- Frontier requires LuckPerms and GroupDepositPoints.
- PlotSquared and WorldGuard require WorldEdit (provided by FastAsyncWorldEdit if its manifest/provider loads correctly).
- BlockClubWorldGuard requires WorldGuard.
- BlockClubLevelToolsArmor and BlockClubIronswornGuard require LevelTools.
- EcoEnchants requires eco; AdvancedGUI and Pl-Hide-Pro require PacketEvents.

No automatic live-world changes, repository binary deletions, or updates to main are part of this draft.

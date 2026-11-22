# BlockClub Phase 2 — Economy and Guild Balance (test candidate)

**Status: coded separately, not deployed and not live-Paper-tested.** This document records proposed settings and the standalone local build package. Do **not** treat this draft PR as approval to install binaries. Phase 1 remains tracked in PR #1.

## Diplomacy: v1.3.0 GKP + v0.1.8 Trade test builds

- The existing trade eligibility rules remain in place (real exchanges, meaningful items, per-player and per-guild limits). A new rolling 24-hour *unordered guild-pair* budget credits the first four eligible trades at +3 each direction, the next six at +1, then zero. **Max +18/day per guild pair**. Trading itself remains unrestricted.
- PvP political effects are restricted to configured Frontier worlds. For each *unordered player pair*, the first eligible kill in 24 hours gives the killer guild −5 and the reverse guild −2; the second gives −2/−1; later kills give zero. The 120-second repeat cooldown remains.
- PvP influence budgets: −15 points per killer per guild pair and −50 aggregate points per unordered guild pair in rolling 24h. Budgets persist across restarts. These affect political scores, not PvP permissions or drops.
- GKP score decay is proposed as **1 point toward neutral every 6 hours**, instead of every 30 minutes.
- **Not implemented:** persistent treaty/state hysteresis; alliance and war labels still follow score thresholds directly.

## Contributions and compact Frontier

| GP threshold | Territory radius |
|---:|---:|
| 0 | 75 |
| 10,000 | 90 |
| 30,000 | 110 |
| 70,000 | 125 |
| 150,000 | 140 |

- Frontier 1000×1000, camps at least 350 blocks apart, campaign 120h.
- GDP decay 1% **daily** rather than hourly.
- Anti-farm raw-GP hourly bands 800 full, 1800 half, 4000 low; automated material bands tightened.
- Remove invalid tier `sk` reward commands; retain stable internal IDs (`blacksmith`, `trader`, `enchanter`).

**Unresolved:** player-based donation budgets still allow larger guilds greater aggregate GP. Do not claim population balance until contributor-normalized mechanics are implemented and measured.

## Specialties

- Ironsworn: LevelTools anvil XP combine `HIGHER_OF_BOTH`, slower item XP scaling, eliminate 41 overpowered LevelTools reward actions from defaults (including Sharpness X, Power X, Fortune V), keep Efficiency VI.
- Hearthbound: FarmingUpgrade efficiency harvesting radius coefficient 0.20 (from 0.30); retain cooking XP safeguards.
- Starweavers: EcoEnchants anvil enchantment stacking cap 6 (previously unlimited).
- Existing above-cap items are not retroactively modified. Check how GuildMechanics rewrites FarmingUpgrade/EcoEnchants configurations on enable.

## Testing and migration

Source-led patch JARs, full test profile, offline Java tests, profile validator, and non-destructive config merge tooling were generated as separate conversation artifacts. **This PR intentionally does not upload unreviewed binary JARs, server data, or vendor plugins**.

Before release, test on disposable Paper with backup and rollback of plugin configs/data/worlds:
1. Two-way trade scores, budgets and restarts; normal barter items unaffected.
2. PvP world scoping, repeated kills, caps and restarts; no negative effects in the Hub or Plot World.
3. GP earned per person and per guild at 3/10/25 active donors; time to each territory tier.
4. Ironsworn high-level TTK and enchant compatibility; Hearthbound real farming output; Starweaver enchant production.
5. 1000×1000 Frontier camp-placement and 10 complete reset cycles; include Java/Bedrock.

All values are **initial balance targets**, not tested production defaults.

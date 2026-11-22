# Phase 2B — Population Scaling & Stable Diplomacy (test candidate)

Status: **coded and packaged locally, not installed and not Paper-tested**. This is a follow-up to [Phase 2 PR #2](https://github.com/jetpropulsioncloud/blockclub-server/pull/2), independent of [Phase 1 PR #1](https://github.com/jetpropulsioncloud/blockclub-server/pull/1). The exact build sources, tests, migration profile and test JARs are in the downloadable Phase 2B coding bundle shared in the chat. **No binary release is committed to this public repository.**

## Balancing philosophy

**Do not balance GP on total registered guild size or momentary online headcount.** Count each UUID as one *eligible active member* after 45 engaged minutes on two different UTC days in the last 168 hours. Activity is measured from actual movement, interaction, block work and combat, not being logged in or remaining AFK. Persist daily/hourly activity and the last observed primary guild to avoid counting a guild-switching player twice. Recompute contribution multipliers from an hourly snapshot; never make PvP diplomacy dependent on who logged out during a fight.

The multiplier is **soft, bounded population balancing**:
```
m = clamp((median(positive qualified guild counts) / max(3, qualified guild count)) ^ 0.65, 0.65, 1.25)
```
Counts fewer than two populated guilds => neutral multiplier 1.0. A guild with zero qualified active members does not receive a free bonus.

With 30 / 8 / 12 eligible active players, factors are **0.65×, 1.25×, 1.00×**. Large guilds still outproduce small ones; this reduces the advantage, not erases it. Population multipliers apply **after** GDP's existing item and personal anti-farm calculations but **before** the normal GDP point event, so Frontier sees the final amount. Item removal is unchanged. Per-UUID/guild sub-1-GP fractional carry is persisted across restarts to prevent repeated one-point contributions bypassing the multiplier. A small donation can therefore award zero immediately while fractional credit carries to a later donation.

## War, peace and all diplomatic states

GKP still stores **directional numerical scores** but shows the same **pairwise public state** to both guilds, using the worse score. This prevents inconsistent trade discounts.

| State | Score / transition |
|---|---|
| **ALLIED** | Both directions >= +40; stays allied down to +25, minimum 6 hours unless extreme hostility |
| **NEUTRAL** | -29 .. +39, unless a prior state persists |
| **TENSE** | -59 .. -30 |
| **HOSTILE** | -99 .. -60; or -100 with insufficient war participants |
| **WAR** | Lowest score <= -100 **and at least 3 distinct eligible attackers** in the pair during the last 7 days; holds for at least 12 hours and until both scores recover to >= -80 |

The phase-2 trade (+3, +1, then +0) and PvP (-5, -2, then 0 per opponent) rolling budgets still apply, with persistent cooldowns and caps. Only successful budgeted kills add war participants. Normal trading and PvP permissions do not change. GKP state changes persist in its plugin data folder and are read by existing integrations. This does **not** add actual siege/capture, formal treaty voting, or faction-member transfer restrictions.

## Test-only builds

- `BlockClubGroupDepositPoints-2.4.5-PopulationBalance-TEST.jar`
- `BlockClubGKP-1.4.0-StableStates-TEST.jar`
- Companion from Phase 2: `BlockClubTrade-0.1.8-DiplomacyBalance-TEST.jar`

New GDP test profile: `plugins/GroupDepositPoints/population-balance.properties` (`enabled=true`; when absent, adjustment is disabled). GKP state rules can be configured under `states:`; existing configs must be merged intentionally.

## Verification still required

Offline policy/unit tests and JAR structural checks passed, **not** live Paper verification. Confirm GUI estimates, sub-1-GP contribution messaging, restart persistence, online activity sampling, PvP state changes, crossplay, and MSPT with 10/25/50 players. Complete Phase 1 restore drills before touching active data. Do not merge this draft into `main` until playtested.
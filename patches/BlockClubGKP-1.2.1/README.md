# BlockClubGKP 1.2.1 — Frontier-only PvP diplomatic effects (test patch)

This directory contains the replacement source for `com.blockclub.gkp.PvpListener`, which was compiled into a test-only JAR based on the BlockClub-owned `BlockClubGKP-1.2.0.jar`.

This patch does **not** alter whether combat is allowed; it only changes which kills count toward inter-guild political scores.

## New options in GKP config.yml

```yaml
pvp:
  enabled: true
  frontier-only: true
  allowed-worlds:
    - guild_frontier
```

If an existing configuration omits these keys, the code defaults to Frontier-only and world `guild_frontier`. For multi-dimension PvP politics, list additional named worlds explicitly.

The existing `GroupKgpPlugin.handlePvpKill` owns all political deltas, asymmetric penalties, and cooldowns; these have intentionally not been changed in Phase 1.

## Install safety

**Do not install on production yet.** Before public promotion, use a disposable Paper test server to verify: kills in `guild_frontier` count; kills in `hub` and the plot world do not; permissions and GKP score values remain intact. Do not install two GKP versions simultaneously.

Source and offline build tooling are in the Phase 1 coding bundle prepared in this conversation. Avoid committing third-party binary JARs into a public repository without checking license permissions.

# Denizen

This directory is for BlockClub-owned Denizen scripts.

## Suggested structure
- `onboarding/` — new-player and reset flows
- `scoreboards/` — guild/world/campaign HUD scripts
- `guis/` — registrar, contribution, info and other menus
- `chat/` — Global/Guild/Local orchestration
- `npcs/` — BlockClub NPC interactions
- `utilities/` — shared procedures, tasks and helpers

## Naming
Use a clear BlockClub prefix for script containers where practical to avoid collisions with third-party scripts.

## Formatting
Keep scripts grouped by feature, use descriptive container names, and comment non-obvious state/flag behavior. Prefer reusable procedures/tasks over duplicating logic across guild-specific scripts.

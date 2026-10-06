# Architecture

## Server platform
BlockClub currently targets Paper 1.21.x.

## Major systems
- PlotSquared: persistent player housing plots
- Multiverse-Core: world management
- WorldGuard: region protection and world rules
- LuckPerms: permissions
- Geyser/Floodgate: Bedrock connectivity
- ItemsAdder: custom content / presentation
- Denizen: orchestration, GUIs, onboarding, scoreboards and scripted UX
- Custom BlockClub plugins: Frontier, guild mechanics, GDP/contribution, plot-world rules

## World model
BlockClub separates persistent housing from competitive/resource gameplay.

### Plot world
Persistent natural-terrain plots. Roads are fixed while plot interiors preserve vanilla-style terrain. Resource-generation rules are sanitized to prevent plot-world mining from replacing Frontier/resource gameplay.

### Frontier
Rotating campaign world with timed cycles, guild competition, territory progression and campaign resets.

## Repository policy
Commit source, Denizen scripts, documentation and sanitized configuration examples. Do not commit live worlds, secrets, player data, logs or compiled JARs by default.

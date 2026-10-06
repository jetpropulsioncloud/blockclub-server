# Plot World

## Goal
Give every player a persistent home area that still feels like vanilla terrain rather than a flat creative-style plot world.

## Current design
- PlotSquared-based
- Natural terrain retained inside plots
- Roads at Y=62
- Plot size: 129×129
- Gap: 7
- Unclaimed road treatment: dark oak slab
- Claimed road treatment: spruce slab
- Resource sanitation prevents the plot world from becoming a primary mining world

## Plot-world rules
The custom BlockClubPlotWorldRules plugin handles terrain-related protections and sanitation.

Current sanitation expectations:
- Natural ores disabled/replaced
- Amethyst/geode resources disabled/replaced
- Generated loot disabled where configured
- Sanitation should remain safe when repeated

## Testing
Any seed/reset testing should use a disposable plot test world rather than the production plot world.

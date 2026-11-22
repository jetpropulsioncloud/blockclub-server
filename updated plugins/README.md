# Updated plugins — BlockClub test builds

**Status: test candidates only. Not approved for production installation.**

This folder is intended to archive the six JAR test builds developed in Phases 1–2. **The actual binary JARs have not yet been uploaded.** Their expected filenames and SHA-256 hashes are recorded in `SHA256SUMS.txt` once present.

| File | Purpose |
| --- | --- |
| `BlockClubPlotWorldRules-1.3.2-PlotScope-TEST.jar` | Plot-bounded sanitation after clear/delete |
| `BlockClubGKP-1.2.1-FrontierOnly-TEST.jar` | Frontier-only PvP diplomacy |
| `BlockClubTrade-0.1.8-DiplomacyBalance-TEST.jar` | Trading diplomacy diminishing returns |
| `BlockClubGKP-1.3.0-DiplomacyBalance-TEST.jar` | PvP diminishing returns |
| `BlockClubGroupDepositPoints-2.4.5-PopulationBalance-TEST.jar` | Activity-based guild population scaling |
| `BlockClubGKP-1.4.0-StableStates-TEST.jar` | Stable alliance/war state transitions |

**Never install all six together:** three are successive versions of BlockClubGKP. For integrated testing use only GKP 1.4.0, alongside PlotWorldRules 1.3.2, Trade 0.1.8 and GroupDepositPoints 2.4.5.

These builds still require tests on a disposable Paper server and a checked configuration migration. They are not automatically deployed.

Keep third-party premium plugins out of this folder unless their licenses explicitly permit redistribution.

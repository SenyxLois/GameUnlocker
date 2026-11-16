<div align="center">

# Game Spoofer

**Unlock higher frame rates and graphics presets in Android mobile games**

[![Latest Release](https://img.shields.io/github/v/release/SenyxLois/GameUnlocker?style=for-the-badge&logo=github)](https://github.com/SenyxLois/GameUnlocker/releases)
[![Build Status](https://img.shields.io/github/actions/workflow/status/SenyxLois/GameUnlocker/build.yml?style=for-the-badge&logo=githubactions&logoColor=white)](https://github.com/SenyxLois/GameUnlocker/actions/workflows/build.yml)
[![libxposed API](https://img.shields.io/badge/libxposed_API-102-4CAF50?style=for-the-badge&logo=android&logoColor=white)](https://github.com/libxposed/api)
[![Android](https://img.shields.io/badge/Android-9.0%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![License: MIT](https://img.shields.io/github/license/SenyxLois/GameUnlocker?style=for-the-badge)](LICENSE)

</div>

---

Game Spoofer is a lightweight Xposed module built on the modern [libxposed-api](https://github.com/libxposed/api) (`API 102`). It spoofs `android.os.Build` device properties per game to unlock high-FPS modes and flagship graphics presets on unsupported or artificially capped devices.

## Features

- **Per-Game Device Profiles** — Maps 54 supported game packages to flagship gaming device profiles (`POCO F9 Ultra`, `OnePlus 15`, `Infinix GT 50 PRO`, `REDMAGIC 11S Pro`, `Xiaomi 18 Pro Max`).
- **Modern libXposed (API 102)** — Uses `META-INF/xposed/scope.list` (`staticScope=true`) so supported games are automatically added to your module scope.
- **LSPosed Manager Logging** — Reports spoofing status and reflection errors directly to the LSPosed Manager log viewer via `XposedModule.log(...)`.
- **Zero Configuration & Lightweight** — Pure hook module with no background services or launcher icon, shipped as an R8-minified release APK.

## Spoofed Device Profiles

| Profile | Brand | Manufacturer | Model | Device | Product | Games |
| :--- | :--- | :--- | :--- | :--- | :--- | :---: |
| **POCO F9 Ultra** | `POCO` | `Xiaomi` | `26077PC53G` | `songyuan` | `songyuan_global` | 9 |
| **OnePlus 15** | `OnePlus` | `OnePlus` | `CPH2747` | `OP611FL1` | `CPH2747` | 9 |
| **Infinix GT 50 PRO** | `Infinix` | `INFINIX` | `Infinix X6891` | `Infinix-X6891` | `X6891` | 2 |
| **REDMAGIC 11S Pro** | `REDMAGIC` | `nubia` | `NX809J` | `NX809J` | `NX809J-EEA` | 27 |
| **Xiaomi 18 Pro Max** | `Xiaomi` | `Xiaomi` | `M154FF` | `madrid` | `madrid` | 7 |

## Getting Started

### Prerequisites

- Rooted Android device running **Android 9.0 (API 28)** or higher.
- An Xposed framework supporting **libxposed API 100–102** (such as a modern LSPosed build).

### Installation

1. Download the latest release APK from the [Releases](../../releases) page and install it.
2. Open your **LSPosed Manager** and navigate to **Modules**.
3. Select **Game Spoofer** and enable the module.
   - Supported games are automatically selected via static scope.
4. **Force Stop** any running target games so the spoofed `Build` properties apply on next launch.

## Usage

Once enabled, Game Spoofer applies the appropriate device profile automatically whenever a scoped game starts—no manual setup required.

- **Per-game control:** Uncheck any game inside the module's scope in LSPosed Manager, then force stop and relaunch the game to disable spoofing for it.
- **Verify spoofing:** Open **LSPosed Manager → Logs** to see `Spoofed <package> as <profile>` entries when a game launches.

> [!NOTE]
> Modifying reported device properties may violate the Terms of Service of certain online games. Use at your own discretion, and report any issues or game requests on the [Issues](../../issues) page.

## Supported Games (54)

<details>
<summary><strong>Click to expand all 54 supported game packages</strong></summary>

### POCO F9 Ultra (9)

| Game | Region / Variant | Package |
| :--- | :--- | :--- |
| Mobile Legends: Bang Bang | Global | [`com.mobile.legends`](https://play.google.com/store/apps/details?id=com.mobile.legends) |
| Mobile Legends: Bang Bang | Xiaomi / GetApps | [`com.mobilelegends.mi`](https://play.google.com/store/apps/details?id=com.mobilelegends.mi) |
| Mobile Legends: Bang Bang VNG | Vietnam | [`com.vng.mlbbvn`](https://play.google.com/store/apps/details?id=com.vng.mlbbvn) |
| Call of Duty: Mobile | Global | [`com.activision.callofduty.shooter`](https://play.google.com/store/apps/details?id=com.activision.callofduty.shooter) |
| Call of Duty: Mobile - Garena | Southeast Asia | [`com.garena.game.codm`](https://play.google.com/store/apps/details?id=com.garena.game.codm) |
| Call of Duty: Mobile | Korea | [`com.tencent.tmgp.kr.codm`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.kr.codm) |
| Call of Duty: Mobile VN | Vietnam | [`com.vng.codmvn`](https://play.google.com/store/apps/details?id=com.vng.codmvn) |
| Crystal of Atlan | Global | [`com.hermes.p6gameos`](https://play.google.com/store/apps/details?id=com.hermes.p6gameos) |
| Garena Undawn | Southeast Asia | [`com.garena.game.lmjx`](https://play.google.com/store/apps/details?id=com.garena.game.lmjx) |

### OnePlus 15 (9)

| Game | Region / Variant | Package |
| :--- | :--- | :--- |
| Honor of Kings | Global | [`com.levelinfinite.sgameGlobal`](https://play.google.com/store/apps/details?id=com.levelinfinite.sgameGlobal) |
| Honor of Kings | Samsung Galaxy Store | [`com.levelinfinite.sgameGlobal.samsung`](https://play.google.com/store/apps/details?id=com.levelinfinite.sgameGlobal.samsung) |
| Honor of Kings (王者荣耀) | China | [`com.tencent.tmgp.sgame`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.sgame) |
| Peacekeeper Elite (和平精英) | China | [`com.tencent.tmgp.pubgmhd`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.pubgmhd) |
| Call of Duty: Mobile (使命召唤手游) | China | [`com.tencent.tmgp.cod`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.cod) |
| Naruto Mobile (火影忍者) | China | [`com.tencent.KiHan`](https://play.google.com/store/apps/details?id=com.tencent.KiHan) |
| CrossFire: Legends (穿越火线) | China | [`com.tencent.tmgp.cf`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.cf) |
| High Energy Heroes (高能英雄) | China | [`com.tencent.tmgp.gnyx`](https://play.google.com/store/apps/details?id=com.tencent.tmgp.gnyx) |
| Genshin Impact | Global | [`com.miHoYo.GenshinImpact`](https://play.google.com/store/apps/details?id=com.miHoYo.GenshinImpact) |

### Infinix GT 50 PRO (2)

| Game | Region / Variant | Package |
| :--- | :--- | :--- |
| Free Fire MAX | Global | [`com.dts.freefiremax`](https://play.google.com/store/apps/details?id=com.dts.freefiremax) |
| Free Fire | Global | [`com.dts.freefireth`](https://play.google.com/store/apps/details?id=com.dts.freefireth) |

### REDMAGIC 11S Pro (27)

| Game | Region / Variant | Package |
| :--- | :--- | :--- |
| PUBG Mobile | Global | [`com.tencent.ig`](https://play.google.com/store/apps/details?id=com.tencent.ig) |
| Battlegrounds Mobile India (BGMI) | India | [`com.pubg.imobile`](https://play.google.com/store/apps/details?id=com.pubg.imobile) |
| PUBG Mobile | Korea / Japan | [`com.pubg.krmobile`](https://play.google.com/store/apps/details?id=com.pubg.krmobile) |
| PUBG Mobile | Taiwan | [`com.rekoo.pubgm`](https://play.google.com/store/apps/details?id=com.rekoo.pubgm) |
| PUBG Mobile VN | Vietnam | [`com.vng.pubgmobile`](https://play.google.com/store/apps/details?id=com.vng.pubgmobile) |
| League of Legends: Wild Rift | Global | [`com.riotgames.league.wildrift`](https://play.google.com/store/apps/details?id=com.riotgames.league.wildrift) |
| League of Legends: Wild Rift | Taiwan | [`com.riotgames.league.wildrifttw`](https://play.google.com/store/apps/details?id=com.riotgames.league.wildrifttw) |
| League of Legends: Wild Rift | Vietnam | [`com.riotgames.league.wildriftvn`](https://play.google.com/store/apps/details?id=com.riotgames.league.wildriftvn) |
| League of Legends: Wild Rift | China | [`com.tencent.lolm`](https://play.google.com/store/apps/details?id=com.tencent.lolm) |
| Teamfight Tactics | Global | [`com.riotgames.league.teamfighttactics`](https://play.google.com/store/apps/details?id=com.riotgames.league.teamfighttactics) |
| Teamfight Tactics | Taiwan | [`com.riotgames.league.teamfighttacticstw`](https://play.google.com/store/apps/details?id=com.riotgames.league.teamfighttacticstw) |
| Teamfight Tactics | Vietnam | [`com.riotgames.league.teamfighttacticsvn`](https://play.google.com/store/apps/details?id=com.riotgames.league.teamfighttacticsvn) |
| Fortnite | Global | [`com.epicgames.fortnite`](https://play.google.com/store/apps/details?id=com.epicgames.fortnite) |
| Epic Games Store | Global | [`com.epicgames.portal`](https://play.google.com/store/apps/details?id=com.epicgames.portal) |
| Arknights: Endfield | Global | [`com.gryphline.endfield.gp`](https://play.google.com/store/apps/details?id=com.gryphline.endfield.gp) |
| Tower of Fantasy | Global | [`com.levelinfinite.hotta.gp`](https://play.google.com/store/apps/details?id=com.levelinfinite.hotta.gp) |
| Aether Gazer | Global | [`com.YoStar.AetherGazer`](https://play.google.com/store/apps/details?id=com.YoStar.AetherGazer) |
| Asphalt Legends Unite | Global | [`com.gameloft.android.ANMP.GloftA9HM`](https://play.google.com/store/apps/details?id=com.gameloft.android.ANMP.GloftA9HM) |
| Shadowgun Legends | Global | [`com.madfingergames.legends`](https://play.google.com/store/apps/details?id=com.madfingergames.legends) |
| Cyber Hunter | Global | [`com.netease.lztgglobal`](https://play.google.com/store/apps/details?id=com.netease.lztgglobal) |
| Minecraft | Global | [`com.mojang.minecraftpe`](https://play.google.com/store/apps/details?id=com.mojang.minecraftpe) |
| Apex Legends Mobile | Global | [`com.ea.gp.apexlegendsmobilefps`](https://play.google.com/store/apps/details?id=com.ea.gp.apexlegendsmobilefps) |
| Arena Breakout | Global | [`com.proximabeta.mf.uamo`](https://play.google.com/store/apps/details?id=com.proximabeta.mf.uamo) |
| Delta Force | Garena | [`com.garena.game.df`](https://play.google.com/store/apps/details?id=com.garena.game.df) |
| Arena of Valor | Global / EU | [`com.ngame.allstar.eu`](https://play.google.com/store/apps/details?id=com.ngame.allstar.eu) |
| Garena Liên Quân Mobile | Vietnam | [`com.garena.game.kgvn`](https://play.google.com/store/apps/details?id=com.garena.game.kgvn) |
| Project SEKAI: Colorful Stage! | Japan | [`com.sega.pjsekai`](https://play.google.com/store/apps/details?id=com.sega.pjsekai) |

### Xiaomi 18 Pro Max (7)

| Game | Region / Variant | Package |
| :--- | :--- | :--- |
| Call of Duty: Warzone Mobile | Global | [`com.activision.callofudty.warzone`](https://play.google.com/store/apps/details?id=com.activision.callofudty.warzone) |
| EA SPORTS FC Mobile | Global | [`com.ea.gp.fifamobile`](https://play.google.com/store/apps/details?id=com.ea.gp.fifamobile) |
| eFootball | Global | [`jp.konami.pesam`](https://play.google.com/store/apps/details?id=jp.konami.pesam) |
| Black Desert Mobile | Korea | [`com.pearlabyss.blackdesertm`](https://play.google.com/store/apps/details?id=com.pearlabyss.blackdesertm) |
| Black Desert Mobile | Global | [`com.pearlabyss.blackdesertm.gl`](https://play.google.com/store/apps/details?id=com.pearlabyss.blackdesertm.gl) |
| Revelation: Infinite Journey | Vietnam | [`vng.games.revelation.mobile`](https://play.google.com/store/apps/details?id=vng.games.revelation.mobile) |
| Clash of Clans | Global | [`com.supercell.clashofclans`](https://play.google.com/store/apps/details?id=com.supercell.clashofclans) |

</details>

## Contributing & Credits

Built upon the work and contributions of:

- [rushiranpise/Game-Unlocker](https://github.com/rushiranpise/Game-Unlocker)
- [crdroidandroid](https://github.com/crdroidandroid)
- [RisingTechOSS](https://github.com/RisingTechOSS)
- [tehcneko](https://github.com/tehcneko)
- [Evolution-X](https://github.com/Evolution-X)

Pull requests adding new game packages or device profiles are welcome. After updating `PACKAGE_PROFILES` in `GameSpoofer.java`, run `./gradlew generateScopeList` and update the table in this README (verified automatically by `./gradlew verifyGameList`).

## License

This project is licensed under the MIT License — see [LICENSE](LICENSE) for details.

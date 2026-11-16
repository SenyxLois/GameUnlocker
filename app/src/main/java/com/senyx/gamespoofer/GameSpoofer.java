package com.senyx.gamespoofer;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import java.lang.reflect.Field;
import java.util.Map;

import io.github.libxposed.api.XposedModule;

@SuppressLint("DiscouragedPrivateApi")
public class GameSpoofer extends XposedModule {

    private static final String TAG = "GameSpoofer";

    private record DeviceProfile(
            String name,
            String brand,
            String device,
            String manufacturer,
            String model,
            String product
    ) {}

    // Device profiles (from firmware/*.prop)
    private static final DeviceProfile POCO_F9_ULTRA = new DeviceProfile(
            "POCO F9 Ultra", "POCO", "songyuan", "Xiaomi", "26077PC53G", "songyuan_global"); // songyuan.prop
    private static final DeviceProfile ONEPLUS_15 = new DeviceProfile(
            "OnePlus 15", "OnePlus", "OP611FL1", "OnePlus", "CPH2747", "CPH2747"); // oneplus15.prop
    private static final DeviceProfile INFINIX_GT_50_PRO = new DeviceProfile(
            "Infinix GT 50 PRO", "Infinix", "Infinix-X6891", "INFINIX", "Infinix X6891", "X6891"); // kingfinix.prop
    private static final DeviceProfile REDMAGIC_11S_PRO = new DeviceProfile(
            "REDMAGIC 11S Pro", "REDMAGIC", "NX809J", "nubia", "NX809J", "NX809J-EEA"); // nx809j.prop
    private static final DeviceProfile XIAOMI_18_PRO_MAX = new DeviceProfile(
            "Xiaomi 18 Pro Max", "Xiaomi", "madrid", "Xiaomi", "M154FF", "madrid"); // madrid.prop

    private static final Map<String, DeviceProfile> PACKAGE_PROFILES = Map.ofEntries(
            // POCO F9 Ultra (songyuan.prop)
            Map.entry("com.mobile.legends", POCO_F9_ULTRA),
            Map.entry("com.mobilelegends.mi", POCO_F9_ULTRA),
            Map.entry("com.vng.mlbbvn", POCO_F9_ULTRA),
            Map.entry("com.activision.callofduty.shooter", POCO_F9_ULTRA),
            Map.entry("com.garena.game.codm", POCO_F9_ULTRA),
            Map.entry("com.tencent.tmgp.kr.codm", POCO_F9_ULTRA),
            Map.entry("com.vng.codmvn", POCO_F9_ULTRA),
            Map.entry("com.hermes.p6gameos", POCO_F9_ULTRA),
            Map.entry("com.garena.game.lmjx", POCO_F9_ULTRA),

            // OnePlus 15 (oneplus15.prop)
            Map.entry("com.levelinfinite.sgameGlobal", ONEPLUS_15),
            Map.entry("com.levelinfinite.sgameGlobal.samsung", ONEPLUS_15),
            Map.entry("com.tencent.tmgp.sgame", ONEPLUS_15),
            Map.entry("com.tencent.tmgp.pubgmhd", ONEPLUS_15),
            Map.entry("com.tencent.tmgp.cod", ONEPLUS_15),
            Map.entry("com.tencent.KiHan", ONEPLUS_15),
            Map.entry("com.tencent.tmgp.cf", ONEPLUS_15),
            Map.entry("com.tencent.tmgp.gnyx", ONEPLUS_15),
            Map.entry("com.miHoYo.GenshinImpact", ONEPLUS_15),

            // Infinix GT 50 PRO (kingfinix.prop)
            Map.entry("com.dts.freefiremax", INFINIX_GT_50_PRO),
            Map.entry("com.dts.freefireth", INFINIX_GT_50_PRO),

            // REDMAGIC 11S Pro (nx809j.prop)
            Map.entry("com.tencent.ig", REDMAGIC_11S_PRO),
            Map.entry("com.pubg.imobile", REDMAGIC_11S_PRO),
            Map.entry("com.pubg.krmobile", REDMAGIC_11S_PRO),
            Map.entry("com.rekoo.pubgm", REDMAGIC_11S_PRO),
            Map.entry("com.vng.pubgmobile", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.wildrift", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.wildrifttw", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.wildriftvn", REDMAGIC_11S_PRO),
            Map.entry("com.tencent.lolm", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.teamfighttactics", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.teamfighttacticstw", REDMAGIC_11S_PRO),
            Map.entry("com.riotgames.league.teamfighttacticsvn", REDMAGIC_11S_PRO),
            Map.entry("com.epicgames.fortnite", REDMAGIC_11S_PRO),
            Map.entry("com.epicgames.portal", REDMAGIC_11S_PRO),
            Map.entry("com.gryphline.endfield.gp", REDMAGIC_11S_PRO),
            Map.entry("com.levelinfinite.hotta.gp", REDMAGIC_11S_PRO),
            Map.entry("com.YoStar.AetherGazer", REDMAGIC_11S_PRO),
            Map.entry("com.gameloft.android.ANMP.GloftA9HM", REDMAGIC_11S_PRO),
            Map.entry("com.madfingergames.legends", REDMAGIC_11S_PRO),
            Map.entry("com.netease.lztgglobal", REDMAGIC_11S_PRO),
            Map.entry("com.mojang.minecraftpe", REDMAGIC_11S_PRO),
            Map.entry("com.ea.gp.apexlegendsmobilefps", REDMAGIC_11S_PRO),
            Map.entry("com.proximabeta.mf.uamo", REDMAGIC_11S_PRO),
            Map.entry("com.garena.game.df", REDMAGIC_11S_PRO),
            Map.entry("com.ngame.allstar.eu", REDMAGIC_11S_PRO),
            Map.entry("com.garena.game.kgvn", REDMAGIC_11S_PRO),
            Map.entry("com.sega.pjsekai", REDMAGIC_11S_PRO),

            // Xiaomi 18 Pro Max (madrid.prop)
            Map.entry("com.activision.callofudty.warzone", XIAOMI_18_PRO_MAX),
            Map.entry("com.ea.gp.fifamobile", XIAOMI_18_PRO_MAX),
            Map.entry("jp.konami.pesam", XIAOMI_18_PRO_MAX),
            Map.entry("com.pearlabyss.blackdesertm", XIAOMI_18_PRO_MAX),
            Map.entry("com.pearlabyss.blackdesertm.gl", XIAOMI_18_PRO_MAX),
            Map.entry("vng.games.revelation.mobile", XIAOMI_18_PRO_MAX),
            Map.entry("com.supercell.clashofclans", XIAOMI_18_PRO_MAX)
    );

    public GameSpoofer() {
        super();
    }

    @Override
    public void onPackageLoaded(@NonNull PackageLoadedParam param) {
        String packageName = param.getPackageName();
        DeviceProfile profile = PACKAGE_PROFILES.get(packageName);
        if (profile != null) {
            spoofDevice(profile);
            log(Log.INFO, TAG, "Spoofed " + packageName + " as " + profile.name());
        }
    }

    private void spoofDevice(DeviceProfile profile) {
        if (profile.brand() != null) setPropValue("BRAND", profile.brand());
        if (profile.device() != null) setPropValue("DEVICE", profile.device());
        if (profile.manufacturer() != null) setPropValue("MANUFACTURER", profile.manufacturer());
        if (profile.model() != null) setPropValue("MODEL", profile.model());
        if (profile.product() != null) setPropValue("PRODUCT", profile.product());
    }

    private void setPropValue(String key, Object value) {
        try {
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log(Log.ERROR, TAG, "Failed to set prop: " + key, e);
        }
    }
}
